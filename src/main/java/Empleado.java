

public class Empleado implements Invitable{
    private String id;
    private String apellidos;
    private String nombre;
    private String correo;
    private String departamento;
    /**
     * Constructor de la clase Empleado.
     * @param id Identificador del empleado.
     * @param nombre Nombre del empleado.
     * @param apellidos Apellidos del empleado.
     * @param correo Correo del empleado.
     */
    public Empleado(String id,String nombre,String apellidos,String correo){
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.correo = correo;

    }
    //getters
    /**
     * Método que retorna el identificador del empleado.
     * @return Identificador del empleado.
     */
    public String getId() {
        return id;
    }
    /**
     * Método que retorna el nombre del empleado.
     * @return Nombre del empleado.
     */
    public String getNombre() {
        return nombre;
    }
    /**
     * Método que retorna los apellidos del empleado.
     * @return Apellidos del empleado.
     */
    public String getApellidos() {
        return apellidos;
    }
    /**
     * Método que retorna el correo del empleado.
     * @return Correo del empleado.
     */
    //setters

    public String getCorreo() {
        return correo;
    }
    public String getDepartamento() {
        return departamento;
    }

    public void setId(String id) {
        this.id = id;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setApellidos(String apellido) {
        this.apellidos = apellidos;
    }
    public void setCorreo(String correo) {
        this.correo=correo;
    }
    public void setDepartamento(String departamento) {
        this.departamento=departamento;
    }



    @Override
    public void invitar(Reunion reunion) {
        String mensaje = "Estimado " + nombre + " " + apellidos + ", está invitado a una reunión ";

        if (reunion instanceof ReunionVirtual) {
            mensaje = mensaje + "virtual en el siguiente enlace: " + ((ReunionVirtual) reunion).getEnlace();
        } else if (reunion instanceof ReunionPresencial) {
            mensaje = mensaje + "presencial en la sala: " + ((ReunionPresencial) reunion).getSala();
        }
        System.out.println("Invitación enviada a " + nombre + " via email: " + correo + " con detalles: " + mensaje);
    }
    @Override
    public String toString() {
        return "Empleado [id=" + id + ", apellido=" + apellidos + ", nombre=" + nombre + ", correo=" + correo + ", departamento=" + departamento + "]";
    }

}





