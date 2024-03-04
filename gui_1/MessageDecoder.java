import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class MessageDecoder {
    public static void main(String[] args) {
        String inputFile = "res/messages.txt";
        String outputFile1 = "res/decoded_messages1.txt";
        String outputFile2 = "res/decoded_messages2.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             FileWriter writer1 = new FileWriter(outputFile1);
             FileWriter writer2 = new FileWriter(outputFile2)) {

            String line = reader.readLine();
            while (line != null) {
                String[] words = line.split(" ");
                decodeAndWriteMessages(words, writer1, writer2);
                line = reader.readLine();
            }

            System.out.println("Messages decoded and written to files successfully!");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void decodeAndWriteMessages(String[] words, FileWriter writer1, FileWriter writer2) throws IOException {
        StringBuilder message1 = new StringBuilder();
        StringBuilder message2 = new StringBuilder();

        for (int i = 0; i < words.length; i++) {
            if (i % 2 == 0) {
                message1.append(words[i]).append(" ");
            } else {
                message2.append(words[i]).append(" ");
            }
        }

        writer1.write(message1.toString().trim() + System.lineSeparator());
        writer2.write(message2.toString().trim() + System.lineSeparator());
    }
}
