/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fleetmanagementsystemv1;
    import java.sql.Connection;
    import java.sql.DriverManager;
    import java.util.ArrayList;
    import javax.swing.JOptionPane;
/**
 *
 * @author khattab youssef
 */
public class General {
    public static admina admina = new admina();
    public static members2 members2 = new members2();
    public static creatuser creatuser = new creatuser();
    public static car car = new car();
    public static creatcar creatcar = new creatcar();
    public static reservation reservation = new reservation();
    
    public static Connection connection(){
        Connection connection = null;
        try{
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/fms?user=root&password=");
        }
        catch(Exception e){
        
        }
        return connection;
    }

    static void importData() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
 