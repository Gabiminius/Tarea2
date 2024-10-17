import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class InformeDeReunion {

    private Reunion reunion;
    private String archivo;

    public InformeDeReunion(Reunion reunion,String archivo) {
        this.reunion = reunion;
        this.archivo=archivo;
    }

    public void generarInforme() {

        try (FileWriter writer = new FileWriter(archivo)) {
            writer.write("Informe de la Reunión\n");
            writer.write("======================\n");
            writer.write("Fecha: " + reunion.getFecha() + "\n");
            writer.write("Hora prevista: " + reunion.getHoraPrevista() + "\n");
            writer.write("Hora de inicio: " + reunion.getHoraInicio() + "\n");
            writer.write("Hora de fin: " + reunion.getHoraFin() + "\n");
            writer.write("Duración total: " + reunion.calcularTiempoReal().toMinutes() + "minutos\n");
            writer.write("Tipo de reunión: " + reunion.getTipoReunion() + "\n");

            if (reunion instanceof ReunionVirtual) {
                writer.write("Enlace de la reunión: " + ((ReunionVirtual) reunion).getEnlace() + "\n");
            } else if (reunion instanceof ReunionPresencial) {
                writer.write("Sala de la reunión: " + ((ReunionPresencial) reunion).getSala() + "\n");
            }

            // Listar los participantes
            writer.write("\nParticipantes:\n");
            for (Invitable participante : reunion.getParticipantes()) {
                if (participante instanceof Empleado) {
                    Empleado empleado = (Empleado) participante;
                    writer.write("- " + empleado.getNombre() + " " + empleado.getApellidos() + "\n");
                } else if (participante instanceof Departamento) {
                    Departamento departamento = (Departamento) participante;
                    writer.write("- Departamento de " + departamento.getNombreDepa() + "\n");
                }
            }

            writer.write("\nNotas de la reunión:\n");
            for (Nota nota : reunion.getNotas()) {
                writer.write("- " + nota.toString() + "\n");
            }

        } catch (IOException e) {
            System.out.println("Error al generar el archivo de informe: " + e.getMessage());
        }
    }
}
