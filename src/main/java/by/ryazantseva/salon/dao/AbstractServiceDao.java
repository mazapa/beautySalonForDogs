package by.ryazantseva.salon.dao;

import by.ryazantseva.salon.entity.Service;
import by.ryazantseva.salon.entity.User;
import by.ryazantseva.salon.exception.DaoException;

import java.sql.Timestamp;
import java.util.List;

public abstract class AbstractServiceDao extends AbstractDao<Service> {

    public abstract List<Long> findCloseServiceTime(String date) throws DaoException ;
    public abstract boolean checkCloseServiceTimeBetweenTime(Long startTime, Long finishTime) throws DaoException ;
    public abstract Integer findServiceDuration(String name) throws DaoException ;
    public abstract void addServiceRegistration(int id_service, String login, Timestamp dateTime) throws DaoException ;

}
