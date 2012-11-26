package ClasesBD;


import ClasesLogicas.Fixture;
import ClasesLogicas.Ronda;

import java.sql.ResultSet;
import java.sql.SQLException;

public class FixtureDB {
    public FixtureDB() {
        super();
    }
    public boolean registrarFixture(Fixture fixture){
                       return true;}
    public static int idFixture(int idCompetencia) throws SQLException {
                           System.out.println("llego a la base idFixture");
                           int idFixture=0;
                           Conexion conexion = new Conexion();
                           ResultSet resultado=null;
                           conexion.conectar();
                           String consultasql;
                           //INSERT INTO participante( nombre, correo)VALUES ('nombre', 'correo')RETURNING id_Participante;
                           consultasql="INSERT INTO fixture( id_competencia) VALUES ( '"+idCompetencia+"')RETURNING id_fixture;";
                           resultado=conexion.consultar(consultasql);
                           resultado.next();
                           System.out.println("despues del next idFixture");
                           idFixture = resultado.getInt("id_fixture");
                           return idFixture;
                       
                       }
    public static int getIdFixture(int idCompetencia) throws SQLException {
                           System.out.println("llego a la base idFixture");
                           int idFixture=0;
                           Conexion conexion = new Conexion();
                           ResultSet resultado=null;
                           conexion.conectar();
                           String consultasql;
                           //INSERT INTO participante( nombre, correo)VALUES ('nombre', 'correo')RETURNING id_Participante;
                           consultasql="SELECT id_fixture, id_competencia FROM fixture where id_competencia='"+idCompetencia+"';";
                           resultado=conexion.consultar(consultasql);
                           resultado.next();
                           System.out.println("despues del next idFixture");
                           idFixture = resultado.getInt("id_fixture");
                           return idFixture;
                       
                       }
    public boolean reemplazarFixture(Fixture fixture){
                       return true;}
    public boolean buscarFixture(int idFixture){
                       return true;}
    public static int guardarSubronda() throws SQLException {
        
            System.out.println("llego a la base idSubRonda");
            int idSubRonda=0;
            Conexion conexion = new Conexion();
            ResultSet resultado=null;
            conexion.conectar();
            String consultasql;
            
            consultasql="INSERT INTO subronda(estado)VALUES ('false')RETURNING id_subronda;";
            resultado=conexion.consultar(consultasql);
            resultado.next();
            System.out.println("despues del next idSubRonda");
            idSubRonda = resultado.getInt("id_subronda");
            return idSubRonda;
        
        }
    public static int guardarRonda(Ronda ronda,int idFixture) throws SQLException {
        
            System.out.println("llego a la base id_ronda");
            int idSubRonda=0;
            Conexion conexion = new Conexion();
            ResultSet resultado=null;
            conexion.conectar();
            String consultasql;
            
            consultasql="INSERT INTO ronda(numeroronda, id_subronda_ganadores, id_fixture)VALUES ('"+ronda.getNumeroDeRonda()+"', '"+ronda.getGanadores().getIdSubronda()+"', '"+idFixture+"')RETURNING id_ronda;";
            System.out.println(consultasql);
            resultado=conexion.consultar(consultasql);
            resultado.next();
            System.out.println("despues del next id_ronda");
            idSubRonda = resultado.getInt("id_ronda");
            System.out.println("despues del id_ronda"+idSubRonda);
            return idSubRonda;
        
        }
    public static ResultSet buscarRonda(int idFixture) throws SQLException {
        
            System.out.println("llego a la base id_ronda");

            Conexion conexion = new Conexion();
            ResultSet resultado=null;
            conexion.conectar();
            String consultasql;
            
            consultasql="SELECT id_ronda, numeroronda, id_subronda_ganadores, id_subronda_perdedores, id_fixture FROM ronda where id_fixture='"+idFixture+"' ;";
            System.out.println(consultasql);
            resultado=conexion.consultar(consultasql);
            conexion.cerrarConexion();
            return resultado;
        
        }
    public static ResultSet buscarSubRonda(int idSubRonda) throws SQLException {
        
            System.out.println("llego a la base id_ronda");

            Conexion conexion = new Conexion();
            ResultSet resultado=null;
            conexion.conectar();
            String consultasql;
            
            consultasql="SELECT id_subronda, estado FROM subronda where id_subronda='"+idSubRonda+"';";
            System.out.println(consultasql);
            resultado=conexion.consultar(consultasql);
            conexion.cerrarConexion();
            return resultado;
        
        }
}
