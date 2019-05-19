package Controlador;

import Modelo.Cliente;
import Modelo.ConsultaCliente;
import Modelo.ConsultaProducto;
import Modelo.DetalleFactura;
import Modelo.Facturamodelo;
import Modelo.Producto;
import Vista.pnlFactura;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ctrlFactura implements ActionListener, MouseListener {

    Facturamodelo factura;
    pnlFactura panelFactura;
    ConsultaCliente consultaCliente;
    ConsultaProducto consultaProducto;
    DefaultTableModel tablaFactura = new DefaultTableModel();
    DefaultTableModel tabProducto = new DefaultTableModel();

    public ctrlFactura(Facturamodelo factura, pnlFactura panelFactura, ConsultaCliente consultaCliente, ConsultaProducto consultaProducto) {
        this.factura = factura;
        this.panelFactura = panelFactura;
        this.consultaCliente = consultaCliente;
        this.consultaProducto = consultaProducto;
        this.panelFactura.btnAgregar.addActionListener(this);
        this.panelFactura.tabProducto.addMouseListener(this);
        this.panelFactura.tabCliente.addMouseListener(this);
        mostrarClientes();
        mostrarTablaProductos();
    }

    public void mostrarDatosdelCliente(Cliente cliente) {
        this.panelFactura.lblNombre.setText(cliente.getNombre());
        this.panelFactura.lblApellido.setText(cliente.getApellido());
        this.panelFactura.lblTelefono.setText(cliente.getTelefono());
        this.panelFactura.lblDireccion.setText(cliente.getDireccion());
    }

    public void mostrarDatosdelProducto(Producto producto) {
        this.panelFactura.txtNombreProducto.setText(producto.getNombre());
    }

    public void mostrarClientes() {
        panelFactura.tabCliente.setModel(consultaCliente.consultarTableClientes());
    }

    public void mostrarTablaProductos() {
        panelFactura.tabProducto.setModel(consultaProducto.ConsultarTablaProductos());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.panelFactura.btnAgregar) {

        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == this.panelFactura.tabProducto) {
            String nombre,id;
            int fila = this.panelFactura.tabProducto.getSelectedRow();
            id = this.panelFactura.tabProducto.getValueAt(fila, 0).toString();
            nombre = this.panelFactura.tabProducto.getValueAt(fila, 1).toString();
            this.panelFactura.txtId_Producto.setText(id);
            this.panelFactura.txtNombreProducto.setText(nombre);
        }
        if(e.getSource() == this.panelFactura.tabCliente){
            String nombre,apellido,telefono,direccion;
            int fila = this.panelFactura.tabCliente.getSelectedRow();
            nombre =this.panelFactura.tabCliente.getValueAt(fila, 0).toString();
            apellido =this.panelFactura.tabCliente.getValueAt(fila, 1).toString();
            telefono =this.panelFactura.tabCliente.getValueAt(fila, 2).toString();
            direccion =this.panelFactura.tabCliente.getValueAt(fila, 3).toString();
            this.panelFactura.lblNombre.setText(nombre);
            this.panelFactura.lblApellido.setText(apellido);
            this.panelFactura.lblTelefono.setText(telefono);
            this.panelFactura.lblDireccion.setText(direccion);
            
        }

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

}
