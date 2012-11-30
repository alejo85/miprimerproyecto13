package ClasesGestores;


import ClasesBD.EncuentroDB;

import ClasesLogicas.Encuentro;
import ClasesLogicas.LugarDeRealizacion;
import ClasesLogicas.Participante;
import ClasesLogicas.ParticipanteAnterior;
import ClasesLogicas.Puntos;
import ClasesLogicas.Resultados;

import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.Vector;


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
     * @param idSubRonda
     * @param participantes
     * @return
     */
    public static Encuentro[] encuentrosDeSubRonda(int idSubRonda)
    {
        
        //System.out.println("encuentrosDeSubRonda");
            Encuentro retorno=null;
                Vector <Encuentro> datos=new Vector <Encuentro>();
                Encuentro [] encuentros=null;
            ResultSet resultado;

            try {
                resultado = EncuentroDB.buscarEncuentros(idSubRonda);
                ParticipanteAnterior aux = null;

               
                    while(resultado.next()){
                        int id = resultado.getInt("id_encuentro");
                        int idParticipanteA= resultado.getInt("id_participantea");
                        int idParticipanteB= resultado.getInt("id_participanteb");
                        int idParticipanteGanador= resultado.getInt("id_participante_ganador");
                        int idParticipantePerdedor= resultado.getInt("id_participante_perdedor");
                        int idResultado= resultado.getInt("id_resultado");
                        String fechaResultado = resultado.getString("fecha_resultado");
                        String horaResultado = resultado.getString("hora_resultado");
                       // int disponibilidad = resultado.getInt("disponibilidad");
                       
                        
                      retorno = new Encuentro();
                        retorno.setIdEncuentro(id);//Participante Libre en la ronda
                        retorno.setParticipanteA(ParticipanteGestor.instanciarUnParticipante(idParticipanteA));
                        
                        retorno.setParticipanteB(ParticipanteGestor.instanciarUnParticipante(idParticipanteB));
                        retorno.setGanador(ParticipanteGestor.instanciarUnParticipante(idParticipanteGanador));
                        retorno.setPerdedor(ParticipanteGestor.instanciarUnParticipante(idParticipantePerdedor));
                        //TODO RecuperarResultado
                      //System.out.println("id_encuentro: "+retorno.getIdEncuentro()+"Participante A: "+retorno.getParticipanteA().getNombre()+"Participante B: "+retorno.getParticipanteB().getNombre());
                        datos.add(retorno);
                 
                    }
                    encuentros= new Encuentro[datos.size()];
                    for(int j=0;j<datos.size();j++){
                            encuentros[j]=datos.get(j);
                            System.out.println("id_encuentro: "+encuentros[j].getIdEncuentro()+"Participante A: "+encuentros[j].getParticipanteA().getNombre()+"Participante B: "+encuentros[j].getParticipanteB().getNombre());
                        }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
            
            
            return encuentros; 
        
        
        
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
    public static void eliminarEncuentros(Encuentro[] encuentrosAEliminar){
        for(int i=0;i<encuentrosAEliminar.length;i++)
        {
            try {
                EncuentroDB.eliminarEncuentros(encuentrosAEliminar[i].getIdEncuentro());
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
        
        }

 
}

