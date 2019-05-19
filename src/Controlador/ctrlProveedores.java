package Controlador;

import Modelo.consultaProveedores;
import Modelo.proveedores;
import Vista.pnlProveedor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;

public class ctrlProveedores implements ActionListener, MouseListener {

    proveedores proveedores;
    pnlProveedor pnlProveedor;
    consultaProveedores consultaProveedores;

    public ctrlProveedores(proveedores proveedores, pnlProveedor pnlProveedor, consultaProveedores consultaProveedores) {
        this.proveedores = proveedores;
        this.pnlProveedor = pnlProveedor;
        this.consultaProveedores = consultaProveedores;
        this.pnlProveedor.btnGuardarProveedor.addActionListener(this);
        this.pnlProveedor.jbnEliminarProveedor.addActionListener(this);
        this.pnlProveedor.jbnLimpiar.addActionListener(this);
        this.pnlProveedor.JBBuscar.addActionListener(this);
        this.pnlProveedor.txtId.setEnabled(false);
        this.pnlProveedor.tabProveedores.setModel(this.consultaProveedores.consultaTablaProveedores());
        this.pnlProveedor.tabProveedores.addMouseListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.pnlProveedor.btnGuardarProveedor) {
            if (this.pnlProveedor.txtNombre.getText().length() == 0) {
                JOptionPane.showMessageDialog(null, "Todos los campos son Obligatorios");
            } else {
                this.proveedores.setNombre(this.pnlProveedor.txtNombre.getText());
                this.proveedores.setDireccion(this.pnlProveedor.txtDireccion.getText());
                this.proveedores.setTelefono(this.pnlProveedor.txtTelefono.getText());
                if (this.consultaProveedores.nuevoProveedor(proveedores)) {
                    JOptionPane.showMessageDialog(null, "Se a guardado correctamente");
                    limpiar();
                    this.pnlProveedor.tabProveedores.setModel(this.consultaProveedores.consultaTablaProveedores());
                } else {
                    JOptionPane.showMessageDialog(null, "Error al guardar");
                }
            }
        }
        if (e.getSource() == this.pnlProveedor.jbnEliminarProveedor) {
            if (this.pnlProveedor.txtId.getText().length() == 0) {
                JOptionPane.showMessageDialog(null, "Primero seleccione una fila en la tabla y luego presione el boton eliminar de nuevo");
            } else {
                proveedores.setId_Proveedor(Integer.parseInt(this.pnlProveedor.txtId.getText()));
                if (this.consultaProveedores.eliminarProveedor(proveedores)) {
                    JOptionPane.showMessageDialog(null, "Se elimino correctamente");
                    this.pnlProveedor.tabProveedores.setModel(this.consultaProveedores.consultaTablaProveedores());
                    limpiar();
                } else {
                    JOptionPane.showMessageDialog(null, "Error al eliminar registro");
                }
            }
        }
        if (e.getSource() == this.pnlProveedor.JBBuscar) {
            if (this.pnlProveedor.TxtBuscar.getText().length() == 0) {
                JOptionPane.showMessageDialog(null, "Es necesario llenar el campo busqueda proveedor con el ID del proveedor");
            } else {
                proveedores.setId_Proveedor(Integer.parseInt(this.pnlProveedor.TxtBuscar.getText()));
                if (this.consultaProveedores.buscarProveedores(proveedores)) {
                    this.pnlProveedor.txtId.setText(String.valueOf(this.proveedores.getId_Proveedor()));
                    this.pnlProveedor.txtNombre.setText(this.proveedores.getNombre());
                    this.pnlProveedor.txtDireccion.setText(this.proveedores.getDireccion());
                    this.pnlProveedor.txtTelefono.setText(this.proveedores.getTelefono());
                }else{
                    JOptionPane.showMessageDialog(null, "Error en la busqueda");
                }
            }
        }
        if (e.getSource() == this.pnlProveedor.jbnLimpiar) {
            limpiar();
        }
    }

    public void limpiar() {
        this.pnlProveedor.txtId.setText("");
        this.pnlProveedor.txtNombre.setText("");
        this.pnlProveedor.txtDireccion.setText("");
        this.pnlProveedor.txtTelefono.setText("");
        this.pnlProveedor.TxtBuscar.setText("");
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == this.pnlProveedor.tabProveedores) {
            int fila = this.pnlProveedor.tabProveedores.getSelectedRow();
            this.pnlProveedor.txtId.setText(this.pnlProveedor.tabProveedores.getValueAt(fila, 0).toString());
            this.pnlProveedor.txtNombre.setText(this.pnlProveedor.tabProveedores.getValueAt(fila, 1).toString());
            this.pnlProveedor.txtDireccion.setText(this.pnlProveedor.tabProveedores.getValueAt(fila, 2).toString());
            this.pnlProveedor.txtTelefono.setText(this.pnlProveedor.tabProveedores.getValueAt(fila, 3).toString());
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
