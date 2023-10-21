public class Q30 {
    public static int nthFibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        return nthFibonacci(n - 1) + nthFibonacci(n - 2);
    }

    public static void main(String[] args) {
        int n = 10; // Change this to the desired value of n
        int result = nthFibonacci(n);
        System.out.println("The " + n + "th Fibonacci number is: " + result);
    }
}
