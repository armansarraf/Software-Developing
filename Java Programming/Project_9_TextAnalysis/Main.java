
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;


public class Main {

    public static void main(String[] args) {
    	PhaseOne phaseOne = new PhaseOne();
    	PhaseTwo phaseTwo = new PhaseTwo();
        String finaldata = "";
        String filepath = "test.txt";
        File myfile = new File(filepath);
        try {
            BufferedReader reader = new BufferedReader(new FileReader(myfile));
            String line;
            line = reader.readLine();
            while (line != null) {
                finaldata += line + '\n';
                line = reader.readLine();
            }


        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        try {
            PrintWriter results = new PrintWriter("output.txt");
            results.println("The number of words in This text file is : " + phaseOne.countwords(finaldata));
            results.println("The number of characters in This text file is : " + phaseOne.countchar(finaldata));
            results.println("The number of numbers in This text file is : " + phaseOne.countnumbers(finaldata));
            results.println("The number of specialchar in This text file is : " + phaseOne.countSpecialChar(finaldata));
            results.println("The repeated characters and the number of their occurrence in This text file are : " + phaseOne.RepeatedChars(finaldata));
            results.println("The repeated words and the number of their occurrence in This text file are : " + phaseOne.RepeatedWords(finaldata));
            results.println("The Consecutive chars and their position are : " + phaseOne.detectConsecutiveChar(finaldata));
            results.println("The Consecutive words and their position are : " + phaseOne.detectConsecutiveWord(finaldata));
            results.println("The text after adding special chars is : " + phaseTwo.addchartonum(finaldata));
            results.println("The text after changing two words with each other is : " + phaseTwo.changewords(finaldata));
            results.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
