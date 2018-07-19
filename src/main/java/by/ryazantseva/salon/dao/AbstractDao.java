package by.ryazantseva.salon.dao;

import by.ryazantseva.salon.connection.ConnectionPool;
import by.ryazantseva.salon.connection.ProxyConnection;
import by.ryazantseva.salon.entity.Entity;
import by.ryazantseva.salon.exception.DaoException;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public abstract class AbstractDao<Type extends Entity> implements AutoCloseable {
    private ProxyConnection connection;
    private static Logger logger = LogManager.getLogger();


    public AbstractDao() {
        connection = ConnectionPool.getInstance().getConnection();
    }

    public abstract void update(Type entity) throws DaoException;

    public abstract void add(Type entity) throws DaoException;

    public abstract boolean delete(Type entity);


    public PreparedStatement getPrepareStatement(String sql) throws DaoException {
        PreparedStatement statement = null;
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(sql);
        } catch (SQLException e) {
            throw new DaoException("Cant get prepareStatement", e);
        }
        return statement;
    }

    public void commitStatement() throws DaoException {
        try {
            connection.commit();
        } catch (SQLException e) {
            try {
                logger.log(Level.ERROR, "Cant commit statement. Rollback changes.");
                connection.rollback();
            } catch (SQLException e1) {
                throw new DaoException("Cant commit statement", e);
            }
        }
    }

    public void closeStatement(Statement statement) throws DaoException {
        try {
            if (statement != null) {
                statement.close();
            }
        } catch (SQLException e) {
            throw new DaoException("Can`t close statement", e);
        }
    }

    public void close() throws DaoException {
        closeConnection(this.connection);
    }

    private void closeConnection(ProxyConnection connection) throws DaoException {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            throw new DaoException("Cant close connection", e);
            }
    }

}
