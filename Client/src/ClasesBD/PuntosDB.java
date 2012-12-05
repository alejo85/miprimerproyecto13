package ClasesBD;

import ClasesLogicas.Puntos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PuntosDB {
    public PuntosDB() {
        super();
    }
    public void crearPunto(Puntos puntos){}
    public static int guardarPunto(Puntos unPunto, int idResultado) throws SQLException {
            ResultSet resultado=null;
            Statement reglamento = Conexion.consultar();
            Statement retornoEmpate = Conexion.consultar();
            Statement consulta = Conexion.consultar();
            //conexion.conectar();
            //  System.out.println("llega conecta conexion");
            String consultasql;
            int id=0;
          
                            //System.out.println(competencia.getModalidad());
                            consultasql="INSERT INTO punto(punto_a, punto_b, id_resultado)VALUES ( '"+unPunto.getPuntoA()+"', '"+unPunto.getPuntoB()+"', '"+idResultado+"')RETURNING id_punto;";
                            //System.out.println(consultasql);
                            resultado = reglamento.executeQuery(consultasql);
                 
   
            //System.out.println("sale al regla no null");
            resultado.next();
            //System.out.println("despues del next");
            id = resultado.getInt("id_Competencia");
            return id;
        }
}
