package by.ryazantseva.salon.logic;

import by.ryazantseva.salon.dao.impl.ServiceDao;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class GetFreeServiceTimeLogic {
    private static final String START_WORKING_DAY_TIME = "8:00:00";
    private static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
    public static final String SPACE = " ";

    public static void main(String[] args) {
        GetFreeServiceTimeLogic logic = new GetFreeServiceTimeLogic();
        logic.findTime("2018-07-12");
    }

    public boolean findTime(String date) {
        //            java.util.Date tdate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2011-05-18 16:29:31");
//            java.sql.Timestamp timestamp = new java.sql.Timestamp(tdate.getTime());
//        Date now = new Date();
//        Timestamp timestamp = new Timestamp(now.getTime());
//        System.out.println(timestamp.);
        if (date == null || date.isEmpty()) {
            //log
            return false;
        }

        DateFormat dateFormat = new SimpleDateFormat(DATE_FORMAT);
        Calendar calendar = Calendar.getInstance();
        try {
            dateFormat.parse(date + SPACE + START_WORKING_DAY_TIME);
        } catch (ParseException e) {
            e.printStackTrace();
            //log
        }
        System.out.println("Current Date Time : " + dateFormat.format(calendar.getTime()));

        ServiceDao dao = new ServiceDao();
        List<Timestamp> closeServiceTime = dao.findCloseServiceTime(date);
        Map<Calendar, Boolean> timetable = new HashMap<>();

        for (int i = 0; i < 39; i++) {

        }


        return false;
    }


}
