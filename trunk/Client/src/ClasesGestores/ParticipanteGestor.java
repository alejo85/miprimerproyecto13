package ClasesGestores;


import ClasesBD.ParticipanteDB;

import ClasesLogicas.Participante;
import ClasesLogicas.ParticipanteAnterior;

import java.sql.ResultSet;
import java.sql.SQLException;

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

    public void modificarParticipante(){}
    
    
    public Participante[] instanciarParticipante(int idCompetencia){
        Participante[] retorno=null;
        ResultSet resultado = ParticipanteDB.buscarParticipante(idCompetencia);
            ParticipanteAnterior [] participantesAnteriores = null;
            ParticipanteAnterior aux = null;

        try {
            while(resultado.next()){
                int idParticipante = resultado.getInt("id_participante");
                int i=0;
                String nombre = resultado.getString("nombre");
                String correo = resultado.getString("correo");
                Byte imagen = resultado.getByte("imagen");
                ImageIcon imag = new ImageIcon("");
                ResultSet anteriores = ParticipanteDB.buscarParticipanteAnterior(idParticipante);
                while(anteriores.next()){
                    
                        int idParticipantea = resultado.getInt("id_participante_anterior");
                        String nombrea = resultado.getString("nombre");
                        String correoa = resultado.getString("correo");
                        String fechaHora = resultado.getString("Fecha")+" - "+resultado.getString("Hora");
                        Byte imagena = resultado.getByte("imagen");
                        participantesAnteriores[i]= new ParticipanteAnterior(idParticipantea,nombrea,correoa,imag,fechaHora);
                    }
                i=0;
              retorno[i]= new Participante(idParticipante,  nombre,  correo, imag,participantesAnteriores);
                participantesAnteriores=null;
            }
        } catch (SQLException e) {
        }
        return retorno; }
    
}
