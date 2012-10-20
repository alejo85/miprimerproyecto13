package ClasesGestores;

import ClasesLogicas.Puntos;

import ClasesLogicas.Resultados;

import java.util.Vector;

public class ResultadoGestor {
    public ResultadoGestor() {
        super();
    }
    public Resultados altaResultado(Puntos unPunto){return new Resultados();}
    public Resultados altaResultado(Vector <Puntos> puntos){return new Resultados();}
    
}
