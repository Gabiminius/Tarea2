import java.time.Duration;
import java.time.Instant;

public class Retraso extends Asistencia{
    private Duration tiempoRetraso;
    public Retraso(Empleado empleado, Instant horaLlegada, Instant horaInicio){
        super(empleado, true, horaLlegada);
        this.tiempoRetraso = Duration.between(horaInicio, horaLlegada);
    }
    public Duration getTiempoRetraso(){
        return tiempoRetraso;
    }
    public void setTiempoRetraso(Duration tiempoRetraso){
        this.tiempoRetraso=tiempoRetraso;
    }
    public String toString(){
        return "Retraso{" + "duracionRetraso=" + tiempoRetraso + '}';

    }
}


