package Modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ConsultaCliente {
    
    Conexion conexion = new Conexion();
    
    public boolean nuevoCliente(Cliente cliente) {//GUARDAR CLIENTE
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        String query = "INSERT INTO clientes(nombre, apellido, telefono, direccion) VALUES('"+cliente.getNombre()+"', '"+cliente.getApellido()+"', '"+cliente.getTelefono()+"', '"+cliente.getDireccion()+"')";
    
        try{
            ps = conexion.conectar().prepareStatement(query);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "SE GUARDO CORRECTAMENTE");
            return true;
        }catch(SQLException | ClassNotFoundException ex){
            return false;
        }finally{
            try{
                conexion.conectar().close();
            }catch(SQLException | ClassNotFoundException ex){
            }
        }
        
    }
    
    public Cliente consultarCliente(int id_cliente){
        Cliente cliente = new Cliente();
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        String consulta ="SELECT id_cliente, nombre, apellido, telefono, direccion FROM clientes WHERE id_cliente='"+id_cliente+"'";
        
        try{
            ps = conexion.conectar().prepareStatement(consulta);
            rs = ps.executeQuery();
            
            if(rs.next()){
            cliente.setNombre(rs.getString("nombre"));
            cliente.setApellido(rs.getString("apellido"));
            cliente.setTelefono(rs.getString("telefono"));
            cliente.setDireccion(rs.getString("direccion"));
            }
            
            JOptionPane.showMessageDialog(null, "Cliente "+id_cliente);
            
            return cliente;
        }catch(SQLException | ClassNotFoundException ex){
            return cliente;
        }
        
        
    }
    
    public DefaultTableModel consultarTableClientes(){
        DefaultTableModel tabClientes = new DefaultTableModel();
        tabClientes.addColumn("ID");
        tabClientes.addColumn("Nombre");
        tabClientes.addColumn("Apellido");
        tabClientes.addColumn("Telefono");
        tabClientes.addColumn("Direccion");
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        String consulta = "SELECT `id_cliente`, `nombre`, `apellido`, `direccion`, `telefono` FROM `clientes` WHERE 1";
        try{
            ps = conexion.conectar().prepareStatement(consulta);
            rs = ps.executeQuery();
            
            while(rs.next()){
                String id = String.valueOf(rs.getInt("id_cliente"));
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String telefono = String.valueOf(rs.getInt("telefono"));
                String direccion = rs.getString("direccion");
                tabClientes.addRow(new Object[]{id,nombre,apellido,telefono,direccion});
            }
            return tabClientes;
        }catch(SQLException | ClassNotFoundException ex){
            return tabClientes;
        } 
    }
    
    public DefaultTableModel consultarTablaClientes(){//CONSULTAR LOS DATOS DE LA TABLA CLIENTES
        DefaultTableModel tablaClientes = new DefaultTableModel();
        String titulo[] = new String[]{"Nº CLIENTE", "NOMBRE", "APELLIDO", "TELEFONO", "DIRECCION"};
        
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        String consulta = "SELECT id_cliente, nombre, apellido, telefono, direccion FROM clientes";
        
        try{
            ps = conexion.conectar().prepareStatement(consulta);
            rs = ps.executeQuery();
            tablaClientes.setColumnIdentifiers(titulo);
            
            while(rs.next()){
                tablaClientes.addRow(new Object[]{String.valueOf(rs.getInt("id_cliente")), rs.getString("nombre"), rs.getString("apellido"), rs.getString("telefono"), rs.getString("direccion")});
            }
            return tablaClientes;
        }catch(SQLException | ClassNotFoundException ex){
            return tablaClientes;
        }
    }
      
    
}
