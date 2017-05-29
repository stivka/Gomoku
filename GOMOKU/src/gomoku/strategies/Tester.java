package gomoku.strategies;

import gomoku.ComputerStrategy;
import gomoku.Location;
import gomoku.SimpleBoard;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Stiv on 29/05/2017.
 */
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Tester {
    /**
     * Created by Stiv on 08/02/2017.
     * For testing bits and pieces.
     */
        public static List<Location> chain = new ArrayList<>();
        public static List<Location> chainEmptyLinks = new ArrayList<>();
        public static List<List<Location>> opponentOpenFours = new ArrayList<>();
        public static List<List<Location>> opponentCloseableFours = new ArrayList<>();
        public static List<List<Location>> yourOpenFours = new ArrayList<>();
        public static List<List<Location>> yourCloseableFours = new ArrayList<>();


        public static void main(String[] args) {
            chain.add(new Location(0, 0));
            chain.add(new Location(1, 1));
            chain.add(new Location(2, 2));
            chain.add(new Location(3, 3));

            opponentCloseableFours.add(chain);
            for (List kett: opponentCloseableFours) {
                for (Object link: kett) {
                    if (link.equals(new Location(3, 3))) {
                        System.out.println("it works.");
                    }
                }
            }

        }

}

