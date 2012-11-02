package ClasesGestores;

import ClasesLogicas.Localidad;
import ClasesLogicas.Usuario;

public class UsuarioGestor {
    public UsuarioGestor() {
        super();
    }
    public Usuario crearUsuario(){
        return new Usuario();}

    /**
     * @param correoElectronico
     * @param apellido
     * @param nombre
     * @param tipoDocumento
     * @param numeroDocumento
     * @param ciudad
     * @return
     */
    public Usuario modificarUsuario(String correoElectronico, String apellido, String nombre, String tipoDocumento,
                                 Integer numeroDocumento, Localidad ciudad){return new Usuario();}

    /**
     * @param correoElectronico
     * @param password
     * @return
     */
    public boolean loguearseUsuario(String correoElectronico, String password){
        return true;
        }
}
