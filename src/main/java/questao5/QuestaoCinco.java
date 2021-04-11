package questao5;

import java.util.ArrayList;
import java.util.Collections;
import tadgrafo.Arestas;
import tadgrafo.TadGrafo;
import tadgrafo.Vertices;

public class QuestaoCinco<TIPO> extends TadGrafo {

    public int menorCaminho() {
        double distancia = 0.0;
        int temSaida = 0;
        ArrayList<Vertices<TIPO>> tVert = new ArrayList();
        tVert=tDsVertices();
        Vertices<TIPO> cidadeSaida = tVert.get(0);
        Vertices<TIPO> cidadeChegada = tVert.get(1);
        ArrayList<Vertices<TIPO>> cidadesAvisitar = new ArrayList();
        ArrayList<Vertices<TIPO>> cidadesVisitadas = new ArrayList();
        ArrayList<Vertices<TIPO>> caminho = new ArrayList();
        

        cidadeSaida.setDistanciaMin(distancia);

        cidadesAvisitar.add(cidadeSaida);

        if (tVert.get(0) == tVert.get(1)) {
            System.out.println("Você já está em: " + tVert.get(0));
            return 0;
        }
        for (Arestas ares : cidadeSaida.getArestaOUT()) {
            if (ares.getFim() != cidadeSaida) {
                temSaida = 1;
            }
        }

        if (temSaida == 0) {
            System.out.println("Dado o grafo orientado você não pode ir a: "
                    + tVert.get(1) + " partindo de: " + tVert.get(0));
            return 0;
        }
        temSaida = 0;
        Vertices<TIPO> cidadeAnt = null;

        while (!cidadesAvisitar.isEmpty()) {

            cidadeSaida = cidadesAvisitar.get(0);
            for (Arestas ares : cidadeSaida.getArestaOUT()) {
                if (ares.getFim() != cidadeSaida) {
                    temSaida = 1;
                }
            }
            if (temSaida == 0) {
                cidadesAvisitar.remove(cidadeSaida);
                cidadesVisitadas.add(cidadeSaida);
                cidadeSaida = cidadeAnt;
                cidadesVisitadas.remove(cidadeAnt);

            }
            temSaida = 0;

            for (Arestas ares : cidadeSaida.getArestaOUT()) {
                if (!cidadesVisitadas.contains(ares.getFim())) {
                    if (!cidadesAvisitar.contains(ares.getFim())) {
                        cidadesAvisitar.add(ares.getFim());
                    }
                }
                distancia = ares.getPeso() + cidadeSaida.getDistanciaMin();
                
                if (distancia < ares.getFim().getDistanciaMin()) {
                    ares.getFim().setDistanciaMin(distancia);
                    ares.getFim().setVertProx(cidadeSaida);
                }
            }

            cidadesVisitadas.add(cidadeSaida);
            //System.out.println(cidadeAnt + "  " + cidadeSaida);
            cidadeAnt = cidadeSaida;
            cidadesAvisitar.remove(cidadeSaida);

        }
        caminho.clear();
        for (cidadeSaida = cidadeChegada; cidadeSaida != null; cidadeSaida = cidadeSaida.getVertProx()) {
                        
            caminho.add(cidadeSaida);
        }
        Collections.reverse(caminho);

        System.out.println("Meenor caminho de " + tVert.get(0) + " a " + tVert.get(1) + "\n" + caminho.toString());
        System.out.println("Distancia total: " + cidadeChegada.getDistanciaMin());

        return 0;
    }

}
