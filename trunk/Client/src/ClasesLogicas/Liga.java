package ClasesLogicas;

public class Liga {
    private int idLiga;
    private int puntosPorPartidoGanado;
    private boolean empate;
    private int puntosPorPartidoEmpatado;
    private int puntosPorPartidoAsistido;
   
    public Liga() {
        super();
    }

    public Liga(int idLiga, int puntosPorPartidoGanado, boolean empate, int puntosPorPartidoEmpatado,
                int puntosPorPartidoAsistido) {
        super();
        this.idLiga = idLiga;
        this.puntosPorPartidoGanado = puntosPorPartidoGanado;
        this.empate = empate;
        this.puntosPorPartidoEmpatado = puntosPorPartidoEmpatado;
        this.puntosPorPartidoAsistido = puntosPorPartidoAsistido;
    }

    public void setIdLiga(int idLiga) {
        this.idLiga = idLiga;
    }

    public int getIdLiga() {
        return idLiga;
    }

    public void setPuntosPorPartidoGanado(int puntosPorPartidoGanado) {
        this.puntosPorPartidoGanado = puntosPorPartidoGanado;
    }

    public int getPuntosPorPartidoGanado() {
        return puntosPorPartidoGanado;
    }

    public void setEmpate(boolean empate) {
        this.empate = empate;
    }

    public boolean getEmpate() {
        return empate;
    }

    public void setPuntosPorPartidoEmpatado(int puntosPorPartidoEmpatado) {
        this.puntosPorPartidoEmpatado = puntosPorPartidoEmpatado;
    }

    public int getPuntosPorPartidoEmpatado() {
        return puntosPorPartidoEmpatado;
    }

    public void setPuntosPorPartidoAsistido(int puntosPorPartidoAsistido) {
        this.puntosPorPartidoAsistido = puntosPorPartidoAsistido;
    }

    public int getPuntosPorPartidoAsistido() {
        return puntosPorPartidoAsistido;
    }


}
