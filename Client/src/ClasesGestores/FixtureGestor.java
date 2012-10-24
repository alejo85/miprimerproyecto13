package ClasesGestores;


import ClasesLogicas.Fixture;
import ClasesLogicas.LugarDeRealización;
import ClasesLogicas.Participante;

public class FixtureGestor {
    public FixtureGestor() {
        super();
    }

    /**
     * @param lugares
     * @param participantes
     * @return
     */
    public Fixture generarFixture(LugarDeRealización[] lugares,
                       Participante[] participantes){
        
        return new Fixture();
        }
    public void actualizar(){}
    
}
