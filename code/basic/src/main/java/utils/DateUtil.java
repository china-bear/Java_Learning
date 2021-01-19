package utils;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.format.ResolverStyle;

public class DateUtil {

    public static void main(String[] args) {

        System.out.println(convertToDate("dt=01-10-01"));

        String dateFormat = "'dt='MM-dd-yyyy";
        String dateString = "dt=05-26-2020";
        LocalDate parsedLocalDate = validateAndParseDateJava8(dateString, dateFormat);
        System.out.println(parsedLocalDate);

        Date parsedDate = validateAndParseDateJava7(dateString, dateFormat);
        System.out.println(parsedDate);

        System.out.println(getCurrTimestamp());
        System.out.println(getSecondTimestamp());

        Long currentTime = System.currentTimeMillis();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddhhmmsssss");
        Date date = new Date(currentTime);
        String time = simpleDateFormat.format(date);
        System.out.println(time);
    }

    // https://juejin.cn/post/6844903704014012430  在 Java 中初始化 List 的五种方法
    // List of all date formats that we want to parse.
    // Add your own format here.
    private static List<SimpleDateFormat> dateFormats = new ArrayList<SimpleDateFormat>() {{
        add(new SimpleDateFormat("M/dd/yyyy"));
        add(new SimpleDateFormat("dd.M.yyyy"));
        add(new SimpleDateFormat("M/dd/yyyy hh:mm:ss a"));
        add(new SimpleDateFormat("dd.M.yyyy hh:mm:ss a"));
        add(new SimpleDateFormat("dd.MM.yyyy"));
        add(new SimpleDateFormat("yyyy-MM-dd"));
        add(new SimpleDateFormat("'dt='yyyy-MM-dd"));
    }
    };


    /**
     * Convert String with various formats into java.util.Date
     *
     * @param input
     *            Date as a string
     * @return java.util.Date object if input string is parsed
     * 			successfully else returns null
     */
    public static Date convertToDate(String input) {
        Date date = null;
        if(null == input) {
            return null;
        }
        for (SimpleDateFormat format : dateFormats) {
            try {
                format.setLenient(false);
                date = format.parse(input);
            } catch (ParseException e) {
                System.out.println(e.getMessage());
                //Shhh.. try other formats
            }
            if (date != null) {
                break;
            }
        }

        return date;
    }

    //Java 8 - Use DateTimeFormatter (thread-safe)
    public static LocalDate validateAndParseDateJava8(String dateStr, String dateFormat) {

        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(dateFormat)
                .withResolverStyle(ResolverStyle.SMART);

        LocalDate date = null;
        try {
            date = LocalDate.parse(dateStr, dateFormatter);
        } catch (DateTimeParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    //Java 7 - Use SimpleDateFormat (not thread-safe)
    public static Date validateAndParseDateJava7(String dateString, String dateFormat) {
        Date date = null;
        DateFormat sdf = new SimpleDateFormat(dateFormat);
        sdf.setLenient(false);
        try {
            date = sdf.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    public static Timestamp getCurrTimestamp() {
        return new Timestamp(System.currentTimeMillis());
    }
    /**
     * 获取秒级时间戳
     *
     * @return
     */
    public static long getSecondTimestamp() {
        return (System.currentTimeMillis() / 1000);
    }


    public static String getCurrDateStr(String dateFormat) {
        return convertDateToStr(new Date(), dateFormat);
    }
    public static String convertDateToStr(Date date, String dateFormat) {
    return null;
    }

}
