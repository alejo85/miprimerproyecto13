package ClasesLogicas;

public class Regiones {
    private int codigo;
    private Pais pais;
    private String nombre;
    public Regiones() {
        super();
    }

   public Regiones(int codigo, int codigoPais, String nombre) {
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

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    public Pais getPais() {
        return pais;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }
}
