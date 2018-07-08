package by.ryazantseva.salon.command;

import by.ryazantseva.salon.command.standartUserFunction.ChangeInformationCommand;
import by.ryazantseva.salon.command.standartUserFunction.ChangePasswordCommand;
import by.ryazantseva.salon.command.standartUserFunction.LoginCommand;
import by.ryazantseva.salon.command.standartUserFunction.RegistrationCommand;

public enum  CommandType {
    LOGIN {
        {
            this.command = new LoginCommand();
        }
    },
   CHANGE_PASSWORD {
        {
            this.command = new ChangePasswordCommand();
        }
    },
   CHANGE_INFORMATION {
        {
            this.command = new ChangeInformationCommand();
        }
    },

    REGISTRATION {
        {
            this.command = new RegistrationCommand();
        }
    };

    Command command;
    public Command getCurrentCommand() {
        return command;
    }

}
