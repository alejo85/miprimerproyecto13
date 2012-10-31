package ClasesLogicas;

import javax.swing.ImageIcon;


public class ParticipanteAnterior {
    private int idParticipante;
    private String nombre;
    private String Correo;
    private ImageIcon imagen;
    private String fechaHora;

    public ParticipanteAnterior(int idParticipante, String nombre, String Correo, ImageIcon imagen, String fechaHora) {
        super();
        this.idParticipante = idParticipante;
        this.nombre = nombre;
        this.Correo = Correo;
        this.imagen = imagen;
        this.fechaHora = fechaHora;
    }

    public void setIdParticipante(int idParticipante) {
        this.idParticipante = idParticipante;
    }

    public int getIdParticipante() {
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

    public void setFechaHora(String fechaHora) {
        this.fechaHora = fechaHora;
    }

    public String getFechaHora() {
        return fechaHora;
    }
}
