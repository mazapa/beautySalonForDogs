package by.ryazantseva.salon.logic.user;

import by.ryazantseva.salon.dao.impl.UserDao;
import by.ryazantseva.salon.entity.User;
import by.ryazantseva.salon.exception.DaoException;
import by.ryazantseva.salon.exception.LogicException;
import by.ryazantseva.salon.validation.ReviewValidation;
import by.ryazantseva.salon.validation.ScriptValidation;


public class AddReviewLogic {

    public boolean addReview(User user, String review) throws LogicException {
        if (review != null && !review.isEmpty() && ReviewValidation.checkReview(review)) {
            UserDao dao = new UserDao();
            try {
                dao.addReview(user, review);
            } catch (DaoException e) {
                throw new LogicException("Cant send password on email", e);
            }
            return true;
        }
        return false;
    }


}
