package collections;

import java.io.File;
import java.util.*;

public class TextAnalysis {
    public static void main(String[] args) {
        Set<String> set = new HashSet<String>();
        HashMap<String,Integer> freqs = new HashMap<String,Integer>();

        try {
        File f = new File("tempest.txt");
        Scanner scan = new Scanner(f);
        while((scan.hasNextLine())) {
            //System.out.println(scan.nextLine());
            String line = scan.nextLine();
            String[] parts = line.split("\\s");
            for (int i = 0; i != parts.length; ++i) {
                parts[i] = parts[i].replaceAll("[^A-Za-z]", "");
                String wordToAdd = parts[i].toLowerCase();
                set.add(wordToAdd);
                freqs.putIfAbsent(wordToAdd, 0);
                freqs.put(wordToAdd, freqs.get(wordToAdd) + 1);
            }
        }

        String maxWord = null;
        Integer maxFreq = 0;
        for(Map.Entry<String,Integer> entry: freqs.entrySet()) {
            if (entry.getKey().equals("") || entry.getKey().equals(" ")) continue;
            if (entry.getValue() > maxFreq) {
                maxFreq = entry.getValue();
                maxWord = entry.getKey();
            }
        }
        System.out.println(set);
        System.out.println(set.size());
        System.out.println(freqs);
        System.out.println("max word: " + maxWord + ", frequency: " + freqs.get(maxWord));
        } catch (Exception e) {
            System.out.println("whoops");
        }
    }
}
