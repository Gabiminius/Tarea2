import java.time.Instant;
import java.util.Date;
import java.time.Duration;

public class ReunionPresencial extends Reunion {
    private String sala;
    public ReunionPresencial(Date fecha, Instant horaPrevista, Duration duracionPrevista, Empleado organizador, TipoReunion tipoReunion,String sala){
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
        return "ReunionPresencial{" + "sala='" + sala + '\'' + '}';

    }
}
