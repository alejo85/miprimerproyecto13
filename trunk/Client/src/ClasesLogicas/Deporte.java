package ClasesLogicas;

public class Deporte {
    Integer idDeporte;
    String nombre;

    public Deporte(Integer idDeporte, String nombre) {
        super();
        this.idDeporte = idDeporte;
        this.nombre = nombre;
    }

    public Deporte() {
        super();
    }

  

    public Integer getIdDeporte() {
        return idDeporte;
    }

    public String getNombre() {
        return nombre;
    }

}
