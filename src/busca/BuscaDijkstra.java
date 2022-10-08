
import java.util.ArrayDeque;
import java.util.Deque;

import estrutura.GrafoMatriz;

public class BuscaDijkstra {
    private int vertices;
    private int[] distancia;
    private int[] edgeTo;
    private boolean[] visitado;

    public BuscaDijkstra(GrafoMatriz grafo, int[][] matriz, int partida) {
        this.vertices = grafo.getTamanho();
        dijkstra(grafo, matriz, partida);
    }

    // Procura a mínima distância
    private int minimaDistancia(int distancia[], boolean visitado[]) {

        // Inicializa o menor valor
        int minimo = Integer.MAX_VALUE, min_index = -1;

        for (int v = 0; v < vertices; v++) {
            if (visitado[v] == false && distancia[v] <= minimo) {
                minimo = distancia[v];
                min_index = v;
            }
        }

        return min_index;

    }

    public void printSolution(GrafoMatriz grafo) {
        System.out.println("Cidades \t distância mínima");
        for (int i = 0; i < vertices; i++) {
            System.out.println(
                    grafo.getVerticesGrafo().get(i) + String.format("%18s", distancia[i]).replace(' ', '-') + "Km");
        }
    }

    private void dijkstra(GrafoMatriz grafo, int[][] matriz, int largada) {
        // Vetor que possui o resultado. Armazena a distância de cada vértice para a
        // origem.
        // dist[i] possuirá o menor caminho da origem até i.
        vertices = matriz.length;

        distancia = new int[vertices];
        edgeTo = new int[vertices];

        // sptSet[i] será true se o vértice fizer parte do menor caminho
        // ou se não for possível continuar
        visitado = new boolean[vertices];

        for (int i = 0; i < vertices; i++) {
            // Inicializa todas as distâncias com o maior valor possível
            // e visitado[] como false
            distancia[i] = Integer.MAX_VALUE;
            edgeTo[i] = -1;
            visitado[i] = false;
        }

        // A distância de todo nó para si mesmo é zero
        distancia[largada] = 0;

        for (int count = 0; count < vertices - 1; count++) {

            int u = minimaDistancia(distancia, visitado);

            // Marca o vértice como visitado
            visitado[u] = true;

            /* Atualiza o valor dist dos vértices adjacentes ao vértice selecionado */
            for (int v = 0; v < vertices; v++) {
                if (!visitado[v] &&
                        matriz[u][v] != 0 &&
                        distancia[u] != Integer.MAX_VALUE &&
                        distancia[u] + matriz[u][v] < distancia[v]) {

                    distancia[v] = distancia[u] + matriz[u][v];
                    edgeTo[v] = u;
                }
            }
        }

    }

    private boolean hasPathTo(int v) {
        return distancia[v] < Integer.MAX_VALUE;
    }

    public Iterable<Integer> pathTo(int v) throws IllegalArgumentException {

        if (!hasPathTo(v)) {
            return null;
        }

        Deque<Integer> path = new ArrayDeque<>();

        for (int atual = v; atual != -1; atual = edgeTo[atual]) {
            path.push(atual);
        }

        return path;

    }
}
