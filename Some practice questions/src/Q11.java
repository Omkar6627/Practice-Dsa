import java.util.Scanner;

public class Q11 {
    public static long calculateFactorial(int n) {
        if (n == 0) {
            return 1;
        } else {
            return n * calculateFactorial(n - 1);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int number = scanner.nextInt();



            long factorial = calculateFactorial(number);
            System.out.println("Factorial of " + number + " is " + factorial);

    }
}
