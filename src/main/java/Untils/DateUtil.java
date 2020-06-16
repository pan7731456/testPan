package Untils;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.commons.lang3.time.DateUtils;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by xiaozhong on 2019/3/29.
 */
public class DateUtil {
    /**
     * 获取时间
     *
     * @param pattern
     * @return
     */
    public static String getStringDate(String pattern) {
        Date currentTime = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat(pattern);
        String dateString = formatter.format(currentTime);
        return dateString;
    }

    public static Date timeStamp(Date date, Date time) {
        Integer hour = truncateTime(time, Calendar.HOUR_OF_DAY);
        Integer minute = truncateTime(time, Calendar.MINUTE);
        date = DateUtils.addHours(date, hour);
        return DateUtils.addMinutes(date, minute);
    }

    public static Date crossDay(Date date, Date starTime, Date endTime) {
        date = truncateDate(date, Calendar.DAY_OF_MONTH);
        if (endTime.before(starTime) || endTime.equals(starTime)) {
            date = DateUtils.addDays(date, 1);
        }
        return date;
    }


    /**
     * 截取日期
     */
    public static Date truncateDate(Date date, int num) {
        switch (num) {
            case Calendar.DAY_OF_MONTH:
                date = DateUtils.truncate(date, Calendar.DAY_OF_MONTH);
                break;
            case Calendar.HOUR_OF_DAY:
                date = DateUtils.truncate(date, Calendar.HOUR_OF_DAY);
                break;
            case Calendar.MINUTE:
                date = DateUtils.truncate(date, Calendar.MINUTE);
                break;
        }
        return date;
    }


    public static Integer truncateTime(Date time, int num) {
        int no = 0;
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(time);
        switch (num) {
            case Calendar.HOUR_OF_DAY:
                no = calendar.get(Calendar.HOUR_OF_DAY);
                break;
            case Calendar.MINUTE:
                no = calendar.get(Calendar.MINUTE);
                break;
        }
        return no;
    }

    /**
     * 获取上月的最小时间/最大时间
     *
     * @param now  传入的上月时间
     * @param most min为最小时间,max为最大时间
     * @return
     */
    public static Date getLastMonthTime(Date now, String most) {
        int year = now.getYear() + 1900;
        int month = now.getMonth();

        //上个月计算
        if (month == 1) {
            year -= 1;
            month = 12;
        } else {
            month -= 1;
        }

        if ("min".equals(most)) {
            return getFirstDay(year, month);
        } else if ("max".equals(most)) {
            return getActualMonthMaximum(year, month);
        } else {
            //不做处理
            return now;
        }
    }

    public static Date getActualMonthMaximum(int year, int month) {
        Calendar startCalendar = Calendar.getInstance();
        startCalendar.clear();
        startCalendar.set(Calendar.YEAR, year);
        startCalendar.set(Calendar.MONTH, month);
        startCalendar.set(Calendar.DAY_OF_MONTH, startCalendar.getActualMaximum(Calendar.DAY_OF_MONTH));
        startCalendar.set(Calendar.HOUR_OF_DAY, startCalendar.getActualMaximum(Calendar.HOUR_OF_DAY));
        startCalendar.set(Calendar.MINUTE, startCalendar.getActualMaximum(Calendar.MINUTE));
        startCalendar.set(Calendar.SECOND, startCalendar.getActualMaximum(Calendar.SECOND));
        return startCalendar.getTime();
    }

    /**
     * 根据年月获取该月份的第一天 0:00:00 的形式的时间
     */
    public static Date getFirstDay(int year, int month) {
        Calendar startCalendar = Calendar.getInstance();
        startCalendar.clear();
        startCalendar.set(Calendar.YEAR, year);
        startCalendar.set(Calendar.MONTH, month);
        return startCalendar.getTime();
    }

    public static Date getTimeZeroPoint(Date date) {
        Calendar startCalendar = Calendar.getInstance();
        startCalendar.clear();
        startCalendar.set(Calendar.YEAR, date.getYear() + 1900);
        startCalendar.set(Calendar.MONTH, date.getMonth());
        startCalendar.set(Calendar.DAY_OF_MONTH, date.getDate()); // 只有date才能精确到天,使用day反而不精确
        return startCalendar.getTime();
    }


    public static String currentDate() {
        Date date = truncateDate(new Date(), Calendar.HOUR_OF_DAY);
        return DateFormatUtils.format(date, "yyyy-MM-dd");
    }


    public static Date localDateToDate(LocalDate dateToConvert) {
        return Date.from(dateToConvert.atStartOfDay()
                .atZone(ZoneId.systemDefault())
                .toInstant());
    }


    /**
     * @param date
     * @return
     */
    public static LocalDate dateToLocalDate(Date date) {
        Instant instant = date.toInstant();
        ZoneId zoneId = ZoneId.systemDefault();
        // atZone()方法返回在指定时区从此Instant生成的ZonedDateTime。
        // LocalDate localDate = instant.atZone(zoneId).toLocalDate();
        return instant.atZone(zoneId).toLocalDate();
    }

    /**
     * 获取一周中不排班的日期
     *
     * @param weekdays
     * @return
     */
    public static List<String> getHolidays(String weekdays) {
        List<String> filter = new ArrayList<>();
        List<String> days = Arrays.asList("1", "2", "3", "4", "5", "6", "7");
        days = days
                .stream()
                .filter(s -> !weekdays.contains(s))
                .collect(Collectors.toList());
        List<Integer> num = days.stream().map(s -> Integer.parseInt(s)).collect(Collectors.toList());
        for (Integer n : num) {
            ++n;
            if (n == 8) {
                n = 1;
            }
            filter.add(String.valueOf(n));
        }
        return filter;
    }
}
