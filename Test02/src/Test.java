import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Test {
    public static void main(String[] args) throws SQLException {
        Connection getconnection = MyDBUtil.getconnection();
        Statement statement = getconnection.createStatement();

    }
}
