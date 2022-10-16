package org.comment.app.util;

import org.comment.app.constant.Constant;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AppUtil {

    public static String getUser() {
        return "tester";
    }

    public static String getVersion() {
        return "1.0.0";
    }

    public static String getCurrentTimeString() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern(Constant.TIME_FORMAT));
    }

}
