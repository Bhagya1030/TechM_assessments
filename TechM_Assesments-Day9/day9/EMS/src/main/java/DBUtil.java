import java.sql.*;
import javax.naming.*;
import javax.sql.DataSource;

public class DBUtil {
    private static DataSource dataSource;

    static {
        try {
            Context ctx = new InitialContext();
            dataSource = (DataSource) ctx.lookup("java:comp/env/jdbc/MyDB");
        } catch (NamingException e) {
            e.printStackTrace();
            throw new RuntimeException("Database connection lookup failed.");
        }
    }

    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }
}
