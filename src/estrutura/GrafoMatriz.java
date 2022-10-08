package estrutura;

import java.util.ArrayList;

public class GrafoMatriz {
    private int tamanho = 0;
    private int matriz[][];
    private ArrayList<String> verticesGrafo = new ArrayList<>();
    public ArrayList<String> arestasGrafo = new ArrayList<>();

    public GrafoMatriz(int tamanho, ArrayList<String> verticesGrafo, ArrayList<String> arestasGrafo) {
        this.tamanho = tamanho;
        this.matriz = new int[tamanho][tamanho];
        this.verticesGrafo = verticesGrafo;
        this.arestasGrafo = arestasGrafo;
    }

    public int getTamanho() {
        return tamanho;
    }

    public ArrayList<String> getVerticesGrafo() {
        return verticesGrafo;
    }

    public int[][] criarMatriz() {

        for (int i = 0; i < tamanho; i++) {
            for (int j = 0; j < tamanho; j++) {
                if (i == j) {
                    matriz[i][j] = 1;
                } else {
                    matriz[i][j] = 0;
                }

            }
        }
        return matriz;
    }

    public int[][] getMatriz() {
        return matriz;
    }

    public void imprimirMatriz() {
        for (int i = 0; i < tamanho; i++) {
            for (int j = 0; j < tamanho; j++) {
                System.out.printf(" %d", matriz[i][j]);
            }
            System.out.println("");

        }
    }

    public void adicionarAresta() {
        String cidade1;
        String cidade2;
        int peso;
        String valores;
        int linha;
        int coluna;

        for (int i = 0; i < arestasGrafo.size(); i++) {
            // pega a aresta no array
            valores = String.valueOf(arestasGrafo.get(i));

            String[] dados = valores.split(" ");

            // aresta = dados[0];
            peso = Integer.parseInt(dados[2]);

            // pega a primeira cidade
            cidade1 = dados[0];
            // pega a segunda cidade
            cidade2 = dados[1];

            linha = verticesGrafo.indexOf(cidade1);
            coluna = verticesGrafo.indexOf(cidade2);

            matriz[linha][coluna] = peso;
            matriz[coluna][linha] = peso;

        }
    }
}
