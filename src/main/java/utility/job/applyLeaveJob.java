package utility.job;

import javaBean.dimissionBean;
import utility.jdbcUtil.jdbcUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

public class applyLeaveJob {
    //员工申请离职
    public int applyLeaveJob(int empID,String dimissionReason){
        jdbcUtils ju = new jdbcUtils();
        Connection con = ju.getConnection();
        Statement stmt = ju.getStatement(con);
        int i = 0;
        String jobStatus = "待审核";
        try{
            String sql = "insert into dimission values ('"+empID+"','"+jobStatus+"','"+dimissionReason+"')";
            i = stmt.executeUpdate(sql);
            if(i==1){
                System.out.println("申请成功");
            }else{
                System.out.println("申请失败");
            }
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("申请失败");
        }finally{
            ju.resource(con,stmt);
        }
        return i;
    }

    //员工查看离职申请进度
    public List<dimissionBean> selectDimission(int empID){
        jdbcUtils ju = new jdbcUtils();
        Connection con = ju.getConnection();
        Statement stmt = ju.getStatement(con);
        ResultSet rs = null;
        List<dimissionBean> list = null;
        try{
            String sql ="select * from emp,dimission,post where emp.empID='"+empID+"' and emp.empID = dimission.empID and emp.pID=post.pID";
            rs = stmt.executeQuery(sql);
            while(rs.next()){
                dimissionBean d = new dimissionBean();
                d.setEmpID(rs.getInt("empID"));
                d.setEmpName(rs.getString("empName"));
                d.setJobStatus(rs.getString("jobStatus"));
                d.setDimissionReason(rs.getString("dimissionReason"));
                d.setpName(rs.getString("pName"));
                list.add(d);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
            ju.resource(con,stmt,rs);
        }
        return list;
    }
}
