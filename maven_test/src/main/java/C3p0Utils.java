import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class C3p0Utils {
    private static DataSource c3p0DataSource = new ComboPooledDataSource();

    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = c3p0DataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

}
