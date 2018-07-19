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

//    SELECT DATE_FORMAT(colName, '%Y-%m-%d') DATEONLY,
//    DATE_FORMAT(colName,'%H:%i:%s') TIMEONLY

    @Override
    public List<Timestamp> findCloseServiceTime(String date) throws DaoException {
        PreparedStatement prepareStatement = getPrepareStatement(SQL_SELECT_CLOSE_TIME_BY_DAY);
        List<Timestamp> closeServiceTime = new ArrayList<>();
        try {
            prepareStatement.setString(1, date);
            ResultSet resultSet = prepareStatement.executeQuery();
            while (resultSet.next()) {
                closeServiceTime.add(resultSet.getTimestamp("date_time"));
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
