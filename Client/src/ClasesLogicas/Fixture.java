package ClasesLogicas;

public class Fixture{

	private int idFixture;
	private Ronda[] rondas;

    public Fixture(int idFixture, Ronda[] rondas) {
        super();
        this.idFixture = idFixture;
        this.rondas = rondas;
    }

    public Fixture() {
        super();
    }

    public void setIdFixture(int idFixture) {
        this.idFixture = idFixture;
    }

    public int getIdFixture() {
        return idFixture;
    }

    public void setRondas(Ronda[] rondas) {
        this.rondas = rondas;
    }

    public Ronda[] getRondas() {
        return rondas;
    }

    /**
     * @param participantes
     */
    public void generarRondas(Participante[] participantes){
       
        }

    /**
     * @param participantes
     */
    public void cargarParticipantes(Participante[] participantes){
        }
}
