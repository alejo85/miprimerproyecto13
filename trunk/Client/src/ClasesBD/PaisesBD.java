package ClasesBD;


import ClasesLogicas.Pais;

import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.Vector;


public class PaisesBD {
    public PaisesBD() {
        super();
    }
    
    
    public static Vector<Pais> obtenerPaises()  {
        Conexion conexion = new Conexion();
        Vector<Pais> paises = new Vector <Pais>();
        try {
            conexion.conectar();
        } catch (SQLException e) {
        }
        String consultasql;
        
        consultasql="select * from PAISES";
        
        ResultSet resultado=null;;

        try {
            resultado = conexion.consultar(consultasql);
        } catch (SQLException e) {
        }
        try {
            while (!resultado.next())
        {
            int codigo = resultado.getInt("ID");
            String nombre = resultado.getString("NOMBRE");
            Pais p = new Pais(codigo,nombre);
            paises.add(p);
        }
        } catch (SQLException e) {
        }
        conexion.cerrarConexion();
        return paises;
    }
    
    public Vector<Pais> obtenerPais(int idPais)  {
        Conexion conexion = new Conexion();
        Vector<Pais> paises = new Vector <Pais>();
        try {
            conexion.conectar();
        } catch (SQLException e) {
        }
        String consultasql;
        
        consultasql="select * from PAISES";
        
        ResultSet resultado=null;

        try {
            resultado = conexion.consultar(consultasql);
        } catch (SQLException e) {
        }
        try {
            while (resultado.next())
        {
            int codigo = resultado.getInt("ID");
            String nombre = resultado.getString("NOMBRE");
            Pais p = new Pais(codigo,nombre);
            paises.add(p);
        }
        } catch (SQLException e) {
        }
        conexion.cerrarConexion();
        return paises;
    }
}
