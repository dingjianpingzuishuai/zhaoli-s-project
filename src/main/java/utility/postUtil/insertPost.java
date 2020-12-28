package utility.postUtil;

import utility.jdbcUtil.jdbcUtils;

import java.sql.Connection;
import java.sql.Statement;

public class insertPost {
    //管理员增加部门的职位
    public int insertPost(int deptID,String pName,String pIntro){
        jdbcUtils ju = new jdbcUtils();
        Connection con = ju.getConnection();
        Statement stmt = ju.getStatement(con);
        int n = 0;
        try{
            String sql = "insert into post (deptID,pName,pIntro) values ('"+deptID+"','"+pName+"','"+pIntro+"')";
            n = stmt.executeUpdate(sql);
            System.out.println("部门职位添加成功");
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("部门职位添加失败");
        }finally {
            ju.resource(con,stmt);
        }
        return n;
    }
}
