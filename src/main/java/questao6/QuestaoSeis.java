package questao6;

import grafonaodirecionado.ArestasND;
import grafonaodirecionado.GrafoND;
import grafonaodirecionado.VerticeND;

public class QuestaoSeis<TIPO> extends GrafoND {
    public void geraMinimoPim(GrafoND<TIPO> grafo, VerticeND verticeInicial) {
        VerticeND<TIPO>[] paiVertices = new VerticeND[grafo.getVertices().size()];
        VerticeND<TIPO> verticeOrigem = null;
        VerticeND<TIPO> verticeDest = null;
        double menorPeso = 0.0;

        for (int i = 0; i < paiVertices.length; i++) {
            paiVertices[i] = null;
        }
        paiVertices[0] = verticeInicial;

        while (true) {
            boolean primeiraIteracao = true;

            for (int i = 0; i < grafo.getVertices().size(); i++) {
                if (paiVertices[i] != null) {
                    VerticeND<TIPO>verticeVisitado = grafo.getVertices().get(i);

                    for (int j = 0; j < verticeVisitado.getArestas().size(); j++) {
                        ArestasND<TIPO> arestasVisitado = verticeVisitado.getArestas().get(j);

                        for (int c = 0; c < grafo.getVertices().size(); c++) {
                            if (grafo.getVertices().get(c).equals(arestasVisitado.getVerticeB())) {
                                if (paiVertices[c] == null) {
                                    if (primeiraIteracao) {
                                        menorPeso = arestasVisitado.getPeso();
                                        verticeOrigem = verticeVisitado;
                                        verticeDest = arestasVisitado.getVerticeB();
                                        primeiraIteracao = false;
                                    } else {
                                        if (menorPeso > arestasVisitado.getPeso()) {
                                            menorPeso = arestasVisitado.getPeso();
                                            verticeOrigem = verticeVisitado;
                                            verticeDest = arestasVisitado.getVerticeB();
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            if (primeiraIteracao) {
                break;
            }

            for (int k = 0; k < grafo.getVertices().size(); k++) {
                if (grafo.getVertices().get(k).equals(verticeDest)) {
                    paiVertices[k] = verticeOrigem;
                }
            }
        }

        for(int i = 0; i < paiVertices.length; i++){
            if(i == 0){
                System.out.println("Começando pelo vertice: " + paiVertices[i].getDado());
                continue;
            }
            System.out.println("Nó pai: " + paiVertices[i].getDado() + " -> Nó Filho: " + grafo.getVertices().get(i).getDado());
        }

    }

    public void geraMinimoKruskal(GrafoND<TIPO> grafo, VerticeND verticeInicial){
        VerticeND<TIPO>[] paiVertices = new VerticeND[grafo.getVertices().size()];
        VerticeND<TIPO>[] arvoreAuxiliar = new VerticeND[grafo.getVertices().size()];
        VerticeND<TIPO> verticeOrigem = null;
        VerticeND<TIPO> verticeDest = null;
        double menorPeso = 0.0;

        for (int i = 0; i < paiVertices.length; i++) {
            arvoreAuxiliar[i] = grafo.getVertices().get(i);
            paiVertices[i] = null;
        }
        paiVertices[0] = verticeInicial;

        while (true) {
            boolean primeiraIteracao = true;

            for (int i = 0; i < grafo.getVertices().size(); i++) {
                if (paiVertices[i] != null) {
                    VerticeND<TIPO>verticeVisitado = grafo.getVertices().get(i);

                    for (int j = 0; j < verticeVisitado.getArestas().size(); j++) {
                        ArestasND<TIPO> arestasVisitado = verticeVisitado.getArestas().get(j);

                        for (int c = 0; c < grafo.getVertices().size(); c++) {
                            if (grafo.getVertices().get(c).equals(arestasVisitado.getVerticeB())) {
                                if (paiVertices[c] == null) {
                                    if (primeiraIteracao) {
                                        menorPeso = arestasVisitado.getPeso();
                                        verticeOrigem = verticeVisitado;
                                        verticeDest = arestasVisitado.getVerticeB();
                                        primeiraIteracao = false;
                                    } else {
                                        if (menorPeso > arestasVisitado.getPeso()) {
                                            menorPeso = arestasVisitado.getPeso();
                                            verticeOrigem = verticeVisitado;
                                            verticeDest = arestasVisitado.getVerticeB();
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            if (primeiraIteracao) {
                break;
            }

            for(int k = 0; k < grafo.getVertices().size(); k ++){
                if (grafo.getVertices().get(k).equals(verticeDest)) {
                    if(paiVertices[k] == null){
                        paiVertices[k] = verticeOrigem;
                    } else {
                        for(int l = 0; l < grafo.getVertices().size(); l ++){
                            if(grafo.getVertices().get(l).equals(verticeOrigem)){
                                paiVertices[l] = verticeDest;
                            }
                        }
                    }
                }
            }

            for(int i = 0; i < grafo.getVertices().size(); i++){
                for(int k = 0; k < grafo.getVertices().size(); k++){
                    if(grafo.getVertices().get(k).equals(verticeDest)){
                        if(arvoreAuxiliar[i] == arvoreAuxiliar[k]){
                            for(int c = 0; c < grafo.getVertices().size(); c ++){
                                if(grafo.getVertices().get(c).equals(verticeOrigem)){
                                    arvoreAuxiliar[i] = arvoreAuxiliar[c];
                                }
                            }
                        }
                    }
                }
            }
        }
        for(int i = 0; i < paiVertices.length; i++){
            if(i == 0){
                System.out.println("Começando pelo vertice: " + paiVertices[i].getDado());
                continue;
            }
            System.out.println("Nó pai: " + paiVertices[i].getDado() + " -> Nó Filho: " + grafo.getVertices().get(i).getDado());
        }
    }
}
