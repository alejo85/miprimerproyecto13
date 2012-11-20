package ClasesBD;


import ClasesLogicas.Deporte;
import ClasesLogicas.LugarDeRealización;

import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.Vector;


public class LugarDeRealizaciónDB {
    public LugarDeRealizaciónDB() {
        super();
    }
    public boolean buscarLugarDeRealización(String codigo, String nombreLugarDerealización,Deporte deporteSeleccionado ){
                       return true;}
    public static void altaLugarDeRealización(String codigo, String nombre,String descripcion, Vector <Deporte> dSeleccionados, String creado, String dia, String hora){
    
        Conexion conexion = new Conexion();
        ResultSet resultado=null;
        int idLugarDeRealizacion;
        try {
            conexion.conectar();
        } catch (SQLException f) {
            System.out.println(f.getMessage());
        }
        String consultasql;
        consultasql="INSERT INTO LUGAR_DE_REALIZACION(Codigo,Nombre, Descripcion) VALUES" +"('"+codigo+"','"+nombre+ "','" +descripcion +"');";

        try {
            resultado = conexion.consultar(consultasql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        conexion.cerrarConexion();
        idLugarDeRealizacion= idLugar();
        // CREANDO LA CONSULTA
        consultasql="INSERT INTO CREA(Creador,id_Lugar_de_Realizacion, Fecha, Hora) VALUES" +"('"+creado+"','"+idLugarDeRealizacion+ "','"+dia+ "','" +hora +"');";
        // CONSULTA EN BD
        try {
            conexion.conectar();
            resultado = conexion.consultar(consultasql);
        } catch (SQLException e) {
        }

        for(int i=0; i < dSeleccionados.size();i++){
            // CREANDO LA CONSULTA
            consultasql="INSERT INTO ASOCIADO(id_Lugar_de_Realizacion, id_Deporte ) VALUES" +"('"+idLugarDeRealizacion+ "','"+dSeleccionados.get(i).getIdDeporte()+"');";
            try {
                // CONSULTA EN BD
                resultado = conexion.consultar(consultasql);
            } catch (SQLException e) {
            }
        }
             conexion.cerrarConexion();
         
                                    
         }
    private static int idLugar(){
            Conexion conexion = new Conexion();
            ResultSet resultado=null;
            int id=0;
            String consultasql;
            consultasql="SELECT MAX(id_lugar_de_realizacion) FROM lugar_de_realizacion;";

        try {
            conexion.conectar();
            resultado = conexion.consultar(consultasql);
            resultado.next();

            id = resultado.getInt("max");
        } catch (SQLException e) {
        }
        
            conexion.cerrarConexion();
       return id;
        }
    public boolean existeLugarDeRealización(String nombreLugarDerealización){
                       return true;}
    public boolean modificarLugarDeRealización(LugarDeRealización lugar){
                       return true;}
    public boolean eliminarLugarDeRealización(LugarDeRealización lugar){
                       return true;}
    public static ResultSet buscarLugarDeRealización(String correoElectronico,int idDeporteSeleccionado ){
                           ResultSet resultado=null;
                       
                       
                       return resultado;
                       
                       }

}
