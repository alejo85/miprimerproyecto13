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
        Deporte listaDeportes []= new Deporte[36];
        
        Deporte unDeporte;
        int i=0;


        try {
            while (resultado.next()){
                id = resultado.getInt("id_deporte");
                nombre = resultado.getString("nombre");
                unDeporte = new Deporte(id,nombre);
                                       
                listaDeportes[i] = unDeporte;

                i++;
            }
        
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            //TODO exepcion de SQL
        }
               
        return listaDeportes;
        }
}
