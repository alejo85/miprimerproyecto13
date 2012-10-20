package ClasesGestores;


import ClasesLogicas.Deporte;
import ClasesLogicas.LugarDeRealización;

import java.util.Vector;

public class LugaresDeRealizacionGestores {
    public LugaresDeRealizacionGestores() {
        super();
    }
    public LugarDeRealización altaLugaresDeRealizacion(String codigo, String Nombre, String descripcion, int disponibilidad,
                              Deporte[] deportesAsociados){
        return new LugarDeRealización( codigo,  Nombre,  descripcion,  disponibilidad, deportesAsociados);}
    public void bajaLugarDeRealizacion(String codigo){}
    public void disminuirDisponibilidad(String codigo){}
    public void asociarDeporte(String codigo){}
    public void eliminarDeporte(String codigo){}
    public Vector <LugarDeRealización> lugaresDeRealizaciónAsociadosAlDeporte(int codigoDeporte){
        return new Vector<LugarDeRealización>();
        }
    
    
}
