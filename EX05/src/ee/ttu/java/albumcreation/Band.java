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
        song3.setTitle("Third song");
        song3.setLength("9:18");
        song3.addAuthor("Me");

        Song wrongSong = new Song();
        wrongSong.setTitle("Bom Diggity");
        wrongSong.setLength("3:2");
        wrongSong.addAuthor("Darkness");

        Song fifthSong = new Song();
        fifthSong.setTitle("Fifth Song");
        fifthSong.setLength("33:00");
        fifthSong.addAuthor("Von Mega");

        Album album1 = new Album();
        album1.setTitle("Album1");
        album1.setGenre("pop");
        album1.addSong(song1);
        album1.addSong(song2);
        album1.addSong(song3);
        album1.addSong(wrongSong);
        album1.addSong(fifthSong);
        album1.release();
//        System.out.println(album1.release());

//        Song testSong = new Song();
//        testSong.setLength("999:0");

//        System.out.println(song1.getLength() + song1.getTitle() + song1.getAuthors());
//        System.out.println(song2.getLength() + song2.getTitle() + song2.getAuthors());
//        System.out.println(song3.getLength() + song3.getTitle() + song3.getAuthors());
//        System.out.println(wrongSong.getLength() + wrongSong.getTitle() + wrongSong.getAuthors());
//        System.out.println();
    }
}
