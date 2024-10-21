import java.time.*;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

/**
 * @author : Gabriela Escalona
 * @author : Valentina Serón
 * @version : 1.2
 */

public class Main {
    /**
     * Método principal que ejecuta el programa.
     * @param args son los argumentos de la línea de comandos.
     * @throws EmpleadoNullException Excepción para cuando el empleado es null.
     * @throws MensajeNullException Excepción para cuando el mensaje es null.
     * @throws IniciarReunionencursoException Excepción para cuando se intenta iniciar una reunión ya iniciada.
     * @throws FinalizarReunionNoIniciadaException Excepción para cuando se intenta finalizar una reunión que no ha sido iniciada.
     * @throws overflowEnumException Excepción para cuando el tipo de reunión no es válido.
     * @throws EmpleadoNoInvitadoException Excepción para cuando un empleado no invitado quiera entrar a una reunión.
     * @throws ReunionFinalizadaException Excepción para cuando se intenta agregar un empleado a una reunión que ya finalizó.
     * @throws ReuniónNulaException Excepción para cuando la duración de la reunión es null.

     */
    public static void main(String[] args) throws EmpleadoNullException, MensajeNullException, ReunionNulaException, IniciarReunionencursoException, FinalizarReunionNoIniciadaException, ReunionFinalizadaException, overflowEnumException, EmpleadoNoInvitadoException {
        // Crear un objeto Date con año, mes y día
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, 2024);
        calendar.set(Calendar.MONTH, Calendar.OCT);
        calendar.set(Calendar.DAY_OF_MONTH, 20);
        Date fecha = calendar.getTime();
        // Crear un objeto LocalDateTime con hora y minuto
        LocalDateTime hora = LocalDateTime.of(2024, Month.OCT, 20, 11, 30); // Año, Mes, Día, Hora, Minutos
        // Convertir LocalDateTime a Instant
        Instant horaPrevista = hora.atZone(ZoneId.systemDefault()).toInstant();
        Duration duracionPrevista = Duration.ofHours(1).plusMinutes(30);

        // Crear una lista de empleados los cuales serán invitados a la reunión
        List<Empleado> listaInvitados = new ArrayList<>();
        Empleado empleado1 = new Empleado("1", "Valentina", "Seron", "vseron@udec.cl");
        listaInvitados.add(empleado1);
        Empleado empleado2 = new Empleado("2", "Gabriela", "Escalona", "gescalona@udec.cl");
        listaInvitados.add(empleado2);
        Empleado empleado3 = new Empleado("3", "Barbie", "Donoso", "bdonoso@udec.cl");
        listaInvitados.add(empleado3);
        Empleado empleado4 = new Empleado("4", "Antonio", "Marín", "amarin@udec.cl");
        listaInvitados.add(empleado4);
        Empleado empleado5 = new Empleado("5", "Leila", "Flores", "lflores@udec.cl");
        listaInvitados.add(empleado5);
        //Agregando un empleado nulo a la lista de invitados
        Empleado empleadonulo = null;
        listaInvitados.add(empleadonulo);
        //Creando un empleado no invitado a la reunión
        Empleado noInvitado = new Empleado("6", "Ignacio", "Soto", "isoto@udec.cl");
        //Creando un empleado que llegará al finalizar la reunión
        Empleado superAtrasado = new Empleado("7", "John", "Valenzuela", "jvalenzuela@udec.cl");
        listaInvitados.add(superAtrasado);

        //Invitando un empleado null a la reunión.
        try {
            Reunion reunion = new ReunionPresencial(3, fecha, horaPrevista, duracionPrevista, listaInvitados, "Aula-1");
        }catch (OverflowEnumException e){
            System.out.println("Hubo un error, la reunión debe ser entre 0 a 3.");
        }catch (EmpleadoNullException e){
            System.out.println("Oh no! Empleado=Null");
        }
        System.out.println();

        listaInvitados.remove(empleadonulo);
        //Intentando finalizar una reunión que no ha sido iniciada
        Reunion reunion = new ReunionPresencial(1, fecha, horaPrevista, duracionPrevista, listaInvitados, "Sala 1");
        try{
            reunion.finalizar();
        }
        catch (FinalizarReunionNoIniciadaException e){
            System.out.println("No se puede finalizar una reunión que no ha sido iniciada");
        }

        //Calculando tiempo antes de haber finalizado la reunión
        reunion.empleadoEntrando(empleado1);
        reunion.iniciar();
        try{
            reunion.calcularTiempoReal();
        }
        catch (DuracionNullException e){
            System.out.println("Error, la reunion no ha sido finalizada");
        }

        //Iniciando la reunión una segunda vez
        try{
            reunion.iniciar();
        }
        catch (IniciarReunionIniciadaException e){
            System.out.println("No se puede iniciar una reunión que ya empezó");
        }
        try{
            reunion.empleadoEntrando(noInvitado);
        }  catch(EmpleadoNoInvitadoException e){
            System.out.println("Error, el/la empleado no tiene invitación para la reunión");
        } catch(ReunionYaFinalizoException e){
            System.out.println("Oh no! La reunión ya ha terminado");
        }

        //Agregando notas a la reunión
        reunion.nuevaNota("Nota 1");
        reunion.nuevaNota("Nota 2");

        //Empleados atrasados entrando a la reunión
        reunion.empleadoEntrando(empleado2);
        reunion.empleadoEntrando(empleado3);

        //Creamos una reunion simulada de 60 segundos
        try {
            TimeUnit.SECONDS.sleep(60); // Retraso de 60 segundos
        } catch (InterruptedException e) {
            // Manejar la interrupción
        }

        reunion.finalizar();
        //Entrando un empleado a una reunion ya finalizada.
        try{
            reunion.empleadoEntrando(superAtrasado);
        } catch(EmpleadoNoInvitadoException e){
            System.out.println("Error, el empleado no ha sido invitado a esta reunión");
        }
        catch (ReunionYaFinalizoException e){
            System.out.println("Oh no! la reunión ya ha terminado");
        }
        System.out.println();



        //Reunión ya finalizada e imprimimos por terminal todos los métodos que tenga la reunión.

        EscribirInforme informe = new EscribirInforme("InformeReunion");
        informe.generarInforme(reunion);
        System.out.println();

        System.out.println("Organizador de la reunión: " + reunion.getOrganizador());
        System.out.println();

        //Pasar de tiempo en formato Duration a formato LocalTime
        Duration duracion = reunion.calcularTiempoReal();
        long horas = duracion.toHours();
        long minutos = duracion.toMinutesPart();
        long segundos = duracion.toSecondsPart();
        // Creamos un objeto LocalTime con los componentes obtenidos
        LocalTime tiempo = LocalTime.of((int) horas, (int) minutos, (int) segundos);
        System.out.println("Duración de la reunión: " + tiempo.toString());
        System.out.println();

        System.out.println("Empleados que asistieron a la reunión: ");
        for (Object em : reunion.obtenerAsistencias())
            System.out.println(em);
        System.out.println();

        System.out.println("Empleados que llegaron tarde a la reunión: ");
        for (Object em : reunion.obtenerRetrasos())
            System.out.println(em);
        System.out.println();

        System.out.println("Empleados que no asistieron a la reunión: ");
        for (Object em : reunion.obtenerAusencias())
            System.out.println(em);
        System.out.println();

        System.out.println("Cantidad de empleados que asistieron a la reunión: " + reunion.obtenerTotalAsistencia());
        System.out.println();

        System.out.println("Porcentaje de asistencia a la reunión: " + reunion.obtenerPorcentajeAsistencia()+"%");
        System.out.println();

        System.out.println("Notas de la reunión: " + reunion.getNotas());
        System.out.println();
        System.out.println();



    }
}