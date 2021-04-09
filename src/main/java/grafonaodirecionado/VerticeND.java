
package grafonaodirecionado;

import java.util.ArrayList;


public class VerticeND<TIPO> {
    private TIPO dado;
    private ArrayList<ArestasND<TIPO>> arestas;
    private int cor;

    public VerticeND(TIPO dado) {
        this.dado = dado;
        this.arestas = new ArrayList<ArestasND<TIPO>>();
    }

    public TIPO getDado() {
        return dado;
    }

    public void setDado(TIPO dado) {
        this.dado = dado;
    }

    public ArrayList<ArestasND<TIPO>> getArestas() {
        return arestas;
    }

    public void setArestas(ArrayList<ArestasND<TIPO>> arestas) {
        this.arestas = arestas;
    }

    public int getCor() {
        return cor;
    }

    public void setCor(int cor) {
        this.cor = cor;
    }

    public void adcionarAresta(ArestasND<TIPO> arestas){
    this.arestas.add(arestas);
    }
    
    
}
