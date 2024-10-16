import java.time.Instant;

public class Asistencia {
    /**
     * Asistencia sirve para representar que un empleado asistió.
     */
    private Empleado empleado;
    private boolean asistio;
    private Instant horaLlegada;

    public Asistencia(Empleado empleado, boolean asistio,Instant horaLlegada){
        this.empleado= empleado;
        this.asistio= asistio;
        this.horaLlegada=horaLlegada;
    }
    /**
     * El siguiente método devuelve el empleado que ha asistido.
     * @return empleado Empleado que asistió.
     */
    public Empleado getEmpleado(){
        return empleado;
    }
    public boolean getAsistio() {
        return asistio;
    }
    public Instant getHoraLlegada() {
        return horaLlegada;
    }
    public String toString(){

    }
        }


