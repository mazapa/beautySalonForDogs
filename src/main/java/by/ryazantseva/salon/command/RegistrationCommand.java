package by.ryazantseva.salon.command;

import by.ryazantseva.salon.logic.RegistrationLogic;

import javax.servlet.http.HttpServletRequest;

public class RegistrationCommand implements Command {
    private static final String LOGIN = "login";
    private static final String NAME = "name";
    private static final String SURNAME = "surname";
    private static final String EMAIL = "email";
    private static final String PHONE_NUMBER = "phoneNumber";
    private static final String PASSWORD = "password";
    private static final String REPEAT_PASSWORD = "repeatPassword";

    public String execute(HttpServletRequest request) {
        String page;
        RegistrationLogic logic = new RegistrationLogic();
        /////////////user
        String role = "user";
        String login = request.getParameter(LOGIN);
        String password = request.getParameter(PASSWORD);
        String name = request.getParameter(NAME);
        String surname = request.getParameter(SURNAME);
        String email = request.getParameter(EMAIL);
        String phoneNumber = request.getParameter(PHONE_NUMBER);
        String repeatPass = request.getParameter(REPEAT_PASSWORD);
        if (logic.addUser(login, password, name, surname, email, phoneNumber, role,repeatPass)) {
            page = PageConstant.WELCOME_PAGE;
        } else {
            page = PageConstant.REGISTRATION_PAGE;
        }
        return page;
    }
}
