package ClasesLogicas;

public class Localidad {
    private int codigo;
    private Regiones provincia;
    private String nombre;
    public Localidad() {
        super();
    }

    public Localidad(int codigo, int codigoRegion, int codigoPais, String nombre) {
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

    public void setProvincia(Regiones provincia) {
        this.provincia = provincia;
    }

    public Regiones getProvincia() {
        return provincia;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }
}
