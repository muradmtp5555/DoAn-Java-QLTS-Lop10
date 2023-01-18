package ketnoisql;

import java.sql.*;

public class sql {
    public static Connection conn;
    public static String user = "sa";
    public static String pass = "Quocdat123ak@";

    public static void sql() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException classNotFoundException) {
            classNotFoundException.printStackTrace();
        }
        try {
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433; databaseName = javabuiquocdat; encrypt = false; trustSeverCerLificate = true", user, pass);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}
