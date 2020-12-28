package utility.loginAndRegister;

import javaBean.empBean;
import utility.jdbcUtil.jdbcUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class login {
    jdbcUtils ju = new jdbcUtils();
    Connection con = ju.getConnection();
    Statement stmt = ju.getStatement(con);
    ResultSet rs = null;

    public List<empBean> login(int empID, String empPassword, int roleID){
        List list = new ArrayList();
        try{
            String sql = "select * from emp,dept,post where empID='"+empID+"'and empPassword='"+empPassword+"'and roleID='"+roleID+"' and emp.deptID = dept.deptID and emp.pID = post.pID";
            rs = stmt.executeQuery(sql);
            while(rs.next()){
                empBean emp = new empBean();
                emp.setEmpID(rs.getInt("empID"));
                emp.setEmpPassword(rs.getString("empPassword"));
                emp.setRoleID(rs.getInt("roleID"));
                emp.setDeptID(rs.getInt("deptID"));
                emp.setpID(rs.getInt("pID"));
                emp.setSalary(rs.getInt("salary"));
                emp.setSex(rs.getString("sex"));
                emp.setAddress(rs.getString("address"));
                emp.setHeadPicture(rs.getString("headPicture"));
                emp.setEmpName(rs.getString("empName"));
                emp.setEmail(rs.getString("email"));
                emp.setDeptName(rs.getString("deptName"));
                emp.setpName(rs.getString("pName"));
                emp.setJobStatus(rs.getString("jobstatus"));
                list.add(emp);
            }
            System.out.println("登录成功");
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("登录失败");
        }finally{
            jdbcUtils.resource(con,stmt,rs);
        }
        return list;
    }
}
