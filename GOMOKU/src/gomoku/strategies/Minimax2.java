package gomoku.strategies;

import gomoku.ComputerStrategy;
import gomoku.Location;
import gomoku.SimpleBoard;

import java.util.ArrayList;
import java.util.Collections;
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

    Location opponentLastMove;
    Location yourLastMove;

    public static List<Location> chain = new ArrayList<>();
    public static List<Location> chainEmptyLinks = new ArrayList<>();
    public static List<List<Location>> opponentOpenFour = new ArrayList<>();
    public static List<List<Location>> opponentCloseableFour = new ArrayList<>();
    public static List<List<Location>> yourOpenFour = new ArrayList<>();
    public static List<List<Location>> yourCloseableFour = new ArrayList<>();







    @Override
    public Location getMove(SimpleBoard board, int player) {
        if (firstMove) {
            firstMoves(board, player);
            return yourLastMove;
        }

        currentBoard = board.getBoard();
        getOpponentLastMove();
        /* Look around opponents last move and look around your last move.*/
        lookAround(opponent, opponentLastMove);

        lookAround(you, yourLastMove);

        for (int i = 0; i < currentBoard.length; i++) {
            for (int j = 0; j < currentBoard[0].length; j++) {
                if (currentBoard[i][j] == SimpleBoard.EMPTY) {
                    // first empty location
                    return new Location(i, j);
                }
            }
        }
        return null;
    }

    public void firstMoves(SimpleBoard board, int player) {
        firstMove = false;
        if (player == SimpleBoard.PLAYER_WHITE) {
            you = SimpleBoard.PLAYER_WHITE;
            opponent = SimpleBoard.PLAYER_BLACK;
            lastBoard = board.getBoard();
            lastBoard[board.getHeight() / 2][board.getWidth() / 2] = player;
            yourLastMove = new Location(board.getHeight() / 2, board.getWidth() / 2);
        }
        else if (player == SimpleBoard.PLAYER_BLACK) {
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

    public void lookAround(int player, Location lastMove) {
        for (int row = lastMove.getRow() - 1; row <= lastMove.getRow() + 1; row++) {
            for (int col = lastMove.getColumn() - 1; col <= lastMove.getColumn() + 1; col++) {
                /* If the square to be viewed is in bounds of the board.*/
                if (row >= 0 && col >= 0 && row < currentBoard.length && col < currentBoard.length) {
                    /* If there's one of opponent's pieces adjacent to the move he made last.*/
                    if (currentBoard[row][col] == player) {
                        chain.add(new Location(row, col));
                        lookOnLine(row, col, player);
                    }
                }
            }
        }
    }
    public void lookOnLine(int row, int col, int player) {
        /* The row and col of adjacent piece to opponentLastMove.*/
        int rowIncrement;
        int colIncrement;

        if (player == you) {
            rowIncrement = yourLastMove.getRow() - row;
            colIncrement = yourLastMove.getColumn() - col;

//            for (List<Location> chain: yourOpenFour){
//                for (Location link : chain) {
//                    if (currentBoard[link.getRow()][link.getColumn()] == SimpleBoard.EMPTY) {
//
//                    }
//                }
//            }
        } else {
            rowIncrement = opponentLastMove.getRow() - row;
            colIncrement = opponentLastMove.getColumn() - col;
        }

        /* Check in one direction of the line.*/
        while (row + rowIncrement >= 0 && col + colIncrement >= 0
                && row + rowIncrement < currentBoard.length && col + colIncrement < currentBoard.length) {
            row += rowIncrement;
            col += colIncrement;
            if (currentBoard[row][col] == player) {
                chain.add(new Location(row, col));
            }
            /* Also adds the locations of any possible empty squares, to later determine if the chain is 'open' or not.*/
            if (currentBoard[row][col] == SimpleBoard.EMPTY) {
                chainEmptyLinks.add(new Location(row, col));
                break;
            } else {
                break;
            }
        }
        /* Check the other direction of the line.*/
        while (row - rowIncrement >= 0 && col - colIncrement >= 0
                && row - rowIncrement < currentBoard.length && col - colIncrement < currentBoard.length) {
            row = opponentLastMove.getRow() - rowIncrement;
            col = opponentLastMove.getColumn() - colIncrement;
            if (currentBoard[row][col] == player) {
                chain.add(new Location(row, col));
            }
            if (currentBoard[row][col] == SimpleBoard.EMPTY) {
                chainEmptyLinks.add(new Location(row, col));
                break;
            } else {
                break;
            }
        }

        determineChainType(player);
    }

    public void determineChainType(int player) {
        if (chain.size() == 4) {
            chain.addAll(chainEmptyLinks);
            if (chainEmptyLinks.size() == 2) {
                if (player == you) {
                    yourOpenFour.add(chain);
                }
                opponentOpenFour.add(chain);
            }
            if (chainEmptyLinks.size() == 1) {
                if (player == you) {
                    yourCloseableFour.add(chain);
                }
                opponentCloseableFour.add(chain);
            }
        }
        if (chain.size() == 3) {

        }
        printLists();
    }

    public void printLists() {
        System.out.println(opponentCloseableFour.size());
    }

    public void getOpponentLastMove() {
        for (int i = 0; i < currentBoard.length; i++) {
            for (int j = 0; j < currentBoard[0].length; j++) {
                /* The square that is different on this board from the square on lastBoard,
                is the OPPONENT'S LAST MOVE.*/
                if (currentBoard[i][j] != lastBoard[i][j]) {
//                    System.out.println(String.valueOf(currentBoard[i][j]));
                    opponentLastMove = new Location(i, j);
                    chain.add(opponentLastMove);
                }
            }
        }
    }

    @Override
    public String getName() {
        return "Tudengi nimi";
    }

}