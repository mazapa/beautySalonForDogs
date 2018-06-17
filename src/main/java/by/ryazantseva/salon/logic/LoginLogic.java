package by.ryazantseva.salon.logic;
import by.ryazantseva.salon.dao.UserDAO;

public class LoginLogic {
    public boolean checkData(String login, String password) {
        if (login != null && !login.isEmpty() && password != null && !password.isEmpty()) {
            UserDAO dao = new UserDAO();
            return dao.checkLoginAndPass(login, password);
        }
        return false;
    }


}
