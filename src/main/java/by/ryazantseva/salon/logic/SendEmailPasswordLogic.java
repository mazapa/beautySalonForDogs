package by.ryazantseva.salon.logic;

import by.ryazantseva.salon.dao.impl.UserDao;
import by.ryazantseva.salon.validation.PasswordGenerator;
import by.ryazantseva.salon.validation.PasswordGeneratorBuilder;

public class SendEmailPasswordLogic {

    public static final int MIN_PASSWORD_LENGTH = 6;
    public static final int MAX_PASSWORD_LENGTH = 10;

    public boolean sendPassword(String email) {
        UserDao dao = new UserDao();
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
