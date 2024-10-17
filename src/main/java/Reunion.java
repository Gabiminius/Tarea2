import java.util.ArrayList;
import java.util.Date;
import java.time.Instant;
import java.time.Duration;
import java.util.List;

public abstract class Reunion {
    private Date fecha;
    private Instant horaPrevista;
    private Duration duracionPrevista;
    private Instant horaInicio;
    private Instant horaFin;
    private List<Asistencia> asistencias;
    private List<Invitacion> invitaciones;
    private List<Nota> notas;
    private Empleado organizador;
    private TipoReunion tipoReunion;
    private List<Invitable> participantes;
    /**
     * Constructor para crear una reunión.
     * @param fecha Fecha de la reunión.
     * @param horaPrevista Hora prevista para iniciar la reunión.
     * @param duracionPrevista Duración prevista de la reunión.
     * @param organizador Empleado que organiza la reunión.
     * @param tipoReunion Tipo de la reunión.
     */


    public Reunion(Date fecha,Instant horaPrevista,Duration duracionPrevista,Empleado organizador, TipoReunion tipoReunion){
        this.fecha = fecha;
        this.horaPrevista = horaPrevista;
        this.duracionPrevista = duracionPrevista;
        this.organizador = organizador;
        this.tipoReunion = tipoReunion;
        this.asistencias = new ArrayList<>();
        this.invitaciones = new ArrayList<>();
        this.notas = new ArrayList<>();
        this.participantes = new ArrayList<>();

    }
    public List<Asistencia> obtenerAsistencias() {
        return asistencias;
    }
    public List<Asistencia> obtenerAusencias(){
        List<Asistencia> ausencias = new ArrayList<>();
        for (Asistencia asistencia : asistencias) {
            if (!asistencia.getAsistio()) {
                ausencias.add(asistencia);
            }
        }
        return ausencias;

    }
    public List<Retraso> obtenerRetrasos(){
        List<Retraso> retrasos = new ArrayList<>();
        for (Asistencia asistencia : asistencias) {
            if (asistencia instanceof Retraso) {
                retrasos.add((Retraso) asistencia);
            }
        }
        return retrasos;
    }
    public int obtenerTotalAsistencia(){
        int total = 0;
        for (Asistencia asistencia : asistencias) {
            if (asistencia.getAsistio()) {
                total++;
            }
        }
        return total;

    }
    public float obtenerPorcentajeAsistencia(){
        int totalAsistencia = obtenerTotalAsistencia();
        int totalInvitados = participantes.size(); // Suponiendo que participantes incluye a todos los invitados
        if (totalInvitados == 0) {
            return 0;
        }
        return (totalAsistencia / (float) totalInvitados) * 100;

    }
    public Duration calcularTiempoReal() {
        if (horaInicio != null && horaFin != null) {
            return Duration.between(horaInicio, horaFin);
        }
        return Duration.ZERO;
    }
    public void iniciar(){
        this.horaInicio = Instant.now();

    }
    public void finalizar(){
        this.horaFin = Instant.now();

    }
    public void agregarParticipante(Invitable participante) {
        if (!participantes.contains(participante)) { //Si el participante no esta en participantes
            participantes.add(participante); //Se añade a participantes

            Invitacion invitacion = new Invitacion(participante, this, Instant.now()); //Se crea una instancia de invitacion para la reunion creada y el participante invitado
            invitaciones.add(invitacion); //Se agrega esa instancia de invitacion a las invitaciones
            invitacion.invitar(); //Se llama el metodo enviar de invitacion
        }
    }
    //getters

    public Empleado getOrganizador() {
        return organizador;
    }

    public Date getFecha() {
        return fecha;
    }

    public Duration getDuracionPrevista() {
        return duracionPrevista;
    }

    public Instant getHoraFin() {
        return horaFin;
    }

    public Instant getHoraInicio() {
        return horaInicio;
    }

    public Instant getHoraPrevista() {
        return horaPrevista;
    }

    public TipoReunion getTipoReunion() {
        return tipoReunion;
    }

    public List<Asistencia> getAsistencias() {
        return asistencias;
    }

    public List<Invitable> getParticipantes() {
        return participantes;
    }

    public List<Invitacion> getInvitaciones() {
        return invitaciones;
    }

    public List<Nota> getNotas() {
        return notas;
    }
    public void agregarNota(String contenido) {
        Nota nota = new Nota(contenido);
        this.notas.add(nota);
    }
    public void listarNotas() {
        System.out.println("Notas de la reunión:");
        for (Nota nota : notas) {
            System.out.println(nota.getNota());
        }
    }
    //setters
    public void setHoraPrevista(Instant horaPrevista) {
        this.horaPrevista = horaPrevista;
    }

    public void setHoraInicio(Instant horaInicio) {
        this.horaInicio = horaInicio;
    }

    public void setHoraFin(Instant horaFin) {
        this.horaFin = horaFin;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setDuracionPrevista(Duration duracionPrevista) {
        this.duracionPrevista = duracionPrevista;
    }

    public void setAsistencias(List<Asistencia> asistencias) {
        this.asistencias = asistencias;
    }

    public void setInvitaciones(List<Invitacion> invitaciones) {
        this.invitaciones = invitaciones;
    }

    public void setNotas(List<Nota> notas) {
        this.notas = notas;
    }

    public void setOrganizador(Empleado organizador) {
        this.organizador = organizador;
    }

    public void setTipoReunion(TipoReunion tipoReunion) {
        this.tipoReunion = tipoReunion;
    }

    public void setParticipantes(List<Invitable> participantes) {
        this.participantes = participantes;
    }
    public String toString(){
        return "Reunion{" + "fecha=" + fecha + ", horaPrevista=" + horaPrevista +
                ", duracionPrevista=" + duracionPrevista + ", horaInicio=" + horaInicio + ", horaFin=" + horaFin +
                ", asistencias=" + asistencias + ", invitaciones=" + invitaciones + ", notas=" + notas +
                ", organizador=" + organizador + ", tipoReunion=" + tipoReunion + ", participantes=" + participantes + '}';

    }
}