package by.ryazantseva.salon.dao;

import by.ryazantseva.salon.entity.User;
import by.ryazantseva.salon.exception.DaoException;

public abstract class AbstractUserDao extends AbstractDao<User> {

    public abstract void addReview(User user, String review) throws DaoException;
    public abstract User findUser(String login, String password) throws DaoException;
    public abstract boolean checkUniqueLogin(String data) throws DaoException;
    public abstract boolean checkUniqueEmail(String data) throws DaoException;
    public abstract boolean checkUniquePhoneNumber(String data) throws DaoException;




}
