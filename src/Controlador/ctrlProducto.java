package Controlador;

import Modelo.ConsultaProducto;
import Modelo.Producto;
import Vista.pnlProductos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ctrlProducto implements ActionListener, MouseListener {

    Producto producto;
    pnlProductos panelProductos;
    ConsultaProducto consultaProducto;

    public ctrlProducto(Producto producto, pnlProductos panelProductos, ConsultaProducto consultaProducto) {
        this.producto = producto;
        this.panelProductos = panelProductos;
        this.consultaProducto = consultaProducto;
        this.panelProductos.btnGuardar.addActionListener(this);
        this.panelProductos.BTNEliminarProducto.addActionListener(this);
        this.panelProductos.limpiar.addActionListener(this);
        this.panelProductos.btBuscar.addActionListener(this);
        this.panelProductos.JTablaProductos.addMouseListener(this);
        this.panelProductos.JTablaProductos.setModel(this.consultaProducto.ConsultarTablaProductos());
        this.panelProductos.txtId.setEnabled(false);
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
                    limpiar();
                    this.panelProductos.JTablaProductos.setModel(this.consultaProducto.ConsultarTablaProductos());
                } else {
                    JOptionPane.showMessageDialog(null, "Error!");
                }
            }
        }
        if (e.getSource() == this.panelProductos.BTNEliminarProducto) {
            if (this.panelProductos.txtId.getText().length() == 0) {
                JOptionPane.showMessageDialog(null, "Es necesario el campo Id para la eliminacion de un registro");
            } else {
                this.producto.setId(Integer.parseInt(this.panelProductos.txtId.getText()));
                int mensaje = JOptionPane.showConfirmDialog(null, "Esta seguro de que sea eliminar el registro seleccionado");
                if (mensaje == JOptionPane.YES_OPTION) {
                    if (this.consultaProducto.eliminarProducto(producto)) {
                        JOptionPane.showMessageDialog(null, "Operacion Exitosa");
                        this.panelProductos.JTablaProductos.setModel(this.consultaProducto.ConsultarTablaProductos());
                        limpiar();
                    } else {
                        JOptionPane.showMessageDialog(null, "Error al eliminar");
                    }
                }
            }
        }
        if (e.getSource() == this.panelProductos.btBuscar) {
            if (this.panelProductos.txtBuscar.getText().length() == 0) {
                JOptionPane.showMessageDialog(null, "El campo Busqueda Producto es requerido");
            } else {
                try{
                this.producto.setId(Integer.parseInt(this.panelProductos.txtBuscar.getText()));
                if (this.consultaProducto.buscarProducto(producto)) {
                    JOptionPane.showMessageDialog(null, "Se a encontrado un resultado");
                    this.panelProductos.txtId.setText(String.valueOf(this.producto.getId()));
                    this.panelProductos.txtNombre.setText(this.producto.getNombre());
                    this.panelProductos.txtPrecio.setText(String.valueOf(this.producto.getPrecio()));
                    this.panelProductos.txtStock.setText(String.valueOf(this.producto.getStock()));
                    this.panelProductos.txtId_proveedor.setText(String.valueOf(this.producto.getId_proveedor()));
                } else {
                    JOptionPane.showMessageDialog(null, "No se han encontrado resultados");
                }
                } catch (NumberFormatException en) {
                    JOptionPane.showMessageDialog(null, "Porfavor Ingrese unicamente el Id del Producto que decea buscar");
                }
            }

        }
        if (e.getSource() == this.panelProductos.limpiar) {
            limpiar();
        }
    }

    public void limpiar() {
        this.panelProductos.txtId.setText("");
        this.panelProductos.txtId_proveedor.setText("");
        this.panelProductos.txtNombre.setText("");
        this.panelProductos.txtPrecio.setText("");
        this.panelProductos.txtStock.setText("");
        this.panelProductos.txtDescripcion.setText("");
        this.panelProductos.txtBuscar.setText("");
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int fila = this.panelProductos.JTablaProductos.getSelectedRow();
        this.panelProductos.txtId.setText(this.panelProductos.JTablaProductos.getValueAt(fila, 0).toString());
        this.panelProductos.txtNombre.setText(this.panelProductos.JTablaProductos.getValueAt(fila, 1).toString());
        this.panelProductos.txtPrecio.setText(this.panelProductos.JTablaProductos.getValueAt(fila, 2).toString());
        this.panelProductos.txtStock.setText(this.panelProductos.JTablaProductos.getValueAt(fila, 3).toString());
        this.panelProductos.txtId_proveedor.setText(this.panelProductos.JTablaProductos.getValueAt(fila, 4).toString());

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
