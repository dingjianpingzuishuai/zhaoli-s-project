package javaBean;
import java.util.*;
public class attendanceBean {
    private int attendanceID;
    private int empID;
    private Date today;
    private String signinTime;
    private String signoutTime;
    private String whetherlate;
    private String whetherleave;

    public int getAttendanceID() {
        return attendanceID;
    }

    public void setAttendanceID(int attendanceID) {
        this.attendanceID = attendanceID;
    }

    public int getEmpID() {
        return empID;
    }

    public void setEmpID(int empID) {
        this.empID = empID;
    }

    public Date getToday() {
        return today;
    }

    public void setToday(Date today) {
        this.today = today;
    }

    public String getSigninTime() {
        return signinTime;
    }

    public void setSigninTime(String signinTime) {
        this.signinTime = signinTime;
    }

    public String getSignoutTime() {
        return signoutTime;
    }

    public void setSignoutTime(String signoutTime) {
        this.signoutTime = signoutTime;
    }

    public String getWhetherlate() {
        return whetherlate;
    }

    public void setWhetherlate(String whetherlate) {
        this.whetherlate = whetherlate;
    }

    public String getWhetherleave() {
        return whetherleave;
    }

    public void setWhetherleave(String whetherleave) {
        this.whetherleave = whetherleave;
    }
}
