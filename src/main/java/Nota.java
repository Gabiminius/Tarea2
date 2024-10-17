public class Nota {
    private String contenido;

    public Nota(String contenido){
        this.contenido=contenido;

    }
    public String getNota(){
        return contenido;
    }
    public void setNota(String contenido){
        this.contenido=contenido;
    }
    public String toString(){
        return "Nota{'" + contenido + '\'' + '}';

    }
}
