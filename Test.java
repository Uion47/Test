
import java.util.*;

public class Test {

    public static void main(String[] args) {
     
        String[] test = {"Pendanaan", "Terproteksi", "Untuk", "Dampak", "Berarti"};
        printSourtedByFrequencyUppercaseAlphabet(test);
        
    }
    public static void printSourtedByFrequencyUppercaseAlphabet(String[] test){

        StringBuilder mixString = new StringBuilder();
        for (String string : test) {
            mixString.append(string);
        }


        char[] charArray = mixString.toString().toCharArray();
        

        Map<Character, Integer> frekuensi = new HashMap<>();
        for (char c : charArray) {
            frekuensi.put(c, frekuensi.getOrDefault(c, 0) + 1);
        }

        
        List<Map.Entry<Character, Integer>> list = new ArrayList<>(frekuensi.entrySet());

    
        list.sort((e1, e2) -> {
            int freqCompare = e2.getValue().compareTo(e1.getValue());
            if (freqCompare != 0) {
                return freqCompare;
            }
    
            return compareCharacters(e1.getKey(), e2.getKey());
        });
        
        for (Map.Entry<Character, Integer> entry : list) {
            System.out.print(entry.getKey());
        }

    }

    
    public static int compareCharacters(Character c1, Character c2) {
        if (Character.isUpperCase(c1) && Character.isLowerCase(c2)) {
            return -1;
        }
        if (Character.isLowerCase(c1) && Character.isUpperCase(c2)) {
            return 1;
        }
        return Character.compare(c1, c2);
    }
}
