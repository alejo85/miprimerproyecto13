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
            ResultSet resultado=null;
            String consultasql;
            consultasql="INSERT INTO usuario(correo, pass, apellido, nombre, tipo_documento, numero_documento,id_ciudad) VALUES" +
                "('"+usuario.getCorreoElectronico() +"','"+contraseña+ "','" +usuario.getApellido() +"','" +usuario.getNombre() +
                        "','" +usuario.getTipoDocumento() +"','"+ usuario.getNumeroDocumento() +"','" +usuario.getCiudad().getCodigo() +"');";
         
         resultado = Conexion.consulta.executeQuery(consultasql);
            return resultado;
     }
    public static Boolean existeUsuario(String correo) throws SQLException {
         String consultasql;
         consultasql="select correo from usuario where correo='"+correo+"'";
        ResultSet resultado = Conexion.consulta.executeQuery(consultasql); 
         resultado.next();
         if(resultado.getString("correo").equals(correo)){
             return true;
         }
         else{
             return true;
         }
    }
    public static ResultSet autentica(String correo, String contraseña) throws SQLException {
            String consultasql;
            consultasql="select * from Usuario where correo = '" +correo + "' and pass = '"+contraseña+"'";
            ResultSet resultado = Conexion.consulta.executeQuery(consultasql);
            return resultado;
    }
}
