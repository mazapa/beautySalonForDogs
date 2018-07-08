package by.ryazantseva.salon.command;

import by.ryazantseva.salon.command.standartUserFunction.ChangeInformationCommand;
import by.ryazantseva.salon.command.standartUserFunction.ChangePasswordCommand;
import by.ryazantseva.salon.command.standartUserFunction.SignInCommand;
import by.ryazantseva.salon.command.standartUserFunction.RegistrationCommand;

public enum  CommandType {
    SIGN_IN {
        {
            this.command = new SignInCommand();
        }
    },SIGN_OUT {
        {
            this.command = new SignInCommand();
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
