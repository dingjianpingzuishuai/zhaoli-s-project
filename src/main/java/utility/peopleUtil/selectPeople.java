package utility.peopleUtil;

import javaBean.empBean;
import utility.jdbcUtil.jdbcUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class selectPeople {
    //查看个人信息
    public List<empBean> selectPeople(int empID){
        jdbcUtils ju = new jdbcUtils();
        Connection con = ju.getConnection();
        Statement stmt = ju.getStatement(con);
        ResultSet rs = null;
        List<empBean> list = new ArrayList<>();
        try{
            String sql = "select * from emp where empID = '"+empID+"'";
            rs = stmt.executeQuery(sql);
            while(rs.next()){
                empBean e = new empBean();
                e.setEmpID(rs.getInt("empID"));
                e.setEmpName(rs.getString("empName"));
                e.setEmpPassword(rs.getString("empPassword"));
                e.setDeptID(rs.getInt("deptID"));
                e.setpID(rs.getInt("pID"));
                e.setSalary(rs.getInt("salary"));
                e.setSex(rs.getString("sex"));
                e.setAddress(rs.getString("address"));
                e.setEmail(rs.getString("email"));
                list.add(e);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally{
            ju.resource(con,stmt,rs);
        }
        return list;
    }

    //查看部门所有人的信息
    public List<empBean> selectDeptPeople(int deptID) {
        jdbcUtils ju = new jdbcUtils();
        Connection con = ju.getConnection();
        Statement stmt = ju.getStatement(con);
        ResultSet rs = null;
        List<empBean> list = new ArrayList<>();
        try{
            String sql = "select * from emp where deptID = '"+deptID+"'";
            rs = stmt.executeQuery(sql);
            while(rs.next()){
                empBean e = new empBean();
                e.setEmpID(rs.getInt("empID"));
                e.setEmpName(rs.getString("empName"));
                e.setEmpPassword(rs.getString("empPassword"));
                e.setDeptID(rs.getInt("deptID"));
                e.setpID(rs.getInt("pID"));
                e.setSalary(rs.getInt("salary"));
                e.setSex(rs.getString("sex"));
                e.setAddress(rs.getString("address"));
                e.setEmail(rs.getString("email"));
                e.setJobStatus(rs.getString("jobstatus"));
                list.add(e);
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            ju.resource(con,stmt,rs);
        }
        return list;
    }

}
