package Modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ConsultaProducto {
    
    Conexion conexion = new Conexion();
    
    public boolean guardarProducto(Producto producto){//GUARDAR PRODUCTOS EN LA BASE DE DATOS
        PreparedStatement ps  = null;
        ResultSet rs = null;
        
        String consulta = "INSERT INTO productos(nombre, precio, stock, id_proveedor, descripcion) VALUES('"+producto.getNombre()+"', '"+producto.getPrecio()+"', '"+producto.getStock()+"', '"+producto.getId_proveedor()+"', '"+producto.getDescripcion()+"')";
        
        try{
            ps = conexion.conectar().prepareStatement(consulta);
            ps.execute();
            return true;
        }catch(SQLException  | ClassNotFoundException ex){
            return false;
        }
    }
    
    public DefaultTableModel ConsultarTablaProductos(){//CONSULTAR LOS DATOS DE LA TABLA CLIENTES
        DefaultTableModel tablaproductos = new DefaultTableModel();
        String titulo[] = new String[]{"Nº PRODUCTO", "NOMBRE", "PRECIO", "STOCK", "N° PROVEEDOR"};
        
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        String consulta = "SELECT * FROM `productos` WHERE 1";
        
        try{
            ps = conexion.conectar().prepareStatement(consulta);
            rs = ps.executeQuery();
            tablaproductos.setColumnIdentifiers(titulo);
            
            while(rs.next()){
                tablaproductos.addRow(new Object[]{String.valueOf(rs.getInt("id_producto")), rs.getString("nombre"), String.valueOf(rs.getInt("precio")), String.valueOf(rs.getInt("stock")), String.valueOf(rs.getInt("id_proveedor")),rs.getString("descripcion")});
            }
            return tablaproductos;
        }catch(SQLException  | ClassNotFoundException ex){
            return tablaproductos;
        }
    }
    
    public DefaultListModel consultarListaClientes(){
        DefaultListModel listaClientes = new DefaultListModel();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        String consulta = "SELECT nombre FROM productos";
        
        try{
            ps = conexion.conectar().prepareStatement(consulta);
            rs = ps.executeQuery();
            
            while(rs.next()){
                listaClientes.addElement(rs.getString("nombre"));
            }
            return listaClientes;
        }catch(SQLException | ClassNotFoundException ex){
            return listaClientes;
        } 
    }
    
    public Producto consultarProducto(int id_producto){
        Producto producto = new Producto();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        String consulta ="SELECT id_producto, nombre, precio FROM productos WHERE id_producto='"+id_producto+"'";
        
        try{
            ps = conexion.conectar().prepareStatement(consulta);
            rs = ps.executeQuery();
            
            if(rs.next()){
            producto.setNombre(rs.getString("nombre"));
            producto.setPrecio(rs.getInt("precio"));
            }
            
            return producto;
        }catch(SQLException | ClassNotFoundException ex){
            return producto;
        }
    }
    
}
