import java.util.Scanner;
import java.util.Arrays;

public class Q7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] arr = new int[n];


        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
//only works for a sorted and unique array if it is not unique make a few more pointers
        Arrays.sort(arr);

        int thirdLowest = arr[2];

        System.out.println("The 3rd lowest number in the array is: " + thirdLowest);
    }
}
