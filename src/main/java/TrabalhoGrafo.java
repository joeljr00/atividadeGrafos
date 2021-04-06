
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;



public class TrabalhoGrafo {

    
    public static void main(String[] args) {
      
        String path = "ConjuntoT.txt";
        try ( BufferedReader br = new BufferedReader(new FileReader(path))) {

            String line = new String();
            line = br.readLine();
            while (line != null) {

              
                line = br.readLine();
            }

        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    
}
