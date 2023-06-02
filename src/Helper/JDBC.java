package Helper;

import java.sql.Connection;
import java.sql.DriverManager;

    public abstract class JDBC {

        private static final String protocol = "jdbc";
        private static final String vendor = ":mysql:";
        private static final String location = "//localhost/";
        private static final String databaseName = "client_schedule";
        private static final String jdbcUrl = protocol + vendor + location + databaseName + "?connectionTimeZone = SERVER"; // LOCAL
        private static final String driver = "com.mysql.cj.jdbc.Driver"; // Driver reference
        private static final String userName = "sqlUser"; // Username
        private static String password = "Passw0rd!"; // Password
        public static Connection connection;  // Connection Interface

        //a method for opening a connection at the beginning of the program
        public static void openConnection()
        {
            try {
                Class.forName(driver); // Locate Driver
                connection = DriverManager.getConnection(jdbcUrl, userName, password); // Reference Connection object
                System.out.println("Connection successful!");
            }
            catch(Exception e)
            {
                System.out.println("Error:" + e.getMessage());
            }
        }

        /**a method for grabbing the connection from the beginning of a program
        in order to use it for a db query**/
        public static Connection getConnection(){
            return connection;
        }

        //a method for closing the connection at the end of the program
        public static void closeConnection() {
            try {
                connection.close();
                System.out.println("Connection closed!");
            }
            catch(Exception e)
            {
                //do nothing because we don't care
            }
        }
}
