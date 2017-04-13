import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Created by Stiv on 12/04/2017.
 */
public class Heatmapper {
    /**
     *
     */

    private HashMap<String, Integer> hashMap;

    /**
     *
     * @param s input string.
     */
    Heatmapper(String s) {
        hashMap = new HashMap<>();

        s = s.toLowerCase();

        String pair = "";
        int value = 0;

        for (int i = 0; i < s.length() - 1; i++) {
            if (Character.isLetter(s.charAt(i)) && Character.isLetter(s.charAt(i + 1))) {
//                pair = String.valueOf(whole.charAt(i)) + String.valueOf(whole.charAt(i + 1));
                pair = new StringBuilder().append(s.charAt(i)).append(s.charAt(i + 1)).toString();

                hashMap().put("something to initialize", 0);
                if (!hashMap.containsKey(pair)) {
                    hashMap.put(pair, 1);
                } else {
                    value = hashMap.get(pair);
                    hashMap.put(pair, value + 1);
                }
            }
        }
    }


    /**
     *
     *
     * @return returns found amount of letter pairs.
     */
    public HashMap<String, Integer> hashMap() {
        Set set = hashMap.entrySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            Map.Entry mentry = (Map.Entry) iterator.next();
            System.out.print("key is: " + mentry.getKey() + " & Value is: ");
            System.out.println(mentry.getValue());
        }
        return hashMap;
    }



    /**
     *
     * @return maximum letter pair from string.
     */
    public int getMaxCount() {

        return 0;
    }

    /**
     *
     * @param bigram what it means??.
     * @return returns amount for given letter pair.
     */
    public int getCountForBigram(String bigram) {
        return 0;
    }

    /**
     *
     * @param args never i know what it means.
     */
    public static void main(String[] args) {

        String fileName = "C:\\Users\\Stiv\\ITI0011\\stkapt\\EX11\\src\\text";

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {

            String whole = "";
            String line;
            while ((line = br.readLine()) != null) {
                whole += line;
//                System.out.println(line);
            }

//            Heatmapper thisObj = new Heatmapper(whole);
//            thisObj.hashMap(whole);
            Heatmapper ipsum = new Heatmapper(whole);
            ipsum.hashMap();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
