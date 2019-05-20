package Controlador;

import Modelo.Cliente;
import Modelo.ConsultaCliente;
import Vista.pnlClientes;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ctrlCliente implements ActionListener, MouseListener {

    Cliente cliente;
    ConsultaCliente consultaCliente;
    pnlClientes panelClientes;
    DefaultTableModel tablaClientes = new DefaultTableModel();

    public ctrlCliente(Cliente cliente, pnlClientes panelClientes, ConsultaCliente consultaCliente) throws ClassNotFoundException {
        this.cliente = cliente;
        this.panelClientes = panelClientes;
        this.consultaCliente = consultaCliente;
        this.panelClientes.tablaCliente.setModel(consultaCliente.consultarTableClientes());
        this.panelClientes.btnGuardarCliente.addActionListener(this);
        this.panelClientes.JBEliminar.addActionListener(this);
        this.panelClientes.JBLimpiar.addActionListener(this);
        this.panelClientes.tablaCliente.addMouseListener(this);
        this.panelClientes.BTBuscar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.panelClientes.btnGuardarCliente) {
            if (this.panelClientes.txtNombre.getText().length() == 0 || this.panelClientes.txtApellido.getText().length() == 0 || this.panelClientes.txtDireccion.getText().length() == 0 || this.panelClientes.txtTelefono.getText().length() == 0) {
                JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios");
            } else {
                this.cliente.setNombre(this.panelClientes.txtNombre.getText());
                this.cliente.setApellido(this.panelClientes.txtApellido.getText());
                this.cliente.setDireccion(this.panelClientes.txtDireccion.getText());
                this.cliente.setTelefono(this.panelClientes.txtTelefono.getText());
                if (consultaCliente.nuevoCliente(cliente)) {
                    JOptionPane.showMessageDialog(null, "Datos guardados correctamente");
                    this.panelClientes.tablaCliente.setModel(consultaCliente.consultarTableClientes());
                    limpiar();
                } else {
                    JOptionPane.showMessageDialog(null, "Error al guardar");
                }
            }
        }
        if (e.getSource() == this.panelClientes.JBEliminar) {
            if (this.panelClientes.txtId.getText().length() == 0) {
                JOptionPane.showMessageDialog(null, "El campo Id es requerido");
            } else {
                int mensaje = JOptionPane.showConfirmDialog(null, "Esta seguro de que decea eliminar el registro seleccionado");
                if (JOptionPane.YES_OPTION == mensaje) {
                    this.cliente.setId(Integer.parseInt(this.panelClientes.txtId.getText()));
                    if (this.consultaCliente.eliminarCliente(cliente)) {
                        JOptionPane.showMessageDialog(null, "Se elimino correctamente");
                        this.panelClientes.tablaCliente.setModel(consultaCliente.consultarTableClientes());
                        limpiar();
                    } else {
                        JOptionPane.showMessageDialog(null, "Error al eliminar");
                    }
                }
            }
        }
        if (e.getSource() == this.panelClientes.JBLimpiar) {
            limpiar();
        }
        if (e.getSource() == this.panelClientes.BTBuscar) {
            if (this.panelClientes.txtBuscar.getText().length() == 0) {
                JOptionPane.showMessageDialog(null, "El campo Busqueda cliente es requerido");
            } else {
                cliente.setId(Integer.parseInt(this.panelClientes.txtBuscar.getText()));
                if (this.consultaCliente.buscarcliente(cliente)) {
                    JOptionPane.showMessageDialog(null, "Se ha encontrado un resultado");
                    this.panelClientes.txtId.setText(String.valueOf(cliente.getid()));
                    this.panelClientes.txtNombre.setText(cliente.getNombre());
                    this.panelClientes.txtApellido.setText(cliente.getApellido());
                    this.panelClientes.txtDireccion.setText(cliente.getDireccion());
                    this.panelClientes.txtTelefono.setText(cliente.getTelefono());

                } else {
                    JOptionPane.showMessageDialog(null, "No se han encontrado resultados");
                }
            }
        }

    }

    public void limpiar() {
        this.panelClientes.txtId.setText("");
        this.panelClientes.txtNombre.setText("");
        this.panelClientes.txtApellido.setText("");
        this.panelClientes.txtDireccion.setText("");
        this.panelClientes.txtTelefono.setText("");
        this.panelClientes.txtBuscar.setText("");
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == this.panelClientes.tablaCliente) {
            int fila = this.panelClientes.tablaCliente.getSelectedRow();
            this.panelClientes.txtId.setText(this.panelClientes.tablaCliente.getValueAt(fila, 0).toString());
            this.panelClientes.txtNombre.setText(this.panelClientes.tablaCliente.getValueAt(fila, 1).toString());
            this.panelClientes.txtApellido.setText(this.panelClientes.tablaCliente.getValueAt(fila, 2).toString());
            this.panelClientes.txtDireccion.setText(this.panelClientes.tablaCliente.getValueAt(fila, 3).toString());
            this.panelClientes.txtTelefono.setText(this.panelClientes.tablaCliente.getValueAt(fila, 4).toString());
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
