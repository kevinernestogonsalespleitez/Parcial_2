package Modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

public class consultaProveedores {

    Conexion c = new Conexion();
    proveedores proveedores;
    public consultaProveedores(proveedores proveedores) {
        this.proveedores = proveedores;
    }

    public DefaultTableModel consultaTablaProveedores() {
        DefaultTableModel tabProveedores = new DefaultTableModel();
        tabProveedores.addColumn("ID");
        tabProveedores.addColumn("Nombre");
        tabProveedores.addColumn("Direccion");
        tabProveedores.addColumn("Telefono");
        try {
            String consulta = "SELECT * FROM `proveedores` WHERE 1";
            PreparedStatement ps = c.conectar().prepareStatement(consulta);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                this.proveedores.setId_Proveedor(rs.getInt("id_proveedor"));
                this.proveedores.setNombre(rs.getString("nombre"));
                this.proveedores.setDireccion(rs.getString("direccion"));
                this.proveedores.setTelefono(rs.getString("telefono"));
                tabProveedores.addRow(new Object[]{this.proveedores.getId_Proveedor(),this.proveedores.getNombre(),this.proveedores.getDireccion(),this.proveedores.getTelefono()});
            }
            ps.close();
            ps = null;
            c.desconectar();
            return tabProveedores;
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Error");
            return tabProveedores;
        }
    }
    public boolean nuevoProveedor(proveedores proveedores){
        try {
            String consulta = "INSERT INTO `proveedores`(`nombre`, `direccion`, `telefono`) VALUES ('"+this.proveedores.getNombre()+"','"+this.proveedores.getDireccion()+"','"+this.proveedores.getTelefono()+"')";
            PreparedStatement ps = c.conectar().prepareStatement(consulta);
            ps.execute();
            ps.close();
            ps = null;
            c.desconectar();
            return true;
        } catch (ClassNotFoundException | SQLException ex) {
            return false;
        }
    }
    public boolean eliminarProveedor(proveedores proveedores){
        try {
            String consulta = "DELETE FROM `proveedores` WHERE proveedores.id_proveedor='"+proveedores.getId_Proveedor()+"'";
            PreparedStatement ps = c.conectar().prepareCall(consulta);
            ps.execute();
            ps.close();
            ps = null;
            c.desconectar();
            return true;
        } catch (ClassNotFoundException | SQLException ex) {
            return false;
        }
    }
    public boolean buscarProveedores(proveedores proveedores) {
        try {
            String consulta = "SELECT `id_proveedor`, `nombre`, `direccion`, `telefono` FROM `proveedores` WHERE nombre='"+this.proveedores.getNombre()+"'";
            PreparedStatement ps = c.conectar().prepareStatement(consulta);
            ResultSet rs = ps.executeQuery();
            if(rs.next()) {
                this.proveedores.setId_Proveedor(rs.getInt("id_proveedor"));
                this.proveedores.setNombre(rs.getString("nombre"));
                this.proveedores.setDireccion(rs.getString("direccion"));
                this.proveedores.setTelefono(rs.getString("telefono"));
            }
            ps.close();
            ps = null;
            c.desconectar();
            return true;
        } catch (ClassNotFoundException | SQLException ex) {
            return false;
        }
    }
}
