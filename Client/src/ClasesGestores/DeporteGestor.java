package ClasesGestores;


import ClasesBD.DeportesDB;

import ClasesLogicas.Deporte;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DeporteGestor {
    public DeporteGestor() {
        super();
    }

    /**
     * @return
     */
    public static Deporte[] instanciarDeportes(){
        
            
        int id;
        String nombre;
        ResultSet resultado;
        resultado = DeportesDB.buscarDeporte();
        Deporte[] listaDeportes=null;
        int i=0;


        try {
            while (resultado.next()){

                id = resultado.getInt("id_deporte");
                nombre = resultado.getString("nombre");
                listaDeportes[i] = new Deporte(id,nombre);
            }
        
        } catch (SQLException e) {
            //TODO exepcion de SQL
        }
               
        return listaDeportes;
        }
}
