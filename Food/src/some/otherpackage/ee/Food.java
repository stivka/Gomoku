package some.otherpackage.ee;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Stiv on 17/05/2017.
 */
public class Food {

    private String name;
    private List<Location> locations = new ArrayList<>();

    public Food(String name) {
        this.name = name;
    }
    public List<Location> getLocations() {
        return locations;
    }
    public void addLocation(Location location) {
        locations.add(location);
    }
    public String toString() {
        return name;
    }
}
