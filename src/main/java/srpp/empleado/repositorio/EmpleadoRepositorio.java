
package srpp.empleado.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import srpp.empleado.modelo.Empleado;

/**
 *
 * @author srpp
 */
public interface EmpleadoRepositorio extends JpaRepository<Empleado, Integer> {
    
    
}
