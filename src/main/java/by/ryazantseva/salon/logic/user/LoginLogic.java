package by.ryazantseva.salon.logic.user;
import by.ryazantseva.salon.dao.impl.UserDao;
import by.ryazantseva.salon.entity.User;
import by.ryazantseva.salon.exception.DaoException;
import by.ryazantseva.salon.exception.LogicException;
import by.ryazantseva.salon.validation.UserDataValidation;

public class LoginLogic {
    private User user;
    public boolean login(String login, String password) throws LogicException {
        if (login != null && !login.isEmpty()&& UserDataValidation.checkLogin(login) && password != null && !password.isEmpty()&& UserDataValidation.checkPassword(password)) {
            UserDao dao = new UserDao();
            try {
                user = dao.findUser(login, password);
            } catch (DaoException e) {
                throw new LogicException("Can't find a user",e);
            }
            return  user != null;
        }
        return false;
    }

    public User getUser(){
        return user;

    }

}
