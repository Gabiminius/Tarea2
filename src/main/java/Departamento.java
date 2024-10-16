import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
public class Departamento implements Invitable{

    private String nombre;
    private List <Empleado> empleados = new ArrayList<>();

    public Departamento(String nombre){
        this.nombre=nombre;
    }
    public void addEmpleado(Empleado empleado){
        empleados.add(empleado);
    }
    int obtenerCantidadEmpleados(){
        return empleados.size();
    }
    @Override
    public void invitar(Reunion reunion) {

    }
    public String toString(){

    }

}

