package Controlador;

import Modelo.Cliente;
import Modelo.ConsultaCliente;
import Modelo.ConsultaProducto;
import Modelo.Facturamodelo;
import Modelo.Producto;
import Modelo.consultaProveedores;
import Modelo.proveedores;
import Vista.Sistem;
import Vista.pnlClientes;
import Vista.pnlFactura;
import Vista.pnlProductos;
import Vista.pnlProveedor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ctrlSistema implements ActionListener {

    //FRAME DEL SISTEMA PRINCIPAL
    Sistem sistema = new Sistem();

    //MODELOS
    Cliente cliente = new Cliente();
    ConsultaCliente consultaCliente = new ConsultaCliente();
    ConsultaProducto consultaProducto = new ConsultaProducto();
    Facturamodelo factura = new Facturamodelo();
    Producto producto = new Producto();
    proveedores proveedores = new proveedores();
    consultaProveedores consultaProveedores = new consultaProveedores(proveedores);

    //VISTA
    pnlFactura panelFactura = new pnlFactura();
    pnlClientes panelClientes = new pnlClientes();
    pnlProductos panelProductos = new pnlProductos();
    pnlProveedor panelProveedor = new pnlProveedor();

    //CONTROLADORES
    ctrlProducto controlProductos;
    ctrlCliente controlClientes;
    ctrlFactura controlFactura;
    ctrlProveedores controlProveedores;

    public ctrlSistema() throws ClassNotFoundException {
        controlClientes = new ctrlCliente(cliente, panelClientes, consultaCliente);
        controlFactura = new ctrlFactura(factura, panelFactura, consultaCliente, consultaProducto);
        controlProductos = new ctrlProducto(producto, panelProductos, consultaProducto);
        controlProveedores = new ctrlProveedores(this.proveedores,this.panelProveedor,this.consultaProveedores);
        mostrarPanelFactura();
        this.sistema.btnFactura.addActionListener(this);
        this.sistema.btnClientes.addActionListener(this);
        this.sistema.btnProductos.addActionListener(this);
        this.sistema.JBProveedores.addActionListener(this);
        this.sistema.setVisible(true);
    }

    public void mostrarPanelFactura() {
        this.sistema.panelPrincipal.removeAll();
        this.sistema.panelPrincipal.add(this.controlFactura.panelFactura);
        this.sistema.panelPrincipal.revalidate();
        this.sistema.panelPrincipal.repaint();
    }

    public void mostrarPanelClientes() {
        this.sistema.panelPrincipal.removeAll();
        this.sistema.panelPrincipal.add(this.controlClientes.panelClientes);
        this.sistema.panelPrincipal.revalidate();
        this.sistema.panelPrincipal.repaint();
    }

    public void mostrarPanelProductos() {
        this.sistema.panelPrincipal.removeAll();
        this.sistema.panelPrincipal.add(this.controlProductos.panelProductos);
        this.sistema.panelPrincipal.revalidate();
        this.sistema.panelPrincipal.repaint();
    }

    public void mostrarPanelProveedores() {
        this.sistema.panelPrincipal.removeAll();
        this.sistema.panelPrincipal.add(this.controlProveedores.pnlProveedor);
        this.sistema.panelPrincipal.revalidate();
        this.sistema.panelPrincipal.repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.sistema.btnFactura) {

            this.controlFactura.mostrarTablaProductos();
            this.controlFactura.mostrarClientes();

            mostrarPanelFactura();

        }

        if (e.getSource() == this.sistema.btnClientes) {
            mostrarPanelClientes();
        }

        if (e.getSource() == this.sistema.btnProductos) {
            mostrarPanelProductos();
        }
        if(e.getSource() == this.sistema.JBProveedores){
            mostrarPanelProveedores();
        }

    }

}
