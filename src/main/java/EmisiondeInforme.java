import java.io.*;
import java.time.Duration;
/**
 * Implementación de una clase que emitirá un informe del la reunión
 * y lo generará como archivo de extensión .txt
 */
public class EmisiondeInforme {
    private String nombreArchivo;

    /**
     * Uso de un método que crea un archivo de texto para el informe.
     * @param reunion es el parametro que se usará para crear el contenido del informe.
     */
    public void generarInforme(Reunion reunion){
        try{
            BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo + ".txt"));
            writer.write("Informe de la reunión\n");
            writer.newLine();
            writer.write("Fecha y hora de la reunión: "  + reunion.getHoraPrevista());
            writer.newLine();
            writer.write("Inicio de la reunión: "+reunion.getHoraInicio() + " Fin de la reunión: " + reunion.getHoraFin());
            writer.newLine();
            writer.write("Duración de la reunión: " + reunion.calcularTiempoReal());
            writer.newLine();
            writer.write("El tipo de reunión fue: " + reunion.getTipoReunion());
            writer.newLine();
            writer.write(reunion.getSalaEnlace()+"\n");
            writer.newLine();
            writer.write("Lista de Participantes: ");
            writer.newLine();
            for (Object empleado : reunion.obtenerAsistencias()){
                writer.write(">> ");
                writer.write(empleado.toString());
                writer.newLine();
            }
            writer.write("Lista de empleados que llegaron atrasados: ");
            writer.newLine();
            for(Retraso retraso : reunion.getEmpleadosHoraRetraso()){
                writer.write(">> ");
                writer.write(retraso.getEmpleado().toString());
                writer.write(" con un retraso de ");
                Duration duracion = retraso.getTiempoAtraso();
                writer.write(String.format("%02d:%02d:%02d", duracion.toHoursPart(), duracion.toMinutesPart(), duracion.toSecondsPart()));
                writer.newLine();
            }
            writer.write("\n");
            writer.write("Notas relacionadas a la reunión: ");
            writer.newLine();
            writer.write(reunion.getNotas());
            writer.close();
            System.out.println("Se ha creado el informe .txt correctamente.");
        }
        catch (IOException e){
            e.printStackTrace();
        } catch (DuracionNullException e) {
            throw new RuntimeException(e);
        }
    }
    /**
     * Constructor de la clase EmitirInforme.
     * @param nombreArchivo Nombre del archivo en el que se guardará el informe.
     */
    public EscribirInforme(String nombreArchivo){
        this.nombreArchivo = nombreArchivo;
    }
}