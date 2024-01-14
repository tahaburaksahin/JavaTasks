// KFS-ScanFil/ScanFil.java
// Taha Burak Sahin PJATK

import java.io.FileReader;
import java.io.IOException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class ScanFil {
    public static void main(String[] args) {
        Map<String,List<Integer>> map =
                new HashMap<String,List<Integer>>();
        // or new TreeMap<String,List<Integer>>();

        Scanner scan = null;
        try {
            scan = new Scanner(new FileReader("scfil.dat"));
        } catch(IOException e) {
            System.err.print("No input file");
            System.exit(1);
        }

        int numlin = 0, quantity;
        while (scan.hasNextLine()) {
            String line = scan.nextLine().trim();
            ++numlin;
            // lines which are empty will be skipped
            if (line.length() == 0) continue;
            // as those starting with a non word character
            if (line.matches("^\\s*\\W.*$")) continue;

            // separators: ',', ';', or ':'
            // possibly surrounded by some spaces
            String[] vals = line.split("\\s*[,;:-]\\s*");
            if (vals.length != 2) {
                System.err.println("Error in line " +
                        numlin + ": " + line);
                continue;
            }
            String key = vals[0].trim().toLowerCase();
            String val = vals[1];

            try {
                quantity = Integer.parseInt(val);
            } catch(NumberFormatException e) {
                System.err.println("Wrong value in line " +
                        numlin + ": " + line);
                continue;
            }

            if (map.containsKey(key))
                map.get(key).add(quantity);
            else {
                List<Integer> a = new ArrayList<Integer>();
                a.add(quantity);
                map.put(key,a);
            }
        }
        scan.close();
        System.out.println();

        for (String key : map.keySet()) {
            List<Integer> list = map.get(key);
            int sum = 0;

            // auto(un)boxing
            for (int i : list) sum += i;

            // lists override toString
            System.out.println(key + ": " + list +
                    " = " + sum);
        }
        // maps override toString as well
        System.out.println("\n" + map);
    }
}
