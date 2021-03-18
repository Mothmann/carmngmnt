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
    protected String Type_Compte;

    public String getType_Compte() {
        return Type_Compte;
    }

    public void setType_Compte(String Type_Compte) {
        this.Type_Compte = Type_Compte;
    }

    public FleetManagmentsys1(int IdUtilisateur, String password,String Type_Compte) {
        this.IdUtilisateur = IdUtilisateur;
        this.password = password;
        this.Type_Compte = Type_Compte;
        
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
            Statement stmt = (Statement) conn.createStatement();
            PreparedStatement pst = conn.prepareStatement("SELECT * FROM user where IdUtilisateur = ? and password = ?");
            pst.setInt(1, IdUtilisateur);
            pst.setString(2, password);
            ResultSet rs=pst.executeQuery();
            if(rs.next()){ 
                System.out.println("connected");
                getrole(IdUtilisateur);
                }
            else{
                System.out.println("no account found");
            }
            conn.close();

        }
        catch (SQLException e){
            System.err.println(e);
        }
    }
    public static void getrole(int IdUtilisateur){
        Connection conn = null;
        try{
            conn = DriverManager.getConnection(CONN_STRING,USERNAME,PASSWORD);
            Statement stmt = (Statement) conn.createStatement();
            PreparedStatement pst = conn.prepareStatement("select Type_Compte FROM user WHERE IdUtilisateur = ?");
            pst.setInt(1, IdUtilisateur);
            ResultSet rs = pst.executeQuery();
            if (rs.next ())
            {
                String TypeCompte = rs.getString ("Type_Compte");
                System.out.println (TypeCompte);
            }
            rs.close ();
            stmt.close ();
                 }
        catch (SQLException e){
            System.err.println(e);
        }
    }
    public static void role(int IdUtilisateur,String TypeCompte){
        Connection conn = null;
        try{
            conn = DriverManager.getConnection(CONN_STRING,USERNAME,PASSWORD);
            Statement stmt = (Statement) conn.createStatement();
            PreparedStatement pst = conn.prepareStatement("SELECT * FROM user where IdUtilisateur = ? and TypeCOmpte = ?");
            pst.setInt(1, IdUtilisateur);
            pst.setString(2, TypeCompte);
            ResultSet rs = pst.executeQuery();
        }
        catch (SQLException e){
            System.err.println(e);
        }
}
}
    