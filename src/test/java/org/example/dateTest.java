package org.example;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class dateTest {
    public static void main(String []args) {
        Date now = new Date();
        DateFormat sdf = new SimpleDateFormat("hh:mm:ss");
        String signinTime = sdf.format(now);
        String signouttime = "18:59:14";
        int i = signinTime.compareTo(signouttime);
        System.out.println(i);
    }
}
