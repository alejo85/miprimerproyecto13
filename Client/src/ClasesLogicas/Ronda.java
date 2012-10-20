package ClasesLogicas;

import java.util.Vector;

public class Ronda {
    private int idRonda;
    private int numeroDeRonda;
    private Vector<Encuentro> encuentros;
    
    public Ronda() {
        super();
    }

    public Ronda(int idRonda, int numeroDeRonda, Vector<Encuentro> encuentros) {
        super();
        this.idRonda = idRonda;
        this.numeroDeRonda = numeroDeRonda;
        this.encuentros = encuentros;
    }

    /*public void setIdRonda(int idRonda) {
        this.idRonda = idRonda;
    }

    public int getIdRonda() {
        return idRonda;
    }

    public void setNumeroDeRonda(int numeroDeRonda) {
        this.numeroDeRonda = numeroDeRonda;
    }

    public int getNumeroDeRonda() {
        return numeroDeRonda;
    }

    public void setEncuentros(Vector<Encuentro> encuentros) {
        this.encuentros = encuentros;
    }

    public Vector<Encuentro> getEncuentros() {
        return encuentros;
    }*/
}
