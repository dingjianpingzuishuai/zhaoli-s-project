package utility.noticeUtil;

import utility.jdbcUtil.jdbcUtils;

import java.sql.Connection;
import java.sql.Statement;

public class deleteNotice {
    //删除部门的公告信息 0表示失败 1表示成功
    public int deleteNotice(int noticeID){
        jdbcUtils ju = new jdbcUtils();
        Connection con = ju.getConnection();
        Statement stmt = ju.getStatement(con);
        int n = 0;
        try{
            String sql = "delete from notice where noticeID = '"+noticeID+"'";
            n = stmt.executeUpdate(sql);
            System.out.println("部门公告删除成功");
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("部门公告删除失败");
        }finally {
            ju.resource(con,stmt);
        }
        return n;
    }
}
