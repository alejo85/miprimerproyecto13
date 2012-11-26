package ClasesGestores;


import ClasesBD.CompetenciaDB;
import ClasesBD.ParticipanteDB;

import ClasesLogicas.Competencia;
import ClasesLogicas.Participante;
import ClasesLogicas.ParticipanteAnterior;

import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.Date;

import java.util.Vector;

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
    public static Participante agregarParticipante(String nombre, String correo, String imagen){
        Participante resultado = new Participante();
        resultado.setNombre(nombre);
        resultado.setCorreo(correo);
        //resultado.setImagen(imagen);
        return resultado;
        }
    public static Participante agregarParticipante(String nombre, String correo, Competencia competencia){
            System.out.println("llego a el gestor");
        Participante resultado = new Participante();
        resultado.setNombre(nombre);
        resultado.setCorreo(correo);
        try {
            resultado.setIdParticipante(ParticipanteDB.altaParticipante(resultado));
            java.util.Date fecha = new Date();
            int dia = fecha.getDate();
            int mes = fecha.getMonth() + 1;
            int anio = fecha.getYear() + 1900;
            int hora = fecha.getHours();
            int min = fecha.getMinutes();
            String horas;
            
            if (min < 10)
            {
                horas= ""+hora+":"+"0" + min;
                
            }
            String dias = ""+dia+"/"+mes+"/"+anio;
            horas = ""+hora+":"+ min;
            CompetenciaDB.agregarParticipante( resultado,  competencia.getIdCompetencia(),  dias,  horas);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return resultado;
        }
    public void modificarParticipante(){}
    
    
    public static Participante[] instanciarParticipante(int idCompetencia){
        Participante retorno=null;
            Vector <Participante> datos=new Vector <Participante>();
            Participante [] participantes=null;
        ResultSet resultado;

        try {
            resultado = ParticipanteDB.buscarParticipante(idCompetencia);
            ParticipanteAnterior aux = null;

           
                while(resultado.next()){
                    int idParticipante = resultado.getInt("id_participante");
                    int i=0;
                    String nombre = resultado.getString("nombre");
                    String correo = resultado.getString("correo");
                    Byte imagen = resultado.getByte("imagen");
                    ImageIcon imag = new ImageIcon("");
                   
                    i=0;
                  retorno= new Participante();
                    retorno.setIdParticipante(idParticipante);
                    retorno.setNombre(nombre);
                    retorno.setCorreo(correo);
                    datos.add(retorno);
                    //todo recuperarImagen
                }
                participantes= new Participante[datos.size()];
                for(int j=0;j<datos.size();j++){
                        participantes[j]=datos.get(j);
                    }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
       
        return participantes; }
    
}
