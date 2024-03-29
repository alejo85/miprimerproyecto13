package ClasesGestores;


import ClasesBD.UsuarioDB;

import ClasesLogicas.Localidad;
import ClasesLogicas.Usuario;

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
        } catch (SQLException e) {//todo
        
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
        Usuario usuario= null;
        ResultSet resultado=null;
        try {
            resultado = UsuarioDB.autentica(correoElectronico, contraseņa);
            resultado.next();
        } catch (SQLException e) {
        }
        
       
       
        
        try {
            if(resultado.getString("correo").equals(correoElectronico)){
                usuario= new Usuario();
                usuario.setCorreoElectronico(resultado.getString("correo"));
                usuario.setApellido(resultado.getString("Apellido"));
                usuario.setNombre(resultado.getString("Nombre"));
                /* FALTA INSTANCIAR EL OBJETO COMPLETO*/
            }
           
        } catch (SQLException f) {
            System.out.println(f.getMessage());
        }
            return usuario;
        }

    
    public static Boolean existeUsuario(String correo) throws SQLException {

              return UsuarioDB.existeUsuario(correo);
       
      }

}
