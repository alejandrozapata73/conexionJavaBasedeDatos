import java.sql.DriverManager;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Usuario
 */
public class ConexionBD {
    
    Connection conn = null;
    Statement st = null;
    ResultSet rt = null;
    
    public ConexionBD(){
    
        try {
            Class.forName("com.mysql.jdbc.Driver");
            
            conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/informatica?zeroDateTimeBehavior=convertToNull", "root", "root");
            
            st = (Statement) conn.createStatement();
            rt = st.executeQuery("select * from articulos");
            
            while(rt.next()){
                
                System.out.println(rt.getString("Nombre"));
                
            }
            
        } catch (ClassNotFoundException ex) {
            
            
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    public static void main (String [] args){
    
    ConexionBD c = new ConexionBD();
    
    }
    
    
}
