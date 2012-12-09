package ClasesBD;

import ClasesLogicas.Localidad;
import ClasesLogicas.Puntos;
import ClasesLogicas.Resultados;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.sql.Statement;
public class ResultadodB {
    public ResultadodB() {
        super();
    }
    public static int  guardarResultado(Resultados unresultado,String fecha,String hora) throws SQLException {
        Statement reglamento = Conexion.consultar();
        ResultSet resultado=null;
        String consultasql;
            consultasql="INSERT INTO resultado( fecha, hora)\n" + 
            "    VALUES ('"+ fecha+"','"+ hora+"')RETURNING id_resultado;";
            //System.out.println(consultasql);
            resultado = reglamento.executeQuery(consultasql);
            resultado.next();
            return resultado.getInt("id_resultado");
        }
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
            id = resultado.getInt("id_punto");
            return id;
        }
}
