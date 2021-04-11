package tadgrafo;

import java.util.ArrayList;

public class TadGrafo<TIPO> {

    private ArrayList<Vertices<TIPO>> vertices;
    private ArrayList<Arestas<TIPO>> arestas;

    public TadGrafo() {
        this.vertices = new ArrayList<Vertices<TIPO>>();
        this.arestas = new ArrayList<Arestas<TIPO>>();
    }

    public void addVertices(TIPO dado) {
        Vertices<TIPO> novoVertice = new Vertices<TIPO>(dado);
        
        this.vertices.add(novoVertice);
    }

    public void addAresta(Double peso, TIPO vertInicio, TIPO vertFim) {
        Vertices<TIPO> inicio = this.getVertices(vertInicio);
        Vertices<TIPO> fim = this.getVertices(vertFim);
        Arestas<TIPO> aresta = new Arestas<TIPO>(peso, inicio, fim);
        inicio.addArestaOut(aresta);
        fim.addArestaIN(aresta);
        this.arestas.add(aresta);
    }

    public Vertices<TIPO> getVertices(TIPO dado) {
        Vertices<TIPO> vertice = null;
        for (int i = 0; i < this.vertices.size(); i++) {
            if (this.vertices.get(i).getDado().equals(dado)) {
                vertice = this.vertices.get(i);
                break;
            }

        }
        return vertice;
    }

    public void buscaLargura(int v) {
        ArrayList<Vertices<TIPO>> marcados = new ArrayList<Vertices<TIPO>>();
        ArrayList<Vertices<TIPO>> fila = new ArrayList<Vertices<TIPO>>();
        Vertices<TIPO> atual = this.vertices.get(v);
        marcados.add(atual);
        System.out.println(atual.getDado());
        fila.add(atual);
        while (fila.size() > 0) {
            Vertices<TIPO> visitado = fila.get(0);
            for (int i = 0; i < visitado.getArestaOUT().size(); i++) {
                Vertices<TIPO> prox = visitado.getArestaOUT().get(i).getFim();
                if (!marcados.contains(prox)) {
                    marcados.add(prox);
                    System.out.println(prox.getDado());
                    fila.add(prox);
                }
            }
            fila.remove(0);
        }

    }

    ArrayList<Vertices<TIPO>> visitados = new ArrayList<Vertices<TIPO>>();

    public void buscaProfundidade(TIPO dado) {

        ArrayList<Vertices<TIPO>> fila = new ArrayList<Vertices<TIPO>>();
        Vertices<TIPO> atual = getVertices(dado);
        System.out.println(atual.getDado());
        visitados.add(atual);

        for (int i = 0; i < atual.getArestaOUT().size(); i++) {
            Vertices<TIPO> prox = atual.getArestaOUT().get(i).getFim();
            if (!visitados.contains(prox)) {
                visitados.add(prox);
                buscaProfundidade(prox.getDado());

            }

        }
        for (int j = 0; j < vertices.size(); j++) {
            if (!visitados.contains(vertices.get(j))) {
                buscaProfundidade(vertices.get(j).getDado());
            }
        }

    }
    public ArrayList<Vertices<TIPO>> tDsVertices() {
        ArrayList<Vertices<TIPO>> vT = new ArrayList<Vertices<TIPO>>();
        vT.addAll(this.vertices);
        return vT;
    }
}