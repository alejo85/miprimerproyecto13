package ClasesGestores;


import ClasesLogicas.Competencia;
import ClasesLogicas.LugarDeRealización;
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
    public Subronda generarSubRonda(LugarDeRealización lugares[]){
        return new Subronda();
        }


    public void actualizarEstado(){
        }
}
