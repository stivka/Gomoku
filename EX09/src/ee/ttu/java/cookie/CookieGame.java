package ee.ttu.java.cookie;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 * Created by Stiv on 10/04/2017.
 */

public class CookieGame {
    /**
     * Field int for the price of the next cursor.
     */
    private int cursorPrice = CURSOR_PRICE_MODULE;
    /**
     *  Final int for the the sum, the price will increase by successively.
     */
    private static final int CURSOR_PRICE_MODULE = 20;
    /**
     * NOT a final int, for use within a constructor, to set the increasing price for buying a cursor.
     */
    private int cursorPriceIncrease = CURSOR_PRICE_MODULE;
    /**
     *  Field int for counting how many cookies you have.
     */
    private int cookieAmount = 0; // default value 0
    /**
     *  Field int for determining the value that one cookie click has.
     */
    private int clickValue = 1; // default value 1
    /**
     *  Field int for determining how many cursors you have.
     */
    private int cursorCount = 1;

    /**
     *
     * @param cursorPrice the price for buying another cursor
     */
    public void setCursorPrice(int cursorPrice) {
        cursorPriceLabel.setText(String.valueOf(cursorCount * CURSOR_PRICE_MODULE));
    }

    /**
     * Label which shows how many cookies you have.
     */
    @FXML
    private Label cookieCounter;
    /**
     * Label which shows how many cursors you have.
     */
    @FXML
    private Label cursorCounter;
    /**
     * Label which shows you how much the next cursor will cost.
     */
    @FXML
    private Label cursorPriceLabel;
    /**
     * Possible button control for setting visibility.
     */
    @FXML
    private Button buyCursor;


    /**
     * Constructor
     */
    public CookieGame() {

    }

    /**
     *
     * @param cursorPrice initial cursor price
     * @param cursorPriceIncrease by how much more expensive
     * @param cookieAmount how many cookies game starts with
     */
    public CookieGame(int cursorPrice, int cursorPriceIncrease, int cookieAmount) {
        this.cookieAmount = cookieAmount;
        this.cursorPrice = cursorPrice;
        this.cursorPriceIncrease = cursorPriceIncrease;
    }

    /**
     *
     * @return true if player has enough cookies to buy another cursor
     */
    boolean canBuyCursor() {

        return false;
    }

    /**
     * buys new cursor
     * @param buyCursor 
     */
    public void buyCursor(ActionEvent buyCursor) {
        if (cookieAmount - (cursorCount * cursorPriceIncrease) >= 0) {

            cookieAmount -= (cursorCount * cursorPriceIncrease);
            cursorCount += 1;
            cursorPrice += cursorPriceIncrease;
            clickValue++;

            cursorPriceLabel.setText(String.valueOf(cursorPrice));
            cookieCounter.setText("Cookies: " + String.valueOf(cookieAmount));
            cursorCounter.setText("Cursors: " + String.valueOf(cursorCount));
        }

    }
/**
 *
 */
//    public void setBuyCursor(ActionEvent buyCursor) {
//        buyCursor
//    }

    /**
     *
     * @return amount of cursors
     */
    int getCursorCount() {

        return cursorCount;
    }

    /**
     *
     * @return the next cursor's price
     */
    int getCursorPrice() {

        return cursorPrice;
    }

    /**
     *
     * @return number of cookies
     */
    int getCookies() {

        return cookieAmount;
    }

    /**
     * executes the action that succeeds clicking on the cookie
     * @param clickOnCookie what will it do
     */
    public void click(ActionEvent clickOnCookie) {
        cookieAmount += clickValue;
        cookieCounter.setText("Cookies: " + Integer.toString(cookieAmount));

        cursorCounter.setText("Cursors: " + String.valueOf(cursorCount));
        cursorPriceLabel.setText(String.valueOf(cursorPrice));
    }


}

