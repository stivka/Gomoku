public class TK2kirjalik {
    public static void main(String[] args) {
        int x = 3, y = 2; // Rida 1
        if ((x++ + ++y) % 2 == 0) { // Rida 2
            System.out.println("Paaris"); // Rida 3
        } else { // Rida 4
            System.out.println("Paaritu"); // Rida 5
        }
    }
}