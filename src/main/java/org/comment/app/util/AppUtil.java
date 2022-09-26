package org.comment.app.util;

import org.comment.app.constant.Constant;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class AppUtil {

    public static String getUser() {
        return "tester";
    }

    public static String getVersion() {
        return "1.0.0";
    }

    public static String getCurrentTimeString() {
        return LocalDate.now().format(DateTimeFormatter.ofPattern(Constant.TIME_FORMAT));
    }

}
