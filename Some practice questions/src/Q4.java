import java.util.Scanner;

public class Q4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String sentence = scanner.nextLine();


        String[] words = sentence.split("\\s+");



        for (String word : words) {
            System.out.println(word);
        }
    }
}
