
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
    public boolean asistio() {
        return asistio;
    }

    public Empleado getEmpleado(){
        return empleado;
    }
    public boolean getAsistio() {
        return asistio;
    }
    public Instant getHoraLlegada() {
        return horaLlegada;
    }
    public void setEmpleado(Empleado empleado){
        this.empleado=empleado;
    }
    public void setAsistio(boolean asistio){
        this.asistio=asistio;
    }
    public void setHoraLlegada(Instant horaLlegada){
        this.horaLlegada=horaLlegada;
    }
    public String toString(){
        return "Asistencia{" + "empleado=" + empleado + ", horaLlegada=" + horaLlegada + ", asistio=" + asistio + '}';

    }
        }


