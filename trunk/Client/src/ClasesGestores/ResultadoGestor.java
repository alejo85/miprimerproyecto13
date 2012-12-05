package ClasesGestores;


import ClasesLogicas.Puntos;
import ClasesLogicas.Resultados;

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

    /**
     * @param puntos
     * @return
     */


    /**
     * @param puntos
     * @return
     */
    public static Resultados crearResultado(Puntos[] puntos, int asistencia){
        
       Resultados unResultado=new Resultados();
       unResultado.setAsistencia(asistencia);
       unResultado.setPuntuacion(puntos);
       
        return unResultado;
          
   }

 
  


    public static Puntos[] crearPuntosSets (int cantidadPuntos, JTable tablaDeSetsJTable){
        
        
        Puntos[] retorno=new Puntos[cantidadPuntos];
        Puntos nuevo;
        for(int i=0; i<cantidadPuntos; i++){            
            nuevo = new Puntos();
        nuevo.setPuntoA((Integer) tablaDeSetsJTable.getCellEditor(i, 1).getCellEditorValue());
                nuevo.setPuntoB((Integer) tablaDeSetsJTable.getCellEditor(i, 2).getCellEditorValue());
                retorno[i]=nuevo;
            }
        return retorno;
    }
    public static  Resultados crearResultado(int cantidadPuntos, JTable tablaDeSetsJTable, int asistencia){
        Resultados unResultado=crearResultado(crearPuntosSets(cantidadPuntos, tablaDeSetsJTable), asistencia);
       
        return unResultado;
    }



}



    
