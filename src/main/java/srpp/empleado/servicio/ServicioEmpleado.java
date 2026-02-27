
package srpp.empleado.servicio;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import srpp.empleado.modelo.Empleado;
import srpp.empleado.repositorio.EmpleadoRepositorio;

/**
 *
 * @author srpp
 */
@Service
public class ServicioEmpleado implements IServicioEmpleado{
    @Autowired
    private EmpleadoRepositorio empleadoRepositorio;
    
    @Override
    public List<Empleado> listarEmpleados() {
        return empleadoRepositorio.findAll();
    }

    @Override
    public Empleado buscarEmpleadoId(Integer idEmpleado) {        
        Empleado empleado= empleadoRepositorio.findById(idEmpleado).orElse(null);
        return empleado;
    }

    @Override
    public void eliminarEmpleado(Empleado empleado) {
       empleadoRepositorio.delete(empleado);
    }

    @Override
    public void agragarEmpleado(Empleado empleado) {
        empleadoRepositorio.save(empleado);
    }
    
}
