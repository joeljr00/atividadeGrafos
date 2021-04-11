package grafonaodirecionado;

import java.util.ArrayList;

public class GrafoND<TIPO> {

    private ArrayList<VerticeND<TIPO>> vertices;
    private ArrayList<ArestasND<TIPO>> arestas;

    public GrafoND() {
        this.vertices = new ArrayList<VerticeND<TIPO>>();
        this.arestas = new ArrayList<ArestasND<TIPO>>();
    }

    public ArrayList<VerticeND<TIPO>> tDsVertices() {
        ArrayList<VerticeND<TIPO>> vT = new ArrayList<VerticeND<TIPO>>();
        vT.addAll(this.vertices);
        return vT;
    }

    public void addVertices(TIPO dado) {
        VerticeND<TIPO> novoVertice = new VerticeND(dado);
        this.vertices.add(novoVertice);

    }

    public void addAresta(Double peso, TIPO vertInicio, TIPO vertFim) {
        VerticeND<TIPO> inicio = this.getVertices(vertInicio);
        VerticeND<TIPO> fim = this.getVertices(vertFim);
        ArestasND<TIPO> aresta = new ArestasND<TIPO>(inicio, fim, peso);
        inicio.adcionarAresta(aresta);
        fim.adcionarAresta(aresta);
        this.arestas.add(aresta);
    }

    public VerticeND<TIPO> getVertices(TIPO dado) {
        VerticeND<TIPO> vertice = null;
        for (int i = 0; i < this.vertices.size(); i++) {
            if (this.vertices.get(i).getDado().equals(dado)) {
                vertice = this.vertices.get(i);
                break;
            }

        }
        return vertice;
    }

    public void buscaLargura(int v) {
        ArrayList<VerticeND<TIPO>> marcados = new ArrayList<VerticeND<TIPO>>();
        ArrayList<VerticeND<TIPO>> fila = new ArrayList<VerticeND<TIPO>>();
        VerticeND<TIPO> atual = this.vertices.get(v);
        marcados.add(atual);
        System.out.println(atual.getDado());
        fila.add(atual);
        while (fila.size() > 0) {
            VerticeND<TIPO> visitado = fila.get(0);
            for (int i = 0; i < visitado.getArestas().size(); i++) {
                VerticeND<TIPO> prox = visitado.getArestas().get(i).getVerticeB();
                if (!marcados.contains(prox)) {
                    marcados.add(prox);
                    System.out.println(prox.getDado());
                    fila.add(prox);
                }
            }
            fila.remove(0);
        }

    }
    ArrayList<VerticeND<TIPO>> visitados = new ArrayList<VerticeND<TIPO>>();

    public ArrayList<VerticeND<TIPO>> buscaProfundidade(int v) {

        VerticeND<TIPO> atual = vertices.get(v);

        visitados.add(atual);

        for (int i = 0; i < atual.getArestas().size(); i++) {
            VerticeND<TIPO> prox = atual.getArestas().get(i).getVerticeB();
            if (!visitados.contains(prox)) {
                buscaProfundidade(vertices.indexOf(prox));
            }

        }
        for (int j = 0; j < vertices.size(); j++) {
            if (!visitados.contains(vertices.get(j))) {
                buscaProfundidade(j);
            }
        }
       
    return visitados;
    }

}
