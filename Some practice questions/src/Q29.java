import java.util.ArrayList;
import java.util.Arrays;

public class Q29 {
    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4, 5};
        int[] B = {5, 6, 7};

        ArrayList<Integer> union = new ArrayList<>();
        ArrayList<Integer> intersection = new ArrayList<>();


        for (int value : A) {
            if (contains(B, value)) {
                union.add(value);
            } else {
                intersection.add(value);
            }
        }


        for (int value : B) {
            if (contains(A, value)) {
                union.add(value);
            }
        }

        System.out.println("Union of arrays A and B: " + Arrays.toString(union.toArray()));
        System.out.println("Intersection of arrays A and B: " + Arrays.toString(intersection.toArray()));
    }

    public static boolean contains(int[] arr, int value) {
        for (int num : arr) {
            if (num == value) {
                return false;
            }
        }
        return true;
    }
}
