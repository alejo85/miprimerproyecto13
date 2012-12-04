package ClasesGestores;

import ClasesBD.CompetenciaDB;

import ClasesBD.LigaDB;

import ClasesLogicas.Liga;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LigaGestor {
    public LigaGestor() {
        super();
    }

    /**
     * @param idLiga
     * @param puntosPorPartidoGanado
     * @param empate
     * @param puntosPorPartidoEmpatado
     * @param puntosPorPartidoAsistido
     * @return
     */
    public static Liga crearLiga(int idLiga, int puntosPorPartidoGanado, boolean empate, int puntosPorPartidoEmpatado, int puntosPorPartidoAsistido)
    {
        return new Liga();
    }
    public static Liga crearLiga( int puntosPorPartidoGanado, boolean empate, int puntosPorPartidoEmpatado, int puntosPorPartidoAsistido)
    {
        Liga liga=new Liga();
        liga.setEmpate(empate);
        liga.setPuntosPorPartidoEmpatado(puntosPorPartidoEmpatado);
        liga.setPuntosPorPartidoAsistido(puntosPorPartidoAsistido);
        liga.setPuntosPorPartidoGanado(puntosPorPartidoGanado);
        return liga;
    }
    public static Liga recuperarliga(int idCompetencia){
            
            int idLiga=-1;
            int puntosPorPartidoGanado=-1;
            boolean empate=false;
            int puntosPorPartidoEmpatado=-1, puntosPorPartidoAsistido=-1;

            ResultSet consulta=null;

            try {
                consulta = LigaDB.buscarLiga( idCompetencia);
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }

        try {
            while(consulta.next())
            {
                    idLiga=consulta.getInt("id_liga");
                    puntosPorPartidoGanado=consulta.getInt("ptos_partidos_g");
                    empate=consulta.getBoolean("empate");
                    puntosPorPartidoEmpatado=consulta.getInt("ptos_por_empate");
                    puntosPorPartidoAsistido=consulta.getInt("ptos_por_asistir");;
                }
        } catch (SQLException e) {
        }
        return crearLiga( idLiga,  puntosPorPartidoGanado,  empate,  puntosPorPartidoEmpatado,  puntosPorPartidoAsistido);
        }
}
