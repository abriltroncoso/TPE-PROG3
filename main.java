import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class main {
    public static void main(String[] args) {
        String rutaArchivo = "texto.txt";
        ArrayList<Maquina> maquinas = new ArrayList<>();
        int piezasTotales = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea = br.readLine();
            if (linea != null) {
                piezasTotales = Integer.parseInt(linea.trim());
            }

            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");
                if (partes.length == 2) {
                    String nombre = partes[0].trim();
                    int piezas = Integer.parseInt(partes[1].trim());
                    maquinas.add(new Maquina(piezas, nombre));
                }
            }

        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Error de formato en número: " + e.getMessage());
        }

        Backtracking back = new Backtracking();
        ArrayList<Maquina> solucionBack = back.solucionBacktracking(piezasTotales, maquinas);
        if (maquinas.isEmpty()) {
            System.out.println("no hay solucion backtracking posible para " + piezasTotales + " piezas");
        } else {
            System.out.println(
                    "solucion backtracking : " + solucionBack +
                            " cantidad de piezas producidas " + piezasTotales
                            + " cantidad de puestas en funcionamiento : " + solucionBack.size()
                            + " estados generados : " + back.getEstados());
        }

        Greedy greedy = new Greedy();
        ArrayList<Maquina> solucionGreedy = greedy.solucionGreedy(piezasTotales, maquinas);
        if (solucionGreedy.isEmpty()) {
            System.out.println("no hay solucion greedy posible para " + piezasTotales + " piezas");
        } else {
            System.out.println(
                    "solucion greedy : " + solucionGreedy +
                            " piezas producidas : " + piezasTotales + " cantidad de puestas en funcionamiento "
                            + solucionGreedy.size() +
                            " candidatos : " + greedy.getCandidatos()

            );
        }

    }
}