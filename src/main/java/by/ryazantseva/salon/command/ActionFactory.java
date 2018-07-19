package by.ryazantseva.salon.command;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;

public class ActionFactory {
    private static Logger logger = LogManager.getLogger();

    public Command defineCommand(HttpServletRequest request) {
        Command command = new EmptyCommand();
        String action = request.getParameter("command");
        if (action == null || action.isEmpty()) {
            throw new RuntimeException("Wrong command!");
        }
        try {
            CommandType currentCommandType = CommandType.valueOf(action.toUpperCase());
            command = currentCommandType.getCurrentCommand();
        } catch (IllegalArgumentException e) {
            throw new RuntimeException("Wrong command!");
        }
        return command;
    }
}
