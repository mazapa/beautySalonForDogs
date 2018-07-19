package by.ryazantseva.salon.command.service;

import by.ryazantseva.salon.command.Command;
import by.ryazantseva.salon.command.PageConstant;

import javax.servlet.http.HttpServletRequest;

public class GetFreeServiceTimeCommand implements Command {
    private static final String CURRENT_SESSION_USER = "currentSessionUser";
    public static final String REVIEW = "review";

    public String execute(HttpServletRequest request) {
        String page = PageConstant.LOGIN_PAGE;

        return page;
    }
}
