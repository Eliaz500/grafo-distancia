import estrutura.GrafoMatriz;
import ferramenta.LeitorTxt;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class main {
    public static void main(String[] args) throws IOException {

        String path = "src/cidade.txt";
        LeitorTxt leitorTxt = new LeitorTxt();
        leitorTxt.setQuantidadeVertice(path);
        leitorTxt.setQuantidadeAresta(path);
        ArrayList<String> vertices = new ArrayList<>();
        ArrayList<String> arestas = new ArrayList<>();
        leitorTxt.setVertices(vertices, path);
        leitorTxt.lerArestas(arestas, path);

        GrafoMatriz grafoMatriz = new GrafoMatriz(leitorTxt.getQuantidadeVertice(), vertices, arestas);
        grafoMatriz.criarMatriz();
        grafoMatriz.adicionarAresta();

        System.out.println("Código das Cidades:");
        for (int i = 0; i < grafoMatriz.getTamanho(); i++) {
            System.out.println(i + "-" + grafoMatriz.getVerticesGrafo().get(i));
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o código da cidade de partida:");
        int entrada = scanner.nextInt();

        BuscaDijkstra caminhoMinimo = new BuscaDijkstra(grafoMatriz, grafoMatriz.getMatriz(), entrada);

        System.out.println("Digite o código da cidade de destino:");
        entrada = scanner.nextInt();

        scanner.close();

        boolean first = true;

        for (int v : caminhoMinimo.pathTo(entrada)) {

            if (!first) {
                System.out.print(" -> ");
            }

            System.out.print(grafoMatriz.getVerticesGrafo().get(v));
            first = false;

        }
        System.out.println();
        System.out.println();

        caminhoMinimo.printSolution(grafoMatriz);
        System.out.println();
    }
}
