package ClasesBD;

import ClasesLogicas.Competencia;
import ClasesLogicas.Liga;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LigaDB {
    public LigaDB() {
        super();
    }
    // CREAR LIGA EN BD
    public static void registrarliga(Liga nuevaLiga,int id_competencia) throws SQLException {
        ResultSet resultado=null;
        Statement consulta = Conexion.consultar();
        String consultasql;
        int id;
        
        consultasql="INSERT INTO liga(ptos_por_empate, ptos_partidos_g, empate, ptos_por_asistir, id_competencia)VALUES('"+nuevaLiga.getPuntosPorPartidoEmpatado()+"', '"+nuevaLiga.getPuntosPorPartidoGanado()+"', '"+nuevaLiga.getEmpate()+"', '"+nuevaLiga.getPuntosPorPartidoAsistido()+"', '"+id_competencia+"')RETURNING *;";
        resultado = consulta.executeQuery(consultasql);
        resultado.next();
        id = resultado.getInt("id_liga");
        nuevaLiga.setIdLiga(id);
        
    }
    public static ResultSet buscarLiga(int idCompetencia) throws SQLException {
            //Conexion conexion = new Conexion();

            // conexion.conectar();
            String consultasql="";
            
                consultasql="SELECT * FROM liga where id_competencia = '"+idCompetencia+"';";
                
                return Conexion.consulta.executeQuery(consultasql);
                
             
        
        }
}
