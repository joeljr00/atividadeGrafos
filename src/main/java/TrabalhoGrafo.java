
import grafonaodirecionado.GrafoND;
import grafonaodirecionado.VerticeND;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import questao4.QuestaoQuatro;
import questao5.QuestaoCinco;
import tadgrafo.TadGrafo;
import tadgrafo.Vertices;

public class TrabalhoGrafo {

    public static void main(String[] args) {
        int qAux4;
        TadGrafo<String> grafo = new TadGrafo<String>();
        GrafoND<String> grafoND = new GrafoND<String>();
        QuestaoQuatro q4 = new QuestaoQuatro();
        QuestaoCinco q5 = new QuestaoCinco();
        ArrayList<VerticeND> vTS = new ArrayList();

        String path = "vertices.txt";

        try ( BufferedReader br = new BufferedReader(new FileReader(path))) {

            String line = new String();
            line = br.readLine();
            line = br.readLine();
            while (line != null) {
                grafo.addVertices(line);
                grafoND.addVertices(line);
                q4.addVertices(line);
                q5.addVertices(line);

                line = br.readLine();
            }

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        path = "arestas.txt";
        try ( BufferedReader br = new BufferedReader(new FileReader(path))) {

            String line = new String();
            line = br.readLine();
            line = br.readLine();
            while (line != null) {
                String[] vect = line.split(";");
                grafo.addAresta(Double.parseDouble(vect[2]), vect[0], vect[1]);
                grafoND.addAresta(Double.parseDouble(vect[2]), vect[0], vect[1]);
                q4.addAresta(Double.parseDouble(vect[2]), vect[0], vect[1]);
                q5.addAresta(Double.parseDouble(vect[2]), vect[0], vect[1]);

                line = br.readLine();
            }

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("\n\n------------------------------");
        vTS.addAll(grafoND.buscaProfundidade(0));//visita começa pelo primeiro vertice;
        System.out.println(vTS.toString());
        System.out.println("\n\n------------------------------");
        grafoND.buscaLargura(0);//visita começa pelo primeiro vertice;
        System.out.println("\n\n------------------------------");
        
      
      if(q4.nroCromatico(1)>2){
          JOptionPane.showMessageDialog(null,"O número de cores necessárias para pintar todos os vertices é maior que 2 " 
                  +"\nlogo o grafo não é bipartido");
      }
      else
          JOptionPane.showMessageDialog(null,"o número de cores necessárias para pintar " 
          +"\n" +"é menor que dois logo o grafo é bipartido");
        System.out.println("\n\n------------------------------");
        q5.menorCaminho();
    }

}
