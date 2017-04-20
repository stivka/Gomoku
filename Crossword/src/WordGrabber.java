
import javax.swing.text.Document;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Stiv on 19/04/2017.
 */
public class WordGrabber {
    private List<String> wordList = new ArrayList<>();

    public void stringFromUrl(String url) {
        try {

            URL url1 = new URL(url);

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(url1.openStream()));

            String wholeString = ""; // clears the string.
            String inputLine;

            //            int wordCount = 10000;
            int charCount = 100000;
            int lineCount = 2;
            String word = "";

            /*
            Stores lineCount lines of text.
             */
            for (int i = 0; i < lineCount; i++) {
                if ((inputLine = in.readLine()) != null) {
                    wholeString += " " + inputLine;
                }
            }
            System.out.println(wholeString);
            in.close();

            wholeString = wholeString.toLowerCase();

            for (int i = 0; i < wholeString.length(); i++) {
                char c = wholeString.charAt(i);
                if (Character.isLetter(wholeString.charAt(i))) {
                    word += wholeString.charAt(i);
                }
                else if (Character.isWhitespace(wholeString.charAt(i)) && word.length() > 0) {
                        wordList.add(word);
                        word = ""; // clears String
                        /*
                If the Character ain't a letter nor a whitespace, it
                should be a punctuation mark or a digit, or a formatting
                symbol. None a symbol which forms a word.
                 */
                } else if (word.length() > 0) {
                    wordList.add(word);
                    word = "";
                }
            }

            java.util.Collections.sort(wordList);
            wordList.forEach(System.out::println);

        } catch (MalformedURLException e) {
            System.out.println("Malformed URL: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("I/O Error: " + e.getMessage());
        }
    }

//    String html = "<p>An <a href='http://example.com/'><b>example</b></a> link.</p>";
//    Document doc = Jsoup.parse(html);
//    String text = doc.body().text(); // "An example link"




    public static void main(String[] args) {
        WordGrabber wordGrab = new WordGrabber();
        wordGrab.stringFromUrl("http://norvig.com/big.txt");
    }
}
