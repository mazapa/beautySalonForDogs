package by.ryazantseva.salon.logic;

import by.ryazantseva.salon.dao.UserDAO;
import by.ryazantseva.salon.validation.PasswordGenerator;
import by.ryazantseva.salon.validation.PasswordGeneratorBuilder;

import java.util.Random;

public class SendEmailPasswordLogic {

    public static final int MIN_PASSWORD_LENGTH = 6;
    public static final int MAX_PASSWORD_LENGTH = 10;

    public boolean sendPassword(String email) {
        UserDAO dao = new UserDAO();
        if(dao.checkUniqueEmail(email)){
        }





        return false;
    }

    private String generatePassword(int length){
        PasswordGeneratorBuilder passwordBuilder = new PasswordGeneratorBuilder();
        passwordBuilder.useDigits(true);
        passwordBuilder.useLower(true);
        passwordBuilder.useUpper(true);
        PasswordGenerator passwordGenerator = passwordBuilder.build();
        String password = passwordGenerator.generate(length);
        return password;
    }


}
