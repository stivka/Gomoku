/**
 * Created by Stiv on 07/03/2017.
 */
package ee.ttu.java.albumcreation;

/**
 *
 */
public class Band {

    /**
     * Entry point to the program.
     * @param args arguments from command line.
     */
    public static void main(String[] args) {
        Song song1 = new Song();
        song1.setTitle("First song");
        song1.setLength("05:34"); //cannot work if length is not valid
        song1.addAuthor("Me");
        song1.addAuthor("My friend");

        Song song2 = new Song();
        song2.setTitle("Second song");
        song2.setLength("12:34");
        song2.addAuthor("My friend");

        Song song3 = new Song();
        song2.setTitle("Third song");
        song2.setLength("9:18");
        song2.addAuthor("Me");

        Song wrongSong = new Song();
        wrongSong.setTitle("Bom Diggity");
        wrongSong.setLength("3:2");
        wrongSong.addAuthor("Darkness");

        Album album1 = new Album();
        album1.setTitle("Album1");
        album1.setGenre("pop");
        album1.addSong(song1);
        album1.addSong(song2);
        album1.addSong(song3);
        System.out.println(album1.release());
    }
}
