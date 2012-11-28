package ClasesGestores;


import ClasesBD.CompetenciaDB;

import ClasesLogicas.Competencia;
import ClasesLogicas.Deporte;
import ClasesLogicas.Encuentro;
import ClasesLogicas.Fixture;
import ClasesLogicas.LugarDeRealizacion;
import ClasesLogicas.Participante;
import ClasesLogicas.Posicion;
import ClasesLogicas.Subronda;
import ClasesLogicas.Usuario;

import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.Vector;

import javax.swing.ImageIcon;


public class CompetenciaGestor {
    public CompetenciaGestor() {
        super();
    }

    /**
     * @param usuarioCreador
     * @param nombreDeCompetencia
     * @param modalidad
     * @param formaDePuntuacion
     * @param estado
     * @param reglamento
     * @param deporte
     * @param lugares
     */
    public static boolean altaCompetencia(Usuario usuarioCreador, String nombreDeCompetencia, String modalidad, String formaDePuntuacion, String estado, String reglamento,Deporte deporte, Vector<LugarDeRealizacion> lugaresSeleccionado,boolean empate, int puntosPorPartidoGanados, int puntosPorPartidoEmpatado, int puntosPorPartidoAsistido, int cantidadDeSets, int tantosPorPartidoAusenciaContrincante){
            Competencia unaCompetencia = new Competencia();
            unaCompetencia.setUsuarioCreador(usuarioCreador);
            unaCompetencia.setNombreCompetencia(nombreDeCompetencia);
            unaCompetencia.setModalidad(modalidad);
            unaCompetencia.setFormaDePuntuacion(formaDePuntuacion);
            unaCompetencia.setEstado(estado);
            unaCompetencia.setReglamento(reglamento);
            unaCompetencia.setDeporte(deporte);
            unaCompetencia.setLugares(lugaresDeRealizacion(lugaresSeleccionado));
            unaCompetencia.setLiga(LigaGestor.crearLiga(puntosPorPartidoGanados, empate, puntosPorPartidoEmpatado, puntosPorPartidoAsistido));
            unaCompetencia.setCantidadDeSets(cantidadDeSets);
            unaCompetencia.setTantosPorPartidoAusenciaContrincante(tantosPorPartidoAusenciaContrincante);
   //     System.out.println("crea la competencia");
        try {
            return CompetenciaDB.registrarCompetencia(unaCompetencia);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }
    private static  LugarDeRealizacion[] lugaresDeRealizacion(Vector<LugarDeRealizacion> lugaresSeleccionado){
           LugarDeRealizacion[] lugaresDeRealizacion= new LugarDeRealizacion[lugaresSeleccionado.size()];
        for(int i=0;i<lugaresSeleccionado.size(); i++){
            lugaresDeRealizacion[i]=lugaresSeleccionado.get(i);
            }
        return lugaresDeRealizacion;
        }
    

    /**
     * @param idCompetencia
     * @param usuarioCreador
     * @param nombreDeCompetencia
     * @param modalidad
     * @param formaDePuntuacion
     * @param estado
     * @param reglamento
     * @param deporte
     * @param lugares
     */
    public void modificarCompetencia(int idCompetencia, Usuario usuarioCreador, String nombreDeCompetencia, String modalidad, String formaDePuntuacion, String estado, String reglamento,Deporte deporte, LugarDeRealizacion[] lugares ){
        
        }

    /**
     * @param competenciaAEliminar
     */
    public void eliminarCompetencia(Competencia competenciaAEliminar){

        }

    /**
     * @param competenciaAModificar
     * @param nombreDeCompetencia
     * @param modalidad
     * @param formaDePuntuacion
     * @param estado
     * @param reglamento
     * @param deporte
     * @param lugares
     */
    public void modificarCompetencia(Competencia competenciaAModificar, String nombreDeCompetencia, String modalidad, String formaDePuntuacion, String estado, String reglamento,Deporte deporte, LugarDeRealizacion[] lugares  ){
    
        }

    /**
     * @param nombre
     * @param deporte
     * @param modalidad
     * @param estado
     */
    public void buscarCompetencia(String  nombre, Deporte deporte, String modalidad, String estado){
             
        }

    /**
     * @param nombre
     * @param usuario
     */
    public void buscarCompetencia(String nombre, Usuario usuario){
     
        }

    /**
     * @param usuarioCreador
     * @param nombreDeCompetencia
     * @param modalidad
     * @param formaDePuntuacion
     * @param estado
     * @param reglamento
     * @param deporte
     * @param lugares
     */
    public void instanciarCompetencia(Usuario usuarioCreador, String nombreDeCompetencia, String modalidad, String formaDePuntuacion, String estado, String reglamento,Deporte deporte, LugarDeRealizacion[] lugares ){
     
        }

    /**
     * @param IDcompetencia
     */
    public void organizarPosiciones(int IDcompetencia){
        
        }

    /**
     * @param IDcompetencia
     */
    public void crearTabla(int IDcompetencia){
        
        }

    /**
     * @param nombreDeCompetencia
     * @return
     */
    public boolean validadNombreCompetencia(String nombreDeCompetencia){
        return true;
        }

    /**
     * @param nombreDelParticipante
     * @return
     */
    public static boolean validadNombreParticipante(String nombreDelParticipante, int idCompetencia){

        try {
            return CompetenciaDB.validadNombreParticipante( nombreDelParticipante,  idCompetencia);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    /**
     * @param corrreoDelParticipante
     * @return
     */
    public boolean validadCorreoParticipante(String corrreoDelParticipante){
        return true;
        }

    /**
     * @param competencia
     * @param usuario
     */
    public void verCompetencia(ClasesLogicas.Competencia competencia, ClasesLogicas.Usuario usuario ){
        
        }

    /**
     * @param usuario
     */
    public void altaCompetencia(ClasesLogicas.Usuario usuario ){
        
        }

    /**
     * @param participante
     */
    public void eliminarParticipante(ClasesLogicas.Participante participante ){
        
        }

    /**
     * @param nombre
     * @param Correo
     * @param imagen
     */
    public void altaParticipante(String nombre, String Correo, ImageIcon imagen){
        
        }

    /**j
     * @param competenci
     */
    public static void generarFixture(ClasesLogicas.Competencia competencia){
        
        
        Participante[] participantes = competencia.getParticipantes();
        LugarDeRealizacion[] lugares = competencia.getLugares();
        String modalidad = competencia.getModalidad();
        Fixture fixture;
        
        switch (Modalidad.valueOf(modalidad)){
            
        //todo definir EN TODOS LADOS modalidad como Simple y Doble    
        case Liga:
            System.out.println("antes del gestor Fixture");
            fixture = FixtureGestor.generarFixture(lugares, participantes, participantes.length, competencia.getIdCompetencia());
            competencia.setFixture(fixture);
            CompetenciaDB.guardarFixture( obtenerEncuentros(obtenerSubRondas(competencia)));

            try {
                CompetenciaDB.actualizarEstado(competencia.getIdCompetencia(),"Planificada");
            } catch (SQLException e) {
            }
            break;
        
        case Simple:
            break;
        
        case Doble:
            break;
        
        default:
            break;
            
        }
           
                    
                    
    }
            
      
    private static Vector<Subronda> obtenerSubRondas(Competencia competencia){
            Vector<Subronda> retorno = new Vector<Subronda> ();
            for(int i=0; i<competencia.getFixture().getRondas().length;i++)
            {
                    System.out.println("Valor de I: "+i+" IdGanadores: "+competencia.getFixture().getRondas()[i].getGanadores().getIdSubronda());
                    retorno.add(competencia.getFixture().getRondas()[i].getGanadores());
                }
            
            
            return retorno;
        
        }
    private static Vector<Encuentro> obtenerEncuentros(Vector<Subronda> subrondas){
            Vector<Encuentro> retorno = new Vector<Encuentro> ();
        
            for(int i=0; i<subrondas.size();i++)
            {
                for(int j=0; j<subrondas.get(i).getEncuentros().length;j++){
                    System.out.println("Valor de I: "+i+"Valor de J: "+j+" IdEncuentro: "+subrondas.get(i).getEncuentros()[j].getIdEncuentro());
                    retorno.add(subrondas.get(i).getEncuentros()[j]);
                    }
                }
            
            System.out.println("Tamaño del Retorno:"+retorno.size());
            return retorno;
        
        }
    private static boolean validarDisponibilidad() {
        return false;
    }
    public static boolean validarNombreDeCompetencia(String nombre, String correo) throws SQLException {
        
        return CompetenciaDB.buscarCompetencia(nombre, correo);
    }
        
        
        

    /**
     * @param tabla
     */
    public void exportarTabla(Posicion[]tabla){}

    /**
     * @param tabla
     */
    public void impimirTabla(Posicion[]tabla){}
    
    public static Competencia buscarCompetencia(int idCompetencia)
    {
       


        Competencia unaCompetencia=new Competencia   ();
        Deporte unDeporte;
        
        int i=0;
        

        ResultSet consulta=null;

        try {
            consulta = CompetenciaDB.buscarCompetencias( idCompetencia);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        try {
            do
            {
                    //System.out.println("Se ejecuta el while:"+i);
                i++;
                unaCompetencia=new Competencia();
            int codigo = consulta.getInt("id_Competencia");
            String nombreCompetencia = consulta.getString("Nombre_Competencia");
                int deporteDeLaCompetencia = consulta.getInt("id_Deporte");
                String modalidadDeLaCompetencia = consulta.getString("Modalidad");
                String estadoDeLaCompetencia = consulta.getString("Estado");
                unDeporte=DeporteGestor.buscarDeporte(deporteDeLaCompetencia);
                unaCompetencia.setIdCompetencia(codigo);
                unaCompetencia.setNombreCompetencia(nombreCompetencia);
                unaCompetencia.setDeporte(unDeporte);
                unaCompetencia.setModalidad(modalidadDeLaCompetencia);
                unaCompetencia.setEstado(estadoDeLaCompetencia);
  
               
                

            }while (consulta.next());
            
            unaCompetencia.setParticipantes(ParticipanteGestor.instanciarParticipante(unaCompetencia.getIdCompetencia()));
            unaCompetencia.setLugares(LugaresDeRealizacionGestores.lugaresDeLaCompetencia(unaCompetencia.getIdCompetencia()));
            unaCompetencia.setFixture(FixtureGestor.retornarFixture(idCompetencia, unaCompetencia.getParticipantes()));
            
        } catch (SQLException e) {
            
            //todo hacer la exepcion correspondiente
        }
        
        
        
        
        
        
        
       
        return unaCompetencia;
    }
    
    
    
    public static Vector <Competencia>  buscarCompetencias(String nombre, int deporte, String modalidad,String estado,String correo){
        Vector <Competencia> competenciaEncontradas= new Vector <Competencia>();
        Competencia unaCompetencia=null;
        Deporte unDeporte;
        int i=0;
        

        ResultSet consulta=null;

        try {
            consulta = CompetenciaDB.buscarCompetencias( nombre,  deporte,  modalidad, estado, correo);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        try {
            do
            {
                   // System.out.println("Se ejecuta el while:"+i);
                i++;
                unaCompetencia=new Competencia();
            int codigo = consulta.getInt("id_Competencia");
            String nombreCompetencia = consulta.getString("Nombre_Competencia");
                int deporteDeLaCompetencia = consulta.getInt("id_Deporte");
                String modalidadDeLaCompetencia = consulta.getString("Modalidad");
                String estadoDeLaCompetencia = consulta.getString("Estado");
                unDeporte=DeporteGestor.buscarDeporte(deporteDeLaCompetencia);
                unaCompetencia.setIdCompetencia(codigo);
                unaCompetencia.setNombreCompetencia(nombreCompetencia);
                unaCompetencia.setDeporte(unDeporte);
                unaCompetencia.setModalidad(modalidadDeLaCompetencia);
                unaCompetencia.setEstado(estadoDeLaCompetencia);
                competenciaEncontradas.add(unaCompetencia);
               
                

            }while (consulta.next());
        } catch (SQLException e) {
            
            //todo hacer la exepcion correspondiente
        }
        return competenciaEncontradas;
        }
    
    
    public static enum Modalidad
    {
        Liga, Simple, Doble; 
    }

}
