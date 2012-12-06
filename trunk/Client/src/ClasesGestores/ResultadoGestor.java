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
        String dato=null;
        for(int i=0; i<cantidadPuntos; i++){            
            nuevo = new Puntos();
                dato=tablaDeSetsJTable.getValueAt(i, 1).toString();
                System.out.println("valor de la celda: "+dato);
            if(!tablaDeSetsJTable.getValueAt(i, 1).toString().equals(" "))
            {
                System.out.println("Puntos de A: "+tablaDeSetsJTable.getValueAt(i, 1).toString());
                nuevo.setPuntoA( Integer.parseInt(tablaDeSetsJTable.getValueAt(i, 1).toString()));
                nuevo.setPuntoB(Integer.parseInt(tablaDeSetsJTable.getValueAt(i, 2).toString()));
                retorno[i]=nuevo;
                }
            else
                i=cantidadPuntos;
            
            }
        return retorno;
    }
    public static  Resultados crearResultado(int cantidadPuntos, JTable tablaDeSetsJTable, int asistencia){
        Resultados unResultado=crearResultado(crearPuntosSets(cantidadPuntos, tablaDeSetsJTable), asistencia);
       
        return unResultado;
    }



}



    
