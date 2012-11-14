package ClasesBD;


import ClasesLogicas.Competencia;
import ClasesLogicas.Deporte;
import ClasesLogicas.Participante;

import java.sql.ResultSet;


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
    public static ResultSet buscarCompetencias(String nombreCompetencia, Deporte deporte, String Modalidad, String estado){
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
    public static ResultSet buscarCompetencia(String nombreCompetencia){
                               ResultSet resultado=null;
                           
                           return resultado;}

    /**
     * @param competencia
     * @return
     */
    public ResultSet registrarCompetencia(Competencia competencia){
                               ResultSet resultado=null;
                           
                           return resultado;}

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
    public void guardarFixture(ClasesLogicas.Competencia competencia){

 
    }
    
}
