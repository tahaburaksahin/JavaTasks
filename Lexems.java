// KFF-RWText/Lexems.java
 
/**
 * Program can be invoked with one argument (name of a text
 * file); if not specified, the file 'alice.txt' is assumed.
 *
 * We read the input file line by line, delete non-letters,
 * and add words to a map representing words in the text;
 * words (in lowercase) are keys, and objects of class Word
 * are values (the objects contain number of occurrences).
 * Class Word is Comparable, so sorting Words will sort
 * according to number of occurrences. Results are written
 * into file 'Words.out'. One letter words will be ignored.
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;
import java.util.TreeMap;

public class Lexems {

    Map<String,Word> map = new TreeMap<String,Word>();

    public static void main(String[] args) {
        String filename;
        if ( args.length == 0 ) filename = "alice.txt";
        else                    filename = args[0];
        new Lexems(filename);
    }

    public Lexems(String filename) {
        File filein = new File(filename);
        File filout = new File("Words.out");

        if ( !filein.exists()     ||
             !filein.canRead()    ||
              filein.isDirectory()  ) {
            System.out.println("Invalid file !!!");
            System.exit(1);
        }

          // reading the file, creating map
        int numWord      = 0;
        int numLines     = 0;
        BufferedReader br = null;
        try {
            br = new BufferedReader(
                     new FileReader(filein));
            String line;
            while ( (line = br.readLine()) != null) {
                numWord += toMap(line);
                numLines++;
            }
        } catch (IOException e) {
            System.out.println("Problems with reading");
            e.printStackTrace();
            System.exit(1);
        } finally {
            try { if (br != null) br.close(); }
            catch(IOException ignore) { }
        }

        Set<Word> coll = new TreeSet<Word>(map.values());
        int numDiffWords = coll.size();

        // results to file 'Words.out'
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter(filout));
            bw.write(String.format(
                "File %s contains %d lines.%n" +
                "Number of words is %d,%n" +
                "of which %d are different.%n%n",
                filename,numLines,numWord,numDiffWords));
            bw.write(" Occurrences     Word\n" +
                     "------------     ----\n");
            for (Word w : coll)
                bw.write(w + "\n");
            System.out.println(
                "\nResults in file \"" + filout + "\".");
        } catch (Exception e) {
            System.out.println("Problems with writing!!!");
            e.printStackTrace();
            System.exit(1);
        } finally {
            try { if (bw != null) bw.close(); }
            catch(IOException ignore) { }
        }
    }

    private int toMap(String line) {
        StringBuffer sb =
                new StringBuffer(line.toLowerCase());
          // deleting non-letters
        for (int i = 0; i < sb.length(); i++)
            if ( !Character.isLetter(sb.charAt(i)) )
                sb.setCharAt(i,' ');

        StringTokenizer st =
                new StringTokenizer(sb.toString());
        String s;
        int ile = 0;
        while ( st.hasMoreTokens() ) {
            s = st.nextToken();
            if ( s.length() < 2 ) continue;
            ile++;
            if (map.containsKey(s))
                map.get(s).addOne();
            else
                map.put(s,new Word(s));
        }
        return ile;
    }

    private class Word implements Comparable<Word> {
        final private String word;
        private int count=1;

        public Word(String w) {
            word = w;
        }

        public void addOne() {
            count++;
        }

        public int compareTo(Word otherWord) {
            if ( count == otherWord.count ) {
                return word.compareTo(otherWord.word);
            } else {
                return otherWord.count - count;
            }
        }

        @Override
        public String toString() {
            return String.format("%12d --> %s",count,word);
        }
    }
}
