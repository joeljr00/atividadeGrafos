package grafonaodirecionado;

import java.util.ArrayList;

public class ArestasND<TIPO> {

    private VerticeND<TIPO> verticeA;
    private VerticeND<TIPO> verticeB;
    private Double peso;

    public ArestasND(VerticeND<TIPO> verticeA, VerticeND<TIPO> verticeB, Double peso) {
        this.verticeA = verticeA;
        this.verticeB = verticeB;
        this.peso = peso;
    }

    public VerticeND<TIPO> getVerticeA() {
        return verticeA;
    }

    public void setVerticeA(VerticeND<TIPO> verticeA) {
        this.verticeA = verticeA;
    }

    public VerticeND<TIPO> getVerticeB() {
        return verticeB;
    }

    public void setVerticeB(VerticeND<TIPO> verticeB) {
        this.verticeB = verticeB;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    

}
