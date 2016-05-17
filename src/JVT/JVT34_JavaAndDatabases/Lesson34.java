package JVT.JVT34_JavaAndDatabases;

// The API for accessing and processing data stored in a database

import java.sql.*;

public class Lesson34 {
    public static void main(String[] args) {

        // A connection object is used to provide access to a database

        Connection conn;

        try {
            // The driver allows you to query the database with Java
            // forName dynamically loads the class for you

            Class.forName("org.sqlite.JDBC");

            // DriverManager is used to handle a set of JDBC drivers
            // getConnection establishes a connection to the database
            // You must also pass the userid and password for the database

            conn = DriverManager.getConnection("jdbc:sqlite:src/JVT/JVT34_JavaAndDatabases/sample.db");

            // Statement objects executes a SQL query
            // createStatement returns a Statement object

            Statement statement = conn.createStatement();

            // This is the query I'm sending to the database

            statement.executeUpdate("drop table if exists person");
            statement.executeUpdate("create table person (id integer, name string)");
            statement.executeUpdate("insert into person values(1, 'leo')");
            statement.executeUpdate("insert into person values(2, 'yui')");

            String selectStuff = "SELECT name FROM person";

            // A ResultSet contains a table of data representing the
            // results of the query. It can not be changed and can
            // only be read in one direction

            ResultSet rows = statement.executeQuery(selectStuff);

            // next is used to iterate through the results of a query

            while (rows.next()) {
                System.out.println(rows.getString("name"));
            }
        } catch (SQLException ex) {

            // String describing the error

            System.out.println("SQLException: " + ex.getMessage());

            // Vendor specific error code

            System.out.println("VendorError: " + ex.getErrorCode());
        } catch (ClassNotFoundException e) {
            // Executes if the driver can't be found
            e.printStackTrace();
        }

    }
}