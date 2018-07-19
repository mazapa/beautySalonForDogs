package by.ryazantseva.salon.command.service;

import by.ryazantseva.salon.command.Command;
import by.ryazantseva.salon.command.PageConstant;
import by.ryazantseva.salon.entity.User;
import by.ryazantseva.salon.exception.LogicException;
import by.ryazantseva.salon.logic.user.AddReviewLogic;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class GetFreeServiceTimeCommand implements Command {
    private static final String CURRENT_SESSION_USER = "currentSessionUser";
    public static final String REVIEW = "review";

    public String execute(HttpServletRequest request) {
        String page = PageConstant.SIGN_IN_PAGE;

        return page;
    }
}
