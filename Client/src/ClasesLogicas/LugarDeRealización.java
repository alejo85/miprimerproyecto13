package ClasesLogicas;

public class LugarDeRealización {
    private String codigo, Nombre, descripcion;
    private int disponibilidad;
    private Deporte[] deportesAsociados;

    public LugarDeRealización(String codigo, String Nombre, String descripcion, int disponibilidad,
                              Deporte[] deportesAsociados) {
        super();
        this.codigo = codigo;
        this.Nombre = Nombre;
        this.descripcion = descripcion;
        this.disponibilidad = disponibilidad;
        this.deportesAsociados = deportesAsociados;
    }
/*
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDisponibilidad(Integer disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public Integer getDisponibilidad() {
        return disponibilidad;
    }

    public void setDeportesAsociados(Deporte[] deportesAsociados) {
        this.deportesAsociados = deportesAsociados;
    }

    public Deporte[] getDeportesAsociados() {
        return deportesAsociados;
    }*/


}
