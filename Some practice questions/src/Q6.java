import java.util.Scanner;

public class Q6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        int n = scanner.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        int highest = arr[0];
        for (int i = 1; i < n; i++) {
            if (arr[i] > highest) {
                highest = arr[i];
            }
        }

        System.out.println( highest);
    }
}
