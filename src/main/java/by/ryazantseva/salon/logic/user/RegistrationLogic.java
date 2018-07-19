package by.ryazantseva.salon.logic.user;

import by.ryazantseva.salon.dao.impl.UserDao;
import by.ryazantseva.salon.entity.User;
import by.ryazantseva.salon.exception.DaoException;
import by.ryazantseva.salon.exception.LogicException;
import by.ryazantseva.salon.validation.UserDataValidation;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class RegistrationLogic {
    private static Logger logger = LogManager.getLogger();
    private User user;

    public boolean addUser(String login, String password, String name, String surname, String email, String phoneNumber, String role, String repeatPass) throws LogicException {
        if (UserDataValidation.checkInput(login, password, name, surname, email, phoneNumber, repeatPass)) {
            UserDao dao = new UserDao();
            try {
                if (dao.checkUniqueLogin(login) && dao.checkUniqueEmail(email) && dao.checkUniquePhoneNumber(phoneNumber)) {
                    User user = new User();
                    user.setRole(role);
                    user.setPassword(password);
                    user.setLogin(login);
                    user.setEmail(email);
                    user.setName(name);
                    user.setSurname(surname);
                    user.setPhoneNumber(phoneNumber);
                    dao.add(user);
                    this.user = user;
                    return true;
                }
            } catch (DaoException e) {
                throw new LogicException("Can't add user",e);
            }
        }
        logger.log(Level.ERROR, "input mistake!");
        return false;
    }

    public User getUser() {
        return user;
    }
}
