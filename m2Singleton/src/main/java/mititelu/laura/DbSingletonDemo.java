package mititelu.laura;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DbSingletonDemo {

    public static void main(String[] args) {
        DbSingleton dbSingleton = DbSingleton.getInstance();

        Connection conn = dbSingleton.getConnection();

        Statement sta;
        try{
            sta = conn.createStatement();
            int count = sta.executeUpdate("CREATE TABLE ADDRESS(ID INT, StreetName VARCHAR2(20), City VARCHAR2(20)");
            System.out.println("Table created");
            sta.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }


        //without DB
//        DbSingleton instance = DbSingleton.getInstance();
//        System.out.println(instance);
//
//        DbSingleton anotherInstance = DbSingleton.getInstance();
//        System.out.println(anotherInstance);

    }
}
