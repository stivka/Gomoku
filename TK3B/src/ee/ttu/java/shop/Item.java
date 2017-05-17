package ee.ttu.java.shop;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by stkapt on 17.05.2017.
 */
public class Item {
    private String name;
    private String type;


    public Item(String type, String name) {
        this.type = type;
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public String getType() {
        return type;
    }
}
