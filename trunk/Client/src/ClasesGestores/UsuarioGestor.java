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
    public Usuario crearUsuario(String correoElectronico, String apellido, String nombre, String tipoDocumento,Integer numeroDocumento,Localidad ciudad, String contraseña){
            Usuario usuario= new Usuario;
            usuario.setCorreoElectronico(correoElectronico);
            usuario.setApellido(apellido);
            usuario.setNombre(nombre);
            usuario.setTipoDocumento(tipoDocumento);
            usuario.setNumeroDocumento(numeroDocumento);
            usuario.setCiudad(ciudad);

        try {
            UsuarioDB.registrarUsuario(usuario,contraseña);
        } catch (SQLException e) {//todo xception sql
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
     * @param contraseña
     * @return
     */
    public static Usuario loguearseUsuario(String correoElectronico, String contraseña){
        Usuario uss= null;

            ResultSet resultado=null;

        try {
            resultado = UsuarioDB.autentica(correoElectronico, contraseña);
        } catch (SQLException e) {//todo
        System.out.println(e.getMessage());
        }


        try {
            if(resultado.getRow()!=0)
            {
                uss= new Usuario();
                int id = resultado.getInt("id_usuario");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            //todo
        }
        return uss;
        }
}
