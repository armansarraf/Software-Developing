
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Vector;

public class PhaseOne {

    public static int countwords;
    public static int countchar;
    public static int countnumbers;
    public static int countspecialchar;

    public int countwords(String words) {
        if (words == null || words.isEmpty()) {
        }
        String[] a = words.split("\\s+");
        countwords += a.length;
        return countwords;
    }

    public int countchar(String words) {
        for (int i = 0; i < words.length(); i++) {
            if (Character.isLetter(words.charAt(i)))
                countchar++;
        }
        return countchar;
    }

    public int countnumbers(String words) {
        for (int i = 0; i < words.length(); i++) {
            if (Character.isDigit(words.charAt(i)))
                countnumbers++;
        }
        return countnumbers;
    }

    public int countSpecialChar(String words) {
        for (int i = 0; i < words.length(); i++) {
            if (!Character.isDigit(words.charAt(i)) && !Character.isLetter(words.charAt(i))
                    && !Character.isSpaceChar(words.charAt(i)))
                countspecialchar++;
        }
        return countspecialchar;
    }

    public Map<Character, Integer> RepeatedChars(String words) {
        Map<Character, Integer> counter = new HashMap<Character, Integer>();
        Map<Character, Integer> finalcounter = new HashMap<Character, Integer>();
        for (int i = 0; i < words.length(); i++) {
            char ch = words.charAt(i);
            if (counter.containsKey(ch)) {
                counter.put(ch, counter.get(ch) + 1);
            } else {
                counter.put(ch, 1);
            }
        }
        Iterator<Map.Entry<Character, Integer>> iterator = counter.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Character, Integer>
                    entry
                    = iterator.next();
            if (entry.getValue() >= 2) {
                finalcounter.put(entry.getKey(), entry.getValue());
            }
        }
        return finalcounter;
    }

    public Map<String, Integer> RepeatedWords(String words) {
        Map<String, Integer> counterwords = new HashMap<>();
        Map<String, Integer> finalcounterwords = new HashMap<String, Integer>();
        String word[] = words.split("\\s+");
        for (String t : word) {
            if (counterwords.containsKey(t)) {
                counterwords.put(t, counterwords.get(t) + 1);

            } else {
                counterwords.put(t, 1);
            }
        }
        Iterator<Map.Entry<String, Integer>> iterator = counterwords.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Integer>
                    entry
                    = iterator.next();
            if (entry.getValue() >= 2) {
                finalcounterwords.put(entry.getKey(), entry.getValue());
            }
        }
        return finalcounterwords;
    }

    public Map<Character, Integer> detectConsecutiveChar(String words) {
        Map<Character, Integer> finalcounterchar = new HashMap<Character, Integer>();
        int n = words.length();
        String finaldetection = "";
        for (int i = 0; i < n; i++) {
            if (i < n - 1 && words.charAt(i) == words.charAt(i + 1)) {
                i++;
                finalcounterchar.put(words.charAt(i), (i + 1));
            }
        }
        return finalcounterchar;
    }

    public Map<String, Integer> detectConsecutiveWord(String words) {
        Map<String, Integer> counterwords = new HashMap<>();
        String separatedword[] = words.split("\\s+");
        Vector<String> total = new Vector<>();
        for (int i = 0; i < separatedword.length; i++) {
            total.add(separatedword[i]);
        }
        int length = total.size();
        for (int i = 1; i < length - 1; i++) {
            if (total.get(i).equals(total.get(i+1)))
             counterwords.put(total.get(i+1), (i+1));
            }
        return counterwords;
    }
}


