package questao5;

import java.util.ArrayList;
import tadgrafo.Arestas;
import tadgrafo.TadGrafo;
import tadgrafo.Vertices;

public class Dijkstra {
    private Vertices cidadeSaida;
    private Vertices cidadeProx;
    private Double distancia;
    
    
    
/*
    private ArrayList<Vertices> caminho = new ArrayList<Vertices>();
    private ArrayList<Vertices> cidadesNaoVisitadas = new ArrayList<Vertices>();

   

    public void menorCaminho(TadGrafo grafo, Vertices cidadeIn, Vertices cidadeFim) {
        double distancia = 0.0, distanciaM = 0.0;
        caminho.add(cidadeIn);

       
        cidadeSaida.setDistanciaMin(0.0);
        grafo.getArestas().size();


        cidadesNaoVisitadas.add(cidadeSaida);
        Vertices aux = null;
        while (!cidadesNaoVisitadas.isEmpty()) {
            cidadeSaida.setDistanciaMin(distanciaM);
            
            cidadeSaida = cidadesNaoVisitadas.get(0);
            caminho.add(cidadeSaida);
            cidadesNaoVisitadas.remove(0);
            
            for (  : cidadeSaida.getArestaOUT()) {

                distancia = ares.getPeso();
                if (distanciaM > 0.0 && distancia < distanciaM) {
                    distanciaM = distancia;
                    aux = ares.getFim();
                } else if (0.0 <= distanciaM) {
                    distanciaM = ares.getPeso();
                }
                aux = ares.getFim();
                cidadesNaoVisitadas.add(aux);
            }

            System.out.println(cidadeSaida.getDado() + "Dis: " + distanciaM + " " + aux.getDado());
        }
    }
*/

    public Dijkstra(Vertices cidadeSaida, Vertices cidadeProx, Double distancia) {
        this.cidadeSaida = cidadeSaida;
        this.cidadeProx = cidadeProx;
        this.distancia = distancia;
    }
    
    
}
