import java.time.Instant;
import java.util.Date;
import java.time.Duration;

public class ReunionPresencial extends Reunion {
    private String sala;
    public ReunionPresencial(String sala, Date fecha, Instant horaPrevista, Duration duracionPrevista, Empleado organizador, TipoReunion tipoReunion){
        super(fecha, horaPrevista, duracionPrevista, organizador, tipoReunion);
        this.sala = sala;
    }
    public String getSala() {
        return sala;
    }

    public void setSala(String sala) {
        this.sala = sala;
    }
    public String toString(){

    }
}
