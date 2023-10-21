public class Q28 {
    public static char findHighestFrequencyCharacter(String str) {
        int[] charCount = new int[256];

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            charCount[c]++;
        }

        char mostFrequentChar = '\0';
        int maxFrequency = 0;

        for (int i = 0; i < charCount.length; i++) {
            if (charCount[i] > maxFrequency) {
                maxFrequency = charCount[i];
                mostFrequentChar = (char) i;
            }
        }

        return mostFrequentChar;
    }

    public static void main(String[] args) {
        String input = "sadggdffgjntdfnggvgmgfsghhjnefghjnfefcadsdssdvrghrrv";
        char mostFrequent = findHighestFrequencyCharacter(input);

        if (mostFrequent != '\0') {
            System.out.println(mostFrequent);
        } else {
            System.out.println("No characters");
        }
    }
}
