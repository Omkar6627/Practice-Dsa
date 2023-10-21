import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Q14 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String input = scanner.nextLine();
        String[] inputArray = input.split(" ");

        int[] numbers = new int[inputArray.length];
        String[] strings = new String[inputArray.length];

        for (int i = 0; i < inputArray.length; i++) {


                numbers[i] = Integer.parseInt(inputArray[i]);


                strings[i] = inputArray[i];

        }
//All codes are merged here togheether which is not reccomended and wont work but just did it to fit

        NumberSorter.sortNumbersAscending(numbers);
        NumberSorter.sortNumbersDescending(numbers);
        StringSorter.sortStringsAscending(strings);
        StringSorter.sortStringsDescending(strings);


        System.out.println(Arrays.toString(numbers));
        System.out.println( Arrays.toString(numbers));


        System.out.println( Arrays.toString(strings));
        System.out.println( Arrays.toString(strings));
    }
}


 class NumberSorter {
    public static void sortNumbersAscending(int[] numbers) {
        Arrays.sort(numbers);
    }

    public static void sortNumbersDescending(int[] numbers) {
        Arrays.sort(numbers);
        int n = numbers.length;
        for (int i = 0; i < n / 2; i++) {
            int temp = numbers[i];
            numbers[i] = numbers[n - i - 1];
            numbers[n - i - 1] = temp;
        }
    }
}

 class StringSorter {

    public static void sortStringsAscending(String[] strings) {
        Arrays.sort(strings);
    }
    public static void sortStringsDescending(String[] strings) {
        Arrays.sort(strings, Comparator.reverseOrder());
    }
}
