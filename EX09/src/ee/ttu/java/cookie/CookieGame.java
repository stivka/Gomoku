package ee.ttu.java.cookie;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 * Created by Stiv on 10/04/2017.
 */

public class CookieGame {
    private int cursorPrice = CURSOR_STARTIN_PRICE;
    private static final int CURSOR_STARTIN_PRICE = 20;
    private int cursorPriceIncrease = 20;
    private int cookieAmount = 0; // default value 0
    private int clickValue = 1; // default value 1
    private int cursorCount = 1;

    public void setCursorPrice(int cursorPrice) {
        cursorPriceLabel.setText(String.valueOf(cursorCount * CURSOR_STARTIN_PRICE));
    }

    @FXML
    private Label cookieCounter;

    @FXML
    private Label cursorCounter;

    @FXML
    private Label cursorPriceLabel;

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

//            buyCursor.

            cookieAmount -= (cursorCount * cursorPriceIncrease);
            cursorCount += 1;
            cursorPrice += cursorPriceIncrease;
            clickValue++;

            cursorPriceLabel.setText(String.valueOf(cursorPrice));
            cookieCounter.setText("Cookies: " + String.valueOf(cookieAmount));
        }

    }

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

