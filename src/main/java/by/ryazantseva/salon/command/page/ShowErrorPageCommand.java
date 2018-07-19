package by.ryazantseva.salon.command.page;

import by.ryazantseva.salon.command.Command;
import by.ryazantseva.salon.command.PageConstant;

import javax.servlet.http.HttpServletRequest;


public class ShowErrorPageCommand implements Command {

    public String execute(HttpServletRequest request) {
        return PageConstant.ERROR_PAGE;
    }
}
