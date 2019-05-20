package Modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ConsultaCliente {

    Conexion conexion = new Conexion();

    public boolean nuevoCliente(Cliente cliente) {
        try {
            String consulta = "INSERT INTO `clientes`(`nombre`, `apellido`, `direccion`, `telefono`) VALUES('" + cliente.getNombre() + "', '" + cliente.getApellido() + "', '" + cliente.getTelefono() + "', '" + cliente.getDireccion() + "')";
            PreparedStatement ps = conexion.conectar().prepareStatement(consulta);
            ps.execute();
            ps.close();
            ps = null;
            conexion.desconectar();
            return true;
        } catch (SQLException | ClassNotFoundException ex) {
            return false;
        }

    }

    public DefaultTableModel consultarTableClientes() {
        DefaultTableModel tabClientes = new DefaultTableModel();
        tabClientes.addColumn("ID");
        tabClientes.addColumn("Nombre");
        tabClientes.addColumn("Apellido");
        tabClientes.addColumn("Telefono");
        tabClientes.addColumn("Direccion");
        PreparedStatement ps = null;
        ResultSet rs = null;

        String consulta = "SELECT `id_cliente`, `nombre`, `apellido`, `direccion`, `telefono` FROM `clientes` WHERE 1";
        try {
            ps = conexion.conectar().prepareStatement(consulta);
            rs = ps.executeQuery();

            while (rs.next()) {
                String id = String.valueOf(rs.getInt("id_cliente"));
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String telefono = String.valueOf(rs.getInt("telefono"));
                String direccion = rs.getString("direccion");
                tabClientes.addRow(new Object[]{id, nombre, apellido, telefono, direccion});
            }
            return tabClientes;
        } catch (SQLException | ClassNotFoundException ex) {
            return tabClientes;
        }
    }

    public boolean eliminarCliente(Cliente Cliente) {
        try {
            String consulta = "DELETE FROM `clientes` WHERE id_cliente='" + Cliente.getid() + "'";
            PreparedStatement ps = conexion.conectar().prepareCall(consulta);
            ps.execute();
            ps.close();
            ps = null;
            conexion.desconectar();
            return true;
        } catch (ClassNotFoundException | SQLException ex) {
            return false;
        }
    }

    public boolean buscarcliente(Cliente Cliente) {
        try {
            String consulta = "SELECT * FROM `clientes` WHERE id_cliente='" + Cliente.getid() + "'";
            Cliente.setId(0);
            Cliente.setNombre("");
            Cliente.setApellido("");
            Cliente.setDireccion("");
            Cliente.setTelefono("");
            PreparedStatement ps = conexion.conectar().prepareStatement(consulta);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Cliente.setId(rs.getInt("id_cliente"));
                Cliente.setNombre(rs.getString("nombre"));
                Cliente.setApellido(rs.getString("apellido"));
                Cliente.setDireccion(rs.getString("direccion"));
                Cliente.setTelefono(rs.getString("telefono"));
                return true;
            }
            return false;
        } catch (ClassNotFoundException | SQLException ex) {
            return false;
        }
    }
}
