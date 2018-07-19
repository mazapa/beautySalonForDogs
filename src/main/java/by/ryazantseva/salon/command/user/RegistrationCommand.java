package by.ryazantseva.salon.command.user;

import by.ryazantseva.salon.command.Command;
import by.ryazantseva.salon.command.PageConstant;
import by.ryazantseva.salon.entity.User;
import by.ryazantseva.salon.exception.LogicException;
import by.ryazantseva.salon.logic.user.RegistrationLogic;

import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;

public class RegistrationCommand implements Command {
    private static final String LOGIN = "login";
    private static final String NAME = "name";
    private static final String SURNAME = "surname";
    private static final String EMAIL = "email";
    private static final String PHONE_NUMBER = "phoneNumber";
    private static final String PASSWORD = "password";
    private static final String REPEAT_PASSWORD = "repeatPassword";
    private static final String USER = "user";
    private static final String CURRENT_SESSION_USER = "currentSessionUser";

    public String execute(HttpServletRequest request) {
        String page = PageConstant.REGISTRATION_PAGE;
        RegistrationLogic logic = new RegistrationLogic();
        String login = request.getParameter(LOGIN);
        String password = request.getParameter(PASSWORD);
        String name = request.getParameter(NAME);
        String surname = request.getParameter(SURNAME);
        String email = request.getParameter(EMAIL);
        String phoneNumber = request.getParameter(PHONE_NUMBER);
        String repeatPass = request.getParameter(REPEAT_PASSWORD);
        try {
            if (logic.addUser(login, password, name, surname, email, phoneNumber, USER, repeatPass)) {
                User user = logic.getUser();
                HttpSession session = request.getSession();
                session.setAttribute(CURRENT_SESSION_USER, user);
                page = PageConstant.WELCOME_PAGE;
    //////////////////////////
                System.out.println(((User) session.getAttribute(CURRENT_SESSION_USER)).getPassword());
    ///////////////////////////
            }
        } catch (LogicException e) {
            page = PageConstant.ERROR_PAGE;
        }
        return page;
    }
}
