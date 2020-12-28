package utility.postUtil;

import javaBean.postBean;
import utility.jdbcUtil.jdbcUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class selectPost {
    //查看部门的职位信息
    public List<postBean> selectPost(int deptID){
        jdbcUtils ju = new jdbcUtils();
        Connection con = ju.getConnection();
        Statement stmt = ju.getStatement(con);
        ResultSet rs = null;
        List<postBean> list = new ArrayList<>();
        try{
            String sql = "select * from post where deptID = '"+deptID+"'";
            rs = stmt.executeQuery(sql);
            while(rs.next()){
                postBean p = new postBean();
                p.setpID(rs.getInt("pID"));
                p.setDeptID(rs.getInt("deptID"));
                p.setpName(rs.getString("pName"));
                p.setpIntro(rs.getString("pIntro"));
                list.add(p);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            ju.resource(con,stmt,rs);
        }
        return list;
    }
}
