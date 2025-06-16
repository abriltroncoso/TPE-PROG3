import java.util.ArrayList;
import java.util.Collections;

public class Greedy {
    private int candidatos;
    private ArrayList<Maquina> solucion;
    private int total;
    private int suma;

    public Greedy() {
        this.suma = 0;

    }

    /*
     * Candidatos:
     * Los candidatos seran las maquinas alojadas en el arreglo de maquinas
     * ordenadas de mayor a menor cantidad de piezas que producen
     * Seleccion de candidatos:
     * Se seleccionara a la maquina con mayor numero de produccion de piezas y se
     * evalua que no exceda el valor total dado.
     * Función de factibilidad:
     * Se verifica si sumar una máquina a la solución actual no supera el total de
     * piezas requeridas.
     * si es factible, se agrega a la solución parcial,si no, se descarta y se pasa
     * al siguiente candidato.
     * Consideraciones sobre encontrar solución:
     * Este algoritmo no garantiza encontrar una solución óptima ni todas las
     * posibles combinaciones.
     * Puede no encontrar solución en casos donde una combinación óptima requiere
     * ignorar
     * la máquina más grande para lograr una suma exacta.
     */

    public ArrayList<Maquina> solucionGreedy(int total, ArrayList<Maquina> maquinas) {

        ArrayList<Maquina> solucion = new ArrayList<>();
        Collections.sort(maquinas, Collections.reverseOrder());
        while (!maquinas.isEmpty() && suma != total) {
            Maquina m = maquinas.get(0);
            candidatos++;
            if (factible(m, suma, total)) {
                suma += m.getNroProduccion();
                solucion.add(m);
            } else {
                maquinas.remove(0);
            }
        }

        return solucion;

    }

    private boolean factible(Maquina m, int suma, int total) {
        if (suma + m.getNroProduccion() > total) {
            return false;
        }
        return true;
    }

    public int getCandidatos() {
        return candidatos;
    }

    public void setCandidatos(int candidatos) {
        this.candidatos = candidatos;
    }

    public ArrayList<Maquina> getSolucion() {
        return solucion;
    }

    public void setSolucion(ArrayList<Maquina> solucion) {
        this.solucion = solucion;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getSuma() {
        return suma;
    }

    public void setSuma(int suma) {
        this.suma = suma;
    }

}
