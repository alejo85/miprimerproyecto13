package ClasesGestores;

import ClasesLogicas.Liga;

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
    public Liga crearLiga(int idLiga, int puntosPorPartidoGanado, boolean empate, int puntosPorPartidoEmpatado, int puntosPorPartidoAsistido)
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
}
