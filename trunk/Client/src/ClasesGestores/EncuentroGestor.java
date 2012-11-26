package ClasesGestores;


import ClasesBD.EncuentroDB;

import ClasesLogicas.Encuentro;
import ClasesLogicas.LugarDeRealizacion;
import ClasesLogicas.Participante;
import ClasesLogicas.Puntos;
import ClasesLogicas.Resultados;

import java.sql.SQLException;

public class EncuentroGestor {

    public EncuentroGestor() {
        super();
    }

    /**
     * todo hacer la descripcion correspondiente
     * @param participanteA
     * @param participanteB
     * @param lugar
     * @return
     */
    public Encuentro nuevoEncuentro(Participante participanteA, Participante participanteB, LugarDeRealizacion lugar){
        Encuentro retorno = new Encuentro();
        //TODO llamar a la base de datos
    
        retorno.setParticipanteA(participanteA);
        retorno.setParticipanteB(participanteB);
        retorno.setLocación(lugar);
        return retorno;}

    /**
     * @param participante
     * @return
     */
    //TODO no se de donde salio
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
    public static Encuentro crearEncuentro(LugarDeRealizacion lugar, int idSubRonda)
    {
         Encuentro temp = new Encuentro();
         temp.setLocación(lugar);

        try {
            temp.setIdEncuentro(EncuentroDB.guardarEncuentro(temp, idSubRonda));
        } catch (SQLException e) {
        }
        return temp;
        
     }

    /**
     * @param puntos
     */
    public void guardarResultado(Encuentro unEncuentro, Puntos puntos[], boolean asistencia){
        Resultados unResultado = new Resultados();
        unResultado.setAsistencia(asistencia);
        unResultado.setPuntuacion(puntos);
            unEncuentro.setResultado(unResultado);
            
            
            }

    /**
     * @param participanteGanador
     */
    public void ganador(Encuentro unEncuentro,Participante participanteGanador){
        unEncuentro.setGanador(participanteGanador);
        //TODO verificar si es un ganador
        }

    /**
     * @param participanteA
     * @param participanteB
     */
    public void ganador(Encuentro unEncuentro, Participante participanteA,Participante participanteB){
        unEncuentro.setEmpate(true);
        //TODO si se crean puntos
        }

    /**
     * @param participanteA
     * @param participanteB
     * @param puntoA
     * @param puntoB
     */
    public void ganador(Encuentro unEncuentro, Participante participanteA,Participante participanteB,int  puntoA,int  puntoB){
        Puntos unPunto = new Puntos();
        unPunto.setPuntoA(puntoA);
        unPunto.setPuntoB(puntoB);
        Resultados unResultado = new Resultados();
        unResultado.setPuntuacion(unPunto);
     
        
        if (puntoA==puntoB)
            unEncuentro.setEmpate(true);
        else
            if(puntoA<puntoB)
                 unEncuentro.setGanador(participanteB);
            else
                 unEncuentro.setGanador(participanteA);
       }
}

