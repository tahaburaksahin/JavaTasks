package task3;

import java.io.*;

public class Task3 {
    public static void main(String[] args) {
        String encodedMessage = "";

        try {
            BufferedReader br = new BufferedReader(new FileReader("messages.txt"));
            String s;
            while((s = br.readLine()) != null){
                encodedMessage += s;
            }
        } catch(IOException e){
            e.getMessage();
        }

        String decodedMessage1 = "";
        String decodedMessage2 = "";

        String[] arr = encodedMessage.split(" ");

        for (int i = 0; i < arr.length ; i++) {
            if(i%2 == 0){
                decodedMessage1 += arr[i] + " ";
            }else{
                decodedMessage2 += arr[i] + " ";
            }
        }

        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("decodedMessage1.txt"));
            bw.write(decodedMessage1);
            bw.close();

            bw = new BufferedWriter(new FileWriter("decodedMessage2.txt"));
            bw.write(decodedMessage2);
            bw.close();
        }catch(IOException e){
            e.getMessage();
        }
    }
}
