package gomoku.strategies;

/**
 * Created by Stiv on 23/05/2017.
 */
import gomoku.ComputerStrategy;
import gomoku.Location;
import gomoku.SimpleBoard;

import java.util.ArrayList;
import java.util.List;

/**
 * Minimax class has evaluation function and minimax algorithm with alpha-beta pruning to determine best moves.
 */
public class Minimax implements ComputerStrategy {

    public static int[][] b; //IS THIS STATIC HERE BAD?
    public static int p;

    int links = 0;
    List<BSquare> chain = new ArrayList<>();
    List<List<BSquare>> openFours = new ArrayList<>();
    List<List<BSquare>> closeableFours = new ArrayList<>();
    List<List<BSquare>> openThrees = new ArrayList<>();
    List<List<BSquare>> closeableThrees = new ArrayList<>();


    int rowIncrement = 0;
    int colIncrement = 0;
    boolean endOfLine = false;
    
    int secondEmpty = 0;
    
    int depth = 3;

    public static int ir = 0;
    public static int ic = 0;
    public static int row;
    public static int col;

    /* Incrementing always starts from the main diagonal.
    The ordering is 0.main diagonal  1.anti diagonal  2.row  3.column .*/
    int incrementType = 0; // not static, that good?

    Location move;

    boolean iterated = false;

    @Override
    public Location getMove(SimpleBoard board, int player) {
        b = board.getBoard();
        p = player;
        if (!iterated) {
            iteration();
        }
        /* For preliminary testing, lets just place the pieces at successive empty squares.*/
        for (int i = 0; i < b.length; i++) {
            for (int j = 0; j < b[0].length; j++) {
                if (b[i][j] == SimpleBoard.EMPTY) {
                    // first empty location
                    printListSize();
                    return new Location(i, j);
                }
            }
        }
        return null;
    }
    public void iteration() {
        /* Store iterator values globally, so when you come back here, you will know where you left off.*/
        for (int i = ir; ir < b.length; ir++) {
            for (int j = ic; ic < b[0].length; ic++) {
                 /* Searches for an EMPTY BSquare. If it is empty then there could be chain squares attached to it,
                  which could make it for example an open Four, which is an OPEN 'CHAIN'. We are looking for open
                  CHAINS and closeable chains. */
                if (b[ir][ic] == SimpleBoard.EMPTY) {
                    chain.add(new BSquare(new Location(row, col), SimpleBoard.EMPTY));
                    increment();
                }
                /* If the getOpponentLastMove is at its' end, and there is still another type of incrementing to do, switch to the
                next type of incrementing and reset the col and row values to zero, to the beginning of getOpponentLastMove.*/
                if (i == b.length - 1 && j == b[0].length - 1 && incrementType < 3) {
                    incrementType++;
                    i = 0; ir = i;
                    j = 0; ic = j;
                }

            }
        }
        /* When the cursor arrives here, it means that the increment value is 3 and col = 9 and row = 9. */
        iterated = true;
        getMove(new SimpleBoard(b), p);
    }
    public void increment() {
        /* Scoots through here the increment values, and picks the one suitable for which lines it is currently
        browsing through.*/
        if (incrementType == 0) { // main diagonal
            rowIncrement = 1; colIncrement = 1;
        }
        if (incrementType == 1) { // anti diagonal
            rowIncrement = 1; colIncrement = -1;
        }
        if (incrementType == 2) { // row
            rowIncrement = 0; colIncrement = 1;
        }
        if (incrementType == 3) { // column
            rowIncrement = 1; colIncrement = 0;
        }
        /*          (Tries to find the magnitude for the chain.)
        First tries to increment the chain, if incrementing isn't possible, because the incrementing would lead out of
        bounds, the chain is kept with the current magnitude, and is CHOPPED UP AND possibly STORED.*/
        while (row + rowIncrement >= 0 && row + rowIncrement < b.length
                && col + colIncrement >= 0 && col + colIncrement < b[0].length) {
            row += rowIncrement;
            col += colIncrement;
            assignMagnitude();
        }
        /* If it can't increment any longer. Return to getOpponentLastMove. And assess what you got, and store it away.*/
        endOfLine = true;
        assignMagnitude();
    }
    public void assignMagnitude() {
        if (b[row][col] == p) {
            chain.add(new BSquare(new Location(row, col), p));
        }
        if (b[row][col] == SimpleBoard.EMPTY && secondEmpty < 2) {
            secondEmpty++;
            /*If the the second chain link is also empty, then go back to iterating. */
            if (chain.get(0).getInhabitance() == SimpleBoard.EMPTY) {
                chain.clear();
                iteration();
            }
            chain.add(new BSquare(new Location(row, col), p));
        }
        /* If is opponents piece CUT OUT THE CHAIN, this is as big as it gets.*/
        else if (b[row][col] != p && b[row][col] != SimpleBoard.EMPTY) {
            sortChains();
        }
        /* If there is a THIRD open link in the chain. THEN THE CHAIN has ended on the previous link. In other words
        don't add this link to the chain, and send the chain as is to the SORTER. */
        else if (b[row][col] == SimpleBoard.EMPTY && secondEmpty == 1) {
            sortChains();
        }
        /* If we aren't at the border, we continue incrementing.*/
        if (!endOfLine) {
            increment();
        } else {
            // add the chain to matching chain list of matching magnitude.
        }
    }
    public void sortChains() {
        int magnitudeCount = 0;
        int openEnds = 0;
        for (BSquare link : chain) {
            if (link.getInhabitance() == p) {
                magnitudeCount++;
            } else {
                openEnds++;
            }
        }
        if (magnitudeCount == 4) {
            if (openEnds == 1) {
                closeableFours.add(chain);
            }
            openFours.add(chain);
        }
        if (magnitudeCount == 3) {
            if (openEnds == 1) {
                closeableThrees.add(chain);
            }
            openThrees.add(chain);
        }
        /* Now fours and threes are stored. Clear the chain container. And by this you are also DISCARDING any chains
        smaller than three.*/
        chain.clear();
    }

    public void printListSize() {
        for (List openFour : openFours) {
            System.out.println("YOU have " + openFours.size() + " open fours.");
        }
        for (List closeableFour : closeableFours) {
            System.out.println("You have " + closeableFours.size() + " closeable fours.");
        }
        for (List openThree : openThrees) {
            System.out.println("You have " + openThree.size() + " open threes.");
        }
        for (List closeableThree : closeableThrees) {
            System.out.println("You have " + closeableThrees.size() + " closeable threes.");
        }
    }
    public class BSquare {
        private Location location;
        private int inhabitance;


        public BSquare(Location location, int inhabitance) {
            this.location = location;
            this.inhabitance = inhabitance;
        }
        public int getInhabitance() {
            return inhabitance;
        }
    }

    @Override
    public String getName() {
        return "Tudengi nimi";
    }

}
