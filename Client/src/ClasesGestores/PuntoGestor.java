package ClasesGestores;

import ClasesBD.Conexion;

import ClasesBD.PuntosDB;

import ClasesBD.ResultadodB;

import ClasesLogicas.Puntos;

import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.Vector;

public class PuntoGestor {
    public PuntoGestor() {
        super();
    }
    public static Puntos crearPunto(Puntos unPunto, int idResultado){
        Puntos unPuntoRetorno = new Puntos();
        try {
            unPuntoRetorno.setIdPunto(ResultadodB.guardarPunto(unPunto, idResultado));
            unPuntoRetorno.setPuntoA(unPunto.getPuntoA());
            unPuntoRetorno.setPuntoB(unPunto.getPuntoB());
        } catch (SQLException e) {
        }
        return unPuntoRetorno;
        }
    public static Puntos[] getPuntos(int idResultado){
            Puntos[] unRetorno=null;
            Vector <Puntos> unVector = new Vector <Puntos>();
            ResultSet busqueda=null;


        try {
            busqueda = PuntosDB.buscarPuntos(idResultado);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        try {
            while(busqueda.next()){
                Puntos elPunto= new Puntos();
                elPunto.setIdPunto(busqueda.getInt("id_punto"));
                elPunto.setPuntoA(busqueda.getInt("punto_a"));
                elPunto.setPuntoB(busqueda.getInt("punto_b"));
                unVector.add(elPunto);


            }
            unRetorno=new Puntos[unVector.size()];
            for(int i=0; i<unVector.size();i++)
                unRetorno[i]=unVector.get(i);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return unRetorno;
        }
   
}
