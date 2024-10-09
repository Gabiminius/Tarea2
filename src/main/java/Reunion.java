import java.util.Date;
import java.time.Instant;
import java.time.Duration;
import java.util.List;


public abstract class Reunion {
    private Date fecha;
    private Instant horaPrevista;
    private Duration duracionPrevista;
    private Instant horarioInicio;
    private Instant horaFin;

    public Reunion(){

    }
    public List obtenerAsistencias(){

    }
    public List obtenerAusencias(){

    }
    public List obtenerRetrasos(){

    }
    int obtenerTotalAsistencia(){

    }
    float obtenerPorcentajeAsistencia(){

    }
    float calcularTiempoReal(){

    }
    void iniciar(){

    }
    void finalizar(){

    }


}
