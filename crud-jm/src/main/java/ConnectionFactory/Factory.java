package ConnectionFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Factory {
    public Connection getConnection(){
        try {
            return DriverManager.getConnection("jdbc:mysql://localhost/primeiro", "root", "batatafrita01");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
