package ClasesLogicas;

public class ResultadosAnteriores {
    
    private Integer idResultado;
    private Integer numeroDeRonda;
    private Boolean asistencia;
    private Puntos[] Puntuacion;
    private Usuario usuario;

    public ResultadosAnteriores(Integer idResultado, Integer numeroDeRonda, Boolean asistencia, Puntos[] Puntuacion, Usuario user) {
        super();
        this.idResultado = idResultado;
        this.numeroDeRonda = numeroDeRonda;
        this.asistencia = asistencia;
        this.Puntuacion = Puntuacion;
        this.usuario = user;
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

    public void setPuntuacion(Puntos[] Puntuacion) {
        this.Puntuacion = Puntuacion;
    }

    public Puntos[] getPuntuacion() {
        return Puntuacion;
    }
    
    
    
    
}
