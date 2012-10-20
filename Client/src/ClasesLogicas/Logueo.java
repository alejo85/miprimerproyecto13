package ClasesLogicas;


import java.util.GregorianCalendar;

public class Logueo {
    private Integer idLogueo;
    private String nombrePc;
    private Usuario usuarioLogueado;
    private GregorianCalendar fechaHoraLogueo;

    public Logueo() {
        super();
        
    }

    public Logueo(Integer idLogueo, String nombrePc, Usuario usuarioLogueado, GregorianCalendar fechaHoraLogueo) {
        super();
        this.idLogueo = idLogueo;
        this.nombrePc = nombrePc;
        this.usuarioLogueado = usuarioLogueado;
        this.fechaHoraLogueo = fechaHoraLogueo;
    }
/*
    public void setIdLogueo(Integer idLogueo) {
        this.idLogueo = idLogueo;
    }

    public Integer getIdLogueo() {
        return idLogueo;
    }

    public void setNombrePc(String nombrePc) {
        this.nombrePc = nombrePc;
    }

    public String getNombrePc() {
        return nombrePc;
    }

    public void setUsuarioLogueado(Usuario usuarioLogueado) {
        this.usuarioLogueado = usuarioLogueado;
    }

    public Usuario getUsuarioLogueado() {
        return usuarioLogueado;
    }

    public void setFechaHoraLogueo(GregorianCalendar fechaHoraLogueo) {
        this.fechaHoraLogueo = fechaHoraLogueo;
    }

    public GregorianCalendar getFechaHoraLogueo() {
        return fechaHoraLogueo;
    }*/
}
