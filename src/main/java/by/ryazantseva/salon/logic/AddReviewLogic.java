package by.ryazantseva.salon.logic;
import by.ryazantseva.salon.dao.UserDAO;
import by.ryazantseva.salon.entity.User;

public class AddReviewLogic {
    public boolean addReview(User user, String review) {
        if (review != null && !review.isEmpty()) {
            UserDAO dao = new UserDAO();
            dao.addReview(user,review);
            return  true;
        }
        return false;
    }


}
