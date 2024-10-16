public class Asistencia {
    /**
     * Asistencia sirve para representar que un empleado asistió.
     */
    private Empleado emp;

    public Asistencia(Empleado emp){
        this.emp= emp;
    }
    /**
     * El siguiente método devuelve el empleado que ha asistido.
     * @return empleado Empleado que asistió.
     */
    public Empleado getEmpleado(){
        return emp;
    }
        }
