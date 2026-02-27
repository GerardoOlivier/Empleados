
package srpp.empleado.controlador;

import jakarta.servlet.http.HttpServletRequest;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import srpp.empleado.modelo.Empleado;
import srpp.empleado.servicio.ServicioEmpleado;

/**
 *
 * @author srpp
 */
@Controller
public class IndexControlador {
   private static final Logger  logger = LoggerFactory.getLogger(IndexControlador.class);
   @Autowired
   ServicioEmpleado servicioEmpleado; 
   
   @RequestMapping(value="/", method=RequestMethod.GET)
   public String iniciar(ModelMap modelo){
       List<Empleado> empleados = servicioEmpleado.listarEmpleados();
       empleados.forEach(empleado -> logger.info(empleado.toString()));
       modelo.put("empleados", empleados);               
       return "index";
   }
   
   @RequestMapping(value="/agregar", method=RequestMethod.GET)
   public String mostrarAgregar(){       
       return "agregar";
   }
   
   @RequestMapping(value="/agregar", method=RequestMethod.POST)
   public String agregar(@ModelAttribute("empleadoForma") Empleado empleado,HttpServletRequest request){
       logger.info("Empleado a agregar:"+empleado);
       servicioEmpleado.agragarEmpleado(empleado);
       return "redirect:/";
   }
   
   @RequestMapping(value="/editar", method=RequestMethod.GET)
   public String mostrarEditar(@RequestParam int idEmpleado,ModelMap modelo){
       Empleado empleado=servicioEmpleado.buscarEmpleadoId(idEmpleado);
       logger.info("Empleado a editar:"+empleado);
       modelo.put("empleado",empleado);
       return "editar";
   }    
   
   @RequestMapping(value="/editar",method=RequestMethod.POST)
   public String editar(@ModelAttribute("empleadoForma") Empleado empleado){
       logger.info("Empleado a guardar (editar):"+empleado);
       servicioEmpleado.agragarEmpleado(empleado);
       return "redirect:/";
   }
   
    @RequestMapping(value="/eliminar", method=RequestMethod.GET)
    public String eliminar(@RequestParam int idEmpleado){
        Empleado empleado=new Empleado();
        empleado.setIdEmpleado(idEmpleado);
        servicioEmpleado.eliminarEmpleado(empleado);
        return "redirect:/";
    }
    
   
   
}
