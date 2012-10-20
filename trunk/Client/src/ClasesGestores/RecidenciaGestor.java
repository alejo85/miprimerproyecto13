package ClasesGestores;


import ClasesLogicas.Localidad;
import ClasesLogicas.Pais;
import ClasesLogicas.Regiones;

import java.util.Vector;

public class RecidenciaGestor {
    public RecidenciaGestor() {
        super();
    }
    public Vector<Pais> obtenerPaises(){
        return new Vector <Pais>();
        }
    public Vector<Regiones> obtenerRegiones(int codigoPais){
        return new Vector <Regiones> ();
        }
    public Vector<Localidad> obtenerLocalidades(int codigoRegion){
        return new Vector <Localidad>();
        }
}
