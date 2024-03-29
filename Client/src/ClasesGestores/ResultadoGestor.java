package ClasesGestores;


import ClasesLogicas.Puntos;
import ClasesLogicas.Resultados;

import java.util.Stack;
import java.util.Vector;

import javax.swing.JTable;

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


    public static Resultados crearResultado(Puntos[] puntos){
        
       Resultados unResultado=new Resultados();
       
       unResultado.setPuntuacion(puntos);
       
        return unResultado;
          
   }

 
  


    public static Puntos[] crearPuntosSets (int cantidadPuntos, JTable tablaDeSetsJTable){
        
        
        Puntos[] retorno=new Puntos[cantidadPuntos];
        Puntos nuevo;

       
        
        for(int i=0; i<cantidadPuntos; i++){            
            nuevo = new Puntos();
              

            if(!tablaDeSetsJTable.getValueAt(i, 1).toString().equals(" "))
            {

                nuevo.setPuntoA( Integer.parseInt(tablaDeSetsJTable.getValueAt(i, 1).toString()));
                nuevo.setPuntoB(Integer.parseInt(tablaDeSetsJTable.getValueAt(i, 2).toString()));
                retorno[i]=nuevo;
                }
            else
                i=cantidadPuntos;
            
            }
        return retorno;
    }

    public static  Resultados crearResultado(int cantidadPuntos, JTable tablaDeSetsJTable ){
        
        Resultados unResultado=crearResultado(crearPuntosSets(cantidadPuntos, tablaDeSetsJTable ));

       
        return unResultado;
    }
    public static Resultados getResultado(int idResultado){
            
            Resultados unResultado = new Resultados();
            unResultado.setIdResultado(idResultado);
            unResultado.setPuntuacion(PuntoGestor.getPuntos(idResultado));
            
            
            
            return unResultado;
        }


}



    
