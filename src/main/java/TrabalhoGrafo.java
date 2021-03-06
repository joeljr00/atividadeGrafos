
import grafonaodirecionado.GrafoND;
import grafonaodirecionado.VerticeND;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import questao4.QuestaoQuatro;
import questao5.QuestaoCinco;
import questao6.QuestaoSeis;
import tadgrafo.TadGrafo;
import tadgrafo.Vertices;

public class TrabalhoGrafo {

    public static void main(String[] args) {
        int qAux4;
        TadGrafo<String> grafo = new TadGrafo<String>();
        GrafoND<String> grafoND = new GrafoND<String>();
        QuestaoQuatro q4 = new QuestaoQuatro();
        QuestaoCinco q5 = new QuestaoCinco();
        QuestaoSeis q6 = new QuestaoSeis();
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
                q6.addVertices(line);

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
                q6.addAresta(Double.parseDouble(vect[2]), vect[0], vect[1]);

                line = br.readLine();
            }

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println("\n\n-PRIMEIRA QUEST??O A--------------");
        vTS.addAll(grafoND.buscaProfundidade(0));//visita come??a pelo primeiro vertice;
        System.out.println(vTS.toString());
        System.out.println("\n\n--PRIMEIRA QUEST??O B--------------");
        grafoND.buscaLargura(0);//visita come??a pelo primeiro vertice;
        
        System.out.println("\n\n--QUARTA QUEST??O--------------");
        
      
      if(q4.nroCromatico(1)>2){
          System.out.println("O n??mero de cores necess??rias para pintar todos os vertices ?? maior que 2 " 
                  +"\nlogo o grafo n??o ?? bipartido");
      }
      else
            System.out.println("o n??mero de cores necess??rias para pintar " 
          +"\n" +"?? menor que dois logo o grafo ?? bipartido");
      
        System.out.println("\n\n--QUINTA QUEST??O--------------");
        q5.menorCaminho();

        System.out.println("\n\n--SEXTA QUEST??O (ALGORITMO PRIM)--------------");
        q6.geraMinimoPim(grafoND.getVertices().get(0));

        System.out.println("\n\n--SEXTA QUEST??O (ALGORITMO KRUSKAL)--------------");
        q6.geraMinimoKruskal(grafoND.getVertices().get(0));
    }

}
