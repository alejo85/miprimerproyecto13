package ClasesBD;


import ClasesLogicas.Localidad;
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
        
        consultasql="select * from Pais";
        
        ResultSet resultado=null;

        try {
            resultado = conexion.consultar(consultasql);
        } catch (SQLException e) {
        }
        try {
            while (resultado.next())
        {
            int codigo = resultado.getInt("id_pais");
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
        
        consultasql="select * from Pais";
        
        ResultSet resultado=null;

        try {
            resultado = conexion.consultar(consultasql);
        } catch (SQLException e) {
        }
        try {
            while (resultado.next())
        {
            int codigo = resultado.getInt("id_pais");
            String nombre = resultado.getString("NOMBRE");
            Pais p = new Pais(codigo,nombre);
            paises.add(p);
        }
        } catch (SQLException e) {
            //TODO
        }
        conexion.cerrarConexion();
        return paises;
    }
    
    public static Vector<Regiones> obtenerRegiones(int idPais) throws SQLException {
        Conexion conexion = new Conexion();
        Vector<Regiones> regiones = new Vector <Regiones>();
        conexion.conectar();
        String consultasql;
        
        consultasql="select * from REGION where ID_PAIS = " +idPais;
        
        ResultSet resultado = conexion.consultar(consultasql);

        while (resultado.next()) 
        {
            int id = resultado.getInt("id_region");

            String nombre = resultado.getString("NOMBRE");
            Regiones p = new Regiones(id, idPais,nombre);
            regiones.add(p);
        }
      
        conexion.cerrarConexion();
        return regiones;
    }
    public  static Vector<Localidad> obtenerLocalidades(int idRegion) throws SQLException {
        Conexion conexion = new Conexion();
        Vector<Localidad> localidades = new Vector <Localidad>();
        conexion.conectar();
        String consultasql;
        
        consultasql="select * from ciudad where ID_REGION = " +idRegion;
        
        ResultSet resultado = conexion.consultar(consultasql);

        while (resultado.next()) 
        {
            int id = resultado.getInt("id_ciudad");
            String nombre = resultado.getString("NOMBRE");
            Localidad p = new Localidad(id, idRegion,nombre);
            localidades.add(p);
        }
        conexion.cerrarConexion();
        return localidades;
    }
}
