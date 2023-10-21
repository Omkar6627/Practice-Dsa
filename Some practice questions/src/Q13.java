import java.util.Scanner;

public class Q13 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String firstString = scanner.nextLine();


        String secondString = scanner.nextLine();

        if (firstString.equals(secondString)) {
            System.out.println("The two strings are equal.");
        } else {
            System.out.println("The two strings are not equal.");
        }
    }
}
