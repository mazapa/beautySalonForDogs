package by.ryazantseva.salon.command.user;

import by.ryazantseva.salon.command.Command;
import by.ryazantseva.salon.command.PageConstant;
import by.ryazantseva.salon.entity.User;
import by.ryazantseva.salon.exception.LogicException;
import by.ryazantseva.salon.logic.user.ChangeInformationLogic;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class ChangeInformationCommand implements Command {


    private static final String CURRENT_SESSION_USER = "currentSessionUser";
    private static final String NAME = "name";
    private static final String SURNAME = "surname";
    private static final String EMAIL = "email";
    private static final String PHONE_NUMBER = "phoneNumber";

    public String execute(HttpServletRequest request) {
        String page = PageConstant.LOGIN_PAGE;
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute(CURRENT_SESSION_USER);
        if (user != null) {
            ChangeInformationLogic logic = new ChangeInformationLogic();
            String name = request.getParameter(NAME);
            String surname = request.getParameter(SURNAME);
            String email = request.getParameter(EMAIL);
            String phoneNumber = request.getParameter(PHONE_NUMBER);
            try {
                if(logic.changeInformation(user,name,surname,email,phoneNumber)){
                    page = PageConstant.WELCOME_PAGE;
                }
            } catch (LogicException e) {
                page = PageConstant.ERROR_PAGE;
            }
        }
        return page;
    }
}
