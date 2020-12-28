package utility.deptUtil;

import javaBean.deptBean;
import utility.jdbcUtil.jdbcUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class selectDept {
    public List<deptBean> selectDept(int deptID){
        jdbcUtils ju = new jdbcUtils();
        Connection con = ju.getConnection();
        Statement stmt = ju.getStatement(con);
        ResultSet rs = null;
        List<deptBean> list = new ArrayList<>();
        try{
            String sql = "select * from dept where deptID = '"+deptID+"'";
            rs = stmt.executeQuery(sql);
            while(rs.next()){
                deptBean d = new deptBean();
                d.setDeptID(rs.getInt("deptID"));
                d.setDeptName(rs.getString("deptName"));
                d.setDeptIntro(rs.getString("deptIntro"));
                list.add(d);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            ju.resource(con,stmt,rs);
        }
        return list;
    }
}
