package utility.attendanceUtil;
import utility.jdbcUtil.jdbcUtils;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
//此类用于保存签到签退的时间
public class saveCheck {
    jdbcUtils ju = new jdbcUtils();
    Connection con = ju.getConnection();
    Statement stmt = ju.getStatement(con);
    public int saveSiginTime(int empID, Date today, String signintime,String whetherlate) {
        int i = 0 ;//0表示失败，1表示成功
        try {
            String sql = "insert into attendance  (empID,today,signintime,whetherlate) values ("+"'"+empID+"',"+"'"+today+"',"+"'"+signintime+"','"+whetherlate+"')";
            i = stmt.executeUpdate(sql);
            //System.out.println("签到成功");
        }catch(Exception e){
            e.printStackTrace();
            //System.out.println("签到失败");

        }finally{
            ju.resource(con,stmt);
        }
        return i;
    }
    public int saveSignOutTime(int empID ,Date today , String signouttime,String whetherleave) {
        int i = 0;//0表示失败，1表示成功
        try {
            String sql = "update  attendance  set signouttime ='"+signouttime+"' , whetherleave = '"+whetherleave+"' where empID='"+empID+"' and today='"+today+"'";
            i = stmt.executeUpdate(sql);
            //System.out.println("签退成功");
        }catch(Exception e){
            e.printStackTrace();
            //System.out.println("签退失败");
        }finally{
            ju.resource(con,stmt);
        }
        return i;
    }

}
