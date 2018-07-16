package by.ryazantseva.salon.command.standartUserFunction;

import by.ryazantseva.salon.command.Command;
import by.ryazantseva.salon.command.PageConstant;
import by.ryazantseva.salon.entity.User;
import by.ryazantseva.salon.logic.ChangePasswordLogic;

import javax.mail.Session;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Properties;

public class SendEmailPasswordCommand implements Command {
    private static final String CURRENT_SESSION_USER = "currentSessionUser";
    public static final String SEND_FROM = "ulyasha_97@mail.ru";

    public String execute(HttpServletRequest request) {
        String page = PageConstant.SIGN_IN_PAGE;
        String email = request.getParameter("email");


        return page;
    }
}
