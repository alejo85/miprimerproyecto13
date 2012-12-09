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

    public void setIdPunto(int idPunto) {
        this.idPunto = idPunto;
    }

    public int getIdPunto() {
        return idPunto;
    }

    public void setPuntoA(int puntoA) {
        this.puntoA = puntoA;
    }

    public int getPuntoA() {
        return puntoA;
    }

    public void setPuntoB(int puntoB) {
        this.puntoB = puntoB;
    }

    public int getPuntoB() {
        return puntoB;
    }


}