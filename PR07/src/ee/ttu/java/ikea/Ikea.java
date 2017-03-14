/**
 * Created by Stiv on 08/03/2017.
 */
package ee.ttu.java.ikea;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Ikea {

    public static void main(String[] args) {
        Path path = Paths.get("PR07", "src", "example.txt");
        List<Item> items = new ArrayList<>();
        items = readItemsFromFile(path);
        System.out.println(findItemByType(items, "Meatballs").getName()); // Swedish Meatballs
        System.out.println(findItemByType(items, "Bed").getName()); // Soft Bed
        System.out.println(findItemByType(items, "Bowl").getName()); // Colorful Rainbow Bowl (simple version) OR Bed Sofa Chair Bowl (bonus version)
        System.out.println(findItemByType(items, "Chair").getAdjectives()); //[Big, Yellow]
        System.out.println(findItemByType(items, "Rainbow")); //null
    }

    /**
     * Open the file, read its contents into a list
     * and return that list.
     * @param path
     * @return
     */
    public static List<Item> readItemsFromFile(Path path) {
        return null;
    }

    /**
     * Return an item of the specified type from the
     * list "items". SIMPLE VERSION: if there is more
     * than one item of that type, return the first
     * in the list. BONUS VERSION: if there is more
     * than one item of that type, return the first
     * based on alphabetic order (case insensitive).
     * @param items
     * @param type
     * @return
     */
    public static Item findItemByType(List<Item> items, String type) {
        return null;
    }
}
