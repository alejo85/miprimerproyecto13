package ClasesLogicas;

import java.util.Vector;

public class TablaDePosiciones {
    private Vector<Posicion> tabla;

    public TablaDePosiciones() {
        super();
    }

    public TablaDePosiciones(Vector<Posicion> tabla) {
        super();
        this.tabla = tabla;
    }
    public TablaDePosiciones(Posicion posicion) {
        super();
        boolean add = this.tabla.add(posicion);
    }
/*
    public void setTabla(Vector<Posicion> tabla) {
        this.tabla = tabla;
    }

    public Vector<Posicion> getTabla() {
        return tabla;
    }*/
}
