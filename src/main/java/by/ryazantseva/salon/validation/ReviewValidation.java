package by.ryazantseva.salon.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReviewValidation {
    private static final String REG_REVIEW = "^[a-zA-Z0-9_./!@#$%^&*()+=-\\|?,<>\\s]{1,500}$"; ///////??????????

    public static boolean checkReview(String review){
        review = ScriptValidation.replaceScript(review);
        Pattern pattern = Pattern.compile(REG_REVIEW);
        Matcher matcher = pattern.matcher(review);
        return review != null && matcher.find() && !review.isEmpty();
    }
}
