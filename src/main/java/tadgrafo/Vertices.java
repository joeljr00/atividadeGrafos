package tadgrafo;

import java.util.ArrayList;

public class Vertices<TIPO> {

    private TIPO dado;
    private ArrayList<Arestas<TIPO>> arestaIN;
    private ArrayList<Arestas<TIPO>> arestaOUT;
    private double  distanciaMin = Double.MAX_VALUE;
    private Vertices<TIPO> vertProx;
    private int cor;

    public Vertices(TIPO valor) {
        this.dado = valor;
        this.arestaIN = new ArrayList<Arestas<TIPO>>();
        this.arestaOUT = new ArrayList<Arestas<TIPO>>();
        
               
    }

    public TIPO getDado() {
        return dado;
    }

    public void setDado(TIPO dado) {
        this.dado = dado;
    }

    public double getDistanciaMin() {
        return distanciaMin;
    }

    public void setDistanciaMin(double distancia) {
        this.distanciaMin = distancia;
    }

    public void addArestaIN(Arestas<TIPO> aresta) {
        this.arestaIN.add(aresta);
        this.arestaOUT.add(aresta);
    }

    public ArrayList<Arestas<TIPO>> getArestaIN() {
        return arestaIN;
    }

    public void setArestaIN(ArrayList<Arestas<TIPO>> arestaIN) {
        this.arestaIN = arestaIN;
    }

    public ArrayList<Arestas<TIPO>> getArestaOUT() {
        return arestaOUT;
    }

    public void setArestaOUT(ArrayList<Arestas<TIPO>> arestaOUT) {
        this.arestaOUT = arestaOUT;
    }

    public void addArestaOut(Arestas<TIPO> aresta) {
        this.arestaOUT.add(aresta);
    }

    public int getCor() {
        return cor;
    }

    public void setCor(int cor) {
        this.cor = cor;
    }

    public Vertices<TIPO> getVertProx() {
        return vertProx;
    }

    public void setVertProx(Vertices<TIPO> vertProx) {
        this.vertProx = vertProx;
    }

    @Override
    public String toString() {
        return "Vertices = {" + dado + '}';
    }
    

}
