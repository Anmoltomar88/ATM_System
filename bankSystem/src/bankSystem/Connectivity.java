package bankSystem;
import java.sql.*;// --->import sql libraries


public class Connectivity {
Connection c;// 2
Statement s;//3

    public Connectivity(){
        try {
            // Class.forName("com.mysql.cj.jdbc.Driver"); // 1--> Register the Driver

            //2--> create connection
            String url="jdbc:mysql://localhost:3306/Bankmanagementsystem";
            String user="root";
            String passward="anmoltomar88";
            c=DriverManager.getConnection(url,user,passward);
            //connection string("jdbc:mysql://localhost:3306/databaseName",user--byDefaukt is "root",password-->"sqlpassword")
            //can also write it as("jdbc:mysql:///databaseName",user--byDefaukt is "root",password-->"sqlpassword")--> localhost is 3306

            //3---> create statements
            s=c.createStatement();
            // now import library
            //4--> execute statement in signup
            //at last close the connection

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
//localhost------> anmol-------> anmoltomar88