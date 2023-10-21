public class Q25 {
    public static char findFirstNonRepeatedCharacter(String str) {

        int[] charCount = new int[256];


        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            charCount[c]++;
        }


        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (charCount[c] == 1) {
                return c;
            }
        }

        return '\0';
    }

    public static void main(String[] args) {
        String input = "Qadewffvfvfbgrvfdvghykjybdsxqw.";
        char firstNonRepeated = findFirstNonRepeatedCharacter(input);

        if (firstNonRepeated != '\0') {
            System.out.println( firstNonRepeated);
        } else {
            System.out.println("No non-repeated character ");
        }
    }
}
