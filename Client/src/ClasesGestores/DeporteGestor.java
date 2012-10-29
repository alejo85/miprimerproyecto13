package ClasesGestores;


import ClasesLogicas.Deporte;
import java.sql.ResultSet;
import java.util.Vector;
import ClasesBD.DeportesDB;
import java.sql.SQLException;

public class DeporteGestor {
    public DeporteGestor() {
        super();
    }

    /**
     * @return
     */
    public Vector <Deporte> instanciarDeportes(){
        
            
        int id;
        String nombre;
        ResultSet resultado;
        resultado = DeportesDB.buscarDeporte();
        Vector<Deporte> listaDeportes = new Vector<Deporte>();


        try {
            while (resultado.next()){

                id = resultado.getInt("id_deporte");
                nombre = resultado.getString("nombre");
                listaDeportes.add(new Deporte(id,nombre));
            }
        
        } catch (SQLException e) {
        }
               
        return listaDeportes;
        }
}
