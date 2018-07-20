package by.ryazantseva.salon.dao.impl;

import by.ryazantseva.salon.dao.AbstractUserDao;
import by.ryazantseva.salon.entity.User;
import by.ryazantseva.salon.exception.DaoException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class UserDao extends AbstractUserDao {
    private static Logger logger = LogManager.getLogger();

    private static final String SQL_SELECT_USER_BY_LOGIN_AND_PASS =
            "SELECT name, surname, email, phone_number, login, password, role FROM person WHERE login = ? AND password = SHA1(?)";
    private static final String SQL_ADD_USER =
            "INSERT INTO person (name, surname, email, phone_number, login, password, role) VALUES(?,?,?,?,?,SHA1(?),?)";
    private static final String SQL_UPDATE_USER =
            "UPDATE person SET name = ?, surname = ?, email = ?, phone_number = ?, password = SHA1(?), role = ? WHERE login = ?";
    private static final String SQL_CHECK_UNIQUE_LOGIN =
            "SELECT  name, surname, email, phone_number, login, password, role FROM person WHERE login = ? ";
    private static final String SQL_CHECK_UNIQUE_EMAIL =
            "SELECT name, surname, email, phone_number, login, password, role FROM person WHERE email = ? ";
    private static final String SQL_CHECK_UNIQUE_PHONE_NUMBER =
            "SELECT name, surname, email, phone_number, login, password, role FROM person WHERE phone_number = ? ";
    private static final String SQL_ADD_REVIEW =
            "INSERT INTO review (review,login) VALUES(?,?)";


    @Override
    public void addReview(User user, String review) throws DaoException {
        PreparedStatement prepareStatement = getPrepareStatement(SQL_ADD_REVIEW);
        try {
            prepareStatement.setString(1, review);
            prepareStatement.setString(2, user.getLogin());
            prepareStatement.executeUpdate();
            commitStatement();
        } catch (SQLException e) {
            throw new DaoException("Can`t execute update <<add review>>!",e);
        } finally {
            if (prepareStatement != null) {
                closeStatement(prepareStatement);
            }
        }

    }

    @Override
    public User findUser(String login, String password) throws DaoException {
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
            throw new DaoException("Can`t execute query <<find user>>!",e);
        } finally {
            if (prepareStatement != null) {
                closeStatement(prepareStatement);
            }
        }
        if (!userList.isEmpty()) {
            return userList.get(0);
        }
        return null;
    }


    private User getUserFromDB(ResultSet resultSet) throws DaoException {
        User user = new User();
        try {
            user.setName(resultSet.getString("name"));
            user.setSurname(resultSet.getString("surname"));
            user.setEmail(resultSet.getString("email"));
            user.setPhoneNumber(resultSet.getString("phone_number"));
            user.setLogin(resultSet.getString("login"));
            user.setPassword(resultSet.getString("password"));
            user.setRole(resultSet.getString("role"));
        } catch (SQLException e) {
            throw new DaoException("Can`t get information about user in result set!",e);
        }
        return user;
    }

    @Override
    public boolean checkUniqueLogin(String data) throws DaoException {
        PreparedStatement prepareStatement = getPrepareStatement(SQL_CHECK_UNIQUE_LOGIN);
        return checkUniqueData(prepareStatement, data);

    }

    @Override
    public boolean checkUniqueEmail(String data) throws DaoException {
        PreparedStatement prepareStatement = getPrepareStatement(SQL_CHECK_UNIQUE_EMAIL);
        return checkUniqueData(prepareStatement, data);
    }

    @Override
    public boolean checkUniquePhoneNumber(String data) throws DaoException {
        PreparedStatement prepareStatement = getPrepareStatement(SQL_CHECK_UNIQUE_PHONE_NUMBER);
        return checkUniqueData(prepareStatement, data);
    }

    private boolean checkUniqueData(PreparedStatement prepareStatement, String data) throws DaoException {
        List<User> userList = new LinkedList<>();
        try {
            prepareStatement.setString(1, data);
            ResultSet resultSet = prepareStatement.executeQuery();
            while (resultSet.next()) {
                userList.add(getUserFromDB(resultSet));
            }
            commitStatement();
        } catch (SQLException e) {
            throw new DaoException("Can`t execute query <<check unique data>>!",e);
        } finally {
            if (prepareStatement != null) {
                closeStatement(prepareStatement);
            }
        }
        return userList.isEmpty();
    }

    @Override
    public void add(User user) throws DaoException {
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
            throw new DaoException("Can`t execute update <<add user>>!",e);
        } finally {
            if (prepareStatement != null) {
                closeStatement(prepareStatement);
            }
        }
    }

    @Override
    public void update(User user) throws DaoException {
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
            throw new DaoException("Can`t execute update user!",e);
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

}
