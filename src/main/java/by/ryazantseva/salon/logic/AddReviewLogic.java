package by.ryazantseva.salon.logic;
import by.ryazantseva.salon.dao.impl.UserDao;
import by.ryazantseva.salon.entity.User;

public class AddReviewLogic {
    public boolean addReview(User user, String review) {
        if (review != null && !review.isEmpty()) {
            UserDao dao = new UserDao();
            dao.addReview(user,review);
            return  true;
        }
        return false;
    }


}
