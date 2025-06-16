public class Maquina implements Comparable<Maquina> {

    private int nroProduccion;
    private String nombre;

    public Maquina(int piezas, String nombre) {
        this.nroProduccion = piezas;
        this.nombre = nombre;
    }

    public int getNroProduccion() {
        return nroProduccion;
    }

    public void setNroProduccion(int nroProduccion) {
        this.nroProduccion = nroProduccion;
    }

    @Override
    public int compareTo(Maquina o) {
        return Integer.compare(this.nroProduccion, o.getNroProduccion());
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Maquina " +
                nombre + '\'' +
                ", nroProduccion=" + nroProduccion;
    }

}
