package ClasesBD;


import ClasesLogicas.Participante;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ParticipanteDB {
    public ParticipanteDB() {
        super();
    }

    /**
     * @param participante
     * @return
     */
    public static int altaParticipante(Participante participante) throws SQLException {
           // System.out.println("llego a la base");
        int idParticipante=0;
            //Conexion conexion = new Conexion();
            ResultSet resultado=null;
            //conexion.conectar();
            String consultasql;
        
        consultasql="INSERT INTO participante( nombre, correo)VALUES ('"+participante.getNombre()+"', '"+participante.getCorreo()+"')RETURNING id_Participante;";
            resultado = Conexion.consulta.executeQuery(consultasql);
            resultado.next();
            //System.out.println("despues del next");
            idParticipante = resultado.getInt("id_Participante");
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
    public static ResultSet buscarParticipante(int idCompetencia) throws SQLException {
            //Conexion conexion = new Conexion();
            ResultSet resultado=null;
            //conexion.conectar();
            String consultasql;
            
            consultasql="SELECT P.id_participante, P.nombre, P.correo, P.imagen\n" + 
            "  FROM participa as A, participante as P where A.id_competencia='"+idCompetencia+"' and P.id_participante=A.id_participante;";
            //System.out.println(consultasql);
            resultado = Conexion.consulta.executeQuery(consultasql);
            
            //conexion.cerrarConexion();
     
            
        return resultado;}
     public static ResultSet buscarUnParticipante(int idParticipante) throws SQLException {
             //Conexion conexion = new Conexion();
             ResultSet resultado=null;
             Statement consulta = Conexion.consultar();
             //conexion.conectar();
             String consultasql;
             
             consultasql="SELECT *FROM participante where id_participante='"+idParticipante+"' ;";
             //System.out.println(consultasql);
             resultado = consulta.executeQuery(consultasql); 
             
             //conexion.cerrarConexion();
      
             
         return resultado;}
     public static ResultSet buscarParticipanteAnterior(int idParticipante){
         ResultSet resultado = null;
         return resultado;}
 }
