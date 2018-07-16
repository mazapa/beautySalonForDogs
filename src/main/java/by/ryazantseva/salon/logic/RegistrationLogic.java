package by.ryazantseva.salon.logic;

import by.ryazantseva.salon.dao.UserDAO;
import by.ryazantseva.salon.entity.User;
import by.ryazantseva.salon.validation.InputUserDataValidation;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.jws.soap.SOAPBinding;

public class RegistrationLogic {
    private static Logger logger = LogManager.getLogger();
    private User user;

    public boolean addUser(String login, String password, String name, String surname, String email, String phoneNumber, String role, String repeatPass) {
        if (InputUserDataValidation.checkInput(login, password, name, surname, email, phoneNumber, repeatPass)) {
            UserDAO dao = new UserDAO();
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
            logger.log(Level.ERROR, "Such login is used!");
        }
        logger.log(Level.ERROR, "input mistake!");
        return false;
    }

    public User getUser() {
        return user;
    }
}
