import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.TreeMap;

public class WordCount {

    String inputFile, outputFile;

    public WordCount(String inputFile, String outputFile) {

        //create variables
        this.inputFile = inputFile;
        this.outputFile = outputFile;

    }

    private String makeHTML(String words) {

        //create beginning of the html file
        String html = "<!DOCTYPE html><html><head></head>";
        html += "<h2>Words Counted</h2><tbody>";

        html += words;
        html += "</body></html>";

        return html;

    }

    private String makeTable(String a, String b) {
        // Create tables for each word and their respective count
        return "<tr><th>" + a + "</th><th>" + b + "</th></tr>";
    }

    public void makeOutput() throws IOException {

        Scanner read = new Scanner(new FileReader(this.inputFile));

        BufferedWriter write = new BufferedWriter(
                new FileWriter(this.outputFile));

        //sort
        TreeMap<String, Integer> map = new TreeMap<>();

        String word;

        while (read.hasNext()) {

            word = read.next();

            if (word.isEmpty()) {

                continue;

            }

            if (map.containsKey(word)) {
                //if word exists

                map.put(word, 1 + map.get(word));

            } else {
                // if not, just 1
                map.put(word, 1);

            }

        }
        String tableContent = "<table border =\"1\">";

        for (String key : map.keySet()) {
            tableContent += this.makeTable(key, String.valueOf(map.get(key)));
        }

        tableContent += "</table>";

        write.write(this.makeHTML(tableContent));

        System.out.println("Output successfully");

        read.close();
        write.close();

    }

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);
        //Inputs .txt file
        System.out.println("Name of the input file:");
        String inputFileName = sc.next();

        System.out.println("Name of the output file:");
        String outputFileName = sc.next();

        WordCount wrdCnt = new WordCount(inputFileName, outputFileName);
        wrdCnt.makeOutput();

        sc.close();

    }

}