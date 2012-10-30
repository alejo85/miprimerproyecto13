package ClasesGestores;


import ClasesLogicas.Puntos;
import ClasesLogicas.Resultados;

import java.util.Vector;

public class ResultadoGestor {
    public ResultadoGestor() {
        super();
    }

    /**
     * @param unPunto
     * @return
     */
    public Resultados altaResultado(Puntos unPunto){
    
    
        return new Resultados();
        
          
    }

    /**
     * @param puntos
     * @return
     */
    public Resultados altaResultado(Puntos[] puntos, int nroRonda){
        
        
        return new Resultados(nroRonda,true, puntos);
                
    }

    /**
     * @param puntos
     * @return
     */
    public Resultados crearResultado(Puntos[] puntos){
        
        
        return new Resultados();
          
   }

    /**
     * @param puntoA
     * @param puntoB
     * @return
     */
    public Resultados crearPunto(int puntoA, int puntoB, int nroRonda){
        
         return new Resultados(nroRonda,true, new Puntos(puntoA, puntoB));
        }


    public Puntos[] crearPuntosSets (int cantidadPuntos){
        
        
        Puntos[] retorno=null;
        
        for(int i=0; i<cantidadPuntos; i++)            
            retorno[i] = new Puntos();
             
        return retorno;
    }




}



    
