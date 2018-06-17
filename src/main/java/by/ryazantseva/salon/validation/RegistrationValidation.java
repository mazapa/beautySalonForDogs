package by.ryazantseva.salon.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegistrationValidation {
    private static final String REG_LOGIN = "^[a-zA-Z][a-zA-Z0-9-_\\.]{1,20}$";
    private static final String REG_NAME = "^[a-zA-Zа-яёА-ЯЁ]{1,20}$";
    private static final String REG_SURNAME = "^[a-zA-Zа-яёА-ЯЁ]{1,50}$";
    private static final String REG_EMAIL = "^[-\\w.]+@([A-z0-9][-A-z0-9]+\\.)+[A-z]{2,4}$";
    private static final String REG_PHONE_NUMBER = "^\\+\\d{12}$";
    private static final String REG_PASSWORD = "(?=^.{6,}$)((?=.*\\d)|(?=.*\\W+))(?![.\\n])(?=.*[A-Z])(?=.*[a-z]).*$";

    public static boolean checkInput(String login, String password, String name, String surname, String email, String phoneNumber, String repeatPass) {
        return login != null && !login.isEmpty() && password != null && !password.isEmpty()
                && checkLogin(login)/* && checkPassword(password,repeatPass) /*&&checkEmail(email)*/
                && checkName(name) && checkSurname(surname) && checkPhoneNumber(phoneNumber);
    }

    private static boolean checkLogin(String login) {
        Pattern pattern = Pattern.compile(REG_LOGIN);
        Matcher matcher = pattern.matcher(login);
        return matcher.find();
    }
    private static boolean checkName(String name) {
        Pattern pattern = Pattern.compile(REG_NAME);
        Matcher matcher = pattern.matcher(name);
        return matcher.find();
    }
    private static boolean checkSurname(String surname) {
        Pattern pattern = Pattern.compile(REG_SURNAME);
        Matcher matcher = pattern.matcher(surname);
        return matcher.find();
    }
//    private static boolean checkEmail(String email) {
//        Pattern pattern = Pattern.compile(REG_EMAIL);
//        Matcher matcher = pattern.matcher(email);
//        return matcher.find();
//    }
    private static boolean checkPhoneNumber(String phoneNumber) {
        Pattern pattern = Pattern.compile(REG_PHONE_NUMBER);
        Matcher matcher = pattern.matcher(phoneNumber);
        return matcher.find();
    }

    private static boolean checkPassword(String password,String repeatPass) {
        Pattern pattern = Pattern.compile(REG_PASSWORD);
        Matcher matcher = pattern.matcher(password);
        return matcher.find() && password.equals(repeatPass);
    }
}
