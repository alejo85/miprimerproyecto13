package ClasesBD;

import ClasesLogicas.Regiones;
import ClasesLogicas.Usuario;

import java.sql.ResultSet;

import java.sql.SQLException;

import java.util.Vector;

public class UsuarioDB {
    public UsuarioDB() {
        super();
    }
    public Boolean esNuevo(Usuario usuario){
                       return true;}
    public static ResultSet registrarUsuario(Usuario usuario, String contrase�a) throws SQLException {
            Conexion conexion = new Conexion();
            conexion.conectar();
            String consultasql;
            // DEBEMOS AGRERGAR LA CIUDAD...
            consultasql="INSERT INTO usuario(correo, pass, apellido, nombre, tipo_documento, numero_documento,id_ciudad) VALUES ("+usuario.getCorreoElectronico() +"," +"?," +contrase�a+"," +usuario.getNombre() +"," +usuario.getTipoDocumento() +","+ usuario.getNumeroDocumento() +"," +usuario.getCiudad().getCodigo() +");";
            System.out.println(consultasql);
            return conexion.consultar(consultasql);
     }
    public Boolean existeUsuario(String correo) throws SQLException {
         Conexion conexion = new Conexion();
         conexion.conectar();
         String consultasql;
         consultasql="select correo from usuario where correo="+correo;
         ResultSet resultado = conexion.consultar(consultasql);        
         if(resultado.getString("correo").equals(correo)){
             return true;
         }
         else{
             return false;
         }
    }
                          
    public Boolean existeUsuarioContrase�a(String contrase�a){
                       return true;}
    public Boolean actualizarUsuario(Usuario usuario){
                       return true;}
    public static ResultSet autentica(String correo, String contrase�a) throws SQLException {
            Conexion conexion = new Conexion();
            conexion.conectar();
            String consultasql;
            consultasql="select * from Usuario where correo = '" +correo + "' and pass = '"+contrase�a+"'";
        return conexion.consultar(consultasql);
}
}
