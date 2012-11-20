package ClasesGestores;


import ClasesBD.DeportesDB;
import ClasesBD.LugarDeRealizaciónDB;

import ClasesLogicas.Deporte;
import ClasesLogicas.LugarDeRealizacion;
import ClasesLogicas.LugarDeRealización;
import ClasesLogicas.Usuario;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;


public class LugaresDeRealizacionGestores {
    public LugaresDeRealizacionGestores() {
        super();
    }

    /**
     * @param codigo
     * @param Nombre
     * @param descripcion
     * @param disponibilidad
     * @param deportesAsociados
     * @return
     */
    public LugarDeRealización altaLugaresDeRealizacion(String codigo, String Nombre, String descripcion, int disponibilidad,
                              Deporte[] deportesAsociados){
        return new LugarDeRealización( codigo,  Nombre,  descripcion,  disponibilidad, deportesAsociados);}

    /**
     * @param codigo
     */
    public void bajaLugarDeRealizacion(String codigo){}

    /**
     * @param codigo
     */
    public void disminuirDisponibilidad(String codigo){}

    /**
     * @param codigo
     */
    public void asociarDeporte(String codigo){}

    /**
     * @param codigo
     */
    public void eliminarDeporte(String codigo){}

    /**
     * @param codigoDeporte
     * @return
     */
    public static Vector<LugarDeRealizacion> lugaresDeRealizaciónAsociadosAlDeporte(String correoElectronico, int codigoDeporte) throws SQLException {
            Vector<LugarDeRealizacion> resultado = new Vector<LugarDeRealizacion>();
        
                
            
            String nombre,Codigo;
            int id, id_Lugar_de_Realizacion;
            ResultSet resultadoSQL;
            resultadoSQL = LugarDeRealizaciónDB.buscarLugarDeRealización(correoElectronico, codigoDeporte);
           
      
            LugarDeRealizacion unLugar;



        
                while (resultadoSQL.next()){
                    id = resultadoSQL.getInt("id_Lugar_de_Realizacion");
                    nombre = resultadoSQL.getString("Nombre");
                    unLugar = new LugarDeRealizacion();
                    unLugar.setIdLugar(id);
                    unLugar.setNombre(nombre);
                    resultado.add(unLugar);

            
                }
            
       
        
        
        
                 
        
        
        return resultado;
        }
    public static LugarDeRealización unLugar(LugarDeRealización [] lugares){
            int i;
        do{
               i = (int)(Math.random()*(lugares.length));
            
            }
        while(lugares[i].getDisponibilidad()>0);
            lugares[i].menosDisponibilidad();
  
        
        return lugares[i];
        }

    /**
     * @param codigo
     * @param nombre
     * @param descripcion
     * @param dSeleccionados
     * @param creado
     * @throws SQLException
     */
    public static void altaLugar(String codigo, String nombre, String descripcion,Vector <Deporte> dSeleccionados, Usuario creado)throws SQLException{
            java.util.Date fecha = new Date();
            String dia = ""+fecha.getDay()+"/"+fecha.getMonth()+"/"+fecha.getYear();
            String hora= ""+fecha.getHours()+":"+fecha.getMinutes();
            LugarDeRealizaciónDB.altaLugarDeRealización( codigo,  nombre, descripcion, dSeleccionados,  creado.getCorreoElectronico(),  dia,  hora);
            
        }

}
