package ClasesLogicas;

public class Subronda {
    private Encuentro [] encuentros;
    private int idSubronda;
    private boolean estado;
    
    public Subronda() {
        super();
    }

    public Subronda(Encuentro[] encuentros, int idSubronda) {
        super();
        this.encuentros = encuentros;
        this.idSubronda = idSubronda;
    }

    public Subronda(Encuentro[] encuentros) {
        super();
        this.encuentros = encuentros;
    }

    public void setEncuentros(Encuentro[] encuentros) {
        this.encuentros = encuentros;
    }

    public Encuentro[] getEncuentros() {
        return encuentros;
    }

    public void setIdSubronda(int idSubronda) {
        this.idSubronda = idSubronda;
    }

    public int getIdSubronda() {
        return idSubronda;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public boolean getEstado() {
        return estado;
    }
}
