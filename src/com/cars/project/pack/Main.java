/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cars.project.pack;
import java.sql.*;
// import java.util.ArrayList;
import java.util.Scanner;



public class Main{
   
    private static String USERNAME= "root";
    private static String PASSWORD= "";
    private static String CONN_STRING= "jdbc:mysql://localhost:3306/fms";
    

    public static void role(int IdUtilisateur){
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
                if (TypeCompte.equals("admin")){
                    crud();
                }
                if (TypeCompte.equals("user")){
                    System.out.println("go to user panel");
                }
            }
            rs.close ();
            stmt.close ();
            }
        catch (SQLException e){
            System.err.println(e);
        }
        
    }
    
    public static void crud(){
       // Database Connection 
       Connection conn = null;
       
        Scanner reader = new Scanner(System.in);

        int optionsSwitch = 0;
        // while loop for unlimited acceess 
        boolean valid = false;
        while(valid){
            
        
            
            optionsSwitch = reader.nextInt();
            switch(optionsSwitch){
                case 1 : 
                    // getting information from new User 
                    
                 
                    User newUser = new User();
              
                    newUser.setName(reader.next());
               
                    newUser.setFonction(reader.next());
                    
                    newUser.setPosition(reader.next());
                   
                    newUser.setRole(reader.next());

                    
                    // insert into database : 
                    try{
                        conn = DriverManager.getConnection(CONN_STRING,USERNAME,PASSWORD);
                        // SQL insertion 
                        String sql = "INSERT INTO user(nom,fonction,statut,Type_Compte,Position) VALUES (?,?,?,?,?,?)";
                        
                        PreparedStatement stmt = conn.prepareStatement(sql);
                        stmt.setString(1, newUser.getName());
                        stmt.setString(2, newUser.getFonction());
                        stmt.setInt(3, 1);
                        stmt.setString(4, newUser.getRole());
                        stmt.setString(5, newUser.getPosition());
                        stmt.setString(6, newUser.getPassword());
                        
                        stmt.execute();
                        System.out.println("User Added");
                        conn.close();
                    }
                    catch (SQLException e){
                        System.err.println(e);
                    }
                    break;
                case 2 : 
                    // ArrayList<String> UserList = new ArrayList<String>();
                    try{
                        conn = DriverManager.getConnection(CONN_STRING,USERNAME,PASSWORD);
                        // SQL insertion 
                        String sql = "SELECT * FROM user GROUP BY  IdUtilisateur";
                        
                        PreparedStatement stmt = conn.prepareStatement(sql);
                        ResultSet result = stmt.executeQuery(sql);
                        
                        while(result.next()){
                            int ID = result.getInt("IdUtilisateur");
                            String name = result.getString("nom");
                            String fonction = result.getString("fonction");
                            int statut = result.getInt("statut");
                            String Role = result.getString("Type_Compte");
                            String Position = result.getString("Position");
                            // int ID,String name, String fonction,String position, boolean status, String role
                            System.out.println("║ ID :"+ ID +"║nom :"+ name +" ║ Fonction :"+ fonction +" ║ Statut : " + statut +" ║ Role :" + Role + " ║Position : " + Position + " ║ \n");
                            
                        }
                        stmt.execute();
                        
                        conn.close();
                    }
                    catch (SQLException e){
                        System.err.println(e);
                    }
                    break;
                case 3 : 
                    System.out.println("Enter ID : ");
                    int id = reader.nextInt();
                    // UPDATE INFO
                    newUser = new User();
                    System.out.print("ENTER YOUR NAME : ");  
                    newUser.setName(reader.next());
                    System.out.print("ENTER YOUR FONCTION : ");    
                    newUser.setFonction(reader.next());
                    System.out.print("ENTER YOUR POSITION : "); 
                    newUser.setPosition(reader.next());
                    System.out.print("ROLE : "); 
                    newUser.setRole(reader.next());
                    newUser.setPassword(reader.next());
                    System.out.println("ENTER YOUR NEW PASSWORD: ");
                    
                    try{
                        conn = DriverManager.getConnection(CONN_STRING,USERNAME,PASSWORD);
                        // SQL insertion 
                        String sql = "UPDATE user SET Nom=?, Fonction=?, Type_Compte=?, Position=?, Password=? WHERE IdUtilisateur = " + id;
 
                        PreparedStatement statement = conn.prepareStatement(sql);
                        statement.setString(1, newUser.getName());
                        statement.setString(2, newUser.getFonction());
                        statement.setString(3, newUser.getPosition());
                        statement.setString(4, newUser.getRole());
                        statement.setString(5, newUser.getPassword());

                        int rowsUpdated = statement.executeUpdate();
                        if (rowsUpdated > 0) {
                            System.out.println("An existing user was updated successfully!");
                        }
                        
                        conn.close();
                    }
                    catch (SQLException e){
                        System.err.println(e);
                    }
                    break;
                case 4 :
                    System.out.println("Enter row u want to delete : ");
                    int ID = reader.nextInt();
                    try{
                        conn = DriverManager.getConnection(CONN_STRING,USERNAME,PASSWORD);
                        // SQL insertion 
                        String sql = "DELETE FROM user where IdUtilisateur = " + ID;
                        
                        PreparedStatement stmt = conn.prepareStatement(sql);
                        
                        stmt.execute();
                        System.out.println("USER DELETED ");
                        
                        conn.close();
                    }
                    catch (SQLException e){
                        System.err.println(e);
                    }
                    break;
                case 5 :
                    System.out.println("\\n\\t\\t███ END OF PROGRAM ███\\n\\");
                    valid = false ;
                    break;
            }
        }   
    }
}
