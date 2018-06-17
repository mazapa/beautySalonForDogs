package by.ryazantseva.salon.command;

import by.ryazantseva.salon.logic.LoginLogic;

import javax.servlet.http.HttpServletRequest;

public class LoginCommand implements Command {
    private static final String LOGIN_PARAMETER = "login";
    private static final String PASSWORD = "password";

    public String execute(HttpServletRequest request) {
        String page;
        LoginLogic logic = new LoginLogic();
        String login = request.getParameter(LOGIN_PARAMETER);
        String password = request.getParameter(PASSWORD);
        if (logic.checkData(login, password)) {
            page = PageConstant.WELCOME_PAGE;
        } else {
            page = PageConstant.LOGIN_PAGE;
        }
        return page;
    }
}
