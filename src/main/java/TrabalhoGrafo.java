
import grafonaodirecionado.GrafoND;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import questao4.QuestaoQuatro;
import tadgrafo.TadGrafo;



public class TrabalhoGrafo {

    
    public static void main(String[] args) {
      
        TadGrafo<String>grafo = new TadGrafo <String>();
        GrafoND<String> grafoND = new GrafoND<String>();
        QuestaoQuatro q4 = new QuestaoQuatro();

        String path = "vertices.txt";
        try ( BufferedReader br = new BufferedReader(new FileReader(path))) {

            String line = new String();
            line = br.readLine();
            while (line != null) {
                grafo.addVertices(line);
                q4.addVertices(line);

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
                q4.addAresta(0.0,vect[0], vect[1]);

                line = br.readLine();
            }

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    
        System.out.println("\n\n------------------------------");
        
        System.out.println("\n\n------------------------------");
     
      //  grafo.menorCaminho("Argentina");
      q4.nroCromatico("Argentina");
    }
    
}
