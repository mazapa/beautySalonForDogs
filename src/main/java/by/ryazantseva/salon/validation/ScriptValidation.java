package by.ryazantseva.salon.validation;

public class ScriptValidation {
    private static final String OPEN_SCRIPT = "<script>";
    private static final String CLOSE_SCRIPT = "</script>";
    private static final String EMPTY = "";

    public static String replaceScript(String string){
        return string.replace(OPEN_SCRIPT,EMPTY).replace(CLOSE_SCRIPT,EMPTY);
    }
}
