package ClasesGestores;


import ClasesBD.EncuentroDB;
import ClasesBD.FixtureDB;

import ClasesLogicas.Encuentro;
import ClasesLogicas.LugarDeRealizacion;
import ClasesLogicas.Participante;
import ClasesLogicas.Ronda;
import ClasesLogicas.Subronda;

import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.Vector;


public class RondaGestor {
  
    public RondaGestor() {
        super();
    }
    
   //TODO se borro public Ronda [] generarRonda(Competencia unaCompetencia)
        
        

    public static Ronda crearRonda(LugarDeRealizacion[] lugares,int cantidadDeEncuentros, int idFixture, int numeroRonda){
        
     
        Ronda laRonda = new Ronda();
        laRonda.setNumeroDeRonda(numeroRonda);
        laRonda.setGanadores(RondaGestor.generarSubRondaLiga(lugares,cantidadDeEncuentros));
        //TODO Guardarla en la base
        try {
            laRonda.setIdRonda(FixtureDB.guardarRonda(laRonda,idFixture));
        } catch (SQLException e) {
        }
        return laRonda;     
    }

    
    public void actualizarRonda(){}
    
    public static Ronda[] getRondas(int idFixture, Participante [] participantes){
            Ronda laRonda[] = null;
            Ronda unaRonda = new Ronda();
            int h=0;
            Vector <Ronda> datos=new Vector <Ronda>();
        ResultSet busqueda;

        try {
            busqueda = FixtureDB.buscarRonda(idFixture);
            while (busqueda.next()){
                unaRonda.setIdRonda(busqueda.getInt("id_ronda"));
                unaRonda.setNumeroDeRonda(busqueda.getInt("numeroronda"));
                unaRonda.setGanadores(getSubRondas(busqueda.getInt("id_subronda_ganadores"),  participantes));
                //System.out.println("valor de la ronda:       "+unaRonda.getNumeroDeRonda());

                datos.add(unaRonda);
                //System.out.println("valor de la ronda:       "+datos.get(h).getNumeroDeRonda());
                h++;
            } 
        laRonda= new Ronda[datos.size()];
        for(int j=0;j<datos.size();j++){
                
                laRonda[j]=datos.get(j);
                laRonda[j].setNumeroDeRonda(j+1);
               // System.out.println("valor de jota"+j+"Valor de numero de ronda"+datos.get(j).getNumeroDeRonda());
            }
    } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return laRonda;
        }
    public static  Vector <Ronda> getRondasVector(int idFixture, Participante [] participantes){
            Ronda laRonda[] = null;
            Ronda unaRonda = new Ronda();
            int h=0;
            Vector <Ronda> datos=new Vector <Ronda>();
        ResultSet busqueda;

        try {
            busqueda = FixtureDB.buscarRonda(idFixture);
            while (busqueda.next()){
                unaRonda.setIdRonda(busqueda.getInt("id_ronda"));
                unaRonda.setNumeroDeRonda(busqueda.getInt("numeroronda"));
                unaRonda.setGanadores(getSubRondas(busqueda.getInt("id_subronda_ganadores"),  participantes));
                //System.out.println("valor de la ronda:       "+unaRonda.getNumeroDeRonda());

                datos.add(unaRonda);
                //System.out.println(""+h+"   valor de la ronda:       "+datos.get(h).getNumeroDeRonda());
                h++;
                
            } 
       
 
         
    } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return datos;
        }
    public static Subronda getSubRondas(int idSubRonda, Participante [] participantes){
            
            Subronda unaRonda = new Subronda();
        
        ResultSet busqueda;

        try {
            busqueda = FixtureDB.buscarSubRonda(idSubRonda);
            while (busqueda.next()){
                unaRonda.setIdSubronda(idSubRonda);
                Encuentro[] encuentrosDeSubRonda =EncuentroGestor.encuentrosDeSubRonda(idSubRonda,participantes );
               // System.out.println("lonitud de  encuentros de la base: "+encuentrosDeSubRonda.length);
            unaRonda.setEncuentros(encuentrosDeSubRonda);
   
            
            }
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
            //System.out.println("Id SUbRonda"+unaRonda.getIdSubronda());
        return unaRonda;
        }
    public void estadoRonda(){}


  
    /**
     * @param rondaAA = ronda A Actualizar
     */
    public void actualizarEstado(Ronda[] rondaAA){
       
        int i;
        int tamanio= rondaAA.length;
            
        for (i=0;i<tamanio;i++){
            
        ///    rondaAA[i];
        }
        
          
    }
    
    public static Subronda generarSubRondaLiga(LugarDeRealizacion[] lugares,int cantidadDeEncuentros){
        
        Subronda subronda = new Subronda();
        try {
            subronda.setIdSubronda(FixtureDB.guardarSubronda());
        } catch (SQLException e) {
        }
        LugarDeRealizacion[] lugaresAux = lugares;
      
        int random;
        int repeticiones = cantidadDeEncuentros;
        Encuentro encuentros[] = new Encuentro[cantidadDeEncuentros];
                
        //todo corregir el diagrama de secuencias!!! 17.1
            
      //  while (repeticiones>0){
            
            random = 0 + (int)(Math.random()*lugaresAux.length);
            
            if (lugaresAux[random].getDisponibilidad()>0){
            
                for(int i=0; i < cantidadDeEncuentros; i++){
                    
                   encuentros[i] = EncuentroGestor.crearEncuentro(lugaresAux[random],subronda.getIdSubronda() ); 
                    lugaresAux[random].menosDisponibilidad();
                   // System.out.println("Encuentro id: "+encuentros[i].getIdEncuentro());
                }
              //  System.out.println("Repeticiones: "+repeticiones);
                repeticiones--;
        
            }
      //  }
        
        subronda.setEncuentros(encuentros);
       
        return subronda; 
        
        
        
    }
    public static void eliminarRonda(int idFixture){

        try {
            FixtureDB.eliminarRonda(idFixture);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public static void eliminarSubRonda(int idSubRonda){

        try {
            FixtureDB.eliminarRonda(idSubRonda);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
