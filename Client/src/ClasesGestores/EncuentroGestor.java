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

import javax.swing.JTable;


public class EncuentroGestor {

    public EncuentroGestor() {
        super();
    }

    /**
     * @param participanteA
     * @param participanteB
     * @param lugar
     * @return
     */
    public Encuentro nuevoEncuentro(Participante participanteA, Participante participanteB, LugarDeRealizacion lugar){
        Encuentro retorno = new Encuentro();
     
    
        retorno.setParticipanteA(participanteA);
        retorno.setParticipanteB(participanteB);
        retorno.setLocación(lugar);
        return retorno;}


 
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
                        boolean empate = resultado.getBoolean("empate");
                        int idResultado= resultado.getInt("id_resultado");
                        String fechaResultado = resultado.getString("fecha_resultado");
                        String horaResultado = resultado.getString("hora_resultado");

                       
                       
                        retorno = new Encuentro();
                        retorno.setIdEncuentro(id);//Participante Libre en la ronda
                        retorno.setParticipanteA(ParticipanteGestor.instanciarUnParticipante(idParticipanteA));
                        System.out.println("entremedio");
                        retorno.setParticipanteB(ParticipanteGestor.instanciarUnParticipante(idParticipanteB));
                        retorno.setGanador(ParticipanteGestor.instanciarUnParticipante(idParticipanteGanador));
                        retorno.setPerdedor(ParticipanteGestor.instanciarUnParticipante(idParticipantePerdedor));
                        retorno.setEmpate(empate);
                        retorno.setFechaResultado(fechaResultado);
                        retorno.setHoraResultado(horaResultado);
                        if(idResultado!=0){
                            retorno.setResultado(ResultadoGestor.getResultado(idResultado));
                            }
                       
                        datos.add(retorno);

                 
                    }
                    encuentros= new Encuentro[datos.size()];
                    for(int j=0;j<datos.size();j++){
                            encuentros[j]=datos.get(j);
                          
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
            System.out.println(e.getMessage());
        }
        return temp;
        
     }

    /**
     * @param puntos
     */
    public void guardarResultado(Encuentro unEncuentro, Puntos puntos[]){
        Resultados unResultado = new Resultados();
        
        unResultado.setPuntuacion(puntos);
            unEncuentro.setResultado(unResultado);
                //unEncuentro.setAsistencia(asistencia);
            
            
            
            }

    /**
     * @param participanteGanador
     */
    
    // GANADOR PARA RESULTADO FINAL
    public static void ganador(Encuentro unEncuentro,Participante participanteGanador, Participante participantePerdedor, String modalidad, int asistencia){
        
        unEncuentro.setGanador(participanteGanador);
        unEncuentro.setPerdedor(participantePerdedor);
        unEncuentro.setAsistencia(asistencia);

        try {
            EncuentroDB.actualizarEncuentro(unEncuentro, modalidad);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public static void ganador(Encuentro unEncuentro,Participante participanteGanador, String modalidad){
        unEncuentro.setGanador(participanteGanador);

        try {
            EncuentroDB.actualizarEncuentro(unEncuentro, modalidad);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public static void presente(Encuentro unEncuentro,Participante participanteGanador, Participante participantePerdedor, int presente, String modalidad){
        unEncuentro.setAsistencia(presente);
        unEncuentro.setGanador(participanteGanador);
        unEncuentro.setPerdedor(participantePerdedor);
        
        try {
            EncuentroDB.actualizarEncuentro(unEncuentro, modalidad);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * @param participanteA
     * @param participanteB
     */
    public static void ganadorEmpate(Encuentro unEncuentro, String modalidad){
        unEncuentro.setEmpate(true);
        try {
            EncuentroDB.actualizarEncuentro(unEncuentro, modalidad);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public static void guardarResultado(Encuentro unEncuentro,int cantidadPuntos, JTable tablaDeSetsJTable, int asistencia, String modalidad){
        int setA=0;
        int setB=0;
        unEncuentro.setAsistencia(asistencia);
        unEncuentro.asignaResultado(ResultadoGestor.crearResultado(cantidadPuntos, tablaDeSetsJTable));
        unEncuentro.setGanador();
        if (setA==setB)
        {
                unEncuentro.setEmpate(true);
            }
        else
        if(setA<setB){
            unEncuentro.setGanador(unEncuentro.getParticipanteB());
            unEncuentro.setPerdedor(unEncuentro.getParticipanteA());
        }
        else{
            unEncuentro.setGanador(unEncuentro.getParticipanteA());
            unEncuentro.setPerdedor(unEncuentro.getParticipanteB());
        }
        
        try {
            EncuentroDB.actualizarEncuentro(unEncuentro, modalidad);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    /**
     * @param participanteA
     * @param participanteB
     * @param puntoA
     * @param puntoB
     */
    public static void ganador(Encuentro unEncuentro, Participante participanteA,Participante participanteB,int  puntoA,int  puntoB, String modalidad){
        unEncuentro.setAsistencia(0);
        Resultados unResultado = new Resultados();
        //NUEVO PUNTO
        Puntos unPunto = new Puntos();
        // SETEAR PUNTOA 
        unPunto.setPuntoA(puntoA);
        // SETEAR PUNTOB
        unPunto.setPuntoB(puntoB);
        // SETEAMOS PUNTO DENTRO DE RESULTADO
        unResultado.setPuntuacion(unPunto);
        // SETEAMOS EL RESULTADO EN EL ENCUENTRO
        unEncuentro.setResultado(unResultado);
   
        if (puntoA==puntoB){
            
                unEncuentro.setEmpate(true);
        }
            else if(puntoA<puntoB){
     
                    unEncuentro.setGanador(participanteB);
                    unEncuentro.setPerdedor(participanteA);
            }
            else{
                
                    unEncuentro.setGanador(participanteA);
                    unEncuentro.setPerdedor(participanteB);
            }


           try {
               EncuentroDB.actualizarEncuentro(unEncuentro, modalidad);
           } catch (SQLException e) {
               System.out.println(e.getMessage());
           }
        
       }
    public static void unGanador(Encuentro unEncuentro, Participante participanteGanador,Participante participantePerdedor,  int asistencia, String modalidad ){
           
            unEncuentro.setGanador(participanteGanador);
            unEncuentro.setPerdedor(participantePerdedor);
            unEncuentro.setAsistencia(asistencia);
           
           try {
               EncuentroDB.actualizarEncuentro(unEncuentro, modalidad);
           } catch (SQLException e) {
               System.out.println(e.getMessage());
           }
        
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

