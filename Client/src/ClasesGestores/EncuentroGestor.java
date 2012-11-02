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
        Encuentro retorno = new Encuentro();
        //TODO
        /*
         * llamar a la base de datos
         * */
        retorno.setParticipanteA(participanteA);
        retorno.setParticipanteB(participanteB);
        retorno.setLocación(lugar);
        return retorno;}

    /**
     * @param participante
     * @return
     */
    //no se de donde salio
    public Encuentro actualizaParticipante(Participante participante){
        
        
        return new Encuentro();
        
        
        
        }

    /**
     * @param resultados
     */
    public void guardarResultado(Encuentro unEncuentro, Resultados resultados){
        unEncuentro.setResultado(resultados);    
        
        
        }


    /**
     * @param lugares se pasa por copia
     * @return
     */
    public Encuentro[] crearEncuantro(LugarDeRealización lugares[], int cantidaDeEncuentros)
    {
         Encuentro [] encuentros;
        for (int i=0; i < cantidaDeEncuentros; i++)
        {
            Encuentro temp=new Encuentro();
            LugarDeRealización lugar = LugaresDeRealizacionGestores.unLugar(lugares);
            temp.setLocación(lugar);
            encuentros[i]=temp;
            
            
        }
     return encuentros;
        
     }

    /**
     * @param puntos
     */
    public void guardarResultado(Encuentro unEncuentro, Puntos puntos[]){
        
            
            
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

