package ee.ttu.java.shop;

/**
 * Created by stkapt on 17.05.2017.
 */
public class Main {
    public static void main(String[] args) {
        Item paulig = new Item("kohv", "Paulig kohv");
        Item löfbergs = new Item("kohv", "Löfbergs kohv");

        ShoppingCart firstBuy = new ShoppingCart();
        firstBuy.addItem(paulig);
        firstBuy.addItem(löfbergs);

        System.out.println(paulig.getType());
        System.out.println(firstBuy.countItems("kohv"));

        System.out.println(firstBuy.countItems("Löfbergs kohv"));
    }
}
