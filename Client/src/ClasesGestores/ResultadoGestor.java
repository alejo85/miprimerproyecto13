package ClasesGestores;


import ClasesLogicas.Puntos;
import ClasesLogicas.Resultados;

import java.util.Vector;

public class ResultadoGestor {
    public ResultadoGestor() {
        super();
    }

    /**
     * @param unPunto
     * @return
     */
    public Resultados altaResultado(Puntos unPunto){return new Resultados();}

    /**
     * @param puntos
     * @return
     */
    public Resultados altaResultado(Vector <Puntos> puntos){return new Resultados();}

    /**
     * @param puntos
     * @return
     */
    public Resultados crearResultado(Puntos puntos[]){
        return new Resultados();
        }

    /**
     * @param puntoA
     * @param puntoB
     * @return
     */
    public Puntos crearPunto(int puntoA, int puntoB){
        return new Puntos();
        }
}
