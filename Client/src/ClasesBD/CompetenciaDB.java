package ClasesBD;


import ClasesLogicas.Competencia;
import ClasesLogicas.Deporte;
import ClasesLogicas.Participante;

import java.sql.ResultSet;
import java.sql.SQLException;


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
     */
    public static ResultSet buscarCompetencias(String nombreCompetencia, String deporte, String Modalidad, String estado){
            ResultSet resultado=null;
        
        return resultado;}

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
                               Conexion conexion = new Conexion();
        
            conexion.conectar();
            String consultasql;
                                   consultasql="select * from COMPETENCIA as C where Creador='"+correo+"' and Nombre_Competencia ='"+nombreCompetencia+"'";
                                   ResultSet resultado = conexion.consultar(consultasql); 
                                   resultado.next();
                                   conexion.cerrarConexion();
                                   if(resultado.getString("Nombre_Competencia").equals(nombreCompetencia)){
                                       return true;
                                   }
                                   else{
                                       return true;
                                   }
       
       
                               }

    /**
     * @param competencia
     * @return
     */
    public static boolean registrarCompetencia(Competencia competencia) throws SQLException {
                               System.out.println("llega al sql");
                               Conexion conexion = new Conexion();
                               System.out.println("llega crea conexion");
                               ResultSet resultado=null;
                               conexion.conectar();
                               System.out.println("llega conecta conexion");
                               String consultasql;
                               if(competencia.getReglamento().equals(""))
                                       {
                                               System.out.println(competencia.getModalidad());
                                               consultasql="INSERT INTO competencia( nombre_competencia, modalidad, forma_puntuacion, estado, tantos_por_partido_ganado, creador, id_deporte)" +
                                               "VALUES ('"+competencia.getNombreCompetencia()+"', '"+competencia.getModalidad()+
                                               "','"+competencia.getFormaDePuntuacion()+"', '"+competencia.getEstado()+"', '"+competencia.getTantosPorPartidoGanado()+"', '"
                                               +competencia.getUsuarioCreador().getCorreoElectronico()+"', '"+competencia.getDeporte().getIdDeporte()+"');";
                                               System.out.println(consultasql);
                                               resultado= conexion.consultar(consultasql);
                                       }
                               else
                                       {

                                               consultasql="INSERT INTO competencia( nombre_competencia, reglamento, modalidad, forma_puntuacion, estado, tantos_por_partido_ganado, creador, id_deporte)" +
                                               "VALUES ('"+competencia.getNombreCompetencia()+"', '"+competencia.getReglamento()+"', '"+competencia.getModalidad()+
                                               "','"+competencia.getFormaDePuntuacion()+"', '"+competencia.getEstado()+"', '"+competencia.getTantosPorPartidoGanado()+"', '"
                                               +competencia.getUsuarioCreador().getCorreoElectronico()+"', '"+competencia.getDeporte().getIdDeporte()+"');";
                                               System.out.println(consultasql);
                                               resultado= conexion.consultar(consultasql);
                                               competencia.setIdCompetencia(idCompetencia());
                                               System.out.println("llega al regla no null");
                                       }
                               
                               if (competencia.getModalidad().equals("Puntuación"))
                               {
                                       System.out.println("llega al puntuacion");
                                       
                                       if(competencia.getLiga().getEmpate())
                                               {
                                                       System.out.println("llega al empatesi");
                                                       consultasql="INSERT INTO liga(ptos_por_empate, ptos_partidos_g, empate, ptos_por_asistir, id_competencia)VALUES('"+competencia.getLiga().getPuntosPorPartidoEmpatado()+"', '"+competencia.getLiga().getPuntosPorPartidoGanado()+"', '"+"', '"+competencia.getLiga().getEmpate()+"', '"+competencia.getLiga().getPuntosPorPartidoAsistido()+"', '"+competencia.getIdCompetencia()+"');";
                                                       System.out.println(consultasql);
                                                       resultado= conexion.consultar(consultasql);
                                               }
                                       else
                                               {
                                                       System.out.println("llega al empateno");
                                                       consultasql="INSERT INTO liga(ptos_partidos_g, empate, ptos_por_asistir, id_competencia)VALUES('"+competencia.getLiga().getPuntosPorPartidoGanado()+"', '"+"', '"+competencia.getLiga().getEmpate()+"', '"+competencia.getLiga().getPuntosPorPartidoAsistido()+"', '"+competencia.getIdCompetencia()+"');";
                                                       System.out.println(consultasql);
                                                       resultado= conexion.consultar(consultasql);
                                               }
                                       System.out.println("llega al puntuacion");
                                       consultasql="INSERT INTO puntuacion(tantos_por_ausencia_contrincante, id_competencia)VALUES('"+competencia.getTantosPorPartidoAusenciaContrincante()+"', '"+competencia.getIdCompetencia()+"');";
                                       System.out.println(consultasql);
                                       resultado= conexion.consultar(consultasql);
                                       System.out.println("termina al puntuacion");
                               }

                               if (competencia.getModalidad().equals("Sets"))
                               {
                                       
                                       if(competencia.getLiga().getEmpate())
                                       {
                                               consultasql="INSERT INTO liga(ptos_por_empate, ptos_partidos_g, empate, ptos_por_asistir, id_competencia)VALUES('"+competencia.getLiga().getPuntosPorPartidoEmpatado()+"', '"+competencia.getLiga().getPuntosPorPartidoGanado()+"', '"+"', '"+competencia.getLiga().getEmpate()+"', '"+competencia.getLiga().getPuntosPorPartidoAsistido()+"', '"+competencia.getIdCompetencia()+"');";
                                               System.out.println(consultasql);
                                               resultado= conexion.consultar(consultasql);
                                       }
                                       else
                                               {
                                                       consultasql="INSERT INTO liga(ptos_partidos_g, empate, ptos_por_asistir, id_competencia)VALUES('"+competencia.getLiga().getPuntosPorPartidoGanado()+"', '"+"', '"+competencia.getLiga().getEmpate()+"', '"+competencia.getLiga().       getPuntosPorPartidoAsistido()+"', '"+competencia.getIdCompetencia()+"');";
                                                       System.out.println(consultasql);
                                                       resultado= conexion.consultar(consultasql);
                                               }
                                       consultasql="INSERT INTO set(id_competencia, cantidad_de_sets)VALUES('"+competencia.getIdCompetencia()+"', '"+competencia.getCantidadDeSets()+"');";
                                       System.out.println(consultasql);
                                       resultado= conexion.consultar(consultasql);
                               }
                             
                               conexion.cerrarConexion();
                               
                           
                           return true;}
                               
                               
                               
   
   
    
   
  
    private static int idCompetencia(){
            Conexion conexion = new Conexion();
            ResultSet resultado=null;
            int id=0;
            String consultasql;
            consultasql="SELECT MAX(id_Competencia) FROM COMPETENCIA;";

        try {
            conexion.conectar();
            resultado = conexion.consultar(consultasql);
            resultado.next();

            id = resultado.getInt("max");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return id;
        }

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
    public static void guardarFixture(ClasesLogicas.Competencia competencia){

 
    }
    
}
