package Modelo;

import com.mysql.jdbc.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    private Connection conexion = null;
    
    public Connection conectar() throws ClassNotFoundException{
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conexion = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/proyectoprogra2", "root", "");
        }catch(SQLException ex){
            System.out.println("Error: "+ex);
        }
        return conexion;
    }
    public void desconectar(){
        try {
            conexion.close();
        } catch (SQLException ex) {
        }
    
    }
    
}
