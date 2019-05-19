package Controlador;

import Modelo.Cliente;
import Modelo.ConsultaCliente;
import Vista.pnlClientes;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ctrlCliente implements ActionListener{
    
    Cliente cliente;
    ConsultaCliente consultaCliente;
   
    pnlClientes panelClientes;
    boolean consulta;
    
    DefaultTableModel tablaClientes = new DefaultTableModel();

    public ctrlCliente(Cliente cliente, pnlClientes panelClientes, ConsultaCliente consultaCliente) throws ClassNotFoundException{
        this.cliente = cliente;
        this.panelClientes = panelClientes;
        this.consultaCliente = consultaCliente;
        this.panelClientes.tablaCliente.setModel(consultaCliente.consultarTablaClientes());
        this.panelClientes.btnGuardarCliente.addActionListener(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        consulta = false;
        if(e.getSource()==this.panelClientes.btnGuardarCliente){
            if (this.panelClientes.txtNombre.getText().length() == 0 || this.panelClientes.txtApellido.getText().length() == 0 || this.panelClientes.txtDireccion.getText().length() == 0 || this.panelClientes.txtTelefono.getText().length() == 0) {
                this.cliente.setNombre(this.panelClientes.txtNombre.getText());
                this.cliente.setApellido(this.panelClientes.txtApellido.getText());
                this.cliente.setDireccion(this.panelClientes.txtDireccion.getText());
                this.cliente.setTelefono(this.panelClientes.txtTelefono.getText());

                consultaCliente.nuevoCliente(this.cliente);

                this.panelClientes.tablaCliente.setModel(consultaCliente.consultarTablaClientes());
            } else {
                JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios");
            }
        }
        /*if(e.getSource() == this.panelClientes.){
            
            if (this.panelClientes.txtNombre.getText().length() == 0 || this.panelClientes.txtApellido.getText().length() == 0) {
                JOptionPane.showMessageDialog(null, "Todos los campos son obligatorios");
            } else {
                this.cliente.setNombre(this.panelClientes.txtNombre.getText());
                this.cliente.setApellido(this.panelClientes.txtApellido.getText());
                this.cliente.setDireccion(this.panelClientes.txtDireccion.getText());
                this.cliente.setTelefono(this.panelClientes.txtTelefono.getText());

                consultaCliente.nuevoCliente(this.cliente);

                this.panelClientes.tablaCliente.setModel(consultaCliente.consultarTablaClientes());
            }
        }*/
        
    }
    
    
    }  
    

