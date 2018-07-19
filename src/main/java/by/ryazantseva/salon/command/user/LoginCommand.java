package by.ryazantseva.salon.command.user;

import by.ryazantseva.salon.command.Command;
import by.ryazantseva.salon.command.PageConstant;
import by.ryazantseva.salon.entity.User;
import by.ryazantseva.salon.exception.LogicException;
import by.ryazantseva.salon.logic.user.LoginLogic;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class LoginCommand implements Command {
    private static final String LOGIN_PARAMETER = "login";
    private static final String PASSWORD = "password";
    private static final String CURRENT_SESSION_USER = "currentSessionUser";

    public String execute(HttpServletRequest request) {
        String page = PageConstant.LOGIN_PAGE;
        LoginLogic logic = new LoginLogic();
        String login = request.getParameter(LOGIN_PARAMETER);
        String password = request.getParameter(PASSWORD);
        try {
            if (logic.login(login, password)) {
                HttpSession session = request.getSession();
                User user = logic.getUser();
                session.setAttribute(CURRENT_SESSION_USER, user);
                page = PageConstant.WELCOME_PAGE;
            }
        } catch (LogicException e) {
            page = PageConstant.ERROR_PAGE;
        }
        return page;
    }
}
