package utility.loginAndRegister;
import javaBean.empBean;
import utility.jdbcUtil.jdbcUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class register {

    public int register(String empName,String empPassword,int deptID,int pID,int salary,String sex,String address,String email,int roleID){
        jdbcUtils ju = new jdbcUtils();
        Connection con = ju.getConnection();
        Statement stmt = ju.getStatement(con);
        int n = 0;
        try{
            String sql = "insert into emp(empName,empPassword,deptID,pID,salary,sex,address,email,roleID) values ('"+empName+"','"+empPassword+"','"+deptID+"','"+pID+"','"+salary+"','"+sex+"','"+address+"','"+email+"','"+roleID+"')";
            n = stmt.executeUpdate(sql);
            System.out.println("注册成功");
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("注册失败");
        }finally{
            ju.resource(con,stmt);
        }
        return n;

   }
}
