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
            
                consultasql="SELECT id_liga, ptos_por_empate, ptos_partidos_g, empate, ptos_por_asistir,  id_competencia FROM liga whereid_competencia = '"+idCompetencia+"';";
               // System.out.println(consultasql);
                ResultSet resultado = Conexion.consulta.executeQuery(consultasql);
                resultado.next();
                //conexion.cerrarConexion();
            
            return resultado;
        
        }
}
