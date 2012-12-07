package ClasesLogicas;

public class Puntos {
    private int idPunto;
    private int puntoA;
    private int puntoB;

    public Puntos(int idPunto, int puntoA, int puntoB) {
        super();
        this.idPunto = idPunto;
        this.puntoA = puntoA;
        this.puntoB = puntoB;
    }
    
    public Puntos() {
        super();

    }

    public Puntos(int puntoA, int puntoB) {
        super();
        this.puntoA = puntoA;
        this.puntoB = puntoB;
    }

    public void setIdPunto(Integer idPunto) {
        this.idPunto = idPunto;
    }

    public Integer getIdPunto() {
        return idPunto;
    }

    public void setPuntoA(Integer puntoA) {
        this.puntoA = puntoA;
    }

    public Integer getPuntoA() {
        return puntoA;
    }

    public void setPuntoB(Integer puntoB) {
        this.puntoB = puntoB;
    }

    public Integer getPuntoB() {
        return puntoB;
    }


}