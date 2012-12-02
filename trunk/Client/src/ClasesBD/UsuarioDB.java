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
    
    public static ResultSet registrarUsuario(Usuario usuario, String  contraseña) throws SQLException {
            //Conexion conexion = new Conexion();
            ResultSet resultado=null;
            //conexion.conectar();
            String consultasql;
            consultasql="INSERT INTO usuario(correo, pass, apellido, nombre, tipo_documento, numero_documento,id_ciudad) VALUES" +
                "('"+usuario.getCorreoElectronico() +"','"+contraseña+ "','" +usuario.getApellido() +"','" +usuario.getNombre() +
                        "','" +usuario.getTipoDocumento() +"','"+ usuario.getNumeroDocumento() +"','" +usuario.getCiudad().getCodigo() +"');";
         
         resultado = Conexion.consulta.executeQuery(consultasql);
         //conexion.cerrarConexion();
            return resultado;
     }
    public static Boolean existeUsuario(String correo) throws SQLException {
         //Conexion conexion = new Conexion();
         //conexion.conectar();
         String consultasql;
         consultasql="select correo from usuario where correo='"+correo+"'";
        ResultSet resultado = Conexion.consulta.executeQuery(consultasql); 
         resultado.next();
        //conexion.cerrarConexion();
         if(resultado.getString("correo").equals(correo)){
             return true;
         }
         else{
             return true;
         }
    }
    public static ResultSet autentica(String correo, String contraseña) throws SQLException {
            //Conexion conexion = new Conexion();
            //conexion.conectar();
            String consultasql;
            consultasql="select * from Usuario where correo = '" +correo + "' and pass = '"+contraseña+"'";
            ResultSet resultado = Conexion.consulta.executeQuery(consultasql);
            //conexion.cerrarConexion();
            return resultado;
    }
    public Boolean actualizarUsuario(Usuario usuario){return true;}
    public Boolean esNuevo(Usuario usuario){return true;}
}
