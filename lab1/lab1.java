import java.io.BufferedReader; 
import java.io.BufferedWriter; 
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random; 

// Tina Liu 29490737 and 

public class lab1 {
    ArrayList<String> official_list_of_numbers = new ArrayList<>();  
    public static final String NUMBERSIN= "numbers_in.txt"; 
    public static final String NUMBERSOUT = "numbers_out.txt"; 
    public static void main(String [] args) {
        lab1 lab = new lab1();
        lab.readNumbers(NUMBERSIN);
        int n_groups = lab.randomGenerator(1, 20);
        int m = lab.randomGenerator(1, 10);
        lab.writeNumbers(n_groups, m, NUMBERSOUT); 
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
            for(int p = 1; p <= m; p++) {
                br.write("f"+p+";");
            }
            br.newLine();
            // content 
            for(int i = 1; i <= n; i++) {
                br.write(i+";");
                for(int x = 0; x< m; x++) {
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