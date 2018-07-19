package by.ryazantseva.salon.command.user;

import by.ryazantseva.salon.command.Command;
import by.ryazantseva.salon.command.PageConstant;
import by.ryazantseva.salon.entity.User;
import by.ryazantseva.salon.logic.LoginLogic;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class SignInCommand implements Command {
    private static final String LOGIN_PARAMETER = "login";
    private static final String PASSWORD = "password";
    private static final String CURRENT_SESSION_USER = "currentSessionUser";

    public String execute(HttpServletRequest request) {
        String page = PageConstant.SIGN_IN_PAGE;
        LoginLogic logic = new LoginLogic();
        String login = request.getParameter(LOGIN_PARAMETER);
        String password = request.getParameter(PASSWORD);
        if (logic.checkData(login, password)) {
            HttpSession session = request.getSession();
            User user = logic.getUser();
            session.setAttribute(CURRENT_SESSION_USER, user);
            page = PageConstant.WELCOME_PAGE;
////////////////////////////
            System.out.println(((User) session.getAttribute(CURRENT_SESSION_USER)).getPassword());
///////////////////////////////
        }
        return page;
    }
}
