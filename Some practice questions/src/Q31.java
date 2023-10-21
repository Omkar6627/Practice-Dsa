import java.util.HashMap;

public class Q31 {
    public static int findMostFrequentElement(int[] arr) {
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();

        int mostFrequentElement = arr[0];
        int maxFrequency = 1;

        for (int element : arr) {
            if (frequencyMap.containsKey(element)) {
                int newFrequency = frequencyMap.get(element) + 1;
                frequencyMap.put(element, newFrequency);

                if (newFrequency > maxFrequency) {
                    maxFrequency = newFrequency;
                    mostFrequentElement = element;
                }
            } else {
                frequencyMap.put(element, 1);
            }
        }

        return mostFrequentElement;
    }

    public static void main(String[] args) {
        int[] array = {1};//insert array here or write your scanner -omi:)

        int mostFrequent = findMostFrequentElement(array);
        System.out.println( mostFrequent);
    }
}
