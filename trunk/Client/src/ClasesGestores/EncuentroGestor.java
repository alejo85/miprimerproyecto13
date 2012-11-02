package ClasesGestores;

import ClasesLogicas.Encuentro;
import ClasesLogicas.LugarDeRealizaci�n;
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
    public Encuentro nuevoEncuentro(Participante participanteA, Participante participanteB, LugarDeRealizaci�n lugar){
        Encuentro retorno = new Encuentro();
        //TODO
        /*
         * llamar a la base de datos
         * */
        retorno.setParticipanteA(participanteA);
        retorno.setParticipanteB(participanteB);
        retorno.setLocaci�n(lugar);
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
    public Encuentro[] crearEncuantro(LugarDeRealizaci�n lugares[], int cantidaDeEncuentros)
    {
         Encuentro [] encuentros;
        for (int i=0; i < cantidaDeEncuentros; i++)
        {
            Encuentro temp=new Encuentro();
            LugarDeRealizaci�n lugar = LugaresDeRealizacionGestores.unLugar(lugares);
            temp.setLocaci�n(lugar);
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

