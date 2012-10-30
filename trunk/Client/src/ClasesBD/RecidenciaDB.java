package ClasesBD;


import ClasesLogicas.Pais;
import ClasesLogicas.Regiones;

import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.Vector;


public class RecidenciaDB {
    public RecidenciaDB() {
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
    
    public static Vector<Regiones> obtenerRegiones(int idPais) throws SQLException {
        Conexion conexion = new Conexion();
        Vector<Regiones> regiones = new Vector <Regiones>();
        conexion.conectar();
        String consultasql;
        
        consultasql="select * from REGIONES where ID_PAIS = " +idPais;
        
        ResultSet resultado = conexion.consultar(consultasql);

        while (resultado.next()) 
        {
            int id = resultado.getInt("ID");

            String nombre = resultado.getString("NOMBRE");
            Regiones p = new Regiones(id, idPais,nombre);
            regiones.add(p);
        }
        conexion.cerrarConexion();
        return regiones;
    }
}
