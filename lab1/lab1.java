import java.io.BufferedReader; 
import java.io.BufferedWriter; 
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random; 

// Tina Liu 29490737 and Oakley Pankratz 35649318

public class lab1 {
    ArrayList<String> official_list_of_numbers = new ArrayList<>();  
    public static final String NUMBERSIN= "lab1/numbers_in.txt"; 
    public static final String NUMBERSOUT = "lab1/numbers_out.txt"; 
    public static void main(String [] args) {
        lab1 lab = new lab1();
        lab.readNumbers(NUMBERSIN);
        // we assumed that there would a random number of n rows along with a random number of groups because  it was unclear what the parameters were supposed to be for n and m respectively. 
        // The code also runs if you initalize n_groups and m to be fixed values  ie.  n_groups = 3 and m = 67
        int n_groups = lab.randomGenerator(1, 20);
        int m = lab.randomGenerator(1, 20);
        lab.writeNumbers(m, n_groups, NUMBERSOUT); 
    } public void readNumbers(String file_name) {
        try (BufferedReader br = new BufferedReader(new FileReader(file_name))) {
            String current_number;
            while ((current_number = br.readLine()) != null) {
                if(!current_number.isEmpty()) {
                    official_list_of_numbers.add(current_number.trim()); 
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    } public void writeNumbers(int n, int m, String file_name) {
        try (BufferedWriter  br = new BufferedWriter(new FileWriter(file_name, false))) {
            // header 
            br.write("partNr;");
            for(int p = 1; p <= n; p++) {
                br.write("f"+p+";");
            }
            br.newLine();
            // content 
            for(int i = 1; i <= m; i++) {
                br.write(i+";");
                for(int x = 0; x< n; x++) {
                    int randomIndex = randomGenerator(0, official_list_of_numbers.size()-1);
                    br.write(official_list_of_numbers.get(randomIndex));
                }
                br.newLine(); 
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    } public int randomGenerator(int min, int max) {
        Random random = new Random(); 
        return random.nextInt(max - min + 1) + min;
    }
}