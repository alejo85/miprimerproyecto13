package ClasesBD;

import ClasesLogicas.Liga;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LigaDB {
    public LigaDB() {
        super();
    }
    public boolean registrarliga(Liga liga){
                       return true;}
    public static ResultSet buscarLiga(int idCompetencia) throws SQLException {
            //Conexion conexion = new Conexion();

            // conexion.conectar();
            String consultasql="";
            
                consultasql="SELECT * FROM liga where id_competencia = '"+idCompetencia+"';";
                System.out.println(consultasql);
                return Conexion.consulta.executeQuery(consultasql);
                
             
        
        }
}
