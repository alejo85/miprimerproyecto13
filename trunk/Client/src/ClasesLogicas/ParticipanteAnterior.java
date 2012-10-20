package ClasesLogicas;

import java.util.GregorianCalendar;

import javax.swing.ImageIcon;


public class ParticipanteAnterior {
    private Integer idParticipante;
    private String nombre;
    private String Correo;
    private ImageIcon imagen;
    private GregorianCalendar fechaHora;

    public ParticipanteAnterior(Integer idParticipante, String nombre, String Correo, ImageIcon imagen,
                                GregorianCalendar fechaHora) {
        super();
        this.idParticipante = idParticipante;
        this.nombre = nombre;
        this.Correo = Correo;
        this.imagen = imagen;
        this.fechaHora = fechaHora;
    }
/*
    public void setIdParticipante(Integer idParticipante) {
        this.idParticipante = idParticipante;
    }

    public Integer getIdParticipante() {
        return idParticipante;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setImagen(ImageIcon imagen) {
        this.imagen = imagen;
    }

    public ImageIcon getImagen() {
        return imagen;
    }

    public void setFechaHora(GregorianCalendar fechaHora) {
        this.fechaHora = fechaHora;
    }

    public GregorianCalendar getFechaHora() {
        return fechaHora;
    }*/
}
