package srpp.empleado.servicio;

import java.util.List;
import srpp.empleado.modelo.Empleado;

/**
 *
 * @author srpp
 */
public interface IServicioEmpleado {

    public List<Empleado> listarEmpleados();
    public Empleado buscarEmpleadoId(Integer idEmpleado);
    public void eliminarEmpleado(Empleado empleado);
    public void agragarEmpleado(Empleado empleado); 
    
    
    
}
