package by.ryazantseva.salon.logic;

import by.ryazantseva.salon.dao.UserDAO;
import by.ryazantseva.salon.entity.User;
import by.ryazantseva.salon.validation.EncryptPassword;
import by.ryazantseva.salon.validation.InputUserDataValidation;

public class ChangePasswordLogic {
    private User user;

    public boolean changePassword(User user, String oldPassword, String newPassword, String repeatNewPassword) {
        oldPassword = EncryptPassword.sha1(oldPassword);
        if (user.getPassword().equals(oldPassword)) {
            if (InputUserDataValidation.checkPassword(newPassword) && InputUserDataValidation.checkPasswordEquals(newPassword, repeatNewPassword)) {
                user.setPassword(newPassword);
                UserDAO dao = new UserDAO();
                dao.update(user);
                this.user = user;
                return true;
            }
        }
        return false;
    }

    public User getUser() {
        return user;

    }

}
