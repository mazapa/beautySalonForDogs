package by.ryazantseva.salon.command.service;

import by.ryazantseva.salon.command.Command;
import by.ryazantseva.salon.command.PageConstant;
import by.ryazantseva.salon.entity.User;
import by.ryazantseva.salon.logic.AddReviewLogic;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class GetFreeServiceTimeCommand implements Command {
    private static final String CURRENT_SESSION_USER = "currentSessionUser";
    public static final String REVIEW = "review";

    public String execute(HttpServletRequest request) {
        String page = PageConstant.SIGN_IN_PAGE;
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute(CURRENT_SESSION_USER);
        if (user != null) {
            String review = request.getParameter(REVIEW);
            AddReviewLogic logic = new AddReviewLogic();
            if(logic.addReview(user,review)){
                page = PageConstant.WELCOME_PAGE;
            }
        }
        return page;
    }
}
