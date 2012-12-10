package ClasesLogicas;


public class Ronda {
    private int idRonda;
    private int numeroDeRonda;
    private Subronda ganadores;
    private Subronda perdedores;
    
    
    public Ronda() {
        super();
    }




    public Ronda(int idRonda, int numeroDeRonda, Subronda ganadores, Subronda perdedores) {
        super();
        this.idRonda = idRonda;
        this.numeroDeRonda = numeroDeRonda;
        this.ganadores = ganadores;
        this.perdedores = perdedores;
    }


    public void setIdRonda(int idRonda) {
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

    public void setGanadores(Subronda ganadores) {
        this.ganadores = ganadores;
    }
  
 
    public Subronda getGanadores() {
        return ganadores;
    }

    public void setPerdedores(Subronda perdedores) {
        this.perdedores = perdedores;
    }

    public Subronda getPerdedores() {
        return perdedores;
    }
}
