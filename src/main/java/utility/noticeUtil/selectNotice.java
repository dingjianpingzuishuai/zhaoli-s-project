package utility.noticeUtil;


import javaBean.noticeBean;
import utility.jdbcUtil.jdbcUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class selectNotice {
    //查看本部门的公告
    public List<noticeBean> selectNotice(int deptID){
        jdbcUtils ju = new jdbcUtils();
        Connection con = ju.getConnection();
        Statement stmt = ju.getStatement(con);
        ResultSet rs = null;
        List<noticeBean> list = new ArrayList<>();
        try{
            String sql = "select * from notice where deptID = '"+deptID+"'";
            rs = stmt.executeQuery(sql);
            while(rs.next()){
                noticeBean n = new noticeBean();
                n.setNoticeID(rs.getInt("noticeID"));
                n.setDeptID(rs.getInt("deptID"));
                n.setNoticeTitle(rs.getString("noticeTitle"));
                n.setNoticeBody(rs.getString("noticeBody"));
                list.add(n);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            ju.resource(con,stmt,rs);
        }return list;
    }
    //查看所有的公告信息(管理员)
    public List<noticeBean> selectNotice(){
        jdbcUtils ju = new jdbcUtils();
        Connection con = ju.getConnection();
        Statement stmt = ju.getStatement(con);
        ResultSet rs = null;
        List<noticeBean> list = new ArrayList<>();
        try{
            String sql = "select * from notice ";
            rs = stmt.executeQuery(sql);
            while(rs.next()){
                noticeBean n = new noticeBean();
                n.setNoticeID(rs.getInt("noticeID"));
                n.setDeptID(rs.getInt("deptID"));
                n.setNoticeTitle(rs.getString("noticeTitle"));
                n.setNoticeBody(rs.getString("noticeBody"));
                list.add(n);
            }
        }catch(Exception e){
            e.printStackTrace();
        }finally{
            ju.resource(con,stmt,rs);
        }
        return list;
    }
}
