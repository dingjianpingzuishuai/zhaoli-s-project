package utility.attendanceUtil;
import javaBean.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class check {
    public int signin(int empID) {
        String whetherlate = null;
        findCheck fc = new findCheck();
        saveCheck sc = new saveCheck();
        Date now = new Date();
        java.sql.Date today = new java.sql.Date(now.getTime());
        boolean flag = fc.findSigninTime(empID, today);
        int n = 0;
        if (flag) {
            System.out.println("您已经签到过啦");
            return 2;
        } else {
            /*dutyBean duty = new dutyBean();
            duty.setEid(eid);
            duty.setDtdata(today);*/
            DateFormat sdf = new SimpleDateFormat("hh:mm:ss");
            String signinTime = sdf.format(now);
            String sign = "08:30:00";
            int i = signinTime.compareTo(sign);
            if (i == -1) {
                whetherlate = "未迟到";
            }else {
                whetherlate = "迟到";
            }
                //duty.setSignintime(signinTime);
                n = sc.saveSiginTime(empID, today, signinTime, whetherlate);
                if (n == 1) {
                    System.out.println("签到成功啦");
                } else {
                    System.out.println("签到失败啦");
                }
                return n;
            }
        }

        public int signout (int empID){
            String whetherlate = null;
            findCheck fc = new findCheck();
            saveCheck sc = new saveCheck();
            Date now = new Date();
            java.sql.Date today = new java.sql.Date(now.getTime());
            boolean flag = fc.findSignOutTime(empID, today);
            int n = 0;
            if (flag) {
                System.out.println("您已经签退过啦");
                n = 2;
                return n;
            } else {
            /*dutyBean duty = new dutyBean();
            duty.setEid(eid);
            duty.setDtdata(today);*/
                DateFormat sdf = new SimpleDateFormat("hh:mm:ss");
                String signOutTime = sdf.format(now);
                String sign = "17:30:30";
                int i = signOutTime.compareTo(sign);
                if(i==-1){
                    whetherlate = "未早退";
                }else{
                    whetherlate = "早退";
                }
                //duty.setSignouttime(signOutTime);
                n = sc.saveSignOutTime(empID, today, signOutTime,whetherlate);
                if (n == 1) {
                    System.out.println("签退成功啦");
                } else {
                    System.out.println("签退失败啦");
                }
                return n;
            }
        }
    }

