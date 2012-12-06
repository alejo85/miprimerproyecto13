package ClasesLogicas;

public class Resultados {
    private int idResultado;
    private int numeroDeRonda;
    private int asistencia;
    private Puntos[] puntuacion;
    
    public Resultados(){
        super();
    
    }
    
    public Resultados(int idResultado, int numeroDeRonda, int asistencia, Puntos[] puntuacion) {
        super();
        this.idResultado = idResultado;
        this.numeroDeRonda = numeroDeRonda;
        this.asistencia = asistencia;
        this.puntuacion = puntuacion;
    }

    public Resultados(int numeroDeRonda, int asistencia, Puntos[] puntuacion) {
        super();
        this.numeroDeRonda = numeroDeRonda;
        this.asistencia = asistencia;
        this.puntuacion = puntuacion;
    }
    public Resultados(int numeroDeRonda, int asistencia, Puntos puntuacion) {
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

    public void setAsistencia(int asistencia) {
        this.asistencia = asistencia;
    }

    public int getAsistencia() {
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
