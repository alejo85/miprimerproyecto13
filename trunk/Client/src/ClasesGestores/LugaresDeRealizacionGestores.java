package ClasesGestores;


import ClasesLogicas.Deporte;
import ClasesLogicas.LugarDeRealizaci�n;

import java.util.Vector;

public class LugaresDeRealizacionGestores {
    public LugaresDeRealizacionGestores() {
        super();
    }

    /**
     * @param codigo
     * @param Nombre
     * @param descripcion
     * @param disponibilidad
     * @param deportesAsociados
     * @return
     */
    public LugarDeRealizaci�n altaLugaresDeRealizacion(String codigo, String Nombre, String descripcion, int disponibilidad,
                              Deporte[] deportesAsociados){
        return new LugarDeRealizaci�n( codigo,  Nombre,  descripcion,  disponibilidad, deportesAsociados);}

    /**
     * @param codigo
     */
    public void bajaLugarDeRealizacion(String codigo){}

    /**
     * @param codigo
     */
    public void disminuirDisponibilidad(String codigo){}

    /**
     * @param codigo
     */
    public void asociarDeporte(String codigo){}

    /**
     * @param codigo
     */
    public void eliminarDeporte(String codigo){}

    /**
     * @param codigoDeporte
     * @return
     */
    public static Vector <LugarDeRealizaci�n> lugaresDeRealizaci�nAsociadosAlDeporte(String correoElectronico, int codigoDeporte){
        return new Vector<LugarDeRealizaci�n>();
        }
    public static LugarDeRealizaci�n unLugar(LugarDeRealizaci�n [] lugares){
            int i;
        do{
               i = (int)(Math.random()*(lugares.length));
            
            }
        while(lugares[i].getDisponibilidad()>0);
            lugares[i].menosDisponibilidad();
  
        
        return lugares[i];
        }
    
}
