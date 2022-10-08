package ferramenta;

import java.io.*;
import java.util.ArrayList;

public class LeitorTxt {

    private int quantidadeVertice;
    private int quantidadeAresta;
    private ArrayList<String> vertices = new ArrayList<>();
    public ArrayList<String> arestas = new ArrayList<>();

    public void setQuantidadeVertice(String path) throws IOException {
        BufferedReader buffRead = new BufferedReader(new FileReader(path));
        String linha = "";
        linha = buffRead.readLine();

        String[] valores = linha.split(" ");
        this.quantidadeVertice = Integer.parseInt(valores[0]);
        buffRead.close();
    }

    public void setQuantidadeAresta(String path) throws IOException {

        BufferedReader buffRead = new BufferedReader(new FileReader(path));
        String linha = "";
        linha = buffRead.readLine();
        linha.split(" ");
        String[] valores = linha.split(" ");
        this.quantidadeAresta = Integer.parseInt(valores[1]);
        buffRead.close();
    }

    public void setVertices(ArrayList<String> vertices, String path) throws IOException {
        BufferedReader buffRead = new BufferedReader(new FileReader(path));
        String linha = "";
        for (int i = 0; i <= getQuantidadeVertice(); i++) {
            linha = buffRead.readLine();
            if (i >= 1) {
                vertices.add(linha);
            }

        }
        buffRead.close();
    }

    public ArrayList lerArestas(ArrayList<String> arestas, String path) throws IOException {
        BufferedReader buffRead = new BufferedReader(new FileReader(path));
        String linha = "";
        for (int i = 0; i <= (getQuantidadeAresta() + getQuantidadeVertice()); i++) {
            linha = buffRead.readLine();
            if (i > getQuantidadeVertice()) {
                arestas.add(linha);
            }
        }
        buffRead.close();
        return arestas;
    }

    public int getQuantidadeVertice() {
        return quantidadeVertice;
    }

    public int getQuantidadeAresta() {
        return quantidadeAresta;
    }

    public ArrayList<String> getVertices() {
        return vertices;
    }

    public int getIndiceVertice(String cidade) {
        return this.vertices.indexOf(cidade);
    }
}
