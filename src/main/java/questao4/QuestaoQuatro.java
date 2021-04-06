
package questao4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import tadgrafo.TadGrafo;
import tadgrafo.Vertices;


public class QuestaoQuatro {

    
    public static void main(String[] args) {
       TadGrafo<String> grafo = new TadGrafo<String>();
       
       String path = "vertices.txt";
        try ( BufferedReader br = new BufferedReader(new FileReader(path))) {

            String line = new String();
            line = br.readLine();
            while (line != null) {
                grafo.addVertices(line);

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
                grafo.addAresta(0.0, vect[0], vect[1]);

                line = br.readLine();
            }

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
       grafo.biParticao(0);
       
    }
    
}
