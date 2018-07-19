package by.ryazantseva.salon.dao;

import by.ryazantseva.salon.entity.Service;
import by.ryazantseva.salon.entity.User;
import by.ryazantseva.salon.exception.DaoException;

import java.sql.Timestamp;
import java.util.List;

public abstract class AbstractServiceDao extends AbstractDao<Service> {

    public abstract List<Timestamp> findCloseServiceTime(String date) throws DaoException ;

}
