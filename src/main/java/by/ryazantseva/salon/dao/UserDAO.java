package by.ryazantseva.salon.dao;

import by.ryazantseva.salon.entity.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class UserDAO extends AbstractDAO<User> {
    private static Logger logger = LogManager.getLogger();

    private static final String SQL_SELECT_USER_BY_LOGIN_AND_PASS =
            "SELECT id_person, name, surname, email, phone_number, login, password, role FROM person WHERE login = ? AND password = SHA1(?)";
    private static final String SQL_ADD_USER =
            "INSERT INTO person (name, surname, email, phone_number, login, password, role) VALUES(?,?,?,?,?,SHA1(?),?)";
     private static final String SQL_UPDATE_USER =
            "UPDATE person SET name = ?, surname = ?, email = ?, phone_number = ?, password = SHA1(?), role = ? WHERE login = ?";
    private static final String SQL_CHECK_UNIQUE_LOGIN =
            "SELECT id_person, name, surname, email, phone_number, login, password, role FROM person WHERE login = ? ";
    private static final String SQL_CHECK_UNIQUE_EMAIL =
            "SELECT id_person, name, surname, email, phone_number, login, password, role FROM person WHERE email = ? ";
    private static final String SQL_CHECK_UNIQUE_PHONE_NUMBER =
            "SELECT id_person, name, surname, email, phone_number, login, password, role FROM person WHERE phone_number = ? ";



    public User findUser(String login, String password) {
        List<User> userList = new LinkedList<>();
        PreparedStatement prepareStatement = getPrepareStatement(SQL_SELECT_USER_BY_LOGIN_AND_PASS);
        try {
            prepareStatement.setString(1, login);
            prepareStatement.setString(2, password);
            ResultSet resultSet = prepareStatement.executeQuery();
            while (resultSet.next()) {
                userList.add(getUserFromDB(resultSet));
            }
            commitStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (prepareStatement != null) {
                closeStatement(prepareStatement);
            }
        }
        if(!userList.isEmpty()){
            return userList.get(0);
        }

        return null;

    }


    private User getUserFromDB(ResultSet resultSet) {
        User user = new User();
        try {
            user.setPersonId(resultSet.getInt("id_person"));
            user.setName(resultSet.getString("name"));
            user.setSurname(resultSet.getString("surname"));
            user.setEmail(resultSet.getString("email"));
            user.setPhoneNumber(resultSet.getString("phone_number"));
            user.setLogin(resultSet.getString("login"));
            user.setPassword(resultSet.getString("password"));
            user.setRole(resultSet.getString("role"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public boolean checkUniqueLogin(String data) {
        PreparedStatement prepareStatement = getPrepareStatement(SQL_CHECK_UNIQUE_LOGIN);
        return checkUniqueData(prepareStatement,data);

    }
    public boolean checkUniqueEmail(String data) {
        PreparedStatement prepareStatement = getPrepareStatement(SQL_CHECK_UNIQUE_EMAIL);
        return checkUniqueData(prepareStatement,data);
    }

    public boolean checkUniquePhoneNumber(String data) {
        PreparedStatement prepareStatement = getPrepareStatement(SQL_CHECK_UNIQUE_PHONE_NUMBER);
        return checkUniqueData(prepareStatement,data);
    }

    private boolean checkUniqueData(PreparedStatement prepareStatement,String data){
        List<User> userList = new LinkedList<>();
        try {
            prepareStatement.setString(1, data);
            ResultSet resultSet = prepareStatement.executeQuery();
            while (resultSet.next()) {
                userList.add(getUserFromDB(resultSet));
            }
            commitStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (prepareStatement != null) {
                closeStatement(prepareStatement);
            }
        }
        return userList.isEmpty();
    }

    @Override
    public void add(User user) {
        PreparedStatement prepareStatement = getPrepareStatement(SQL_ADD_USER);
        try {
            prepareStatement.setString(1, user.getName());
            prepareStatement.setString(2, user.getSurname());
            prepareStatement.setString(3, user.getEmail());
            prepareStatement.setString(4, user.getPhoneNumber());
            prepareStatement.setString(5, user.getLogin());
            prepareStatement.setString(6, user.getPassword());
            prepareStatement.setString(7, user.getRole());
            prepareStatement.executeUpdate();
            commitStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (prepareStatement != null) {
                closeStatement(prepareStatement);
            }
        }
    }

    @Override
    public void update(User user) {
        PreparedStatement prepareStatement = getPrepareStatement(SQL_UPDATE_USER);
        try {
            prepareStatement.setString(1, user.getName());
            prepareStatement.setString(2, user.getSurname());
            prepareStatement.setString(3, user.getEmail());
            prepareStatement.setString(4, user.getPhoneNumber());
            prepareStatement.setString(5, user.getPassword());
            prepareStatement.setString(6, user.getRole());
            prepareStatement.setString(7, user.getLogin());
            prepareStatement.executeUpdate();
            commitStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (prepareStatement != null) {
                closeStatement(prepareStatement);
            }
        }

    }


    @Override
    public boolean delete(User entity) {
        return false;
    }

    @Override
    public boolean create(User entity) {
        return false;
    }
}
