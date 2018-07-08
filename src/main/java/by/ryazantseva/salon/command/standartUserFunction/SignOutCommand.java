package by.ryazantseva.salon.command.standartUserFunction;

import by.ryazantseva.salon.command.Command;
import by.ryazantseva.salon.command.PageConstant;
import by.ryazantseva.salon.entity.User;
import by.ryazantseva.salon.logic.LoginLogic;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class SignOutCommand implements Command {
    private static final String CURRENT_SESSION_USER = "currentSessionUser";

    public String execute(HttpServletRequest request) {
        String page = PageConstant.SIGN_IN_PAGE;
        HttpSession session = request.getSession();
        session.removeAttribute(CURRENT_SESSION_USER);
        return page;
    }
}
