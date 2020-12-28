package utility.postUtil;

import javaBean.emp_expectpostBean;
import utility.jdbcUtil.jdbcUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class applyPost {
    //员工申请职位
    public int applyPost(int empID,int pID){
        jdbcUtils ju = new jdbcUtils();
        Connection con = ju.getConnection();
        Statement stmt = ju.getStatement(con);
        String expect_state = "待审核";
        int n = 0;
        try{
            String sql = "insert into emp_expectpost (empID,expect_pID,expect_state) values('"+empID+"','"+pID+"','"+expect_state+"')";
            n = stmt.executeUpdate(sql);
            System.out.println("申请职位成功");
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("申请职位成功");
        }finally {
            ju.resource(con,stmt);
        }
        return n;
    }
    //部门经理查看
    public List<emp_expectpostBean> selectDeptApplyPost(int deptID){
        jdbcUtils ju = new jdbcUtils();
        Connection con = ju.getConnection();
        Statement stmt = ju.getStatement(con);
        ResultSet rs = null;
        List<emp_expectpostBean> list = new ArrayList<>();
        try{
            String sql = "select * from emp_expectpost where empID in (select empID from emp where deptID = '"+deptID+"')";
            rs = stmt.executeQuery(sql);
            while(rs.next()){
                emp_expectpostBean e = new emp_expectpostBean();
                e.setEmpID(rs.getInt("empID"));
                e.setExpect_pID(rs.getInt("expect_pID"));
                e.setExpect_state(rs.getString("expect_state"));
                list.add(e);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally{
            ju.resource(con,stmt,rs);
        }
        return list;
    }
    //员工查看自己的申请记录
    public List<emp_expectpostBean> selectApplyPost(int empID){
        jdbcUtils ju = new jdbcUtils();
        Connection con = ju.getConnection();
        Statement stmt = ju.getStatement(con);
        ResultSet rs = null;
        List<emp_expectpostBean> list = new ArrayList<>();
        try{
            String sql = "select * from emp_expectpost,post where empId='"+empID+"' AND emp_expectpost.expect_pID = post.pID ";
            rs = stmt.executeQuery(sql);
            while(rs.next()){
                emp_expectpostBean e = new emp_expectpostBean();
                e.setEmpID(rs.getInt("empID"));
                e.setExpect_pID(rs.getInt("expect_pID"));
                e.setExpect_state(rs.getString("expect_state"));
                e.setpName(rs.getString("pName"));
                e.setpIntro(rs.getString("pIntro"));
                list.add(e);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally{
            ju.resource(con,stmt,rs);
        }
        return list;
    }
    //部门经理审核
    public int checkApplyPost(String expect_state,int empID){
        jdbcUtils ju = new jdbcUtils();
        Connection con = ju.getConnection();
        Statement stmt = ju.getStatement(con);
        int n = 0;
        try{
            String sql ="update emp_expectpost set expect_state = '"+expect_state+"' where empId = '"+empID+"'";
            n = stmt.executeUpdate(sql);
            System.out.println("审核成功");
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("审核失败");
        }finally {
            ju.resource(con,stmt);
        }
        return n;
    }
}
