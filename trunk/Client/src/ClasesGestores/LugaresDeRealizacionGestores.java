package ClasesGestores;


import ClasesLogicas.Deporte;
import ClasesLogicas.LugarDeRealizaci�n;

import java.util.Vector;

public class LugaresDeRealizacionGestores {
    public LugaresDeRealizacionGestores() {
        super();
    }
    public LugarDeRealizaci�n altaLugaresDeRealizacion(String codigo, String Nombre, String descripcion, int disponibilidad,
                              Deporte[] deportesAsociados){
        return new LugarDeRealizaci�n( codigo,  Nombre,  descripcion,  disponibilidad, deportesAsociados);}
    public void bajaLugarDeRealizacion(String codigo){}
    public void disminuirDisponibilidad(String codigo){}
    public void asociarDeporte(String codigo){}
    public void eliminarDeporte(String codigo){}
    public Vector <LugarDeRealizaci�n> lugaresDeRealizaci�nAsociadosAlDeporte(int codigoDeporte){
        return new Vector<LugarDeRealizaci�n>();
        }
    
    
}
