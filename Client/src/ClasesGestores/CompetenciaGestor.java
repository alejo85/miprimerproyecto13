package ClasesGestores;


import ClasesLogicas.Competencia;
import ClasesLogicas.Deporte;
import ClasesLogicas.LugarDeRealización;
import ClasesLogicas.Posicion;
import ClasesLogicas.Usuario;

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
    public void altaCompetencia(Usuario usuarioCreador, String nombreDeCompetencia, String modalidad, String formaDePuntuacion, String estado, String reglamento,Deporte deporte, LugarDeRealización[] lugares ){
        
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
    public void modificarCompetencia(int idCompetencia, Usuario usuarioCreador, String nombreDeCompetencia, String modalidad, String formaDePuntuacion, String estado, String reglamento,Deporte deporte, LugarDeRealización[] lugares ){
        
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
    public void modificarCompetencia(Competencia competenciaAModificar, String nombreDeCompetencia, String modalidad, String formaDePuntuacion, String estado, String reglamento,Deporte deporte, LugarDeRealización[] lugares  ){
    
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
    public void instanciarCompetencia(Usuario usuarioCreador, String nombreDeCompetencia, String modalidad, String formaDePuntuacion, String estado, String reglamento,Deporte deporte, LugarDeRealización[] lugares ){
     
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
    public boolean validadNombreParticipante(String nombreDelParticipante){
        return true;
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
    public void generarFixture(ClasesLogicas.Competencia competenci){
        
        }

    /**
     * @param tabla
     */
    public void exportarTabla(Posicion[]tabla){}

    /**
     * @param tabla
     */
    public void impimirTabla(Posicion[]tabla){}
    
}
