package by.ryazantseva.salon.dao.impl;

import by.ryazantseva.salon.dao.AbstractDao;
import by.ryazantseva.salon.dao.AbstractServiceDao;
import by.ryazantseva.salon.entity.Service;
import by.ryazantseva.salon.entity.User;
import by.ryazantseva.salon.exception.DaoException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class ServiceDao extends AbstractServiceDao {

    private static final String SQL_SELECT_CLOSE_TIME_BY_DAY =
            "SELECT date_time FROM registration WHERE date_time = ?";
    private static final String SQL_SELECT_TIME_BETWEEN_TIME =
            "SELECT date_time FROM registration WHERE date_time BETWEEN ? AND  ?";
    private static final String SQL_SELECT_SERVICE_DURATION =
            "SELECT duration FROM service WHERE name = ?";
    private static final String SQL_ADD_SERVICE_REGISTRATION =
            "INSERT INTO registration (id_service, login, date_time) VALUES(?,?,?)";

    @Override
    public List<Long> findCloseServiceTime(String date) throws DaoException {
        PreparedStatement prepareStatement = getPrepareStatement(SQL_SELECT_CLOSE_TIME_BY_DAY);
        List<Long> closeServiceTime = new ArrayList<>();
        try {
            prepareStatement.setString(1, date);
            ResultSet resultSet = prepareStatement.executeQuery();
            while (resultSet.next()) {
                closeServiceTime.add(resultSet.getTimestamp("date_time").getTime());
            }
            commitStatement();
        } catch (SQLException e) {
            throw new DaoException("Can`t execute query <<find close service time>>!",e);
        } finally {
            if (prepareStatement != null) {
                closeStatement(prepareStatement);
            }
        }
        return closeServiceTime;
    }

    @Override
    public boolean checkCloseServiceTimeBetweenTime(Long startTime, Long finishTime) throws DaoException {
        PreparedStatement prepareStatement = getPrepareStatement(SQL_SELECT_TIME_BETWEEN_TIME);
        List<Timestamp> closeServiceTime = new ArrayList<>();
        try {
            prepareStatement.setLong(1, startTime);
            prepareStatement.setLong(2, finishTime);
            ResultSet resultSet = prepareStatement.executeQuery();
            while (resultSet.next()) {
                closeServiceTime.add(resultSet.getTimestamp("date_time"));
            }
            commitStatement();
        } catch (SQLException e) {
            throw new DaoException("Can`t execute query <<find close service time between time>>!",e);
        } finally {
            if (prepareStatement != null) {
                closeStatement(prepareStatement);
            }
        }
        return !closeServiceTime.isEmpty();
    }

    @Override
    public Integer findServiceDuration(String name) throws DaoException {
        PreparedStatement prepareStatement = getPrepareStatement(SQL_SELECT_SERVICE_DURATION);
        List<Integer> duration = new ArrayList<>();
        try {
            prepareStatement.setString(1, name);
            ResultSet resultSet = prepareStatement.executeQuery();
            while (resultSet.next()) {
                duration.add(resultSet.getInt("duration"));
            }
            commitStatement();
        } catch (SQLException e) {
            throw new DaoException("Can`t execute query <<find service duration>>!",e);
        } finally {
            if (prepareStatement != null) {
                closeStatement(prepareStatement);
            }
        }
        return duration.get(0);
    }

    @Override
    public void addServiceRegistration(int id_service, String login, Timestamp dateTime) throws DaoException {
        PreparedStatement prepareStatement = getPrepareStatement(SQL_ADD_SERVICE_REGISTRATION);
        try {
            prepareStatement.setInt(1, id_service);
            prepareStatement.setString(2, login);
            prepareStatement.setTimestamp(3, dateTime);
            prepareStatement.executeUpdate();
            commitStatement();
        } catch (SQLException e) {
            throw new DaoException("Can`t execute update <<add service registration>>!",e);
        } finally {
            if (prepareStatement != null) {
                closeStatement(prepareStatement);
            }
        }
    }


    @Override
    public void update(Service entity) throws DaoException {

    }

    @Override
    public void add(Service entity) throws DaoException {

    }

    @Override
    public boolean delete(Service entity) {
        return false;
    }
}
