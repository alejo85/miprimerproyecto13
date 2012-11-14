package ClasesGestores;


import ClasesLogicas.LugarDeRealización;
import ClasesLogicas.Ronda;
import ClasesLogicas.Subronda;

public class RondaGestor {
  
    public RondaGestor() {
        super();
    }
    
   //TODO se borro public Ronda [] generarRonda(Competencia unaCompetencia)
        
        

    public Ronda crearRonda(){
        
        return new Ronda();
        
        }

    
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
