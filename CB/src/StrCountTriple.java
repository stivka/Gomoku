/**
 * Created by Stiv on 16/05/2017.
 */
public class StrCountTriple {
    public void printNumbers(int[] numbers) {
        for (int number : numbers) {
            System.out.print(number);
        }
    }

    public static void main(String[] args) {
        int[] numbers = {8, 6, 4, 6, 9, 6};
//        printNumbers(numbers);
        StrCountTriple instance = new StrCountTriple();
        instance.printNumbers(numbers);
    }
}
