package by.ryazantseva.salon.command.user;

import by.ryazantseva.salon.command.Command;
import by.ryazantseva.salon.command.PageConstant;
import by.ryazantseva.salon.entity.User;
import by.ryazantseva.salon.exception.LogicException;
import by.ryazantseva.salon.logic.user.AddReviewLogic;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class AddReviewCommand implements Command {
    private static final String CURRENT_SESSION_USER = "currentSessionUser";
    private static final String REVIEW = "review";

    public String execute(HttpServletRequest request) {
        String page = PageConstant.LOGIN_PAGE;
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute(CURRENT_SESSION_USER);
        if (user != null) {
            String review = request.getParameter(REVIEW);
            AddReviewLogic logic = new AddReviewLogic();
            try {
                if(logic.addReview(user,review)){
                    page = PageConstant.WELCOME_PAGE;
                }
            } catch (LogicException e) {
                page = PageConstant.ERROR_PAGE;
            }
        }
        return page;
    }
}
