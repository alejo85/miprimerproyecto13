package ClasesLogicas;

public class Resultados {
    private Integer idResultado;
    private Integer numeroDeRonda;
    private Boolean asistencia;
    private Puntos[] puntuacion;
    
    public Resultados(){
        super();
    
    }
    
    public Resultados(Integer idResultado, Integer numeroDeRonda, Boolean asistencia, Puntos[] puntuacion) {
        super();
        this.idResultado = idResultado;
        this.numeroDeRonda = numeroDeRonda;
        this.asistencia = asistencia;
        this.puntuacion = puntuacion;
    }

    public Resultados(Integer numeroDeRonda, Boolean asistencia, Puntos[] puntuacion) {
        super();
        this.numeroDeRonda = numeroDeRonda;
        this.asistencia = asistencia;
        this.puntuacion = puntuacion;
    }
    public Resultados(Integer numeroDeRonda, Boolean asistencia, Puntos puntuacion) {
        super();
        this.numeroDeRonda = numeroDeRonda;
        this.asistencia = asistencia;
        this.puntuacion[0] = puntuacion;
    }
    public void setIdResultado(Integer idResultado) {
        this.idResultado = idResultado;
    }

    public Integer getIdResultado() {
        return idResultado;
    }

    public void setNumeroDeRonda(Integer numeroDeRonda) {
        this.numeroDeRonda = numeroDeRonda;
    }

    public Integer getNumeroDeRonda() {
        return numeroDeRonda;
    }

    public void setAsistencia(Boolean asistencia) {
        this.asistencia = asistencia;
    }

    public Boolean getAsistencia() {
        return asistencia;
    }

    public void setPuntuacion(Puntos[] puntuacion) {
        this.puntuacion = puntuacion;
    }

    public Puntos[] getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(Puntos puntos) {
        this.puntuacion[0]=puntos;
    }
}
