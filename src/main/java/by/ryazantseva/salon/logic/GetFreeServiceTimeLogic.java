package by.ryazantseva.salon.logic;

import by.ryazantseva.salon.dao.impl.ServiceDao;
import by.ryazantseva.salon.exception.DaoException;
import by.ryazantseva.salon.exception.LogicException;
import by.ryazantseva.salon.validation.DateValidation;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class GetFreeServiceTimeLogic {
    private static final String START_WORKING_DAY_TIME = "8:00:00";
    private static final String FINISH_WORKING_DAY_TIME = "18:00:00";
    private static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
    private static final String SPACE = " ";
    private static final long ONE_MINUTE_IN_MILLIS = 60000;
    private static final int DIFFERENCE_BETWEEN_TIME_REGISTRATION = 15;

    public boolean findTime(String date, String serviceName) throws LogicException {
        if (DateValidation.checkDate(date)) {/////////????????????validation
            DateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);
            long currentDate;
            long finishWorkingDate;
            try {
                dateFormat.parse(date + SPACE + START_WORKING_DAY_TIME);
                currentDate = dateFormat.getCalendar().getTimeInMillis();
                dateFormat.parse(date + SPACE + FINISH_WORKING_DAY_TIME);
                finishWorkingDate = dateFormat.getCalendar().getTimeInMillis();
            } catch (ParseException e) {
                throw new LogicException("Incorrect input date!", e);
            }

            //////////////////
            System.out.println("Current Date Time : " + dateFormat.format(currentDate));
            System.out.println("Current Date Time : " + dateFormat.format(finishWorkingDate));
            ///////////////////////////

            ServiceDao dao = new ServiceDao();
            try {
                List<Long> closeServiceTime = dao.findCloseServiceTime(date);
                long serviceDuration = dao.findServiceDuration(serviceName);
                List<Long> timetable = new LinkedList<>();

                while (currentDate <= finishWorkingDate) {
                    if (!closeServiceTime.contains(currentDate)
                            && !dao.checkCloseServiceTimeBetweenTime(currentDate, currentDate + ONE_MINUTE_IN_MILLIS * serviceDuration)) {
                        timetable.add(currentDate);
                    }
                    currentDate  = currentDate+ (ONE_MINUTE_IN_MILLIS * DIFFERENCE_BETWEEN_TIME_REGISTRATION);
                }

                for (long c: timetable) {
                    System.out.println(dateFormat.format(c));
                }

            } catch (DaoException e) {
                throw new LogicException("Cant find free timetable", e);
            }

        }
        return false;
    }


}
