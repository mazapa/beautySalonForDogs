package by.ryazantseva.salon.logic;
import by.ryazantseva.salon.dao.impl.UserDao;
import by.ryazantseva.salon.entity.User;

public class LoginLogic {
    private User user;
    public boolean checkData(String login, String password) {
        if (login != null && !login.isEmpty() && password != null && !password.isEmpty()) {
            UserDao dao = new UserDao();
            user = dao.findUser(login, password);
            return  user != null;
        }
        return false;
    }

    public User getUser(){
        return user;

    }

}
