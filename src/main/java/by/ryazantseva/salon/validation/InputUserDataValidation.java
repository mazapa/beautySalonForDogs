package by.ryazantseva.salon.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputUserDataValidation {
    private static final String REG_LOGIN = "^[a-zA-Z][a-zA-Z0-9-_.]{3,20}$";
    private static final String REG_NAME = "^[a-zA-Zа-яёА-ЯЁ]{1,20}$";
    private static final String REG_SURNAME = "^[a-zA-Zа-яёА-ЯЁ]{1,50}$";
    private static final String REG_EMAIL = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$";
    private static final String REG_PHONE_NUMBER = "^\\+\\d{12}$";
    private static final String REG_PASSWORD = "^(?=.*[0-9])(?=.*[a-zA-Z])(?=\\S+$).{6,}$";

    public static boolean checkInput(String login, String password, String name, String surname, String email, String phoneNumber, String repeatPassword) {
        return checkLogin(login) && checkPassword(password) && checkPasswordEquals(password, repeatPassword) && checkEmail(email)
                && checkName(name) && checkSurname(surname) && checkPhoneNumber(phoneNumber);
    }

    public static boolean checkLogin(String login) {
        Pattern pattern = Pattern.compile(REG_LOGIN);
        Matcher matcher = pattern.matcher(login);
        return matcher.find() && !login.isEmpty();
    }

    public static boolean checkName(String name) {
        Pattern pattern = Pattern.compile(REG_NAME);
        Matcher matcher = pattern.matcher(name);
        return matcher.find() && !name.isEmpty();
    }

    public static boolean checkSurname(String surname) {
        Pattern pattern = Pattern.compile(REG_SURNAME);
        Matcher matcher = pattern.matcher(surname);
        return matcher.find() && !surname.isEmpty();
    }

    public static boolean checkEmail(String email) {
        Pattern pattern = Pattern.compile(REG_EMAIL);
        Matcher matcher = pattern.matcher(email);
        return matcher.find() && !email.isEmpty();
    }

   public static boolean checkPhoneNumber(String phoneNumber) {
        Pattern pattern = Pattern.compile(REG_PHONE_NUMBER);
        Matcher matcher = pattern.matcher(phoneNumber);
        return matcher.find() && !phoneNumber.isEmpty();
    }

    public static boolean checkPasswordEquals(String password, String repeatPass) {
        return password.equals(repeatPass);

    }

    public static boolean checkPassword(String password) {
        Pattern pattern = Pattern.compile(REG_PASSWORD);
        Matcher matcher = pattern.matcher(password);
        return matcher.find() && !password.isEmpty();
    }
}
