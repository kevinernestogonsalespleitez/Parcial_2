package Controlador;

import Modelo.ConsultaProducto;
import Modelo.Producto;
import Vista.pnlProductos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ctrlProducto implements ActionListener {

    Producto producto;
    pnlProductos panelProductos;
    ConsultaProducto consultaProducto;

    public ctrlProducto(Producto producto, pnlProductos panelProductos, ConsultaProducto consultaProducto) {
        this.producto = producto;
        this.panelProductos = panelProductos;
        this.consultaProducto = consultaProducto;
        this.panelProductos.btnGuardar.addActionListener(this);
        this.panelProductos.JTablaProductos.setModel(this.consultaProducto.ConsultarTablaProductos());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.panelProductos.btnGuardar) {
            if (this.panelProductos.txtNombre.getText().length() == 0 || this.panelProductos.txtPrecio.getText().length() == 0 || this.panelProductos.txtStock.getText().length() == 0 || this.panelProductos.txtId_proveedor.getText().length() == 0 || this.panelProductos.txtDescripcion.getText().length() == 0) {
                JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios");
            } else {
                this.producto.setNombre(this.panelProductos.txtNombre.getText());
                this.producto.setPrecio(Float.parseFloat(this.panelProductos.txtPrecio.getText()));
                this.producto.setStock(Integer.parseInt(this.panelProductos.txtStock.getText()));
                this.producto.setId_proveedor(Integer.parseInt(this.panelProductos.txtId_proveedor.getText()));
                this.producto.setDescripcion(this.panelProductos.txtDescripcion.getText());
                if (this.consultaProducto.guardarProducto(producto)) {
                    JOptionPane.showMessageDialog(null, "Operacion Exitosa");
                    this.panelProductos.JTablaProductos.setModel(this.consultaProducto.ConsultarTablaProductos());
                } else {
                    JOptionPane.showMessageDialog(null, "Error!");
                }
            }
        }
    }

}
