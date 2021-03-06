package by.ryazantseva.salon.command.user;

import by.ryazantseva.salon.command.Command;
import by.ryazantseva.salon.command.PageConstant;
import by.ryazantseva.salon.entity.User;
import by.ryazantseva.salon.exception.LogicException;
import by.ryazantseva.salon.logic.user.ChangePasswordLogic;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class ChangePasswordCommand implements Command {

    private static final String OLD_PASSWORD = "oldPassword";
    private static final String PASSWORD = "password";
    private static final String REPEAT_PASSWORD = "repeatPassword";
    private static final String CURRENT_SESSION_USER = "currentSessionUser";

    public String execute(HttpServletRequest request) {
        String page = PageConstant.LOGIN_PAGE;
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute(CURRENT_SESSION_USER);
        if (user != null) {
            ChangePasswordLogic logic = new ChangePasswordLogic();
            String oldPassword = request.getParameter(OLD_PASSWORD);
            String newPassword = request.getParameter(PASSWORD);
            String repeatNewPassword = request.getParameter(REPEAT_PASSWORD);
            try {
                if(logic.changePassword(user,oldPassword,newPassword,repeatNewPassword)){
                    session.setAttribute(CURRENT_SESSION_USER, user);
                    page = PageConstant.WELCOME_PAGE;
                }
            } catch (LogicException e) {
                page = PageConstant.ERROR_PAGE;
            }
        }
        return page;
    }
}
