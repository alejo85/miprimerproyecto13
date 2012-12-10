package ClasesGestores;


import ClasesBD.CompetenciaDB;
import ClasesBD.LigaDB;

import ClasesLogicas.Competencia;
import ClasesLogicas.Deporte;
import ClasesLogicas.Encuentro;
import ClasesLogicas.Fixture;
import ClasesLogicas.Liga;
import ClasesLogicas.LugarDeRealizacion;
import ClasesLogicas.Participante;
import ClasesLogicas.Posicion;
import ClasesLogicas.Puntuacion;
import ClasesLogicas.Ronda;
import ClasesLogicas.Set;
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
    // CONSTRUCTOR LIGA 
    // LIGA : 
    // PUNTOS POR PARTIDO GANADO
    // EMPATE -> PTOS POR PARTIDO EMPATADO
    // PTOS POR PRESENTARSE
    
    // FORMA DE PUNTUACION
    //  - SET --> MAXIMO DE SET
    // - PUNTUACION --> PTOS POR AUSENSIA DE CONTRINCANTE
    // - RESULTADO FINAL 
    public static Competencia altaCompetencia(Usuario usuarioCreador, String nombreDeCompetencia, String modalidad, String formaDePuntuacion,String reglamento,Deporte deporte, Vector<LugarDeRealizacion> lugaresSeleccionado,boolean empate,int ptos_partido_ganado,int ptos_partido_empatado,int ptos_por_asistido,int valor) throws SQLException {
        Competencia nuevaCompetencia = new Competencia();
        Liga nuevaLiga = new Liga();
        nuevaCompetencia.setUsuarioCreador(usuarioCreador);
        nuevaCompetencia.setNombreCompetencia(nombreDeCompetencia);
        nuevaCompetencia.setFormaDePuntuacion(formaDePuntuacion);
        nuevaCompetencia.setEstado("Creada");
        nuevaCompetencia.setModalidad(modalidad);
        nuevaCompetencia.setReglamento(reglamento);
        nuevaCompetencia.setDeporte(deporte);
        nuevaCompetencia.setLugares(lugaresDeRealizacion(lugaresSeleccionado));
        nuevaCompetencia.setFixture(null);

        System.out.println("KAKA");
        try {
            CompetenciaDB.registrarCompetencia(nuevaCompetencia);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("KAKA2");
        if(formaDePuntuacion.equals("Sets")){
            Set set= new Set();
            set.setCantidadSet(valor);
            CompetenciaDB.agregarFormaPuntuacionSet(set, nuevaCompetencia.getIdCompetencia());
            nuevaCompetencia.setFormaDePuntuacionSet(set);
        }
        else if(formaDePuntuacion.equals("Puntuación")){
            Puntuacion punt= new Puntuacion();
            punt.setPtosAusencia(valor);
            CompetenciaDB.agregarFormaPuntuacionPuntuacion(punt, nuevaCompetencia.getIdCompetencia());
            nuevaCompetencia.setFormaDePuntuacionPunt(punt);
        }
        System.out.println("KAKA2");
        //DISTINTOS CAMINOS EN FUNCION DE MODALIDAD
        nuevaLiga=LigaGestor.crearLiga(ptos_partido_ganado, empate, ptos_partido_empatado, ptos_por_asistido);
        try {
            LigaDB.registrarliga(nuevaLiga,nuevaCompetencia.getIdCompetencia());
        } catch (SQLException e) {//TODO
        }
        nuevaCompetencia.setLiga(nuevaLiga);
        return nuevaCompetencia;
        
    }
    
    
    
    // CONSTRUCTOR PARA ELIMINACION SIMPLE O DOBLE
    public static Competencia altaCompetencia(Usuario usuarioCreador, String nombreDeCompetencia, String modalidad, String formaDePuntuacion,String reglamento,Deporte deporte, Vector<LugarDeRealizacion> lugaresSeleccionado,int valor) throws SQLException {
        Competencia nuevaCompetencia = new Competencia();
        nuevaCompetencia.setUsuarioCreador(usuarioCreador);
        nuevaCompetencia.setNombreCompetencia(nombreDeCompetencia);
        nuevaCompetencia.setFormaDePuntuacion(formaDePuntuacion);
        nuevaCompetencia.setEstado("Creada");
        nuevaCompetencia.setReglamento(reglamento);
        nuevaCompetencia.setModalidad(modalidad);
        nuevaCompetencia.setDeporte(deporte);
        nuevaCompetencia.setLugares(lugaresDeRealizacion(lugaresSeleccionado));
        nuevaCompetencia.setFixture(null);
        System.out.println("MODALIDAD SIMPLE O DOBLE");
        try {
            CompetenciaDB.registrarCompetencia(nuevaCompetencia);
        } catch (SQLException e) {
        }
        if(formaDePuntuacion.equals("Sets")){
            Set set= new Set();
            set.setCantidadSet(valor);
            CompetenciaDB.agregarFormaPuntuacionSet(set, nuevaCompetencia.getIdCompetencia());
            nuevaCompetencia.setFormaDePuntuacionSet(set);
        }
        else if(formaDePuntuacion.equals("Puntuación")){
            Puntuacion punt= new Puntuacion();
            punt.setPtosAusencia(valor);
            CompetenciaDB.agregarFormaPuntuacionPuntuacion(punt, nuevaCompetencia.getIdCompetencia());
            nuevaCompetencia.setFormaDePuntuacionPunt(punt);
        }
        return nuevaCompetencia;
    }
    
    
    
    /*
     public static Competencia altaCompetencia(Usuario usuarioCreador, String nombreDeCompetencia, String modalidad, String formaDePuntuacion, String estado, String reglamento,Deporte deporte, Vector<LugarDeRealizacion> lugaresSeleccionado,boolean empate, int puntosPorPartidoGanados, int puntosPorPartidoEmpatado, int puntosPorPartidoAsistido, int cantidadDeSets, int tantosPorPartidoAusenciaContrincante){
                Competencia unaCompetencia = new Competencia();
                unaCompetencia.setUsuarioCreador(usuarioCreador);
                unaCompetencia.setNombreCompetencia(nombreDeCompetencia);
               
                if (modalidad.equals("Sistema de Liga"))
                    unaCompetencia.setModalidad("Liga");
                else if (modalidad.equals("Sistema de Eliminatoria Simple"))
                    unaCompetencia.setModalidad("Simple");
                else 
                    unaCompetencia.setModalidad("Doble");
                
                if(unaCompetencia.getModalidad().equals("Liga")){
                    unaCompetencia.setLiga(LigaGestor.crearLiga(puntosPorPartidoGanados, empate, puntosPorPartidoEmpatado, puntosPorPartidoAsistido));
                }
                
                unaCompetencia.setFormaDePuntuacion(formaDePuntuacion);
                unaCompetencia.setEstado(estado);
                unaCompetencia.setReglamento(reglamento);
                unaCompetencia.setDeporte(deporte);
                unaCompetencia.setLugares(lugaresDeRealizacion(lugaresSeleccionado));
                
                if(formaDePuntuacion.equals("Puntuación")){
                    unaCompetencia.setTantosPorPartidoAusenciaContrincante(tantosPorPartidoAusenciaContrincante);
                }
                else if(formaDePuntuacion.equals("Sets")){
                    unaCompetencia.setCantidadDeSets(cantidadDeSets);
                }
                
            try {
                return CompetenciaDB.registrarCompetencia(unaCompetencia);
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
            return unaCompetencia;
        }
     public static Competencia altaCompetencia(Usuario usuarioCreador, String nombreDeCompetencia, String modalidad, String formaDePuntuacion, String estado, String reglamento,Deporte deporte, Vector<LugarDeRealizacion> lugaresSeleccionado, int cantidadDeSets, int tantosPorPartidoAusenciaContrincante){
                Competencia unaCompetencia = new Competencia();
                unaCompetencia.setUsuarioCreador(usuarioCreador);
                unaCompetencia.setNombreCompetencia(nombreDeCompetencia);
                unaCompetencia.setModalidad(modalidad);
                unaCompetencia.setFormaDePuntuacion(formaDePuntuacion);
                unaCompetencia.setEstado(estado);
                unaCompetencia.setReglamento(reglamento);
                unaCompetencia.setDeporte(deporte);
                unaCompetencia.setLugares(lugaresDeRealizacion(lugaresSeleccionado));
                unaCompetencia.setCantidadDeSets(cantidadDeSets);
                unaCompetencia.setTantosPorPartidoAusenciaContrincante(tantosPorPartidoAusenciaContrincante);
            try {
                return CompetenciaDB.registrarCompetencia(unaCompetencia);
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
            return unaCompetencia;
        }
     */
    private static  LugarDeRealizacion[] lugaresDeRealizacion(Vector<LugarDeRealizacion> lugaresSeleccionado){
           LugarDeRealizacion[] lugaresDeRealizacion= new LugarDeRealizacion[lugaresSeleccionado.size()];
        for(int i=0;i<lugaresSeleccionado.size(); i++){
            lugaresDeRealizacion[i]=lugaresSeleccionado.get(i);
            }
        return lugaresDeRealizacion;
        }
    
    public static  Competencia reemplazarEncuentro(Competencia unaCompetencia, Encuentro unEncuentro, int ronda){
        //unaCompetencia.getFixture().getRondas()[ronda].getGanadores().remplazarEncuentro(unEncuentro);

        return unaCompetencia;
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
     * @param competencia
     */
    public static void eliminarFixtureDeCompetencia(Competencia competencia){
            Ronda [] rondas = competencia.getFixture().getRondas();
            for(int i=0; i<rondas.length;i++ ){
                Subronda sub = rondas[i].getGanadores();
                Encuentro[] encuentrosDeSubRonda=sub.getEncuentros();
                EncuentroGestor.eliminarEncuentros(encuentrosDeSubRonda);
                RondaGestor.eliminarRonda(competencia.getFixture().getIdFixture());
                FixtureGestor.eliminarFixture(competencia.getFixture().getIdFixture());
                RondaGestor.eliminarSubRonda(sub.getIdSubronda());
                }

        }
    public static int getCantidadMaximaDeSets(int idCompetencia){
           
           ResultSet consulta=null;
           int cantidadMaximaDeSet=0;
        try {
            consulta = CompetenciaDB.buscarCantidadMaximaDeSets(idCompetencia);
        } catch (SQLException e) {
        }
        try {
            while(consulta.next())
            {
                    cantidadMaximaDeSet=consulta.getInt("cantidad_de_sets");
                 
                }
        } catch (SQLException e) {
        }
        return cantidadMaximaDeSet;

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
    public static Vector<Posicion> crearTabla(int idCompetencia){
        
            Competencia competencia = buscarCompetencia(idCompetencia);
            Vector <Posicion> tabla = new Vector <Posicion>();
            int idTabla=0;
            Participante[] participantes = competencia.getParticipantes();
            Posicion unaPosicion;
                
            for(int i=0; i<participantes.length; i++){
                unaPosicion = new Posicion(0,i+1,0,0,0,0,0,0,0,participantes[i]);
            try {
                idTabla = CompetenciaDB.guardarPosicion(unaPosicion,idCompetencia);
            } catch (SQLException e) {
            }
            unaPosicion.setIdTabla(idTabla);
            tabla.add(unaPosicion);
        }
            
            return tabla;
            
            
        
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
        competencia.setFixture(new Fixture());
        String modalidad = competencia.getModalidad();
        Fixture fixture;
        
       
        switch (Modalidad.valueOf(modalidad)){
            
        //todo definir EN TODOS LADOS modalidad como Simple y Doble    
        case Liga:
            //System.out.println("antes del gestor Fixture");
            fixture = FixtureGestor.generarFixture(participantes, participantes.length, competencia.getIdCompetencia());
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
        competencia.setTablaDePosiciones(crearTabla(competencia.getIdCompetencia()));
           
                    
                    
    }
    public static void actualizarEstado(ClasesLogicas.Competencia competencia, String estado){
        
        competencia.setEstado(estado);


            try {
                CompetenciaDB.actualizarEstado(competencia.getIdCompetencia(),estado);
            } catch (SQLException e) {
            }

           
                    
                    
    }     
      
    private static Vector<Subronda> obtenerSubRondas(Competencia competencia){
            Vector<Subronda> retorno = new Vector<Subronda> ();
            for(int i=0; i<competencia.getFixture().getRondas().length;i++)
            {
                  //  System.out.println("Valor de I: "+i+" IdGanadores: "+competencia.getFixture().getRondas()[i].getGanadores().getIdSubronda());
                    retorno.add(competencia.getFixture().getRondas()[i].getGanadores());
                }
            
            
            return retorno;
        
        }
    private static Vector<Encuentro> obtenerEncuentros(Vector<Subronda> subrondas){
            Vector<Encuentro> retorno = new Vector<Encuentro> ();
        
            for(int i=0; i<subrondas.size();i++)
            {
                for(int j=0; j<subrondas.get(i).getEncuentros().length;j++){
                  //  System.out.println("Valor de I: "+i+"Valor de J: "+j+" IdEncuentro: "+subrondas.get(i).getEncuentros()[j].getIdEncuentro());
                    retorno.add(subrondas.get(i).getEncuentros()[j]);
                    }
                }
            
            //System.out.println("Tamaño del Retorno:"+retorno.size());
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
                String formaDePuntuacion = consulta.getString("Forma_Puntuacion");
                String estadoDeLaCompetencia = consulta.getString("Estado");
                unDeporte=DeporteGestor.buscarDeporte(deporteDeLaCompetencia);
                unaCompetencia.setIdCompetencia(codigo);
                unaCompetencia.setNombreCompetencia(nombreCompetencia);
                unaCompetencia.setDeporte(unDeporte);
                unaCompetencia.setModalidad(modalidadDeLaCompetencia);
                unaCompetencia.setEstado(estadoDeLaCompetencia);
                unaCompetencia.setFormaDePuntuacion(formaDePuntuacion);
  
               
                

            }while (consulta.next());
            unaCompetencia.setLiga(LigaGestor.recuperarliga(unaCompetencia.getIdCompetencia()));
            if(unaCompetencia.getFormaDePuntuacion().equals("Sets")){
                    //unaCompetencia.setCantidadDeSets(CompetenciaGestor.getCantidadMaximaDeSets(unaCompetencia.getIdCompetencia()));
                
            }
            if(unaCompetencia.getModalidad().equals("Liga"))
                unaCompetencia.setTablaDePosiciones(CompetenciaDB.getTablaDePosiciones(unaCompetencia.getIdCompetencia()));
            unaCompetencia.setParticipantes(ParticipanteGestor.instanciarParticipante(unaCompetencia.getIdCompetencia()));
            unaCompetencia.setLugares(LugaresDeRealizacionGestores.lugaresDeLaCompetencia(unaCompetencia.getIdCompetencia()));
            unaCompetencia.setFixture(FixtureGestor.retornarFixture(idCompetencia));
            
        } catch (SQLException e) {
            
            //todo hacer la exepcion correspondiente
        }
       
        
       
        return unaCompetencia;
    }
    
    
    
    public static Vector <Competencia>  buscarCompetencias(String nombre, int deporte, String modalidad,String estado,String correo){
        Vector <Competencia> competenciaEncontradas= new Vector <Competencia>();
        Competencia unaCompetencia=null;
        Deporte unDeporte;
        int i=0, codigo, deporteDeLaCompetencia;
        String modalidadDeLaCompetencia, estadoDeLaCompetencia, nombreCompetencia;
        
        
        
        ResultSet consulta=null;

        try {
            consulta = CompetenciaDB.buscarCompetencias( nombre,  deporte,  modalidad, estado, correo);
           // consulta.next();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        
        try {
            while(consulta.next())
            {
                   // System.out.println("Se ejecuta el while:"+i);
                //i++;
                unaCompetencia=new Competencia();
                if(!consulta.getString("Estado").equals("Eliminada")){
                        codigo = consulta.getInt("id_Competencia");
                        nombreCompetencia = consulta.getString("Nombre_Competencia");
                        deporteDeLaCompetencia = consulta.getInt("id_Deporte");
                        modalidadDeLaCompetencia = consulta.getString("Modalidad");
                        estadoDeLaCompetencia = consulta.getString("Estado");
                        unDeporte=DeporteGestor.buscarDeporte(deporteDeLaCompetencia);
                        unaCompetencia.setIdCompetencia(codigo);
                        unaCompetencia.setNombreCompetencia(nombreCompetencia);
                        unaCompetencia.setDeporte(unDeporte);
                        unaCompetencia.setModalidad(modalidadDeLaCompetencia);
                        unaCompetencia.setEstado(estadoDeLaCompetencia);
                        competenciaEncontradas.add(unaCompetencia);
                }
                
                

            }//while (consulta.next());
        } catch (SQLException e) {
            
            //todo hacer la exepcion correspondiente
        }
        System.out.println("");
        return competenciaEncontradas;
        }
    
    public static void actualizarResultados(Competencia competencia,Encuentro encuentro){
        
        Participante participanteA = encuentro.getParticipanteA();
        Participante participanteB = encuentro.getParticipanteB();
        
        int puntosEmpate=0;
        
        if (encuentro.getEmpate())
            puntosEmpate = competencia.getLiga().getPuntosPorPartidoEmpatado();
        
        for(int i=0; i < competencia.getParticipantes().length; i++){
            if (competencia.getTablaDePosiciones().get(i).getParticipante().getIdParticipante()==participanteA.getIdParticipante()){
                if (  (encuentro.getGanador()!=null) && (participanteA.getIdParticipante()==encuentro.getGanador().getIdParticipante())){
                     competencia.getTablaDePosiciones().get(i).setPuntos(competencia.getTablaDePosiciones().get(i).getPuntos()+ competencia.getLiga().getPuntosPorPartidoGanado()+competencia.getLiga().getPuntosPorPartidoAsistido() );
                     competencia.getTablaDePosiciones().get(i).setPartidosGanados(competencia.getTablaDePosiciones().get(i).getPartidosGanados()+1);
                    if (competencia.getModalidad().equals("Puntuacion") || competencia.getModalidad().equals("Sets")){
                        competencia.getTablaDePosiciones().get(i).setTantosAFavor(competencia.getTablaDePosiciones().get(i).getTantosAFavor() + encuentro.getResultado().getPuntosA());
                        competencia.getTablaDePosiciones().get(i).setTantosEncontra(competencia.getTablaDePosiciones().get(i).getTantosEncontra() + encuentro.getResultado().getPuntosB());
                    }
                    
                    
                     
                }
                else {
                    
                    if (encuentro.getAsistencia() == -1)
                       competencia.getTablaDePosiciones().get(i).setPuntos(competencia.getTablaDePosiciones().get(i).getPuntos() + competencia.getLiga().getPuntosPorPartidoAsistido()+ puntosEmpate);
                    else
                        competencia.getTablaDePosiciones().get(i).setPartidosPerdidos(competencia.getTablaDePosiciones().get(i).getPartidosPerdidos()+1);
                }
            }
            
            else if (competencia.getTablaDePosiciones().get(i).getParticipante().getIdParticipante()==participanteB.getIdParticipante()){
                if ((encuentro.getGanador()!=null) && (participanteB.getIdParticipante()==encuentro.getGanador().getIdParticipante())){
                        competencia.getTablaDePosiciones().get(i).setPuntos(competencia.getTablaDePosiciones().get(i).getPuntos()+ competencia.getLiga().getPuntosPorPartidoGanado()+competencia.getLiga().getPuntosPorPartidoAsistido() );
                        competencia.getTablaDePosiciones().get(i).setPartidosGanados(competencia.getTablaDePosiciones().get(i).getPartidosGanados()+1);
                         if (competencia.getModalidad().equals("Puntuacion") || competencia.getModalidad().equals("Sets")){
                             competencia.getTablaDePosiciones().get(i).setTantosAFavor(competencia.getTablaDePosiciones().get(i).getTantosAFavor() + encuentro.getResultado().getPuntosB());
                             competencia.getTablaDePosiciones().get(i).setTantosEncontra(competencia.getTablaDePosiciones().get(i).getTantosEncontra() + encuentro.getResultado().getPuntosA());
                        }   
                    
                }
                else {
                    
                    if (encuentro.getAsistencia() == 1)
                        competencia.getTablaDePosiciones().get(i).setPuntos(competencia.getTablaDePosiciones().get(i).getPuntos() + competencia.getLiga().getPuntosPorPartidoAsistido()+ puntosEmpate);
                    else
                        competencia.getTablaDePosiciones().get(i).setPartidosPerdidos(competencia.getTablaDePosiciones().get(i).getPartidosPerdidos()+1);
                }
           }
            
        
            
        }
        
        if (competencia.getModalidad().equals("Puntuacion")){
            
            
            
        }


     
            CompetenciaDB.eliminarPosiciones(competencia.getIdCompetencia());
      
        setTabla(competencia.getTablaDePosiciones(), competencia.getIdCompetencia());
    }
    
    public static enum Modalidad
    {
        Liga, Simple, Doble; 
    }
    
    public static void setTabla(Vector <Posicion> tabla, int idCompetencia){
        int idTabla=0;
      
                
            for(int i=0; i<tabla.size(); i++){
                
            try {
                idTabla = CompetenciaDB.guardarPosicion(tabla.get(i),idCompetencia);
            } catch (SQLException e) {
            }
            tabla.get(i).setIdTabla(idTabla);
            
        }
            
         
            
            
        
        }

}
