package collections;

import java.io.File;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class TextAnalysis {
    public static void main(String[] args) {
        Set<String> set = new HashSet<String>();

        try {
        File f = new File("tempest.txt");
        Scanner scan = new Scanner(f);
        while((scan.hasNextLine())) {
            //System.out.println(scan.nextLine());
            String line = scan.nextLine();
            String[] parts = line.split("\\s");
            for (int i = 0; i != parts.length; ++i) {
                parts[i] = parts[i].replaceAll("[^A-Za-z]", "");
                set.add(parts[i].toLowerCase());
            }
        }
        System.out.println(set);
        System.out.println(set.size());
        } catch (Exception e) {
            System.out.println("whoops");
        }
    }
}
