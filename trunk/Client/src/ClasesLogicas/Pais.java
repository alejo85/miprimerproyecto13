package ClasesLogicas;

public class Pais {
    private int codigo;
    private String nombre;
    public Pais() {
        super();
    }

    public Pais(int codigo, String nombre) {
        super();
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }


}
