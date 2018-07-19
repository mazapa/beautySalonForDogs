package by.ryazantseva.salon.command.user;

import by.ryazantseva.salon.command.Command;
import by.ryazantseva.salon.command.PageConstant;

import javax.servlet.http.HttpServletRequest;

public class SendEmailPasswordCommand implements Command {
    private static final String CURRENT_SESSION_USER = "currentSessionUser";
    public static final String SEND_FROM = "ulyasha_97@mail.ru";

    public String execute(HttpServletRequest request) {
        String page = PageConstant.SIGN_IN_PAGE;
        String email = request.getParameter("email");


        return page;
    }
}
