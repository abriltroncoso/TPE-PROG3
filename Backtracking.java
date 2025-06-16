import java.util.ArrayList;

public class Backtracking {
    private ArrayList<Maquina> solucion;
    private int estados;
    private int suma;

    public Backtracking() {
        this.solucion = new ArrayList<>();
        this.suma = 0;
        this.estados = 0;
    }
    /*
     * Generación del árbol de exploración:
     * Se construye un árbol donde cada nodo representa una combinación parcial de
     * máquinas
     * seleccionadas. En cada nivel del árbol se agrega una máquina a la combinación
     * actual,
     * permitiendo repeticiones, y se avanza si la suma parcial de piezas no supera
     * el objetivo.
     * Estados:
     * Un estado se define por la suma actual de piezas y la secuencia de máquinas
     * elegidas hasta ese punto.
     * Estado final:
     * Un estado final sera cuando en la tupla ya estan todas las maquinas
     * combinadas (sin poda)
     * Estado solucion :
     * Un estado solucion sera cuando la suma de las piezas de las maquinas de la
     * tupla sean igual al valor total dado
     * Posible poda:
     * Si la suma parcial de piezas supera el total requerido, se descarta esa rama
     * (poda).
     * Esto evita seguir explorando combinaciones que ya no pueden ser solución
     */

    public ArrayList<Maquina> solucionBacktracking(int total, ArrayList<Maquina> maquinas) {
        ArrayList<Maquina> solucionActul = new ArrayList<>();
        int pos = 0;
        back(total, maquinas, solucionActul, pos);
        return solucion;
    }

    private void back(int total, ArrayList<Maquina> maquinas, ArrayList<Maquina> solucionActul, int pos) {
        estados++;
        if (total == suma) {
            if (solucionActul.size() < solucion.size() || solucion.isEmpty()) {
                solucion.clear();
                solucion.addAll(solucionActul);
            }
        } else

            for (int i = pos; i < maquinas.size(); i++) {

                if (suma + maquinas.get(i).getNroProduccion() <= total) {
                    suma += maquinas.get(i).getNroProduccion();
                    solucionActul.add(maquinas.get(i));
                    back(total, maquinas, solucionActul, i);
                    suma -= maquinas.get(i).getNroProduccion();
                    solucionActul.removeLast();
                }
            }
    }

    public ArrayList<Maquina> getSolucion() {
        return solucion;
    }

    public void setSolucion(ArrayList<Maquina> solucion) {
        this.solucion = solucion;
    }

    public int getEstados() {
        return estados;
    }

    public void setEstados(int estados) {
        this.estados = estados;
    }

    public int getSuma() {
        return suma;
    }

    public void setSuma(int suma) {
        this.suma = suma;
    }

}
