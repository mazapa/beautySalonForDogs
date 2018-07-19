package by.ryazantseva.salon.command;

import by.ryazantseva.salon.command.user.*;

public enum  CommandType {
    LOGIN {
        {
            this.command = new LoginCommand();
        }
    },LOGOUT {
        {
            this.command = new LogoutCommand();
        }
    },SEND_PASSWORD {
        {
            this.command = new SendEmailPasswordCommand();
        }
    },ADD_REVIEW {
        {
            this.command = new AddReviewCommand();
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
