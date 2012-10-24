package ClasesGestores;

import ClasesLogicas.Encuentro;
import ClasesLogicas.LugarDeRealización;
import ClasesLogicas.Participante;
import ClasesLogicas.Puntos;
import ClasesLogicas.Resultados;

public class EncuentroGestor {
    private Encuentro [] encuentros;
    public EncuentroGestor() {
        super();
    }

    /**
     * @param participanteA
     * @param participanteB
     * @param lugar
     * @return
     */
    public Encuentro nuevoEncuentro(Participante participanteA, Participante participanteB, LugarDeRealización lugar){
        return new Encuentro();}

    /**
     * @param participante
     * @return
     */
    public Encuentro actualizaParticipante(Participante participante){return new Encuentro();}

    /**
     * @param resultados
     */
    public void guardarResultado(Resultados resultados){}


    /**
     * @param lugares
     * @return
     */
    public Encuentro[] crearEncuantro(LugarDeRealización lugares[])
    {
     return encuentros;
        
     }

    /**j
     * @param puntos
     */
    public void guardarResultado(Puntos puntos[]){
        }

    /**
     * @param participanteGanador
     */
    public void ganador(Participante participanteGanador){
        }

    /**
     * @param participanteA
     * @param participanteB
     */
    public void ganador(Participante participanteA,Participante participanteB){}

    /**
     * @param participanteA
     * @param participanteB
     * @param puntoA
     * @param puntoB
     */
    public void ganador(Participante participanteA,Participante participanteB,int  puntoA,int  puntoB){
        }
}

