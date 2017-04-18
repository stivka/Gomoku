package ee.ttu.java.heatmapper;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

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
    private String wholeString;

    /**
     * @param url the url of the site, from where the text is grabbed.
     */
    Heatmapper(String url) {
        stringFromUrl(url);
        hashMap = new HashMap<>();

        wholeString = wholeString.toLowerCase();

        String pair = "";
        int value = 0;

        for (int i = 0; i < wholeString.length() - 1; i++) {
            if ((wholeString.charAt(i) >= 'a' && wholeString.charAt(i) <= 'z')
                    && (wholeString.charAt(i + 1) >= 'a'
                    && wholeString.charAt(i + 1) <= 'z')) {
// if (Character.isLetter(s.charAt(i)) && Character.isLetter(s.charAt(i + 1))) {
//                pair = String.valueOf(whole.charAt(i)) + String.valueOf(whole.charAt(i + 1));
                pair = new StringBuilder().append(wholeString.charAt(i)).append(wholeString.charAt(i + 1)).toString();

                if (!hashMap.containsKey(pair)) {
                    hashMap.put(pair, 1);
                } else {
                    hashMap.put(pair, hashMap.get(pair) + 1);
                }
            }
        }
    }

    /**
     * @param url the URL address.
     * @return
     */
    public String stringFromUrl(String url) {
        try (BufferedReader br = new BufferedReader(new FileReader(url))) {

//            String wholeString = "";
            String line;
            while ((line = br.readLine()) != null) {
                wholeString += line;
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return wholeString; /*Should give the field wholeString the String value
         equal to the text read from the URL site. Is the keyword 'this' necessary
         here? */
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
//    public int getMaxCount() {
////        Heatmapper maxCount = new Heatmapper(s);
//        int maxCount = 0;
//
//        for (Map.Entry<String, Integer> entry : hashMap.entrySet()) {
//            if (entry.getValue() > maxCount) {
//                maxCount = Integer.valueOf(entry.getValue());
//                //maybe the value of here is unnecessary
//            }
//        }
//        System.out.println("Maximum occurring amount of a pair is: " + maxCount);
//        return maxCount;
//    }


    /**
     *
     * @param bigram what it means??.
     * @return returns (hopefully*) the integer amount for given letter pair.
     */
//        public int getCountForBigram (String bigram){
////        Heatmapper getCount = new Heatmapper(bigram);
//            int count = 0;
//
//            Set set = hashMap.entrySet();
//            Iterator iterator = set.iterator();
//            while (iterator.hasNext()) {
//                Map.Entry mentry = (Map.Entry) iterator.next();
//                System.out.println("Value is: " + mentry.getValue());
//                System.out.println(mentry.getValue());
//                System.out.println(bigram + " occurs " + getBigrams().get(bigram) + " times.");
//            }
//            return count;
//        }

    /**
     * @return
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
     * @param args never i know what it means.
     */
    public static void main(String[] args) {
        launch(args);
//            Heatmapper instance = new Heatmapper("C:\\Users\\Stiv\\ITI0011\\stkapt\\EX11\\src\\text");


//            Heatmapper thisObj = new Heatmapper(whole);
//            thisObj.getBigrams(whole);
//            Heatmapper ipsum = new Heatmapper(whole);
//            ipsum.getBigrams();
//            ipsum.getMaxCount();
//            ipsum.getCountForBigram("ha");
//
//            ipsum.getCountForBigram("aaa aab");
//            ipsum.getTotalCount();
//
//            Heatmapper countForPair = new Heatmapper(whole);
//            countForPair.getCountForBigram("pi");
//        }
    }
}
