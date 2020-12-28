package utility.peopleUtil;

import utility.jdbcUtil.jdbcUtils;

import java.sql.Connection;
import java.sql.Statement;

public class deletePeople {
    public int deletePeople(int empID){
        jdbcUtils ju = new jdbcUtils();
        Connection con = ju.getConnection();
        Statement stmt = ju.getStatement(con);
        int i = 0;
        try{
            String sql = "delete from emp where empID = '"+empID+"'";
            i = stmt.executeUpdate(sql);
            System.out.println("删除成功");
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("删除失败");
        }
        finally{
            ju.resource(con,stmt);
        }
        return i;
    }
}
