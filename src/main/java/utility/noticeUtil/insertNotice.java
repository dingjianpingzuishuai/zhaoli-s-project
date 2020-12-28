package utility.noticeUtil;

import utility.jdbcUtil.jdbcUtils;

import java.sql.Connection;
import java.sql.Statement;

public class insertNotice {
    //部门经理发布部门公告的方法
    public int insertNotice(int deptID,String noticeTitle,String noticeBody){
        //0表示成功1表示失败
        jdbcUtils ju = new jdbcUtils();
        Connection con = ju.getConnection();
        Statement stmt = ju.getStatement(con);
        int i = 0;
        try{
            String sql = "insert into notice (deptID,noticeTitle,noticeBody) values ('"+deptID+"','"+noticeTitle+"','"+noticeBody+"')";
            i = stmt.executeUpdate(sql);
            System.out.println("发布公告成功");
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("发布公告失败");
        }
        finally{
            ju.resource(con,stmt);
        }
        return i;
    }
}
