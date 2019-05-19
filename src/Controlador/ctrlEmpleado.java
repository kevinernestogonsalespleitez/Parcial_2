package Controlador;

import Modelo.ConsultaEmpleado;
import Modelo.Empleado;
import Vista.ventanaPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ctrlEmpleado implements ActionListener {

    Empleado empleado;
    ConsultaEmpleado consultaEmpleado;
    ventanaPrincipal vistaPrincipal;

    public ctrlEmpleado(Empleado empleado, ConsultaEmpleado consultaEmpleado, ventanaPrincipal vistaPrincipal) {
        this.empleado = empleado;
        this.consultaEmpleado = consultaEmpleado;
        this.vistaPrincipal = vistaPrincipal;
        this.vistaPrincipal.setVisible(true);
        this.vistaPrincipal.btnIngresarx.addActionListener(this);
    }
/////////////////////////////////////////////////////////////////////////////

    /*public void mostrarLogin(){
        this.ventanaPrincipal.Panel.setVisible(false);
        this.ventanaPrincipal.Panel.removeAll();
        this.ventanaPrincipal.Panel.setVisible(true);
        this.ventanaPrincipal.Panel.add(this.panelLog);
        this.ventanaPrincipal.Panel.revalidate();
        this.ventanaPrincipal.Panel.repaint();
        
    }*/
/////////////////////////////////////////////////////////////////////
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.vistaPrincipal.btnIngresarx) {
            empleado.setCorreo(this.vistaPrincipal.txtCorreo.getText());
            empleado.setContraseña(new String(this.vistaPrincipal.JTPPass.getPassword()).toString());

            try {
                if (this.consultaEmpleado.IniciarSesion(this.empleado) == true) {
                    JOptionPane.showMessageDialog(null, "Exito!");
                    this.vistaPrincipal.setVisible(false);
                    ctrlSistema sistema = new ctrlSistema();
                }else{
                    JOptionPane.showMessageDialog(null, "Error");
                
                }

            } catch (SQLException ex) {
                Logger.getLogger(ctrlEmpleado.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ctrlEmpleado.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

}
