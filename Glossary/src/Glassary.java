import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Put a short phrase describing the program here.
 *
 * @author Nick Boenau
 *
 */
public final class Glassary {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private Glassary() {
    }

    /**
     * Checks to see if a line has spaces
     *
     * @param s
     * @return
     */
    private static boolean doesLineHaveSpaces(String s) {
        boolean b = false;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            String temp = Character.toString(c);
            if (temp.equals(" ")) {
                b = true;
            }

        }
        return b;
    }

    /**
     * Creates separate definition glossary pages for each line of the text file
     * that it is given and stores and returns each word in an ArrayList
     *
     * @throws IOException
     */
    private static ArrayList<String> makeDefinitionPage(String file,
            String outFolder) throws IOException {
        ArrayList<String> words = new ArrayList<String>();

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            for (String line; (line = br.readLine()) != null;) {
                if (doesLineHaveSpaces(line)) {
                    // definition
                } else if ("".equals(line)) {
                    //blank line
                } else {
                    // one word
                    words.add(line);
                    //header
                    String page = "<html>" + "\n" + "<head>" + "\n" + "<title>"
                            + line + "</title>" + "\n" + "</head>" + "\n";
                    //body
                    page += "<body>" + "\n" + "<h2>" + "\n" + "<b>" + "\n"
                            + "<i>" + "\n" + "<font color=\"red\">" + line
                            + "</font>" + "\n" + "</i>" + "\n" + "</b>" + "\n"
                            + "</h2>" + "\n";
                    String def = br.readLine();
                    page += "<blockquote>" + def + "</blockquote>" + "\n"
                            + "<hr>" + "\n";
                    page += "<p>" + "\n" + "Return to" + "\n"
                            + "<a href=\"index.html\">index</a>" + "\n" + "</p>"
                            + "\n" + "</body>" + "\n" + "</html>";
                    SimpleWriter outFile = new SimpleWriter1L(line + ".html");
                    outFile.print(page);
                    outFile.close();

                    SimpleWriter outFile2 = new SimpleWriter1L(
                            outFolder + ".zip");
                    outFile2.print(line + ".html");
                    outFile2.close();
                }

            }
        }
        return words;

    }

    /*
     * Makes the index page with all listed words and saves it to the given
     * outFolder
     */
    private static void makeIndex(String outFolder, ArrayList<String> words) {
        // header
        String HTML = "<html>" + "\n" + "<head>" + "\n" + "<title>"
                + "Sample Glossary" + "</title>" + "\n" + "</head>" + "\n";
        // body
        HTML += "<body>" + "\n" + "<h2>Gloassary</h2>" + "\n" + "<hr>" + "\n";
        HTML += "<h3>Index</h3>" + "\n" + "<ul>" + "\n";

        for (int i = 0; i < words.size(); i++) {
            HTML += "<li>" + "\n" + "\n" + "<a href=\"" + words.get(i)
                    + ".html\">" + words.get(i) + "</a>" + "\n" + "</li>"
                    + "\n";
        }

        HTML += "</ul>" + "\n" + "</body>" + "\n" + "</html>";

        SimpleWriter outFile = new SimpleWriter1L("index.html");
        outFile.print(HTML);
        SimpleWriter outFile2 = new SimpleWriter1L(outFolder + ".zip");
        outFile2.print("index.html");

        outFile.close();
        outFile2.close();

    }

    /**
     * Main method.
     *
     * @param args
     *            the command line arguments
     */
    public static void main(String[] args) {
        SimpleReader in = new SimpleReader1L();
        SimpleWriter out = new SimpleWriter1L();

        // enter terms.txt
        out.print("Name of the input file: ");
        String inFile = in.nextLine();

        out.print("Name of the folder for all the files to save to: ");
        String outFolder = in.nextLine();

        ArrayList<String> words = new ArrayList<String>();

        try {
            words = makeDefinitionPage(inFile, outFolder);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Collections.sort(words);

        makeIndex(outFolder, words);

        in.close();
        out.close();
    }

}
