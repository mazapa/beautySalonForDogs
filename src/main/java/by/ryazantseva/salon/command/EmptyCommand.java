package by.ryazantseva.salon.command;

import javax.servlet.http.HttpServletRequest;

public class EmptyCommand implements Command {

    public static final String EMPTY_STRING = "";

    @Override
    public String execute(HttpServletRequest request) {
        return EMPTY_STRING;
    }
}
