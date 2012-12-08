package ClasesBD;


import ClasesGestores.EncuentroGestor;

import ClasesLogicas.Encuentro;

import ClasesLogicas.Puntos;
import ClasesLogicas.Resultados;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.Date;


public class EncuentroDB {
    public EncuentroDB() {
        super();
    }

    /**
     * @param encuentro
     * @return
     */
    public Boolean registrarEncuentro(Encuentro encuentro){
                       return true;}

    /**j
     * @param encuentro
     */
    public static void actualizarEncuentro(Encuentro encuentro, String modalidad) throws SQLException {
            System.out.println("lleho a la base");
            ResultSet resultado=null;
            /*try {
                conexion.conectar();
            } catch (SQLException e) {
            }*/
            java.util.Date fecha = new Date();
            int dia = fecha.getDate();
            int mes = fecha.getMonth() + 1;
            int anio = fecha.getYear() + 1900;
            int hora = fecha.getHours();
            int min = fecha.getMinutes();
            String horas;
            
            if (min < 10)
            {
                horas= ""+hora+":"+"0" + min;
                
            }
            String dias = ""+dia+"/"+mes+"/"+anio;
            horas = ""+hora+":"+ min;
            String consultasql;
            try {
                   
                  
                if(modalidad.equals("Resultado Final"))
                {
                    if(encuentro.getEmpate()){
                            consultasql="UPDATE encuentro\n" + 
                            "   SET fecha_resultado='"+dias+"', hora_resultado='"+horas+"',empate='"+encuentro.getEmpate()+"',asistencia='"+encuentro.getAsistencia()+"'\n" + 
                            " WHERE id_encuentro='"+encuentro.getIdEncuentro()+"'RETURNING *;";
                            
                            System.out.println(consultasql);
                            resultado = Conexion.consulta.executeQuery(consultasql);
                        }
                    else
                    {
                        
                            if(encuentro.getAsistencia()==0)
                            {
                                    consultasql="UPDATE encuentro\n" + 
                                    "   SET  id_participante_ganador='"+encuentro.getGanador().getIdParticipante()+"', id_participante_perdedor='"+encuentro.getPerdedor().getIdParticipante()+"', \n" + 
                                    "       fecha_resultado='"+dias+"', hora_resultado='"+horas+"',asistencia='"+encuentro.getAsistencia()+"'" + 
                                    " WHERE id_encuentro='"+encuentro.getIdEncuentro()+"'RETURNING *;";
                                    System.out.println(consultasql);
                                    resultado = Conexion.consulta.executeQuery(consultasql);
                                
                                }
                            else
                            {
                                    consultasql="UPDATE encuentro\n" + 
                                    "   SET fecha_resultado='"+dias+"', hora_resultado='"+horas+"',asistencia='"+encuentro.getAsistencia()+"'\n" + 
                                    " WHERE id_encuentro='"+encuentro.getIdEncuentro()+"'RETURNING *;";
                                    System.out.println(consultasql);
                                    resultado = Conexion.consulta.executeQuery(consultasql);
                                
                                }
                        }
                      
                        
                       
                       
                    }
                if(modalidad.equals("Puntuación"))
                {
                        if(encuentro.getAsistencia()==0)
                        {
                            
                                    encuentro.getResultado().get(0).setIdResultado(ResultadodB.guardarResultado( encuentro.getResultado().get(0), dias, horas));
                                    for(int i=0;i<encuentro.getResultado().get(0).getPuntuacion().length;i++){
                                            encuentro.getResultado().get(0).getPuntuacion()[i].setIdPunto(ResultadodB.guardarPunto(encuentro.getResultado().get(0).getPuntuacion()[i], encuentro.getResultado().get(0).getIdResultado()));
                                        }
                               
                            
                                consultasql="UPDATE encuentro\n" + 
                                "   SET  id_participante_ganador='"+encuentro.getGanador().getIdParticipante()+"', id_participante_perdedor='"+encuentro.getPerdedor().getIdParticipante()+"', \n" + 
                                "       fecha_resultado='"+dias+"', hora_resultado='"+horas+"',asistencia='"+encuentro.getAsistencia()+"'" + 
                                " WHERE id_encuentro='"+encuentro.getIdEncuentro()+"'RETURNING *;";
                                System.out.println(consultasql);
                                resultado = Conexion.consulta.executeQuery(consultasql);
                                
                            
                            }
                        else
                        {
                                consultasql="UPDATE encuentro\n" + 
                                "   SET fecha_resultado='"+dias+"', hora_resultado='"+horas+"',asistencia='"+encuentro.getAsistencia()+"'\n" + 
                                " WHERE id_encuentro='"+encuentro.getIdEncuentro()+"'RETURNING *;";
                                System.out.println(consultasql);
                                resultado = Conexion.consulta.executeQuery(consultasql);
                            
                            }
                    }
                       
                   
                if(modalidad.equals("Sets"))
                {
                        if(encuentro.getAsistencia()==0)
                        {
                            
                                    encuentro.getResultado().get(0).setIdResultado(ResultadodB.guardarResultado( encuentro.getResultado().get(0), dias, horas));
                                    for(int i=0;i<encuentro.getResultado().get(0).getPuntuacion().length;i++){
                                            encuentro.getResultado().get(0).getPuntuacion()[i].setIdPunto(ResultadodB.guardarPunto(encuentro.getResultado().get(0).getPuntuacion()[i], encuentro.getResultado().get(0).getIdResultado()));
                                        }
                               
                            
                                consultasql="UPDATE encuentro\n" + 
                                "   SET  id_participante_ganador='"+encuentro.getGanador().getIdParticipante()+"', id_participante_perdedor='"+encuentro.getPerdedor().getIdParticipante()+"', \n" + 
                                "       fecha_resultado='"+dias+"', hora_resultado='"+horas+"',asistencia='"+encuentro.getAsistencia()+"'" + 
                                " WHERE id_encuentro='"+encuentro.getIdEncuentro()+"'RETURNING *;";
                                System.out.println(consultasql);
                                resultado = Conexion.consulta.executeQuery(consultasql);
                                
                            
                            }
                        else
                        {
                                consultasql="UPDATE encuentro\n" + 
                                "   SET fecha_resultado='"+dias+"', hora_resultado='"+horas+"',asistencia='"+encuentro.getAsistencia()+"'\n" + 
                                " WHERE id_encuentro='"+encuentro.getIdEncuentro()+"'RETURNING *;";
                                System.out.println(consultasql);
                                resultado = Conexion.consulta.executeQuery(consultasql);
                            
                            }
                       
                    }
                  
                  
                        
                        
                 
                
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
            
            
            
        //TODO HACER EL GUARDAR
        }
    public static int guardarEncuentro(Encuentro encuentro, int idSubRonda) throws SQLException {
        
   
            int idEncuentro=0;
            //Conexion conexion = new Conexion();
            ResultSet resultado=null;
            //conexion.conectar();
            String consultasql;
            
            consultasql="INSERT INTO encuentro(id_lugar_de_realizacion, id_Subronda )VALUES ('"+encuentro.getLocación().getIdLugar()+"', '"+idSubRonda+"' )RETURNING id_encuentro;";
           // System.out.println(consultasql);
           
           //Creo un nuevo statement, y ya que estoy devuelvo el resultset
            resultado = Conexion.consulta.executeQuery(consultasql);
            resultado.next();
            
            idEncuentro = resultado.getInt("id_encuentro");
            //System.out.println("despues id_encuentro: "+idEncuentro);
            return idEncuentro;
        
        }
    public static ResultSet buscarEncuentros(int idSubRonda) throws SQLException {
            //System.out.println("llego a la base id_encuentro");

            //Conexion conexion = new Conexion();
            ResultSet resultado=null;
            Statement consulta = Conexion.consultar();
            //conexion.conectar();
            String consultasql;
            
            consultasql="SELECT *  FROM encuentro where id_subronda='"+idSubRonda+"';";
            System.out.println(consultasql);
            System.out.println("antes");
            resultado = consulta.executeQuery(consultasql); 
            System.out.println("despues");
            return resultado;
        
        }
    public static  void eliminarEncuentros(int idEncuentro) throws SQLException {
            //System.out.println("llego a la base id_encuentro");
            Statement consulta = Conexion.consultar();
            //Conexion conexion = new Conexion();
            ResultSet resultado=null;
            //conexion.conectar();
            String consultasql;
            
            
            consultasql="DELETE FROM encuentro WHERE id_encuentro='"+idEncuentro+"';";
           // System.out.println(consultasql);
            consulta.executeUpdate(consultasql);

        
        }
}
