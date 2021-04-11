package questao6;

import grafonaodirecionado.ArestasND;
import grafonaodirecionado.GrafoND;
import grafonaodirecionado.VerticeND;

import java.util.ArrayList;

public class QuestaoSeis<TIPO> extends GrafoND {
    ArrayList<VerticeND<TIPO>> vertices = getVertices();

    public void geraMinimoPim(VerticeND verticeInicial) {
        VerticeND<TIPO>[] paiVertices = new VerticeND[vertices.size()];
        VerticeND<TIPO> verticeOrigem = null;
        VerticeND<TIPO> verticeDest = null;
        double menorPeso = 0.0;

        for (int i = 0; i < paiVertices.length; i++) {
            paiVertices[i] = null;
        }
        paiVertices[0] = verticeInicial;

        while (true) {
            boolean primeiraIteracao = true;

            for (int i = 0; i < vertices.size(); i++) {
                if (paiVertices[i] != null) {
                    VerticeND<TIPO>verticeVisitado = vertices.get(i);

                    for (int j = 0; j < verticeVisitado.getArestas().size(); j++) {
                        ArestasND<TIPO> arestasVisitado = verticeVisitado.getArestas().get(j);

                        for (int c = 0; c < vertices.size(); c++) {
                            if (vertices.get(c).equals(arestasVisitado.getVerticeB())) {
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

            for (int k = 0; k < vertices.size(); k++) {
                if (vertices.get(k).equals(verticeDest)) {
                    paiVertices[k] = verticeOrigem;
                }
            }
        }

        for(int i = 0; i < paiVertices.length; i++){
            if(i == 0){
                System.out.println("Começando pelo vertice: " + paiVertices[i].getDado());
                continue;
            }
            System.out.println("Nó pai: " + paiVertices[i].getDado() + " -> Nó Filho: " + vertices.get(i).getDado());
        }

    }

    public void geraMinimoKruskal(VerticeND verticeInicial){
        VerticeND<TIPO>[] paiVertices = new VerticeND[vertices.size()];
        VerticeND<TIPO>[] arvoreAuxiliar = new VerticeND[vertices.size()];
        VerticeND<TIPO> verticeOrigem = null;
        VerticeND<TIPO> verticeDest = null;
        double menorPeso = 0.0;

        for (int i = 0; i < paiVertices.length; i++) {
            arvoreAuxiliar[i] = vertices.get(i);
            paiVertices[i] = null;
        }
        paiVertices[0] = verticeInicial;

        while (true) {
            boolean primeiraIteracao = true;

            for (int i = 0; i < vertices.size(); i++) {
                if (paiVertices[i] != null) {
                    VerticeND<TIPO>verticeVisitado = vertices.get(i);

                    for (int j = 0; j < verticeVisitado.getArestas().size(); j++) {
                        ArestasND<TIPO> arestasVisitado = verticeVisitado.getArestas().get(j);

                        for (int c = 0; c < vertices.size(); c++) {
                            if (vertices.get(c).equals(arestasVisitado.getVerticeB())) {
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

            for(int k = 0; k < vertices.size(); k ++){
                if (vertices.get(k).equals(verticeDest)) {
                    if(paiVertices[k] == null){
                        paiVertices[k] = verticeOrigem;
                    } else {
                        for(int l = 0; l < vertices.size(); l ++){
                            if(vertices.get(l).equals(verticeOrigem)){
                                paiVertices[l] = verticeDest;
                            }
                        }
                    }
                }
            }

            for(int i = 0; i < vertices.size(); i++){
                for(int k = 0; k < vertices.size(); k++){
                    if(vertices.get(k).equals(verticeDest)){
                        if(arvoreAuxiliar[i] == arvoreAuxiliar[k]){
                            for(int c = 0; c < vertices.size(); c ++){
                                if(vertices.get(c).equals(verticeOrigem)){
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
            System.out.println("Nó pai: " + paiVertices[i].getDado() + " -> Nó Filho: " + vertices.get(i).getDado());
        }
    }
}
