package ClasesLogicas;

public class Set {
    private int idSet;
    private int cantidadDeSets;
    public Set() {
        super();
    }

    public Set(int idSet, int cantidadDeSets) {
        super();
        this.idSet = idSet;
        this.cantidadDeSets = cantidadDeSets;
    }

    public void setCantidadSet(int cantidad) {
        this.cantidadDeSets = cantidad;
    }
    public void setId(int id) {
        this.idSet = id;
    }
    public int getCantidadSet() {
       return cantidadDeSets;
    }
    public int getId() {
        return idSet;
    }
}
