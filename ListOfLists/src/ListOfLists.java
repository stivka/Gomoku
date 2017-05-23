import java.util.ArrayList;
import java.util.List;

/**
 * Created by Stiv on 22/05/2017.
 */
public class ListOfLists {
    List<Location> locations = new ArrayList<>();
    List<List<Location>> listOflists = new ArrayList<>();

    public static void main(String[] args) {
        ListOfLists run = new ListOfLists();
        run.putInside();

    }

    private void putInside() {
        locations.add(new Location(0, 0));
        locations.add(new Location(1, 1));
        listOflists.add(locations);
        List<Location> moreLocations = new ArrayList<>();
        moreLocations.add(new Location(3, 3));
        moreLocations.add(new Location(2, 2));
        listOflists.add(moreLocations);

        for (int i = 0; i < listOflists.size(); i++) {
            System.out.print(listOflists.get(i).toString());
        }
    }



    public class Location {
        private int rows;
        private int cols;

        public Location(int rows, int cols) {
            this.rows = rows;
            this.cols = cols;
        }
        /**
         * @return Row index
         */
        public int getRow() {
            return rows;
        }

        /**
         * @return Column index
         */
        public int getColumn() {
            return cols;
        }

        @Override
        public String toString() {
            return String.format("(%d, %d)", rows, cols);
        }


    }
}

