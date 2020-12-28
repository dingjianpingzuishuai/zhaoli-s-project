package utility.attendanceUtil;
import utility.jdbcUtil.jdbcUtils;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
//此类用于查看今天是否签到签退
public class findCheck {
    jdbcUtils ju = new jdbcUtils();
    Connection con = ju.getConnection();
    Statement stmt = ju.getStatement(con);
    ResultSet rs = null;
    //查看今天是否签到
    public boolean findSigninTime(int empID,java.sql.Date today) {
        boolean flag = false;
        try {
            String sql = "select * from attendance where empID='" + empID + "' and today='" + today + "'";
            rs = stmt.executeQuery(sql);
            if (rs.next()) {
                flag = true;
                //System.out.println("今日已经签到了");
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{
            ju.resource(con,stmt,rs);
        }

        return flag;
    }
    //查看今天是否签退
    public boolean findSignOutTime(int empID,java.sql.Date today) {
        boolean flag = false;
        try {
            String sql = "select signouttime from attendance where empID='"+empID+"' and today='"+today+"'";
            rs = stmt.executeQuery(sql);
            if(rs.next()) {
                String signouttime = rs.getString("signouttime");
                if(signouttime!=null) {
                    flag=true;
                    //System.out.println("今日已经签退了");
                }
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        finally{
            ju.resource(con,stmt,rs);
        }
        System.out.println(flag);
        return flag;
    }
}
