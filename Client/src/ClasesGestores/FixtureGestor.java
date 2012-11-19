package ClasesGestores;


import ClasesLogicas.Fixture;
import ClasesLogicas.LugarDeRealizacion;
import ClasesLogicas.Participante;
import ClasesLogicas.Ronda;

public class FixtureGestor {
    public FixtureGestor() {
        super();
    }

    /**
     * @param lugares
     * @param participantes
     * @return
     */
    public static Fixture generarFixture(LugarDeRealizacion[] lugares,                   
        Participante[] participantes, int cantidadDeParticipantes){
        
        Fixture fixture = new Fixture();
        Ronda ronda;

        
        for (int i=0; i<cantidadDeParticipantes;i++){            
            ronda = RondaGestor.crearRonda(lugares,cantidadDeParticipantes/2);
            fixture.addRonda(ronda);   
        }
        
        
        return fixture;
        }
   
   
    public void actualizar(){}
    
}
