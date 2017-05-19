package some.otherpackage.ee;

/**
 * Created by Stiv on 17/05/2017.
 */
public class Main {
    public static void main(String[] args) {
        Food avocado = new Food("Avocado");
        Location fridge = new Location("Fridge");
        Food beans = new Food("Beans");
        Location shelf = new Location("Shelf");

        avocado.addLocation(fridge);
        shelf.addFood(beans);
        System.out.println(avocado.getLocations());
        System.out.println(beans.getLocations());
    }

}
