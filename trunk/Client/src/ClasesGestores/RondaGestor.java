package ClasesGestores;


import ClasesLogicas.Competencia;
import ClasesLogicas.LugarDeRealización;
import ClasesLogicas.Ronda;
import ClasesLogicas.Subronda;

import java.util.Vector;

public class RondaGestor {
  
    public RondaGestor() {
        super();
    }
    
   //TODO se borro public Ronda [] generarRonda(Competencia unaCompetencia)
        
        
    public Ronda crearRonda;
    
    
    public void actualizarRonda(){}
    
    
    
    public void estadoRonda(){}


    /**
     * @param lugares
     * @return
     */
    public Subronda generarSubRonda(LugarDeRealización lugares[]){
        return new Subronda();
        }



    


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
}
