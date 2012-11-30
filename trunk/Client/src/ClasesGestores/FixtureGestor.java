package ClasesGestores;


import ClasesBD.FixtureDB;

import ClasesLogicas.Deporte;
import ClasesLogicas.Fixture;
import ClasesLogicas.LugarDeRealizacion;
import ClasesLogicas.Participante;
import ClasesLogicas.Ronda;

import java.sql.SQLException;

public class FixtureGestor {
    public FixtureGestor() {
        super();
    }

    /**
     * @param lugares
     * @param participantes
     * @return
     */
 //todo borrar main de prueba
  /*
   /*  public static  void main(String[] args) {
    
        int i;
        LugarDeRealizacion[] lugares = new LugarDeRealizacion[3];
        Deporte deporte[] = new Deporte[10];
        Participante participantes[]=new Participante[6];  
        Fixture fixture;
          
        for (i=0;i<3;i++){
            lugares[i]=new LugarDeRealizacion("", "hola","lala", 99, deporte);
        }
        
        for(i=0;i<6;i++){
            participantes[i]=new Participante(i+"");
        }
        
        fixture = generarFixture(lugares, participantes, 5,8);    
        System.out.println("");
     }*/

 
    public static Fixture generarFixture(LugarDeRealizacion[] lugares,                   
        Participante[] participantes, int cantidadDeParticipantes, int idCompetencia){
        
        Fixture fixture = new Fixture();
        Ronda rondas[];
        Participante participantesAux[];
           
        //Comienza decisicion para ver si el numero de participantes es impar, y si se debe
        //agregar un participante auxiliar
        if((cantidadDeParticipantes % 2) == 0){
            
            rondas = new Ronda[cantidadDeParticipantes-1];
            participantesAux = participantes;
        }
           
        else{
            cantidadDeParticipantes++;
            participantesAux = new Participante[cantidadDeParticipantes];
            int i;
            
            
            
            rondas = new Ronda[cantidadDeParticipantes-1];
            
            for (i=0;i<cantidadDeParticipantes-1;i++)
                participantesAux[i] = participantes[i];
            
            
            Participante unParticipante = new Participante();//se agrega el participantes auxiliar
            unParticipante.setIdParticipante(1);
            unParticipante.setNombre("*");
            unParticipante.setCorreo("nada@noexisto.com");
            participantesAux[i] = unParticipante;
        }

        //Fin de la decision, empieza el generar fixture


        try {
            fixture.setIdFixture(FixtureDB.idFixture(idCompetencia));
        } 
        catch (SQLException e) {
        }
        for (int i=0; i<cantidadDeParticipantes-1;i++){            
            rondas[i] = RondaGestor.crearRonda(lugares,cantidadDeParticipantes/2, fixture.getIdFixture(), i+1);
            
        }
        
        fixture.setRondas(rondas);

        cargarParticipantes(participantesAux, fixture);

            //System.out.println("antes de retonar fixture");
        return fixture;
        }
   
   
    public void actualizar(){}
    
    public static void cargarParticipantes (Participante[] participantes, Fixture fixture){
        
        
        int e = participantes.length-1;
        int f = participantes.length / 2;
        int i,j,aux=0;
        int ultimo;
        Participante locales[][] = new Participante[e][f];
        Participante visitantes[][] = new Participante[e][f];
        
        
        for (i=0;i<e;i++){
            
            for(j=0;j<f;j++,aux++){
                
                if (aux == e)
                    aux=0;
                locales[i][j] = participantes[aux]; 
            }
        }
        aux--;
        ultimo = participantes.length-1;
        for(i=0;i<e;i++){
            //aux--;   
            visitantes[i][0] = participantes[ultimo];
            for(j=1;j<f;aux--,j++){
                if(aux==-1)
                    aux=e-1;
                visitantes[i][j] = participantes[aux];
            }
        }
        fixture.cargarParticipantes(locales, visitantes);
        //TODO Guardar los participantes a la base
    }
    public static Fixture retornarFixture( int idCompetencia){
        
        Fixture fixture = new Fixture();

        try {
            fixture.setIdFixture(FixtureDB.getIdFixture(idCompetencia));
            fixture.setRondas(RondaGestor.getRondas(fixture.getIdFixture()));
            
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
            //System.out.println("antes de retornar el fixture ronda 0= "+fixture.getRonda1().get(1).getNumeroDeRonda());
        return fixture;
        }
    public static void eliminarFixture( int idFixture){
        try {
            FixtureDB.eliminarFixture(idFixture);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
