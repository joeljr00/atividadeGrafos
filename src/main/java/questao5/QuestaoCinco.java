
package questao5;

import java.util.ArrayList;
import tadgrafo.Arestas;
import tadgrafo.TadGrafo;
import tadgrafo.Vertices;


public class QuestaoCinco<TIPO> extends TadGrafo {
    
    public void menorCaminho2(TIPO cidadeIn) {
        double distancia = 0.0, distanciaM = 0.0;
        Vertices<TIPO> cidadeSaida = this.getVertices(cidadeIn);
        //  Vertices<TIPO> cidadeChegada = this.getVertices(cidadeIn);
        ArrayList<Vertices<TIPO>> cidadesNaoVisitadas = new ArrayList<Vertices<TIPO>>();
        ArrayList<Vertices<TIPO>> caminho = new ArrayList<Vertices<TIPO>>();

        cidadeSaida.setDistanciaMin(distanciaM);
        caminho.add(cidadeSaida);
        cidadesNaoVisitadas.add(cidadeSaida);

        // cidadesNaoVisitadas.addAll(vertices);
        Vertices<TIPO> aux = null;
        while (!cidadesNaoVisitadas.isEmpty()) {
            cidadeSaida = cidadesNaoVisitadas.get(0);

            for (Arestas ares : cidadeSaida.getArestaOUT()) {
                if (!caminho.contains(ares.getFim())) {
                    cidadesNaoVisitadas.add(ares.getFim());
                    caminho.add(ares.getFim());
                }

                distancia = ares.getPeso();

                if (distanciaM > 0.0 && distancia < distanciaM) {
                    distanciaM = distancia;
                    aux = ares.getFim();
                } else if (0.0 <= distanciaM) {
                    distanciaM = ares.getPeso();

                    aux = ares.getFim();
                }

            }
            aux.setDistanciaMin(distanciaM);

            System.out.println(cidadeSaida.getDado() + " Dis: " + aux.getDistanciaMin() + " " + aux.getDado());

            cidadesNaoVisitadas.remove(0);
        }

    }
    
}
