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
    private static final String SQL_CHECK_UNIQUE_LOGIN =
            "SELECT id_person, name, surname, email, phone_number, login, password, role FROM person WHERE login = ? ";
    private static final String SQL_CHECK_UNIQUE_EMAIL =
            "SELECT id_person, name, surname, email, phone_number, login, password, role FROM person WHERE email = ? ";

    public boolean checkUniqueLogin(String login) {
        List<User> userList = new LinkedList<>();
        PreparedStatement prepareStatement = getPrepareStatement(SQL_CHECK_UNIQUE_LOGIN);
        try {
            prepareStatement.setString(1, login);
            ResultSet resultSet = prepareStatement.executeQuery();
            while (resultSet.next()) {
                userList.add(getInfAboutUser(resultSet));
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
    public boolean checkUniqueEmail(String email) {
        List<User> userList = new LinkedList<>();
        PreparedStatement prepareStatement = getPrepareStatement(SQL_CHECK_UNIQUE_EMAIL);
        try {
            prepareStatement.setString(1, email);
            ResultSet resultSet = prepareStatement.executeQuery();
            while (resultSet.next()) {
                userList.add(getInfAboutUser(resultSet));
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

    public void addUser(String login, String password, String name, String surname, String email, String phoneNumber, String role) {
        PreparedStatement prepareStatement = getPrepareStatement(SQL_ADD_USER);
        try {
            prepareStatement.setString(1, name);
            prepareStatement.setString(2, surname);
            prepareStatement.setString(3, email);
            prepareStatement.setString(4, phoneNumber);
            prepareStatement.setString(5, login);
            prepareStatement.setString(6, password);
            prepareStatement.setString(7, role);
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

    public boolean checkLoginAndPass(String login, String password) {
        List<User> userList = new LinkedList<>();
        PreparedStatement prepareStatement = getPrepareStatement(SQL_SELECT_USER_BY_LOGIN_AND_PASS);
        try {
            prepareStatement.setString(1, login);
            prepareStatement.setString(2, password);
            ResultSet resultSet = prepareStatement.executeQuery();
            while (resultSet.next()) {
                userList.add(getInfAboutUser(resultSet));
            }
            commitStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (prepareStatement != null) {
                closeStatement(prepareStatement);
            }
        }
        return !userList.isEmpty();

    }

    private User getInfAboutUser(ResultSet resultSet) {
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

    @Override
    public User update(User entity) {
        return null;
    }

    @Override
    public boolean add(User entity) {
        return false;
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
