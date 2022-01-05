import java.util.Scanner;

public class PhaseTwo {

    public String addchartonum(String words) {
        String total = "";
        for (int i = 0; i < words.length(); i++) {
            if (!Character.isDigit(words.charAt(i))) {
                total += words.charAt(i);
            } else if (Character.isDigit(words.charAt(i))) {
                total += '\"';
                total += words.charAt(i);
                total += '\"';
            }
        }
        return total;

    }


    public String changewords(String words) {

        Scanner getword = new Scanner(System.in);
        String total = words;
        String keywordtofind;
        String keywordtochange;
        System.out.println("Enter the First key word to be searched");
        keywordtofind = getword.nextLine();
        System.out.println("Enter the Second key word to be replaced with the entered keyword");
        keywordtochange = getword.nextLine();
        keywordtochange = "ZZ" + keywordtochange + "ZZ";
        String newtotal = total.replaceAll(keywordtofind,keywordtochange);
         return newtotal;

    }
}
