package fleetmanagmentsys1;
import java.sql.*;
import java.util.Scanner;

/**
 *
 * @author mothman
 */
public class FleetManagmentsys1 {

    private static final String USERNAME= "root";
    private static final String PASSWORD= "";
    private static final String CONN_STRING=
            "jdbc:mysql://localhost:3306/fleetmanagmentsys1";
        private int IdUtilisateur; 
    protected String password;

    public FleetManagmentsys1(int IdUtilisateur, String password) {
        this.IdUtilisateur = IdUtilisateur;
        this.password = password;
    }

    public int getIdUtilisateur() {
        return IdUtilisateur;
    }

    public void setIdUtilisateur(int IdUtilisateur) {
        this.IdUtilisateur = IdUtilisateur;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    



    public static void main(String[] args) {
        Scanner input1 = new Scanner(System.in);  
        System.out.println("Enter ID");
        int id = input1.nextInt(); 
        Scanner input2 = new Scanner(System.in);  
        System.out.println("Enter password");
        String pass = input2.nextLine();
        auth(id, pass);
        
    }
    public static void auth(int IdUtilisateur,String password){
        Connection conn = null;
        try{
            conn = DriverManager.getConnection(CONN_STRING,USERNAME,PASSWORD);
            System.out.println("Connected");
            Statement stmt = (Statement) conn.createStatement();
            PreparedStatement pst = conn.prepareStatement("SELECT * FROM user where IdUtilisateur = ? and password = ?");
            pst.setInt(1, IdUtilisateur);
            pst.setString(2, password);
            ResultSet rs=pst.executeQuery();
            if(rs.next()){ 
                System.out.println("yes");
                }
            else{
                System.out.println("no");
            }
            conn.close();

        }
        catch (SQLException e){
            System.err.println(e);
        }
        /*
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
        */
    }
}
    