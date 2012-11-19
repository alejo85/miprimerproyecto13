package ClasesGestores;


import ClasesLogicas.Encuentro;
import ClasesLogicas.LugarDeRealizacion;
import ClasesLogicas.Ronda;
import ClasesLogicas.Subronda;

public class RondaGestor {
  
    public RondaGestor() {
        super();
    }
    
   //TODO se borro public Ronda [] generarRonda(Competencia unaCompetencia)
        
        

    public static Ronda crearRonda(LugarDeRealizacion[] lugares,int cantidadDeEncuentros){
        
        
        Ronda laRonda = new Ronda();
        
        laRonda.setGanadores(RondaGestor.generarSubRondaLiga(lugares,cantidadDeEncuentros));
       
       return laRonda;     
    }

    
    public void actualizarRonda(){}
    
    
    
    public void estadoRonda(){}


  
    /**
     * @param rondaAA = ronda A Actualizar
     */
    public void actualizarEstado(Ronda[] rondaAA){
       
        int i;
        int tamanio= rondaAA.length;
            
        for (i=0;i<tamanio;i++){
            
        ///    rondaAA[i];
        }
        
          
    }
    
    public static Subronda generarSubRondaLiga(LugarDeRealizacion[] lugares,int cantidadDeEncuentros){
        
        Subronda subronda = new Subronda();
        
        LugarDeRealizacion[] lugaresAux = lugares;
        int random;
        int repeticiones = cantidadDeEncuentros;
        Encuentro encuentros[] = new Encuentro[cantidadDeEncuentros];
                
        //todo corregir el diagrama de secuencias!!! 17.1
            
        while (repeticiones>0){
            
            random = (int)Math.random()*lugaresAux.length;
            if (lugaresAux[random].getDisponibilidad()>0){
            
                for(int i=0; i < cantidadDeEncuentros; i++){
                    
                   encuentros[i] = EncuentroGestor.crearEncuentro(lugaresAux[random]); 
                }
                
                repeticiones--;
        
            }
        }
        
        subronda.setEncuentros(encuentros);
       
        return subronda; 
        
        
        
    }
}
