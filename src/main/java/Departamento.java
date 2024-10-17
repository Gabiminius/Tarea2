
import java.util.ArrayList;
import java.util.List;

public class Departamento implements Invitable{

    private String nombredepa;
    private List <Empleado> empleados;

    public Departamento(String nombredepa){
        this.nombredepa=nombredepa;
        this.empleados = new ArrayList<>();
    }
    public void addEmpleado(Empleado empleado){
        empleado.setDepartamento(this.nombredepa);
        empleados.add(empleado);
    }
    int obtenerCantidadEmpleados(){
        return empleados.size();
    }
    /**
     * Obtiene el nombre del departamento.
     *
     * @return El nombre del departamento.
     */
    public String getNombreDepa() {
        return nombredepa;
    }

    /**
     * Establece el nombre del departamento.
     *
     * @param nombredepa El nombre a establecer.
     */
    public void setNombreDepa(String nombredepa) {
        this.nombredepa = nombredepa;
    }

    /**
     * Obtiene la lista de empleados del departamento.
     *
     * @return La lista de empleados.
     */
    public List<Empleado> getEmpleados() {
        return empleados;
    }

    /**
     * Establece la lista de empleados del departamento.
     *
     * @param empleados La lista de empleados a establecer.
     */
    public void setEmpleados(List<Empleado> empleados) {
        this.empleados = empleados;
    }

    public void agregarEmpleado(Empleado empleado) {
        empleado.setDepartamento(this.nombredepa); // Asigna el departamento al empleado
        empleados.add(empleado); //Se añade el empleado a la lista de empleados del departamento
    }
    @Override
    public void invitar(Reunion reunion) {
        System.out.println("Enviando invitación al departamento " + nombredepa);
        for (Empleado empleado : empleados) {
            reunion.agregarParticipante(empleado);
        }

    }
    public String toString(){
        return "Departamento{" + "nombre='" + nombredepa + '\'' + ", empleados=" + empleados + '}';


    }

}

