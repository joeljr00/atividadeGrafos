package questao1;

import grafonaodirecionado.GrafoND;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import tadgrafo.TadGrafo;

public class QuestaoUm {

    public static void main(String[] args) {
        TadGrafo<String>grafo = new TadGrafo <String>();
        GrafoND<String> grafoND = new GrafoND<String>();

        String path = "vertices.txt";
        try ( BufferedReader br = new BufferedReader(new FileReader(path))) {

            String line = new String();
            line = br.readLine();
            while (line != null) {
                grafo.addVertices(line);
                grafoND.addVertices(line);

                line = br.readLine();
            }

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        path = "arestas.txt";
        try ( BufferedReader br = new BufferedReader(new FileReader(path))) {

            String line = new String();
            line = br.readLine();
            while (line != null) {
                                String[] vect = line.split(";");
                grafo.addAresta(Double.parseDouble(vect[2]), vect[0], vect[1]);
                grafoND.addAresta(0.0,vect[0], vect[1]);

                line = br.readLine();
            }

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
       // grafo.buscaLargura(1);
       // grafo.buscaProfundidade("Argentina");
        System.out.println("\n\n------------------------------");
        //grafoND.buscaLargura(0);
        System.out.println("\n\n------------------------------");
      // grafoND.buscaProfundidade("Brasil");
      //  grafoND.nroCromatico("Argentina");
        grafo.menorCaminho("Argentina");
    }

}
