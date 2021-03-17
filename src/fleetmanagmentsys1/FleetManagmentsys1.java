package fleetmanagmentsys1;
import java.sql.*;
import java.util.ArrayList;

/**
 *
 * @author mothman
 */
public class FleetManagmentsys1 {

    private static final String USERNAME= "root";
    private static final String PASSWORD= "qwerty";
    private static final String CONN_STRING=
            "jdbc:mysql://localhost:3306/fleetmanagmentsys1";
        private int userId; 
    protected String userPassword;
    public static ArrayList<authentification> studentsList = new ArrayList<authentification>();


    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public static void main(String[] args) {
        Connection conn = null;
        try{
            conn = DriverManager.getConnection(CONN_STRING,USERNAME,PASSWORD);
            System.out.println("Connected");
            Statement stmt = (Statement) conn.createStatement();
            String q = "SELECT * FROM user";
            ResultSet rs=stmt.executeQuery(q);
            if(rs.next()){ 
                do{
                System.out.println(rs.getString(1)+","+rs.getString(2)+","+rs.getString(3)+","+rs.getString(4)+","+rs.getString(5));
                }
                while(rs.next());
                }
            else{
                System.out.println("error");
            }
            conn.close();

        }
        catch (SQLException e){
            System.err.println(e);
        }
    }
}
    