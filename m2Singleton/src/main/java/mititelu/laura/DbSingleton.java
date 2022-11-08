package mititelu.laura;

import org.apache.derby.jdbc.EmbeddedDriver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbSingleton {


    //using derby - does not work!!
    private static volatile DbSingleton instance = null;
    private static volatile Connection conn = null;

    private DbSingleton(){

        try{
            DriverManager.registerDriver(new org.apache.derby.jdbc.EmbeddedDriver());
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if(conn != null){
            throw new RuntimeException("Use getConnection() method to create");
        }

        //make sure nobody uses reflection on our code
        if(instance != null){
            throw new RuntimeException("Use getInstance() method to create");
        }
    }

    public static DbSingleton getInstance(){ //if you make the entire method synchronized it is a performance hit!!
        if(instance == null){
            synchronized (DbSingleton.class){ //synchronized adds a little overhead
                if(instance == null) {
                    instance = new DbSingleton();
                }
            }

        }
        return instance;
    }

    //it is not static
    //we have to have an instance of the singleton and then use getConnection
    public Connection getConnection(){
        if(conn == null){
            synchronized (DbSingleton.class){
                if(conn == null){
                    try {
                        String dbUrl = "jdbc:derby:memory:codejava/webdb;create=true";
                        conn = DriverManager.getConnection(dbUrl);
                    }catch (SQLException e){
                        e.printStackTrace();
                    }
                }
            }
        }

        return conn;

    }



    //thread-safe using volatile keyword
//    private static volatile DbSingleton instance = null;
//
//    private DbSingleton(){
//        //make sure nobody uses reflection on our code
//        if(instance != null){
//            throw new RuntimeException("Use getInstance() method to create");
//        }
//    }
//
//    public static DbSingleton getInstance(){ //if you make the entire method synchronized it is a performance hit!!
//        if(instance == null){
//            synchronized (DbSingleton.class){ //synchronized adds a little overhead
//                if(instance == null) {
//                    instance = new DbSingleton();
//                }
//            }
//
//        }
//        return instance;
//    }


    //lazy loaded, not thread-safe
    //substantial performance improvement for application
//
//    private static DbSingleton instance = null;
//
//    private DbSingleton(){}
//
//    public static DbSingleton getInstance(){
//        if(instance == null){
//            instance = new DbSingleton();
//        }
//        return instance;
//    }



//    Eagerly loaded , not thread-safe because instance is created whether we need it or not
//    private static DbSingleton instance = new DbSingleton();
//
//    private DbSingleton(){
//
//    }
//
//    public static DbSingleton getInstance(){ //standard naming convention. it does not have to be called this
//        return instance;
//    }
}
