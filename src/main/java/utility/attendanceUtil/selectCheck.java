package utility.attendanceUtil;

import javaBean.attendanceBean;
import utility.jdbcUtil.jdbcUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class selectCheck {
    //获取个人签到信息
    public List<attendanceBean> selectCheck(int empID){
        jdbcUtils ju = new jdbcUtils();
        Connection con = ju.getConnection();
        Statement stmt = ju.getStatement(con);
        ResultSet rs = null;
        List<attendanceBean> list = new ArrayList<>();
        try{
            String sql = "select * from attendance where empID = '"+empID+"'";
            rs = stmt.executeQuery(sql);
            while(rs.next()){
                attendanceBean a = new attendanceBean();
                a.setEmpID(rs.getInt("empID"));
                a.setToday(rs.getDate("today"));
                a.setSigninTime(rs.getString("signinTime"));
                a.setSignoutTime(rs.getString("signoutTime"));
                a.setWhetherlate(rs.getString("whetherlate"));
                a.setWhetherleave(rs.getString("whetherleave"));
                list.add(a);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            ju.resource(con,stmt,rs);
        }
        return list;
    }
    //获取部门的所有签到信息
    public List<attendanceBean> selectDeptCheck(int deptID){
        jdbcUtils ju = new jdbcUtils();
        Connection con = ju.getConnection();
        Statement stmt = ju.getStatement(con);
        ResultSet rs = null;
        List<attendanceBean> list = new ArrayList<>();
        try{
            String sql = "select * from attendance where empID in (select empID from emp where deptID = '"+deptID+"' )";
            rs = stmt.executeQuery(sql);
            while(rs.next()){
                attendanceBean a = new attendanceBean();
                a.setEmpID(rs.getInt("empID"));
                a.setToday(rs.getDate("today"));
                a.setSigninTime(rs.getString("signinTime"));
                a.setSignoutTime(rs.getString("signoutTime"));
                a.setWhetherlate(rs.getString("whetherlate"));
                a.setWhetherleave(rs.getString("whetherleave"));
                list.add(a);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            ju.resource(con,stmt,rs);
        }
        return list;
    }

}
