package by.ryazantseva.salon.logic;

import by.ryazantseva.salon.dao.UserDAO;
import by.ryazantseva.salon.validation.RegistrationValidation;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class RegistrationLogic {
    private static Logger logger = LogManager.getLogger();

    public boolean addUser(String login, String password, String name, String surname, String email, String phoneNumber, String role,String repeatPass) {
        if (RegistrationValidation.checkInput(login, password, name, surname, email, phoneNumber, repeatPass)) {
            UserDAO dao = new UserDAO();
            if (dao.checkUniqueLogin(login)&&dao.checkUniqueEmail(email)) {
                dao.addUser(login, password, name, surname, email, phoneNumber, role);
                return true;
            }
            logger.log(Level.ERROR, "Such login is used!");
        }
        logger.log(Level.ERROR, "input mistake!");
        return false;
    }
}
