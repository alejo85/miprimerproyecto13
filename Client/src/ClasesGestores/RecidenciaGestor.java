package ClasesGestores;


import ClasesLogicas.Localidad;
import ClasesLogicas.Pais;
import ClasesLogicas.Regiones;

import java.util.Vector;

public class RecidenciaGestor {
    public RecidenciaGestor() {
        super();
    }

    /**
     * @return
     */
    public Vector<Pais> obtenerPaises(){
        return new Vector <Pais>();
        }

    /**
     * @param codigoPais
     * @return
     */
    public Vector<Regiones> obtenerRegiones(int codigoPais){
        //TODO
        return new Vector <Regiones> ();
        }

    /**
     * @param codigoRegion
     * @return
     */
    public Vector<Localidad> obtenerLocalidades(int codigoRegion){
        //TODO
        return new Vector <Localidad>();
        }
}
