package gomoku.strategies;

import gomoku.ComputerStrategy;
import gomoku.Location;
import gomoku.SimpleBoard;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Stiv on 25/05/2017.
 */
public class Minimax2 implements ComputerStrategy {
    public static int[][] lastBoard;
    public static int[][] currentBoard;

    boolean firstMove = true;
    public static int you;
    public static int opponent;

    boolean lookAroundOpponent = true;

    public static Location opponentLastMove;
    public static Location yourLastMove;
    public static Location adjacent;
    public static int player;
    public static Location lastMove;

    public static List<Location> chain = new ArrayList<>();
    public static List<Location> chainEmptyLinks = new ArrayList<>();

    public static List<List<Location>> opponentOpenThrees = new ArrayList<>();
    public static List<List<Location>> yourOpenThrees = new ArrayList<>();
    public static List<List<Location>> opponentCloseableThrees = new ArrayList<>();
    public static List<List<Location>> yourCloseableThrees = new ArrayList<>();
    public static List<List<Location>> opponentOpenFours = new ArrayList<>();
    public static List<List<Location>> yourOpenFours = new ArrayList<>();
    public static List<List<Location>> opponentCloseableFours = new ArrayList<>();
    public static List<List<Location>> yourCloseableFours = new ArrayList<>();

    public static List<List<List<Location>>> opponentLists = new ArrayList<>();


    @Override
    public Location getMove(SimpleBoard board, int player) {
        if (firstMove) {
            firstMoves(board, player);
            return yourLastMove;
        }
        chain.clear();
        chainEmptyLinks.clear();

        currentBoard = board.getBoard();
        getOpponentLastMove();

        /* Checks from opponent's and your list whether it takes the place of an opening in a four chain.
         If it is an opening in one of the lists, the change the value of the list.
         After doing this operation, you have a new assessment of fours.

        If the piece isn't a part of any four lists, it means it might form a new four list.
        It will then enter the lookAround method:
        Look around opponents last move and look around your last move.*/
        checkFromLists();

        printLists();

        player = you;
        for (int i = 0; i < currentBoard.length; i++) {
            for (int j = 0; j < currentBoard[0].length; j++) {
                if (currentBoard[i][j] == SimpleBoard.EMPTY) {
                    // first empty location
                    yourLastMove = new Location(i, j);
                    lastBoard = currentBoard;
                    lastBoard[i][j] = player;

                    return new Location(i, j);
                }
            }
        }
        return null;
    }

    public void checkFromLists() {

        /* If one of the locations is already stored as an empty in a list with four pieces of one player.*/
        for (int i = 0; i < yourCloseableFours.size(); i++) {
            if (yourCloseableFours.get(i).contains(opponentLastMove)
                    || yourCloseableFours.get(i).contains(yourLastMove)) {
                /* Remove because it is closed. */
                yourCloseableFours.remove(i);
            }
        }
        for (int i = 0; i < opponentCloseableFours.size(); i++) {
            if (opponentCloseableFours.get(i).contains(yourLastMove)
                    || opponentCloseableFours.get(i).contains(opponentLastMove)) {
                opponentCloseableFours.remove(i);
            }
        }
        for (int i = 0; i < yourOpenThrees.size(); i++) {
            for (int j = 0; j < yourOpenThrees.get(i).size(); j++) {
                if (yourOpenThrees.get(i).get(j).equals(opponentLastMove)
                        || yourOpenThrees.get(i).get(j).equals(yourLastMove)) {
                    yourOpenThrees.remove(i);
                }
            }
        }
        for (int i = 0; i < opponentOpenThrees.size(); i++) {
            System.out.println(opponentOpenThrees.get(i).size());
            for (int j = 0; j < opponentOpenThrees.get(i).size(); j++) {

                System.out.println(String.valueOf(opponentOpenThrees.get(i)));

                if (opponentOpenThrees.get(i).get(j).equals(yourLastMove)
                        || opponentOpenThrees.get(i).get(j).equals(opponentLastMove)) {
                    opponentOpenThrees.remove(i);
                }
            }
        }
        lookAround();
    }

    public void lookAround() {
        /* lookAroundOpponent value is globally set to true initially, so that it would first check opponent's state
        of affairs. Whence it passes into the if condition, the player is switched to you. */

        for (int row = lastMove.getRow() - 1; row <= lastMove.getRow() + 1; row++) {
            for (int col = lastMove.getColumn() - 1; col <= lastMove.getColumn() + 1; col++) {
                /* If the square to be viewed is in bounds of the board.*/
                if (row >= 0 && col >= 0 && row < currentBoard.length && col < currentBoard.length) {
                    /* If there's one of opponent's pieces adjacent to the move he made last.*/
                    if (currentBoard[row][col] == player && !(row == lastMove.getRow() && col == lastMove.getColumn())) {
                        chain.clear();
                        chainEmptyLinks.clear();

                        chain.add(lastMove);
                        adjacent = new Location(row, col);
                        chain.add(adjacent);
                        lookOnLine(row, col, player);
                    }
                }
            }
        }
        /* Call again the same method, for checking YOUR moves.*/
        if (player == opponent) {
            player = you;
            lastMove = yourLastMove;

            lookAround();
        }
        player = opponent;
    }


    public void lookOnLine(int row, int col, int player) {
        /* The row and col of adjacent piece to lastMove.
        lookOnline is called out first with opponent as player, and second you as player, from lookAround method.*/
        int rowIncrement;
        int colIncrement;
        Location lastMove;

        if (player == you) {
            rowIncrement = yourLastMove.getRow() - row;
            colIncrement = yourLastMove.getColumn() - col;
            lastMove = yourLastMove;
        } else {
            rowIncrement = opponentLastMove.getRow() - row;
            colIncrement = opponentLastMove.getColumn() - col;
            lastMove = opponentLastMove;
        }

        /* Check in one direction of the line.*/
        while (row + rowIncrement >= 0 && col + colIncrement >= 0
                && row + rowIncrement < currentBoard.length && col + colIncrement < currentBoard.length) {
            row += rowIncrement;
            col += colIncrement;
            if (currentBoard[row][col] == player && !(row == lastMove.getRow() && col == lastMove.getColumn())
                    && !(row == adjacent.getRow() && col == adjacent.getColumn())) {
                chain.add(new Location(row, col));
            }
            /* Also adds the locations of any possible empty squares, to later determine if the chain is 'open' or not.*/
            if (currentBoard[row][col] == SimpleBoard.EMPTY) {
                chainEmptyLinks.add(new Location(row, col));
                break;
            /* else it is other player's piece, and it breaks your chain. */
            } else if (currentBoard[row][col] != SimpleBoard.EMPTY && currentBoard[row][col] != player) {
                break;
            }
        }
        /* Check the other direction of the line.*/
        while (row - rowIncrement >= 0 && col - colIncrement >= 0
                && row - rowIncrement < currentBoard.length && col - colIncrement < currentBoard.length) {
            row -= rowIncrement;
            col -= colIncrement;
            if (currentBoard[row][col] == player && !(row == lastMove.getRow() && col == lastMove.getColumn())
                    && !(row == adjacent.getRow() && col == adjacent.getColumn())) {
                chain.add(new Location(row, col));
            }
            if (currentBoard[row][col] == SimpleBoard.EMPTY) {
                chainEmptyLinks.add(new Location(row, col));
                break;
            } else if (currentBoard[row][col] != SimpleBoard.EMPTY && currentBoard[row][col] != player){
                break;
            }
        }
        determineChainType(player);
    }

    public void determineChainType(int player) {
        /* If there are 4 links of one player next to each other, it is a potential closeable or open chain.*/
        List<Location> chain2 = new ArrayList<Location>();
        if (chain.size() == 4) {
            chain.addAll(chainEmptyLinks);
//            System.out.println();
            chain2 = chain;
            if (chainEmptyLinks.size() == 2) {
                if (player == you) {
                    yourOpenFours.add(chain);
                } else {
                    opponentOpenFours.add(chain);
                }
            }
            if (chainEmptyLinks.size() == 1) {
                if (player == you) {
                    yourCloseableFours.add(chain);
                } else {
                    opponentCloseableFours.add(chain);
                }
            }
        }
        if (chain.size() == 3) {
            chain.addAll(chainEmptyLinks);
            chain2 = chain;
            if (chainEmptyLinks.size() == 2) {
                if (player == you) {
                    yourOpenThrees.add(chain2);
                } else {
                    opponentOpenThrees.add(chain2);
                }
            }
            if (chainEmptyLinks.size() == 1) {
                if (player == you) {
                    yourCloseableThrees.add(chain);
                } else {
                    opponentCloseableThrees.add(chain);
                }
            }
        }
        chain.clear();
        chainEmptyLinks.clear();
    }

    public void firstMoves(SimpleBoard board, int player) {
        firstMove = false;
        if (player == SimpleBoard.PLAYER_WHITE) {
            you = SimpleBoard.PLAYER_WHITE;
            opponent = SimpleBoard.PLAYER_BLACK;
            lastBoard = board.getBoard();
            lastBoard[board.getHeight() / 2][board.getWidth() / 2] = player;
            yourLastMove = new Location(board.getHeight() / 2, board.getWidth() / 2);
        } else if (player == SimpleBoard.PLAYER_BLACK) {
            you = SimpleBoard.PLAYER_BLACK;
            opponent = SimpleBoard.PLAYER_WHITE;
            lastBoard = board.getBoard();
            if (lastBoard[board.getHeight() / 2][board.getWidth() / 2] == SimpleBoard.EMPTY) {
                lastBoard[board.getHeight() / 2][board.getWidth() / 2] = player;
                yourLastMove = new Location(board.getHeight() / 2, board.getWidth() / 2);
            } else {
                lastBoard[board.getHeight() / 2 - 1][board.getWidth() / 2 - 1] = player;
                yourLastMove = new Location(board.getHeight() / 2 - 1, board.getWidth() / 2 - 1);
            }
        }
    }

    public void printLists() {
        System.out.println("opponentCloseableFours.size()" + opponentCloseableFours.size());
        System.out.println("opponentOpenThrees.size()" + opponentOpenThrees.size());
        System.out.println("opponentCloseableThrees.size()" + opponentCloseableThrees.size());
        System.out.println("yourCloseableFours.size()" + yourCloseableFours.size());
        System.out.println("yourOpenThrees.size()" + yourOpenThrees.size());
        System.out.println("yourCloseableThrees.size()" + yourCloseableThrees.size());
    }

    public void getOpponentLastMove() {
        for (int i = 0; i < currentBoard.length; i++) {
            for (int j = 0; j < currentBoard[0].length; j++) {
                /* The square that is different on this board from the square on lastBoard,
                is the OPPONENT'S LAST MOVE.*/
                if (currentBoard[i][j] != lastBoard[i][j]) {
//                    System.out.println(String.valueOf(currentBoard[i][j]));
                    opponentLastMove = new Location(i, j);

                    lastMove = opponentLastMove;
                    player = opponent;
                }
            }
        }
    }

    @Override
    public String getName() {
        return null;
    }
}