import java.sql.*;
import java.util.ResourceBundle;

public class DBUtil {
    //静态变量
    private static ResourceBundle bundle=ResourceBundle.getBundle("resources.jdbc");
    private static  String driver= bundle.getString("driver");
    private static  String url= bundle.getString("url");
    private static  String user= bundle.getString("user");
    private static  String password= bundle.getString("password");
    static {
        try {
            //注册驱动
            //Class.forName("com.mysql.jdbc.Driver");
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        Connection conn=DriverManager.getConnection(url,user,password);
        return conn;
    }

    public static void close(Connection conn, Statement ps, ResultSet rs){
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
