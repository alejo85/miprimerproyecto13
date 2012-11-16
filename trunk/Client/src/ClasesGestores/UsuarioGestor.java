package ClasesGestores;

import ClasesBD.UsuarioDB;

import ClasesLogicas.Localidad;
import ClasesLogicas.Logueo;
import ClasesLogicas.Usuario;

import com.sun.org.apache.bcel.internal.generic.NEW;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioGestor {
    public static Object crearUsuario;

    public UsuarioGestor() {
        super();
    }
    
    public static Usuario crearUsuario(String correoElectronico, String apellido, String nombre, String tipoDocumento,int numeroDocumento,Localidad ciudad, String  contraseņa){
            Usuario usuario= new Usuario();
            usuario.setCorreoElectronico(correoElectronico);
            usuario.setApellido(apellido);
            usuario.setNombre(nombre);
            usuario.setTipoDocumento(tipoDocumento);
            usuario.setNumeroDocumento(numeroDocumento);
            usuario.setCiudad(ciudad);

        try {
            UsuarioDB.registrarUsuario(usuario,contraseņa);
        } catch (SQLException e) {//todo xception sql
        System.out.println(e.getMessage());
        }
        return usuario;
    }

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
     * @param contraseņa
     * @return
     */
    public static Usuario loguearseUsuario(String correoElectronico, String contraseņa){
        Usuario uss= null;

            ResultSet resultado=null;
            System.out.println(correoElectronico);
            System.out.println(contraseņa);
        try {
            
            resultado = UsuarioDB.autentica(correoElectronico, contraseņa);
        } catch (SQLException e) {//todo
        System.out.println(e.getMessage());
        }

           
        try {
            resultado.next();
            if(resultado.next()){
               return uss;
            }
            else{
               uss= new Usuario();
               int id = resultado.getInt("id_usuario");
           }
           
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            //todo
        }
            return uss;
        }

    
    public static Boolean existeUsuario(String correo) throws SQLException {

            return UsuarioDB.existeUsuario(correo);
      
    }
}
