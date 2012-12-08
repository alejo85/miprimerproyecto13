package ClasesBD;


import ClasesGestores.ParticipanteGestor;

import ClasesLogicas.Competencia;
import ClasesLogicas.Deporte;
import ClasesLogicas.Encuentro;
import ClasesLogicas.LugarDeRealizacion;
import ClasesLogicas.Pais;
import ClasesLogicas.Participante;

import ClasesLogicas.Posicion;
import ClasesLogicas.Subronda;

import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.Statement;

import java.util.Vector;


public class CompetenciaDB {
    public CompetenciaDB() {
        super();
    }

    /**
     * @param nombreCompetencia
     * @param deporte
     * @param Modalidad
     * @param estado
     * @return
     * 
     * 
     */

    public static ResultSet buscarCompetencias(String nombreCompetencia,int deporte, String modalidad, String estado, String correo) throws SQLException {
            
            
           String where="";
           String consultasql="";
           if(!nombreCompetencia.equals(""))where+="and  C.nombre_competencia ILIKE '%"+nombreCompetencia+"%'";
           if(deporte>0)where+="and C.id_deporte='"+deporte+"'";
           if(!modalidad.equals("Seleccione Una Modalidad"))where+="and C.modalidad ='"+modalidad+"'";
           if(!estado.equals("Seleccione Un Estado"))where+="and C.estado='"+estado+"'";
           consultasql="SELECT C.id_competencia, C.nombre_competencia, C.modalidad, C.estado,  C.creador, C.id_deporte FROM competencia as C where C.creador='"+correo+"'"+where+";";
           ResultSet resultado = Conexion.consultar(consultasql); 
                
          return resultado;
          }
    public static Vector<Posicion> getTablaDePosiciones(int idCompetencia) throws SQLException {
        
        Vector <Posicion> vector = new Vector <Posicion>();
        Statement consulta = Conexion.consultar();
        String consultasql="";
        consultasql="SELECT * FROM fila_tabla_de_posiciones where id_Competencia='"+idCompetencia+"';";
        ResultSet resultado = consulta.executeQuery(consultasql);
        while(resultado.next()){
           Posicion unaPosicion = new Posicion();
           unaPosicion.setIdTabla(resultado.getInt("id_tabla"));
           unaPosicion.setPosicion(resultado.getInt("posicion"));
           unaPosicion.setPuntos(resultado.getInt("puntos"));
           unaPosicion.setPartidosGanados(resultado.getInt("pg"));
           unaPosicion.setPartidosPerdidos(resultado.getInt("pp"));
           unaPosicion.setPartidosEmpatados(resultado.getInt("pe"));
           unaPosicion.setTantosAFavor(resultado.getInt("tantos_a_favor"));
           unaPosicion.setTantosEncontra(resultado.getInt("tantos_en_contra"));
           unaPosicion.setDiferencia(resultado.getInt("diferencia"));
           unaPosicion.setParticipante(ParticipanteGestor.instanciarUnParticipante(resultado.getInt("id_participante")));
           vector.add(unaPosicion);      
            
        }
                
        return vector;
    }
    
    
    
    
    public static ResultSet buscarCompetencias(int idCompetencia) throws SQLException {
          
            String consultasql="";
            consultasql="SELECT * FROM competencia where id_Competencia='"+idCompetencia+"';";
            ResultSet resultado = Conexion.consulta.executeQuery(consultasql);
            resultado.next();
            return resultado;
        }

    /**
     * @param nombreCompetencia
     * @param deporte
     * @param Modalidad
     * @param estado
     * @param usuario
     * @return
     */
    public static ResultSet buscarCompetencias(String nombreCompetencia, Deporte deporte, String Modalidad, String estado, String usuario){
             
             ResultSet resultado=null;
            
             return resultado;}

    /**
     * @param nombreCompetencia
     * @param deporte
     * @param Modalidad
     * @param estado
     * @return
     */

    /**
     * @param nombreCompetencia
     * @return
     */
    public static boolean buscarCompetencia(String nombreCompetencia, String correo) throws SQLException {
                           
        
            
            String consultasql;
            consultasql="select * from COMPETENCIA as C where Creador='"+correo+"' and Nombre_Competencia ='"+nombreCompetencia+"'";
            ResultSet resultado = Conexion.consulta.executeQuery(consultasql); 
            resultado.next();
             
             if(resultado.getString("Nombre_Competencia").equals(nombreCompetencia)){
                   return true;
             }
             else{
                   return true;
             }
       
       
    }         
    public static ResultSet buscarCantidadMaximaDeSets(int idCompetencia) throws SQLException {
                
            String consultasql;
            consultasql="SELECT id_set, id_competencia, cantidad_de_sets FROM set where id_competencia='"+idCompetencia+"'";
            ResultSet resultado = Conexion.consulta.executeQuery(consultasql); 
            return resultado;
       
  }
    public static Competencia registrarCompetencia(Competencia competencia) throws SQLException {
                                   ResultSet resultado=null;
                                   Statement reglamento = Conexion.consultar();
                                   Statement retornoEmpate = Conexion.consultar();
                                   Statement consulta = Conexion.consultar();
                                 String consultasql;
                                   int id;
                                   if(competencia.getReglamento().equals("")){
                                                   consultasql="INSERT INTO competencia( nombre_competencia, modalidad, forma_puntuacion, estado, tantos_por_partido_ganado, creador, id_deporte)" +
                                                   "VALUES ('"+competencia.getNombreCompetencia()+"', '"+competencia.getModalidad()+
                                                   "','"+competencia.getFormaDePuntuacion()+"', '"+competencia.getEstado()+"', '"+competencia.getTantosPorPartidoGanado()+"', '"
                                                   +competencia.getUsuarioCreador().getCorreoElectronico()+"', '"+competencia.getDeporte().getIdDeporte()+"')RETURNING id_Competencia;";
                                                   resultado = reglamento.executeQuery(consultasql);
                                   }
                                   else{

                                                   consultasql="INSERT INTO competencia( nombre_competencia, reglamento, modalidad, forma_puntuacion, estado, tantos_por_partido_ganado, creador, id_deporte)" +
                                                   "VALUES ('"+competencia.getNombreCompetencia()+"', '"+competencia.getReglamento()+"', '"+competencia.getModalidad()+
                                                   "','"+competencia.getFormaDePuntuacion()+"', '"+competencia.getEstado()+"', '"+competencia.getTantosPorPartidoGanado()+"', '"
                                                   +competencia.getUsuarioCreador().getCorreoElectronico()+"', '"+competencia.getDeporte().getIdDeporte()+"')RETURNING id_Competencia;";
                                                   resultado = reglamento.executeQuery(consultasql);
                                           }
                                   resultado.next();
                                   id = resultado.getInt("id_Competencia");
                                   competencia.setIdCompetencia(id);
                                   
                                   if(competencia.getLiga().getEmpate())
                                           {
                                                   consultasql="INSERT INTO liga(ptos_por_empate, ptos_partidos_g, empate, ptos_por_asistir, id_competencia)VALUES('"+competencia.getLiga().getPuntosPorPartidoEmpatado()+"', '"+competencia.getLiga().getPuntosPorPartidoGanado()+"', '"+competencia.getLiga().getEmpate()+"', '"+competencia.getLiga().getPuntosPorPartidoAsistido()+"', '"+competencia.getIdCompetencia()+"')RETURNING *;";
                                                   resultado = retornoEmpate.executeQuery(consultasql);
                                           }
                                   else
                                           {
                                                   consultasql="INSERT INTO liga(ptos_partidos_g, empate, ptos_por_asistir, id_competencia)VALUES('"+competencia.getLiga().getPuntosPorPartidoGanado()+"', '"+competencia.getLiga().getEmpate()+"', '"+competencia.getLiga().getPuntosPorPartidoAsistido()+"', '"+competencia.getIdCompetencia()+"')RETURNING *;";
                                                   resultado = retornoEmpate.executeQuery(consultasql);
                                           }
                                   
                                   if (competencia.getFormaDePuntuacion().equals("Puntuación"))
                                   {
                                           consultasql="INSERT INTO puntuacion(tantos_por_ausencia_contrincante, id_competencia)VALUES('"+competencia.getTantosPorPartidoAusenciaContrincante()+"', '"+competencia.getIdCompetencia()+"')RETURNING *;";
                                           consulta = Conexion.consultar();
                                           resultado = consulta.executeQuery(consultasql);
                                   }
                                   
                                   if (competencia.getFormaDePuntuacion().equals("Sets"))
                                   {
                                           
                             
                                           consultasql="INSERT INTO set(id_competencia, cantidad_de_sets)VALUES('"+competencia.getIdCompetencia()+"', '"+competencia.getCantidadDeSets()+"')RETURNING *";
                                         consulta = Conexion.consultar();
                                         resultado = consulta.executeQuery(consultasql);
                                   }
                                   LugarDeRealizacion lugares[]=competencia.getLugares();
                                   for(int i=0; i<lugares.length;i++){
                                           consulta = Conexion.consultar();
                                           consultasql="INSERT INTO juega(id_competencia, id_lugar_de_realizacion, disponibilidad)VALUES ('"+competencia.getIdCompetencia()+"', '"+lugares[i].getIdLugar()+"', '"+lugares[i].getDisponibilidad()+"')RETURNING *";
                                           resultado = consulta.executeQuery(consultasql);
     
                                       }
                               return competencia;
                               }
    
    /**
     * @param competencia
     * @return
     */
   /* public static boolean registrarCompetencia(Competencia competencia) throws SQLException {
         
            ResultSet resultado=null;
            Statement reglamento = Conexion.consultar();
            Statement retornoEmpate = Conexion.consultar();
            Statement consulta = Conexion.consultar();
            String consultasql;
            int id;
            if(competencia.getReglamento().equals("")){
           
                consultasql="INSERT INTO competencia( nombre_competencia, modalidad, forma_puntuacion, estado, tantos_por_partido_ganado, creador, id_deporte)" +
                "VALUES ('"+competencia.getNombreCompetencia()+"', '"+competencia.getModalidad()+
                "','"+competencia.getFormaDePuntuacion()+"', '"+competencia.getEstado()+"', '"+competencia.getTantosPorPartidoGanado()+"', '"
                +competencia.getUsuarioCreador().getCorreoElectronico()+"', '"+competencia.getDeporte().getIdDeporte()+"')RETURNING id_Competencia;";
                resultado = reglamento.executeQuery(consultasql);
           }
           else{
               consultasql="INSERT INTO competencia( nombre_competencia, reglamento, modalidad, forma_puntuacion, estado, tantos_por_partido_ganado, creador, id_deporte)" +
               "VALUES ('"+competencia.getNombreCompetencia()+"', '"+competencia.getReglamento()+"', '"+competencia.getModalidad()+
               "','"+competencia.getFormaDePuntuacion()+"', '"+competencia.getEstado()+"', '"+competencia.getTantosPorPartidoGanado()+"', '"
               +competencia.getUsuarioCreador().getCorreoElectronico()+"', '"+competencia.getDeporte().getIdDeporte()+"')RETURNING id_Competencia;";
               resultado = reglamento.executeQuery(consultasql);
           }
          resultado.next();
          id = resultado.getInt("id_Competencia");
          competencia.setIdCompetencia(id);
         
          if(competencia.getLiga().getEmpate()){
               consultasql="INSERT INTO liga(ptos_por_empate, ptos_partidos_g, empate, ptos_por_asistir, id_competencia)VALUES('"+competencia.getLiga().getPuntosPorPartidoEmpatado()+"', '"+competencia.getLiga().getPuntosPorPartidoGanado()+"', '"+competencia.getLiga().getEmpate()+"', '"+competencia.getLiga().getPuntosPorPartidoAsistido()+"', '"+competencia.getIdCompetencia()+"')RETURNING *;";
               System.out.println(consultasql);
               resultado = retornoEmpate.executeQuery(consultasql);
          }
          else{
               consultasql="INSERT INTO liga(ptos_partidos_g, empate, ptos_por_asistir, id_competencia)VALUES('"+competencia.getLiga().getPuntosPorPartidoGanado()+"', '"+competencia.getLiga().getEmpate()+"', '"+competencia.getLiga().getPuntosPorPartidoAsistido()+"', '"+competencia.getIdCompetencia()+"')RETURNING *;";
               resultado = retornoEmpate.executeQuery(consultasql);
         }
         if (competencia.getFormaDePuntuacion().equals("Puntuación")){
               System.out.println("llega al puntuacion");
               consultasql="INSERT INTO puntuacion(tantos_por_ausencia_contrincante, id_competencia)VALUES('"+competencia.getTantosPorPartidoAusenciaContrincante()+"', '"+competencia.getIdCompetencia()+"')RETURNING *;";
               consulta = Conexion.consultar();
               resultado = consulta.executeQuery(consultasql);
         }
        if (competencia.getFormaDePuntuacion().equals("Sets")){
                                       
               consultasql="INSERT INTO set(id_competencia, cantidad_de_sets)VALUES('"+competencia.getIdCompetencia()+"', '"+competencia.getCantidadDeSets()+"')RETURNING *";
               consulta = Conexion.consultar();
               resultado = consulta.executeQuery(consultasql);
        }
        LugarDeRealizacion lugares[]=competencia.getLugares();
        for(int i=0; i<lugares.length;i++){
               consulta = Conexion.consultar();
               consultasql="INSERT INTO juega(id_competencia, id_lugar_de_realizacion, disponibilidad)VALUES ('"+competencia.getIdCompetencia()+"', '"+lugares[i].getIdLugar()+"', '"+lugares[i].getDisponibilidad()+"')RETURNING *";
               resultado = consulta.executeQuery(consultasql);
        }
        return true;
    }
                               
                               
                    */           
   
   
    
   

    /**
     * @param competencia
     * @return
     */
    public ResultSet actualizarEstadoCompetencia(Competencia competencia){
                               ResultSet resultado=null;
                           
                           return resultado;}

    /**j
     * @param competencia
     * @return
     */
    public ResultSet actualizarCompetencia(Competencia competencia){
                               ResultSet resultado=null;
                           
                           return resultado;}

    /**
     * @param idCompetencia
     * @return
     */
    public ResultSet eliminarCompetencia(int idCompetencia){
                               ResultSet resultado=null;
                           
                           return resultado;}

    /**
     * @param nombreDeCompetencia
     * @return
     */
    public ResultSet nombreCompetencia(String nombreDeCompetencia){
        ResultSet resultado=null;
    
    return resultado;}

    /**j
     * @param nombreDeCompetencia
     * @param idCompetencia
     * @return
     */
    public ResultSet nombreCompetencia(String nombreDeCompetencia, int idCompetencia){
        ResultSet resultado=null;
    
    return resultado;}

    /**
     * @param competencia
     * @return
     */
    public int guardarCompetencia(ClasesLogicas.Competencia competencia){

    int idCompetencia=0;
    return idCompetencia;
    }

    /**
     * @param participante
     */
    public void agregarParticipante(Participante participante){

    }

    /**
     * @param competencia
     */
    public static void guardarFixture(Vector<Encuentro> encuentros){
       // System.out.println("antes del guardar el fixture!!!");
        //Conexion conexion = new Conexion();
        ResultSet resultado=null;
        /*try {
            conexion.conectar();
        } catch (SQLException e) {
        }*/
        String consultasql;
        try {
               for(int i=0;i<encuentros.size();i++)
               {
                    
                    
                    consultasql="UPDATE encuentro\n" + 
                    "   SET id_participantea='"+encuentros.get(i).getParticipanteA().getIdParticipante()+"', \n" + 
                    "       id_participanteb='"+encuentros.get(i).getParticipanteB().getIdParticipante()+"'\n" + 
                    " WHERE id_encuentro='"+encuentros.get(i).getIdEncuentro()+"' and id_lugar_de_realizacion='"+encuentros.get(i).getLocación().getIdLugar()+"'RETURNING *;";
                    System.out.println(consultasql);
                    resultado = Conexion.consulta.executeQuery(consultasql);
                    
               }
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
      //  conexion.cerrarConexion();
        
        
 
    }
    
    public static void actualizarEstado (int idCompetencia, String estado) throws SQLException {
        
        //Conexion conexion = new Conexion();
        ResultSet resultado=null;
        //conexion.conectar();
        String consultasql;
        
        consultasql="UPDATE competencia\n" + 
        "   SET estado='"+estado+"'\n" + 
        " WHERE id_competencia='"+idCompetencia+"';";
       // System.out.println(consultasql);
        resultado = Conexion.consulta.executeQuery(consultasql);
        
        //conexion.cerrarConexion();
        
    }

    public static boolean validadNombreParticipante(String nombreDelParticipante, int idCompetencia) throws SQLException {
            //Conexion conexion = new Conexion();
            ResultSet resultado=null;
            //conexion.conectar();
            String consultasql;
            
            consultasql="SELECT A.id_competencia, A.id_participante, A.fecha, A.hora, P.id_participante, P.nombre, P.correo, P.imagen\n" + 
            "  FROM participa as A, participante as P where P.nombre='"+nombreDelParticipante+"' and A.id_competencia='"+idCompetencia+"' and A.id_participante=P.id_participante;";
           // System.out.println(consultasql);
           resultado = Conexion.consulta.executeQuery(consultasql);
        
      //  conexion.cerrarConexion();
            if(resultado.next()){
               // System.out.println(false);
                return false;
                
            }
            else{
              //  System.out.println(true);
                return true;
            }
        
    }

    /**
     * @param participante
     * @param idCompetencia
     */
    public static void agregarParticipante(Participante participante, int idCompetencia, String dias, String horas) throws SQLException {
        
            //Conexion conexion = new Conexion();
            ResultSet resultado=null;
            //conexion.conectar();
            String consultasql;
            consultasql="INSERT INTO participa(id_competencia, id_participante, fecha, hora)VALUES('"+idCompetencia+"', '"+participante.getIdParticipante()+"', '"+dias+"', '"+horas+"');";
            
            resultado = Conexion.consulta.executeQuery(consultasql);
            //conexion.cerrarConexion();
        
        
        }
        
        
    public static int guardarPosicion(Posicion unaPosicion, int idCompetencia) throws SQLException {
        
       
        
        
        ResultSet resultado=null;
        
        String consultasql;
        consultasql="INSERT INTO fila_tabla_de_posiciones(id_competencia, posicion, puntos, diferencia, pg, pe, pp, tantos_a_favor, tantos_en_contra, id_participante)\n" + 
        "VALUES ('"+idCompetencia+"', '"+unaPosicion.getPosicion()+"', '"+unaPosicion.getPuntos()+"','"+unaPosicion.getDiferencia()+"'," +
            "'"+unaPosicion.getPartidosGanados()+"','"+unaPosicion.getPartidosEmpatados()+"','"+unaPosicion.getPartidosPerdidos()+"'," +
            "'"+unaPosicion.getTantosAFavor()+"','"+unaPosicion.getTantosEncontra()+"','"+unaPosicion.getParticipante().getIdParticipante()+"')RETURNING id_tabla;";
        System.out.println(consultasql);
        resultado = Conexion.consulta.executeQuery(consultasql);
        
        resultado.next();
        return resultado.getInt("id_tabla");
        
        
    }
}
