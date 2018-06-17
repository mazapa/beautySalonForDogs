package by.ryazantseva.salon.command;

public enum  CommandType {
    LOGIN {
        {
            this.command = new LoginCommand();
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
