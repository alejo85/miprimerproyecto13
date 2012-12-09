package ClasesLogicas;

public class Puntuacion {
    private int idPunt;
    private int ptos_por_ausencia_contrincante;
    public Puntuacion() {
        super();
    }
    public void setPtosAusencia(int cantidad) {
        this.ptos_por_ausencia_contrincante = cantidad;
    }
    public void setId(int id) {
        this.idPunt = id;
    }
    public int getPtosAusencia() {
        return ptos_por_ausencia_contrincante;
    }
    public int getId() {
        return idPunt;
    }
}
