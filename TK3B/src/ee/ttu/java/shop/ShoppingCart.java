package ee.ttu.java.shop;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by stkapt on 17.05.2017.
 */
public class ShoppingCart {
    List<String> names = new ArrayList<>();
    List<String> types = new ArrayList<>();
    List<Item> items = new ArrayList<>();

    public ShoppingCart() {

    }

    public void addItem(Item item) {
        if (!items.contains(item)) {
            items.add(item);
        }
    }
    public int countItems(String keyword) {
        int count = 0;
        if (items.size() == 0) {
            return 0;
        }
        if (keyword == null || keyword.equals("")) {
            return 0;
        }
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getName().equals(keyword)) {
                count++;
            }
            else if (items.get(i).getType().equals(keyword)) {
                count++;
            }
        }
        return count;
    }
}
