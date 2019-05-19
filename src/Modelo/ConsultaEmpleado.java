package Modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConsultaEmpleado {
    
    Conexion conexion = new Conexion();
    
    public boolean IniciarSesion(Empleado empleado) throws SQLException, ClassNotFoundException{//INICIAR SESION
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT correo, contraseña FROM empleados WHERE correo='"+empleado.getCorreo()+"' AND contraseña='"+empleado.getContraseña()+"'";
        
        try{
            ps = conexion.conectar().prepareStatement(sql);
            rs = ps.executeQuery();
        
        if(rs.next()){
            return true;
        }
        return false;
        }catch(SQLException ex){
            System.out.println("Error: "+ex);
            return false;
        }finally{
            try{
            conexion.conectar().close();
            }catch(SQLException ex){
                System.out.println("Error: "+ex);
            }
        }  
    }
    
    public boolean ValidarCorreo(Empleado empleado) throws ClassNotFoundException{
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT correo From empleados WHERE correo='"+empleado.getCorreo()+"'";
    
        try{
        ps = conexion.conectar().prepareStatement(sql);
        rs = ps.executeQuery();
        
        if(rs.next()){
            return true;
        }
        return false;
        }catch(SQLException ex){
            System.out.println("Error: "+ex);
            return false;
        }finally{
            try{
            conexion.conectar().close();
            }catch(SQLException ex){
            }
        } 
    }
    
    
    
}
