package gomoku.strategies;

import gomoku.*;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class StivStrategy implements ComputerStrategy {
    List<List<Location>> yourOpenFoursMainDiagonal = new ArrayList<>();
    List<Location> yourOpenFoursAntiDiagonal = new ArrayList<>();
    List<Location> yourOpenFoursColumn = new ArrayList<>();
    List<Location> yourOpenFoursRow = new ArrayList<>();
    List<Location> opponentOpenFoursMainDiagonal = new ArrayList<>();
    List<Location> opponentOpenFoursAntiDiagonal = new ArrayList<>();

    public List<Square> four = new ArrayList<>();

    public List<List<Square>> openFours = new ArrayList<>();
    public List<List<Square>> closeableFours = new ArrayList<>();




    @Override
    public Location getMove(SimpleBoard board, int player) {
        findYourSemiOpenFoursMainDiagonal(board, player);
        for (int i = 0; i < yourOpenFoursMainDiagonal.size(); i++) {
            System.out.println(yourOpenFoursMainDiagonal.get(i));
        }
        int[][] checkBoard = board.getBoard();

        int[][] b = board.getBoard();
        for (int row = b.length - 1; row >= 0; row--) {
            for (int col = b[0].length - 1; col >= 0; col--) {
                if (b[row][col] == SimpleBoard.EMPTY) {
                    // first empty location
                    return new Location(row, col);
                }
            }
        }
        return null;
    }

    public void findYourSemiOpenFoursMainDiagonal(SimpleBoard board, int player) {
        int[][] b = board.getBoard();
        int empty = 0;
        boolean beginningEmpty = false;
        boolean middleEmpty = false;

        for (int row = 0; row < b.length; row++) {
            for (int col = 0; col < b[0].length; col++) {
                /*If there is a piece of your's on a square.*/
                if (b[row][col] == player) {
                    four.add(new Square(new Location(row, col), player));
                    /*If there is a square on the board, backwards from this square in the direction.*/
                    if (row - 1 >= 0 && col - 1 >= 0) {
                        if (b[row - 1][col - 1] == SimpleBoard.EMPTY) {
                            four.add(new Square(new Location(row - 1, col - 1), SimpleBoard.EMPTY))
                            /* From this moment on, it is possible that this Four is open from two sides.
                            *  This condition will be reverted on appearance of a middleEmpty.*/
                            beginningEmpty = true;
                        }
                    }
                    /*From here moving only forward. If there is a board square ahead. */
                    while (row + 1 < board.getWidth() && col + 1 < board.getHeight()) {
                        row++;
                        col++;
                        /*If piece on square isn't opponents. If it is your's or it's empty.
                         */
                        if (b[row][col] == player) {
                            four.add(new Square(new Location(row, col), player));
                        }
                        if (b[row][col] == SimpleBoard.EMPTY) {
                            /*If there already is an square empty in the middle, then it can't
                             * be a potential Four. Breaks out of the potentialFour while loop to
                              * the searching for one piece for loops. OTHERWISE */
                            if (middleEmpty) {
                                /*Empty the openFour 'variable'.*/
                                four.clear();
                                break;
                            }
                            four.add(new Square(new Location(row, col), SimpleBoard.EMPTY));
                            middleEmpty = true;
                        }
                        /* There can be 3 X 3 = 9 different cases with beginning, end and middle position
                        states. Of which one is unusable 000 - totally closed from all positions. So 8.
                        Case 1 & 2  001 & 000  A closeable four, only one side open from the END.*/
                        if (four.size() == 4 && !beginningEmpty && !middleEmpty) {
                            if (row + 1 < board.getWidth() && col + 1 < board.getHeight()) {
                                if (b[row + 1][col + 1] == SimpleBoard.EMPTY) {
                                    four.add(new Square(new Location(row, col), SimpleBoard.EMPTY));
                                    closeableFours.add(four);
                                    four.clear();
                                    break;
                                }
                            }
                            /*If isn't empty CAN ONLY BE opponents piece, otherwise the game would have already
                            * been won. And in this case, its a closed four, so break.*/
                            four.clear();
                            break;
                        }
                        /* 000. 001.
                        * Case 3 & 4  010 & 011
                        * 010 is closeable. */
                        if (four.size() >= 4 && !beginningEmpty && middleEmpty) {
                            if (row + 1 < board.getWidth() && col + 1 < board.getHeight()) {
                                if (b[row + 1][col + 1] == SimpleBoard.EMPTY) {
                                    four.add(new Square(new Location(row, col), player));
                                    openFours.add(four);
                                    four.clear();
                                    break;
                                }
                            }
                            /*When it gets out of bounds, breaks.*/
                            else if (row + 1 == board.getWidth() && col - 1 == board.getHeight()) {
                                four.clear();
                                break;
                            }
                            /*If is followed*/
                            else if (four.size() == 5b[row + 1][col + 1] != SimpleBoard.EMPTY
                                    && b[row + 1][col + 1] != player) {

                            }

                        }
                        /* 000 001 010 011
                         100 & 101
                        Case 5. &  6. .*/
                        if (four.size() == 5 && beginningEmpty && !middleEmpty) {
                            if (row + 1 < board.getWidth() && col + 1 < board.getHeight()) {
                                if (b[row + 1][col + 1] == SimpleBoard.EMPTY) {
                                    four.add(new Square(new Location(row, col), SimpleBoard.EMPTY));
                                    openFours.add(four);
                                }
                            }
                            /* Case 3. 100 An open four that is open only from the BEGINNING. */
                            else if (row + 1 == board.getWidth() && col + 1 == board.getHeight()) {
                                closeableFours.add(four);
                            }
                            else if (b[row + 1][col + 1] != SimpleBoard.EMPTY) {
                                closeableFours.add(four);
                            }
                        }
                        /* Case 4. 110 An open four that is open from the BEGINNING and the MIDDLE. */
                        if (four.size() == 5 && middleEmpty && beginningEmpty) {
                            if (row + 1 < board.getWidth() && col + 1 < board.getHeight()) {
                                if (b[row + 1][col + 1] == SimpleBoard.EMPTY) {

                                }
                            }
                        }
                    }
                }
            }
        }
    }
    public class Square {
        private Object location;
        private int inhabitance;


        public Square(Location location, int inhabitance) {
            this.location = location;
            this.inhabitance = inhabitance;
        }
        public int getInhabitance() {
            return inhabitance;
        }
    }

//    public Location mainDiagonal(SimpleBoard board, int player, Location piece){
//        int[][] b = board.getBoard();
//        int above = 0;
//        int below = 0;
//        int count = 1;
//        boolean upwards = true;
//        // check up the diagonal
//        for (int i = 1; row > 0 && col > 0 && row < board.getWidth() && col < board.getHeight(); i++) {
//            if (above != player && above != 0) {
//                count++;
//                upwards = false;
//            }
//
//            // check down the diagonal
//            if (!upwards && piece.getRow() < board.getWidth() && piece.getColumn() < board.getHeight()) {
//                if (above != player && above != 0) {
//                    count++;
//                    upwards = true;
//                }
//            } else {
//                break;
//            }
//        }
//        return null;
//    }

    @Override
    public String getName() {
        return "Stiv";
    }

}
