package ClasesBD;


import ClasesLogicas.Participante;

import java.io.File;
import java.io.FileInputStream;

import java.sql.PreparedStatement;
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
        int idParticipante=0;
            ResultSet resultado=null;
            String consultasql;
            consultasql="INSERT INTO participante( nombre, correo)VALUES ('"+participante.getNombre()+"', '"+participante.getCorreo()+"')RETURNING id_Participante;";
            resultado = Conexion.consulta.executeQuery(consultasql);
            resultado.next();
            idParticipante = resultado.getInt("id_Participante");
        return idParticipante;
        }


    /**
     * @param correoElectronico
     * @return
     * 
     */
    public static ResultSet buscarParticipante(int idCompetencia) throws SQLException {
            ResultSet resultado=null;
            String consultasql;
            consultasql="SELECT P.id_participante, P.nombre, P.correo, P.imagen\n" + 
            "  FROM participa as A, participante as P where A.id_competencia='"+idCompetencia+"' and P.id_participante=A.id_participante;";
            resultado = Conexion.consulta.executeQuery(consultasql);
            return resultado;
            }
     public static ResultSet buscarUnParticipante(int idParticipante) throws SQLException {
             ResultSet resultado=null;
             Statement consulta = Conexion.consultar();
             String consultasql;
             consultasql="SELECT *FROM participante where id_participante='"+idParticipante+"' ;";
             resultado = consulta.executeQuery(consultasql); 
             return resultado;
             }
     public static ResultSet buscarParticipanteAnterior(int idParticipante){
         ResultSet resultado = null;
         return resultado;}
     
 }
