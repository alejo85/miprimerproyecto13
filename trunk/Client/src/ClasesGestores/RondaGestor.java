package ClasesGestores;


import ClasesLogicas.Competencia;
import ClasesLogicas.LugarDeRealizaci�n;
import ClasesLogicas.Ronda;
import ClasesLogicas.Subronda;

import java.util.Vector;

public class RondaGestor {
    public RondaGestor() {
        super();
    }
    public Vector <Ronda> generarRonda(Competencia unaCompetencia){return new Vector <Ronda>();}
    public void actualizarRonda(){}
    public void estadoRonda(){}


    /**
     * @param lugares
     * @return
     */
    public Subronda generarSubRonda(LugarDeRealizaci�n lugares[]){
        return new Subronda();
        }


    public void actualizarEstado(){
        }
}
