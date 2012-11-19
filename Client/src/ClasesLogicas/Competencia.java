package ClasesLogicas;

import java.util.Vector;

public class Competencia{

	private int idCompetencia;
	private int tantosPorPartidoGanado;
	private int tantosPorPartidoAusenciaContrincante;
	private int cantidadDeSets;
	private String nombreCompetencia;
	private String modalidad;
	private String formaDePuntuacion;
	private String estado;
	private String reglamento;
	private Deporte deporte;
	private Fixture fixture;
	private Liga liga;
	private Usuario usuarioCreador;
	private Vector <Posicion> tablaDePosiciones;
	private LugarDeRealizacion[] lugares;
	private Participante[] participantes;

    public Competencia(int idCompetencia, int tantosPorPartidoGanado, int tantosPorPartidoAusenciaContrincante,
                       int cantidadDeSets, String nombreCompetencia, String modalidad, String formaDePuntuacion,
                       String estado, String reglamento, Deporte deporte, Fixture fixture, Liga liga,
                       Usuario usuarioCreador, Vector<Posicion> tablaDePosiciones, LugarDeRealizacion[] lugares,
                       Participante[] participantes) {
        super();
        this.idCompetencia = idCompetencia;
        this.tantosPorPartidoGanado = tantosPorPartidoGanado;
        this.tantosPorPartidoAusenciaContrincante = tantosPorPartidoAusenciaContrincante;
        this.cantidadDeSets = cantidadDeSets;
        this.nombreCompetencia = nombreCompetencia;
        this.modalidad = modalidad;
        this.formaDePuntuacion = formaDePuntuacion;
        this.estado = estado;
        this.reglamento = reglamento;
        this.deporte = deporte;
        this.fixture = fixture;
        this.liga = liga;
        this.usuarioCreador = usuarioCreador;
        this.tablaDePosiciones = tablaDePosiciones;
        this.lugares = lugares;
        this.participantes = participantes;
    }

    public Competencia() {
        super();
        
    }

    public void agregarParticipante (Participante participante){}
    public void eliminarParticipante (Participante participante){}
    public void modificarParticipante(Participante participante){}


    public void setIdCompetencia(int idCompetencia) {
        this.idCompetencia = idCompetencia;
    }

    public int getIdCompetencia() {
        return idCompetencia;
    }

    public void setTantosPorPartidoGanado(int tantosPorPartidoGanado) {
        this.tantosPorPartidoGanado = tantosPorPartidoGanado;
    }

    public int getTantosPorPartidoGanado() {
        return tantosPorPartidoGanado;
    }

    public void setTantosPorPartidoAusenciaContrincante(int tantosPorPartidoAusenciaContrincante) {
        this.tantosPorPartidoAusenciaContrincante = tantosPorPartidoAusenciaContrincante;
    }

    public int getTantosPorPartidoAusenciaContrincante() {
        return tantosPorPartidoAusenciaContrincante;
    }

    public void setCantidadDeSets(int cantidadDeSets) {
        this.cantidadDeSets = cantidadDeSets;
    }

    public int getCantidadDeSets() {
        return cantidadDeSets;
    }

    public void setNombreCompetencia(String nombreCompetencia) {
        this.nombreCompetencia = nombreCompetencia;
    }

    public String getNombreCompetencia() {
        return nombreCompetencia;
    }

    public void setModalidad(String modalidad) {
        this.modalidad = modalidad;
    }

    public String getModalidad() {
        return modalidad;
    }

    public void setFormaDePuntuacion(String formaDePuntuacion) {
        this.formaDePuntuacion = formaDePuntuacion;
    }

    public String getFormaDePuntuacion() {
        return formaDePuntuacion;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getEstado() {
        return estado;
    }

    public void setReglamento(String reglamento) {
        this.reglamento = reglamento;
    }

    public String getReglamento() {
        return reglamento;
    }

    public void setDeporte(Deporte deporte) {
        this.deporte = deporte;
    }

    public Deporte getDeporte() {
        return deporte;
    }

    public void setFixture(Fixture fixture) {
        this.fixture = fixture;
    }

    public Fixture getFixture() {
        return fixture;
    }

    public void setLiga(Liga liga) {
        this.liga = liga;
    }

    public Liga getLiga() {
        return liga;
    }

    public void setUsuarioCreador(Usuario usuarioCreador) {
        this.usuarioCreador = usuarioCreador;
    }

    public Usuario getUsuarioCreador() {
        return usuarioCreador;
    }

    public void setTablaDePosiciones(Vector<Posicion> tablaDePosiciones) {
        this.tablaDePosiciones = tablaDePosiciones;
    }

    public Vector<Posicion> getTablaDePosiciones() {
        return tablaDePosiciones;
    }

    public void setLugares(LugarDeRealizacion[] lugares) {
        this.lugares = lugares;
    }

    public LugarDeRealizacion[] getLugares() {
        return lugares;
    }

    public void setParticipantes(Participante[] participantes) {
        this.participantes = participantes;
    }

    public Participante[] getParticipantes() {
        return participantes;
    }
}
