
import utility.attendanceUtil.findCheck;
import utility.jdbcUtil.jdbcUtils;

import java.util.Date;

public class jdbcTest {
    public static void main(String []args){
        jdbcUtils j = new jdbcUtils();
        j.getConnection();
//     findCheck fc = new findCheck();
//     Date now = new Date();
//     java.sql.Date today = new java.sql.Date(now.getTime());
//      fc.findSigninTime(1,today);



    }
}
