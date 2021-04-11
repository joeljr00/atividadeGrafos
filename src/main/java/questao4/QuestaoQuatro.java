
package questao4;

import grafonaodirecionado.ArestasND;
import grafonaodirecionado.GrafoND;
import grafonaodirecionado.VerticeND;
import java.util.ArrayList;
import java.util.Collections;



public class QuestaoQuatro<TIPO> extends GrafoND {
    
 
 ArrayList<VerticeND> coloridos = new ArrayList();
 private ArrayList<VerticeND> vertices;
 
    public int nroCromatico(int v) {
        ArrayList<VerticeND<TIPO>> tVertices = new ArrayList();
        tVertices.addAll(tDsVertices());
        Cor cor = new Cor();
        ArrayList<Integer> cores = new ArrayList();
        cores.addAll(cor.todasCores());
        ArrayList<Integer> coraux = new ArrayList();
        VerticeND<TIPO> atual = tVertices.get(v);
        VerticeND<TIPO> prox = atual;

        while (coloridos.size() < tVertices.size()) {
            for (ArestasND ares : atual.getArestas()) {

                if (coloridos.contains(ares.getVerticeB())) {
                    coraux.add(ares.getVerticeB().getCor());
                } else {
                    prox = ares.getVerticeB();
                }
                if (coloridos.contains(ares.getVerticeA())) {
                    coraux.add(ares.getVerticeA().getCor());
                } else if (ares.getVerticeA() != atual) {
                    prox = ares.getVerticeA();
                }
                if (coloridos.contains(ares.getVerticeB()) && coloridos.contains(ares.getVerticeA())) {
                   for(int i=0;i<coloridos.size();i++){
                   if(!coloridos.contains(tVertices.get(i))){
                       nroCromatico(i);
                   }
                   }
                 }
            }
            if (coraux.isEmpty()) {
                atual.setCor(cor.getC1());
                coloridos.add(atual);
                System.out.println(atual.getDado() + " Cor " + atual.getCor());
            } else {
                Collections.sort(coraux);
                for (int i = 0; i < coraux.size(); i++) {
                    if (!coraux.contains(cores.get(i))) {
                        atual.setCor(cores.get(i));
                        break;
                    }

                }
                if (!coloridos.contains(atual)) {
                    coloridos.add(atual);
                    System.out.println(atual.getDado() + " Cor " + atual.getCor());
                    coraux.clear();
                }
            }
            nroCromatico(tVertices.indexOf(prox));
        }
 return cores.size();
    }
    
}
