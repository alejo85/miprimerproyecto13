package ClasesBD;


import ClasesLogicas.Participante;

import java.sql.ResultSet;

public class ParticipanteDB {
    public ParticipanteDB() {
        super();
    }

    /**
     * @param participante
     * @return
     */
    public int altaParticipante(Participante participante){
        int idParticipante=0;
                       return idParticipante;}


    /**
     * @param correoElectronico
     * @return
     * 
     */
    public boolean existeParticipantes(String correoElectronico){
                       return true;}

    /**
     * @param participante
     * @return
     */
    public boolean registrarParticipante(Participante participante){
                       return true;}

    /**j
     * @param participante
     * @return
     */
    public boolean actualizarParticipante(Participante participante){
                       return true;}

    /**j
     * @param participante
     * @return
     */
    public boolean eliminarParticipante(Participante participante){
                       return true;}
    public static ResultSet buscarParticipante(int idCompetencia){
        ResultSet resultado = null;
        return resultado;}
     public static ResultSet buscarParticipanteAnterior(int idParticipante){
         ResultSet resultado = null;
         return resultado;}
 }
