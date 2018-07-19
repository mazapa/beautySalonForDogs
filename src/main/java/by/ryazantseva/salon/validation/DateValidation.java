package by.ryazantseva.salon.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DateValidation {
    private static final String REG_DATE = "^[0-9]{4}-(0[1-9]|1[012])-(0[1-9]|1[0-9]|2[0-9]|3[01])$";

    public static boolean checkDate(String date) {
        date = ScriptValidation.replaceScript(date);
        Pattern pattern = Pattern.compile(REG_DATE);
        Matcher matcher = pattern.matcher(date);
        return date != null && matcher.find() && !date.isEmpty();
    }
}
