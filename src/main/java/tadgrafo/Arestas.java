package tadgrafo;

public class Arestas<TIPO> {

    private Double peso;
    private Vertices<TIPO> inicio;
    private Vertices<TIPO> fim;

    public Arestas(Double peso, Vertices<TIPO> inicio, Vertices<TIPO> fim) {
        this.peso = peso;
        this.inicio = inicio;
        this.fim = fim;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public Vertices<TIPO> getInicio() {
        return inicio;
    }

    public void setInicio(Vertices<TIPO> inicio) {
        this.inicio = inicio;
    }

    public Vertices<TIPO> getFim() {
        return fim;
    }

    public void setFim(Vertices<TIPO> fim) {
        this.fim = fim;
    }

}
