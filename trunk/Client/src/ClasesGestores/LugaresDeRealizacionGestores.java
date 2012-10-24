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
    public Vector <LugarDeRealizaci�n> lugaresDeRealizaci�nAsociadosAlDeporte(int codigoDeporte){
        return new Vector<LugarDeRealizaci�n>();
        }
    
    
}
