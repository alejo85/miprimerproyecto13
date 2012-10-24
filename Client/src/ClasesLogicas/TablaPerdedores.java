package ClasesLogicas;

import java.util.Vector;

public class TablaPerdedores {
    private Vector<Evento> eventos;
    public TablaPerdedores() {
        super();
    }

    public TablaPerdedores(Vector<Evento> eventos) {
        super();
        this.eventos = eventos;
    }

    public void setEventos(Vector<Evento> eventos) {
        this.eventos = eventos;
    }

    public Vector<Evento> getEventos() {
        return eventos;
    }
}
