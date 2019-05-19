package Principal;

import Controlador.ctrlEmpleado;
import Modelo.ConsultaEmpleado;
import Modelo.Empleado;
import Vista.ventanaPrincipal;

public class Principal {
    
    public static void main(String []args){
        Empleado empleado = new Empleado();
        ConsultaEmpleado consultaEmpleado = new ConsultaEmpleado();
        ventanaPrincipal vistaPrincipal = new ventanaPrincipal();
        
        ctrlEmpleado log = new ctrlEmpleado(empleado, consultaEmpleado,vistaPrincipal);
        
   
    }
    
}
