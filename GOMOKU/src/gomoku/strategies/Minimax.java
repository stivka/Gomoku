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
    List<Square> chain = new ArrayList<>();
    List<List<Square>> fours = new ArrayList<>();

    int rowIncrement = 0;
    int colIncrement = 0;
    int depth = 3;

    /* Incrementing always starts from the main diagonal.
    The ordering is 0.main diagonal  1.anti diagonal  2.row  3.column .*/
    int incrementType = 0; // not static, that good?

    Location move;

    @Override
    public Location getMove(SimpleBoard board, int player) {
        b = board.getBoard();
        p = player;
        iteration();

        return move;
    }
    public void iteration() {
        for (int row = 0; row < b.length; row++) {
            for (int col = 0; col < b[0].length; col++) {
                /* If the iteration is at its' end, and there is still another type of incrementing to do, switch to the
                next type of incrementing.*/
                if (row == b.length - 1 && col == b[0].length - 1 && incrementType < 4) {
                    incrementType++;
                }
                /* Searches for an EMPTY Square. If it is empty then there could be chain squares attached to it, making
                it an open Four, which is an OPEN 'CHAIN'. We are looking for open CHAINS. */
                if (b[row][col] == SimpleBoard.EMPTY) {
                    chain.add(new Square(new Location(row, col), SimpleBoard.EMPTY));
                    findMagnitude(row, col);
                }
            }
        }
    }
    public Square findMagnitude(int row, int col) {
        increment(row, col);

        if (b[row][col] == p) {
            chain.add(new Square(new Location(row, col), p));

        }
        return square;
    }
    public void increment(int row, int col) {
        /* Scoots through here the increment values, and picks the one suitable for which lines it is currently
        browsing through.*/
        if (incrementType.equals("mainDiagonal")) {
            rowIncrement = 1; colIncrement = 1;
        }
        if (incrementType.equals("antiDiagonal")) {
            rowIncrement = -1; colIncrement = 1;
        }
        if (incrementType.equals("row")) {
            rowIncrement = 0; colIncrement = 1;
        }
        if (incrementType.equals("column")) {
            rowIncrement = 1; colIncrement = 0;
        }
        while (row + rowIncrement >= 0 && row + rowIncrement < b.length
                && col + colIncrement >= 0 && col + colIncrement < b[0].length) {
            row += rowIncrement;
            col += colIncrement;
            findMagnitude(row, col);
        }

        increment(row, col);

    }


    public class Square {
        private Location location;
        private int inhabitance;


        public Square(Location location, int inhabitance) {
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
