package ClasesLogicas;

public class Resultados {
    private int idResultado;
    private int numeroDeRonda;
    private Puntos[] puntuacion;
    
    public Resultados(){
        super();
    
    }
    
    public Resultados(int idResultado, int numeroDeRonda, Puntos[] puntuacion) {
        super();
        this.idResultado = idResultado;
        this.numeroDeRonda = numeroDeRonda;
        
        this.puntuacion = puntuacion;
    }

    public Resultados(int numeroDeRonda,  Puntos[] puntuacion) {
        super();
        this.numeroDeRonda = numeroDeRonda;
 
        this.puntuacion = puntuacion;
    }
    public Resultados(int numeroDeRonda, Puntos puntuacion) {
        super();
        this.numeroDeRonda = numeroDeRonda;
    
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
    
    public int getPuntosA(){
        
        int puntosA=0;
        
        for(int i=0; i<this.puntuacion.length;i++)            
            puntosA+= this.puntuacion[i].getPuntoA();
            
        return puntosA;
        
    }
 
    public int getPuntosB(){
        
        int puntosB=0;
        
        for(int i=0; i<this.puntuacion.length;i++)            
            puntosB+= this.puntuacion[i].getPuntoB();
            
        return puntosB;
        
    }


    public void setPuntuacion(Puntos[] puntuacion) {
        this.puntuacion = puntuacion;
    }

    public Puntos[] getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(Puntos puntos) {
        this.puntuacion=new Puntos[1];
        this.puntuacion[0]=puntos;
    }
}
