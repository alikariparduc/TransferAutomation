package org.example;

import java.sql.*;

public class LogoutControl {
    public static String connectionString = "";

    //DB Bilgileri
    public static String releaseConnectionString = "jdbc:oracle:thin:@//172.31.60.22:1521/srv_retckam";
    public static String testConnectionString = "jdbc:oracle:thin:@//172.31.60.22:1521/srv_retckdev";

    //TRANSFER tablosu bilgileri
    public static String oracleUsernameForTransfer = "STORE";
    public static String oraclePasswordForTransfer = "STORE123*";
    public static void logoutKontrolEt(String username) throws SQLException, ClassNotFoundException {

        String environment = System.getProperty("ENVIRONMENT");
        if(environment == null || environment.equals("release")) {
            connectionString = releaseConnectionString;
        }
        else if(environment.equals("test")) {
            connectionString = testConnectionString;
        }

        Class.forName ("oracle.jdbc.driver.OracleDriver");
        Connection con = DriverManager.getConnection(connectionString,
                oracleUsernameForTransfer,
                oraclePasswordForTransfer);
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery ("select * from login_logout_ledger " +
                "where logout_time is null and user_name ='" + username + "'");
        if (rs.next ())
        {
            int rows = st.executeUpdate("update login_logout_ledger set is_active = 0 where is_active = 1 and logout_time is null and user_name = '" + username + "'");
            //int rows = st.executeUpdate("delete from login_logout_ledger where logout_time is null and user_name = '" + username + "'");
            System.out.println(rows + " row(s) affected.");
        }
        else
            System.out.println ("This user is already logged out.");


        rs.close();
        System.out.println("rs close");
        st.close();
        System.out.println("st close");
        con.close();
        System.out.println("connection closed");
    }
}
