package by.ryazantseva.salon.logic;

import by.ryazantseva.salon.dao.impl.UserDao;
import by.ryazantseva.salon.entity.User;
import by.ryazantseva.salon.validation.InputUserDataValidation;

public class ChangeInformationLogic {
   // private User user;

    public boolean changeInformation(User user, String name, String surname, String email, String phoneNumber) {
        if (InputUserDataValidation.checkSurname(surname) && InputUserDataValidation.checkName(name)
                && InputUserDataValidation.checkPhoneNumber(phoneNumber) && InputUserDataValidation.checkEmail(email)) {
            user.setName(name);
            user.setSurname(surname);
            user.setPhoneNumber(phoneNumber);
            user.setEmail(email);
            UserDao dao = new UserDao();
            dao.update(user);
           // this.user = user;
            return true;

        }
        return false;
    }

//    public User getUser() {
//        return user;
//
//    }

}
