package ClasesGestores;


import ClasesBD.DeportesDB;

import ClasesLogicas.Deporte;

import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.Vector;


public class DeporteGestor {
    public DeporteGestor() {
        super();
    }

    /**
     * @return
     */
    public static Vector <Deporte> instanciarDeportes(){
        
            
        int id;
        String nombre;
        ResultSet resultado;
        resultado = DeportesDB.buscarDeporte();
        Vector <Deporte> listaDeportes=new Vector <Deporte>();
        
        Deporte unDeporte;



        try {
            while (resultado.next()){
                id = resultado.getInt("id_deporte");
                nombre = resultado.getString("nombre");
                unDeporte = new Deporte(id,nombre);
                                       
                listaDeportes.add(unDeporte);

        
            }
        
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            //TODO exepcion de SQL
        }
        return listaDeportes;
        }
    public static Deporte buscarDeporte(int idDeporte){
        
            
        int id;
        String nombre;
        ResultSet resultado;
        resultado = DeportesDB.buscarDeporte(idDeporte);
  
        
        Deporte unDeporte=null;



        try {
            while (resultado.next()){
                id = resultado.getInt("id_deporte");
                nombre = resultado.getString("nombre");
                unDeporte = new Deporte(id,nombre);
                                       
                

        
            }
        
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            //TODO exepcion de SQL
        }
        return unDeporte;
        }
}
