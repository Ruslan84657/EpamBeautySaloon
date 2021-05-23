package net.epamproj.bl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;

public class Util {
    private final Logger logger = Logger.getLogger(String.valueOf(getClass()));

    private static String jdbcDriver = "org.postgresql.Driver";
    private static String jdbcURL = "jdbc:postgresql://localhost:5432/beauty_saloon";
    private static String jdbcUsername = "postgres";
    private static String jdbcPassword = "specnaz119";

    public static final String SELECT_ALL_SERVICES = "SELECT * FROM services";
    public static final String SELECT_ALL_MASTERS = "SELECT * FROM saloon_user WHERE role_id =3;";
    public static final String INSERT_USER_SQL = "INSERT INTO saloon_user" +
            " (first_name, last_name, login, password, role_id) VALUES (?, ?, ?, ?, 2);";
    public static final String DELETE_USER_SQL = "DELETE FROM saloon_user WHERE id =?;";
    public static final String REGISTRATION_FOR_SERVICE = "UPDATE saloon_user" +
            " SET service_id =?, master_id =? WHERE id =?;";
    public static final String SELECT_CLIENT_REGISTRATION = "SELECT * FROM saloon_user" +
            " JOIN services ON saloon_user.service_id = services.id and services.id =?;";
    //    public static final String CHANGE_CLIENT_REGISTRATION = "UPDATE saloon_user SET timeslot =? WHERE id =?;";
    public static final String CANCEL_CLIENT_REGISTRATION = "UPDATE saloon_user SET service_id =NULL, master_id =NULL WHERE id =?";
    public static final String SELECT_MASTERS_TIMETABLE = "SELECT * FROM saloon_user WHERE master_id =?;";
//    public static final String MARK_AS_DONE = ;

    public Connection getConnection(){
        Connection connection = null;
        try {
            Class.forName(jdbcDriver);
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
            logger.info("Connection established!");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }
}