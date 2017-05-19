package some.otherpackage.ee;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Stiv on 17/05/2017.
 */
public class Location {
    private String name;
    public List<Food> foods = new ArrayList<>();

    public Location(String name) {
        this.name = name;
    }
    public void addFood(Food food) {
        foods.add(food);
        food.addLocation(this);
    }
    public List<Food> getFoods() {
        return foods;
    }

    public String toString() {
        return name;
    }
}
