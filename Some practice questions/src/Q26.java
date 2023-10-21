public class Q26
{
    public static int findIndexForSum(int a, int b, int[] x) {
        for (int i = 0; i < x.length; i++) {
            if (x[i] + a == b) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int a = 2;
        int b = 3;
        int[] x = {1, 6, 8, 9, 5};

        int index = findIndexForSum(a, b, x);

        if (index != -1) {
            System.out.println( index);
        } else {
            System.out.println("No match");
        }
    }
}
