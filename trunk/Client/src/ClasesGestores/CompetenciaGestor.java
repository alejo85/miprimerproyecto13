package ClasesGestores;

import ClasesLogicas.Competencia;
import ClasesLogicas.Deporte;
import ClasesLogicas.LugarDeRealización;
import ClasesLogicas.Usuario;

public class CompetenciaGestor {
    public CompetenciaGestor() {
        super();
    }
    public Competencia crearCompetencia(Usuario usuarioCreador, String nombreDeCompetencia, String modalidad, String formaDePuntuacion, String estado, String reglamento,Deporte deporte, LugarDeRealización[] lugares ){
        return new Competencia();
        }
    public void eliminarCompetencia(Competencia competenciaAEliminar){

        }
    public void modificarCompetencia(Competencia competenciaAModificar, String nombreDeCompetencia, String modalidad, String formaDePuntuacion, String estado, String reglamento,Deporte deporte, LugarDeRealización[] lugares  ){
    
        }
    public void buscarCompetencia(String  nombre, Deporte deporte, String modalidad, String estado){
             
        }
    public void buscarCompetencia(String nombre, Usuario usuario){
     
        }
    public void instanciarCompetencia(Usuario usuarioCreador, String nombreDeCompetencia, String modalidad, String formaDePuntuacion, String estado, String reglamento,Deporte deporte, LugarDeRealización[] lugares ){
     
        }
    public void organizarPosiciones(int IDcompetencia){
        
        }
    public void crearTabla(int IDcompetencia){
        
        }
}
