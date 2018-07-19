package by.ryazantseva.salon.logic.user;

import by.ryazantseva.salon.dao.impl.UserDao;
import by.ryazantseva.salon.entity.User;
import by.ryazantseva.salon.exception.DaoException;
import by.ryazantseva.salon.exception.LogicException;
import by.ryazantseva.salon.validation.EncryptPassword;
import by.ryazantseva.salon.validation.UserDataValidation;

public class ChangePasswordLogic {

    public boolean changePassword(User user, String oldPassword, String newPassword, String repeatNewPassword) throws LogicException {
        oldPassword = EncryptPassword.sha1(oldPassword);
        if (user.getPassword().equals(oldPassword)) {
            if (UserDataValidation.checkPassword(newPassword) && UserDataValidation.checkPasswordEquals(newPassword, repeatNewPassword)) {
                UserDao dao = new UserDao();
                try {
                    user.setPassword(newPassword);
                    dao.update(user);
                } catch (DaoException e) {
                    throw new LogicException("Can't change password",e);
                }
                return true;
            }
        }
        return false;
    }

}
