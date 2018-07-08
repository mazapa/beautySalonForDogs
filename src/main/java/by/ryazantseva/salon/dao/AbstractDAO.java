package by.ryazantseva.salon.dao;

import by.ryazantseva.salon.connection.ConnectionPool;
import by.ryazantseva.salon.connection.ProxyConnection;
import by.ryazantseva.salon.entity.Entity;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public abstract class AbstractDAO<Type extends Entity> {
    private ProxyConnection connection;
    private static Logger logger = LogManager.getLogger();


    public AbstractDAO() {
        connection = ConnectionPool.getInstance().getConnection();
    }

    public abstract void update(Type entity);
    public abstract void add(Type entity);
    public abstract boolean delete(Type entity);
    public abstract boolean create(Type entity);

    public PreparedStatement getPrepareStatement(String sql) {
        PreparedStatement statement = null;
        try {
            connection.setAutoCommit(false);
            statement = connection.prepareStatement(sql);
        } catch (SQLException e) {
            logger.log(Level.ERROR, "Cant get prepareStatement");
        }
        return statement;
    }

    public void commitStatement() {
        try {
            connection.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            logger.log(Level.ERROR, "Cant commit statement");
            try {
                connection.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
                logger.log(Level.ERROR, "Cant rollback statement");

            }
        }
    }

    public void closeStatement(Statement statement) {
        try {
            if (statement != null) {
                statement.close();
            }
        } catch (SQLException e) {
            logger.log(Level.ERROR, "Cant close statement");
        }
    }

    public void closeConnection(ProxyConnection connection) {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            logger.log(Level.ERROR, "Cant close connection");
        }
    }

}
