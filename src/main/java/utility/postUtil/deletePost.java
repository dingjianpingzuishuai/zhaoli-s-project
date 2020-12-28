package utility.postUtil;

import utility.jdbcUtil.jdbcUtils;

import java.sql.Connection;
import java.sql.Statement;

public class deletePost {
    //管理员删除部门的职位
    public int deletePost(int pID){
        jdbcUtils ju = new jdbcUtils();
        Connection con = ju.getConnection();
        Statement stmt = ju.getStatement(con);
        int n = 0;
        try {
            String sql = "delete from post where pID = '"+pID+"'";
            n = stmt.executeUpdate(sql);
            System.out.println("部门职位删除成功");
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("部门职位删除失败");
        }finally{
            ju.resource(con,stmt);
        }
        return n;
    }
}
