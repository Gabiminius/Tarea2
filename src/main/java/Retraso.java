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
    public String toString(){

    }
}


