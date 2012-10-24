package ClasesLogicas;

import javax.swing.ImageIcon;

public class Participante {
        private Integer idParticipante;
        private String nombre;
        private String Correo;
        private ImageIcon imagen;
        private ParticipanteAnterior[] historial;

    public Participante(Integer idParticipante, String nombre, String Correo, ImageIcon imagen,
                        ParticipanteAnterior[] historial) {
        super();
        this.idParticipante = idParticipante;
        this.nombre = nombre;
        this.Correo = Correo;
        this.imagen = imagen;
        this.historial = historial;
    }
    public Participante() {
        super();
            }



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

    public void setHistorial(ParticipanteAnterior[] historial) {
        this.historial = historial;
    }

    public ParticipanteAnterior[] getHistorial() {
        return historial;
    }
    public void enviarCorreoElectronico(String correoElectronico){} 
}
