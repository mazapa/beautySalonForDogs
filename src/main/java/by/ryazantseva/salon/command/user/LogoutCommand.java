package by.ryazantseva.salon.command.user;

import by.ryazantseva.salon.command.Command;
import by.ryazantseva.salon.command.PageConstant;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class LogoutCommand implements Command {
    private static final String CURRENT_SESSION_USER = "currentSessionUser";

    public String execute(HttpServletRequest request) {
        String page = PageConstant.LOGIN_PAGE;
        HttpSession session = request.getSession();
        session.removeAttribute(CURRENT_SESSION_USER);
        return page;
    }
}
