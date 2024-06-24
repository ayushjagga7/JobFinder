package sample;
import java.sql.Connection;
import java.sql.DriverManager;

public class database {
    private static final String username = "root";
    private static final String password = "Ayushjagga@7";
    private static final String database = "profiles";

    public static Connection main(){
        try{
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/" + database,username,password);
            return conn;
        }catch(Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
}
