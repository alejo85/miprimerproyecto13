package ClasesGestores;


import ClasesBD.ParticipanteDB;

import ClasesLogicas.Participante;

import java.sql.ResultSet;

import java.sql.ResultSetMetaData;

import javax.swing.ImageIcon;

public class ParticipanteGestor {
    public ParticipanteGestor() {
        super();
    }

    /**
     * @param nombre
     * @param correo
     * @param imagen
     * @return
     */
    public Participante agregarParticipante(String nombre, String correo, ImageIcon imagen){
        Participante resultado = new Participante();
        resultado.setNombre(nombre);
        resultado.setCorreo(correo);
        resultado.setImagen(imagen);
        return resultado;
        }

    public void modificarParticipante(int idCompetencia){}
    public Participante[] instanciarParticipante(){
        Participante[] retorno;
        ResultSet resultado = ParticipanteDB.buscarParticipante(idCompetencia);
            return retorno; }
    
}
