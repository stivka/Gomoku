package ee.ttu.java.heatmapper;


import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import static javafx.application.Application.launch;

/**
 * Created by Stiv on 12/04/2017.
 */
public class Heatmapper {
    /**
     *
     */
    private HashMap<String, Integer> hashMap;
    /**
     * The String created from text on the URL site.
     */
    public String s;

    /**
     * @param s used to be "url" the url of the site, from where the text is grabbed.
     */
    public Heatmapper(String s) {
//        stringFromUrl(url);
        System.out.println(s);
        hashMap = new HashMap<>();

        this.s = s.toLowerCase();

        String pair = "";
        int value = 0;

        for (int i = 0; i < this.s.length() - 1; i++) {
            if ((this.s.charAt(i) >= 'a' && this.s.charAt(i) <= 'z')
                    && (this.s.charAt(i + 1) >= 'a'
                    && this.s.charAt(i + 1) <= 'z')) {
// if (Character.isLetter(s.charAt(i)) && Character.isLetter(s.charAt(i + 1))) {
//                pair = String.valueOf(whole.charAt(i)) + String.valueOf(whole.charAt(i + 1));
                pair = new StringBuilder().append(this.s.charAt(i)).append(this.s.charAt(i + 1)).toString();

                if (!hashMap.containsKey(pair)) {
                    hashMap.put(pair, 1);
                } else {
                    hashMap.put(pair, hashMap.get(pair) + 1);
                }
            }
        }
    }

    /**
     * This method I understand will be only used for printing the
     * values from the HashMap. The 'get' function by key, will be
     * the function getCountForBigram(String Bigram), which will take
     * in a value passed, such as String Bigram.
     *
     * @return returns all letter pairs' occurrence counts.
     */
    public HashMap<String, Integer> getBigrams() {
        Set set = hashMap.entrySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            Map.Entry mentry = (Map.Entry) iterator.next();
            System.out.print("Key is: " + mentry.getKey() + " & Value is: ");
            System.out.println(mentry.getValue());
        }
        return hashMap;
    }
    /**
     *
     * @return maximum letter pair from string.
     */
    public int getMaxCount() {
//        Heatmapper maxCount = new Heatmapper(s);
        int maxCount = 0;

        for (Map.Entry<String, Integer> entry : hashMap.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = Integer.valueOf(entry.getValue());
                //maybe the value of here is unnecessary
            }
        }
        System.out.println("Maximum occurring amount of a pair is: " + maxCount);
        return maxCount;
    }


    /**
     *
     * @param bigram what it means??.
     * @return returns (hopefully*) the integer amount for given letter pair.
     */
        public int getCountForBigram(String bigram) {

            int count = 0;
            bigram = bigram.toLowerCase();

            Heatmapper getCount = new Heatmapper(bigram);

            Set set = hashMap.entrySet();
            Iterator iterator = set.iterator();
            while (iterator.hasNext()) {
                Map.Entry mentry = (Map.Entry) iterator.next();
                System.out.println("Value is: " + mentry.getValue());
                System.out.println(mentry.getValue());
                System.out.println(bigram + " occurs " + getBigrams().get(bigram) + " times.");
                count = getBigrams().get(bigram);
            }
            return count;
        }

    /**
     * @return The sum of all existing pairs in hashMap.
     */
    public int getTotalCount() {
        int totalCount = 0;
        for (Integer val : hashMap.values()) {
            totalCount += val;
        }
        System.out.println(totalCount);
        return totalCount;
    }

    /**
     * @param args never i know what it means..
     */
    public static void main(String[] args) {
        launch(args);
//        Heatmapper ipsum = new Heatmapper()
    }
}
