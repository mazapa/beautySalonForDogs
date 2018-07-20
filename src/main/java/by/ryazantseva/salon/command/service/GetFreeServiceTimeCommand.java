package by.ryazantseva.salon.command.service;

import by.ryazantseva.salon.command.Command;
import by.ryazantseva.salon.command.PageConstant;
import by.ryazantseva.salon.entity.User;
import by.ryazantseva.salon.exception.LogicException;
import by.ryazantseva.salon.logic.GetFreeServiceTimeLogic;
import by.ryazantseva.salon.logic.user.AddReviewLogic;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class GetFreeServiceTimeCommand implements Command {
    private static final String CURRENT_SESSION_USER = "currentSessionUser";


    public String execute(HttpServletRequest request) {
        String page = PageConstant.WELCOME_PAGE;
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute(CURRENT_SESSION_USER);
        if (user != null) {
            GetFreeServiceTimeLogic logic = new GetFreeServiceTimeLogic();
            try {
                if(logic.findTime("2018-07-12", "Гигиеническая стрижка ")){
                    page = PageConstant.WELCOME_PAGE;
                }
            } catch (LogicException e) {
                page = PageConstant.ERROR_PAGE;
            }
        }
        return page;
    }
}
