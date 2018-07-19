package by.ryazantseva.salon.command;

import by.ryazantseva.salon.command.page.*;
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
   SHOW_CHANGE_PASSWORD_PAGE {
        {
            this.command = new ShowChangePasswordPageCommand();
        }
    },
   SHOW_CHANGE_INFORMATION_PAGE {
        {
            this.command = new ShowChangeInformationPageCommand();
        }
    },
   SHOW_REGISTRATION_PAGE {
        {
            this.command = new ShowRegistrationPageCommand();
        }
    },

   SHOW_REVIEW_PAGE {
        {
            this.command = new ShowReviewPageCommand();
        }
    },

   SHOW_ERROR_PAGE {
        {
            this.command = new ShowErrorPageCommand();
        }
    },

   SHOW_LOGIN_PAGE {
        {
            this.command = new ShowLoginPageCommand();
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
