package ClasesLogicas;


public class Usuario {
    private int idUsuario;
    private String correoElectronico;
    private String apellido;
    private String nombre;
    private String tipoDocumento;
    private int numeroDocumento;
    private Localidad ciudad;
    private Logueo[] logueos;


    public Usuario() {
        super();
    }

    public Usuario(Integer idUsuario, String correoElectronico, String apellido, String nombre, String tipoDocumento,
                   Integer numeroDocumento, Localidad ciudad, Logueo[] logueos) {
        super();
        this.idUsuario = idUsuario;
        this.correoElectronico = correoElectronico;
        this.apellido = apellido;
        this.nombre = nombre;
        this.tipoDocumento = tipoDocumento;
        this.numeroDocumento = numeroDocumento;
        this.ciudad = ciudad;
        this.logueos = logueos;
    }

    public Usuario(String correoElectronico, String apellido, String nombre) {
        super();
        this.correoElectronico = correoElectronico;
        this.apellido = apellido;
        this.nombre = nombre;
    }


    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getApellido() {
        return apellido;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setNumeroDocumento(Integer numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public Integer getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setCiudad(Localidad ciudad) {
        this.ciudad = ciudad;
    }

    public Localidad getCiudad() {
        return ciudad;
    }

    public void setLogueos(Logueo[] logueos) {
        this.logueos = logueos;
    }

    public Logueo[] getLogueos() {
        return logueos;
    }
}
