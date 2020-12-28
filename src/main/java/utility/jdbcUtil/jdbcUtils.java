package utility.jdbcUtil;
import java.sql.*;
public class jdbcUtils {
    private static String driverClassName = null;
    private static String url = null;
    private static String username = null;
    private static String password = null;
    static {
        driverClassName = "com.mysql.cj.jdbc.Driver";
        url = "jdbc:mysql://localhost:3306/peoplesystem?useUnicode=true&serverTimezone=UTC&characterEncoding=utf8";
        username = "root";
        password = "mysql";
    }
    //加载驱动方法
    public static void loadDriver() {
        try {
            Class.forName(driverClassName);
            System.out.println("驱动加载成功");
        }catch(ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("驱动加载失败");
        }
    }
    //获取数据库连接对象
    public static Connection getConnection() {
        Connection con = null;
        loadDriver();
        try {
            con = DriverManager.getConnection(url,"root","mysql");
            System.out.println("成功获取数据库连接对象");
            return con;
        }catch(Exception e) {
            e.printStackTrace();
            System.out.println("获取数据库连接对象失败");
            return null;
        }
    }
    //获取sql语句执行对象
    public static Statement getStatement(Connection con) {

        Statement stmt = null;
        getConnection();
        try {
            stmt = con.createStatement();
            System.out.println("获取sql语句执行对象成功");
            return stmt;
        }catch(Exception e) {
            e.printStackTrace();
            System.out.println("获取sql语句执行对象失败");
            return null;
        }
    }
    //释放资源connection，statement
    public static void resource(Connection con,Statement stmt) {
        try {
            if(con != null) {
                con.close();
                con = null;
            }if(stmt != null) {
                stmt.close();
                stmt = null;
            }
            System.out.println("释放资源成功");
        }catch(Exception e) {
            e.printStackTrace();
            System.out.println("释放资源失败");
        }
    }
    //释放资源connection，statement，resultset
    public static void resource(Connection con,Statement stmt,ResultSet rs) {
        try {
            if(con != null) {
                con.close();
                con = null;
            }if(stmt != null) {
                stmt.close();
                stmt = null;
            }
            if(rs != null) {
                rs.close();
                rs = null;
            }
            System.out.println("释放资源成功");
        }catch(Exception e) {
            e.printStackTrace();
            System.out.println("释放资源失败");
        }
    }

}
