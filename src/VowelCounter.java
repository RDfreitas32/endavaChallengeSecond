import java.util.HashMap;
import java.util.Map;

class VowelCounter {
    private String input;
    private Map<Character, Integer> vowelMap;
    private int totalVowels;
    private StringBuilder totalVowelsDetail;
    private StringBuilder repeatedVowelsDetail;

    // Constructor
    public VowelCounter(String input) {
        this.input = input.toLowerCase(); // Normalize to lowercase
        this.vowelMap = new HashMap<>();
        this.totalVowels = 0;
        this.totalVowelsDetail = new StringBuilder();
        this.repeatedVowelsDetail = new StringBuilder();
        initializeVowelMap();
    }

    // Initialize the vowel map with all vowels set to 0
    private void initializeVowelMap() {
        char[] vowels = {'a', 'e', 'i', 'o', 'u'};
        for (char vowel : vowels) {
            vowelMap.put(vowel, 0);
        }
    }

    // Method to process the input and count vowels
    public void process() {
        for (char ch : input.toCharArray()) {
            if (vowelMap.containsKey(ch)) {
                vowelMap.put(ch, vowelMap.get(ch) + 1);
            }
        }
        buildDetails();
    }

    // Build details for total vowels and repeated vowels
    private void buildDetails() {
        for (Map.Entry<Character, Integer> entry : vowelMap.entrySet()) {
            int count = entry.getValue();
            if (count > 0) {
                totalVowels += count;
                totalVowelsDetail.append(entry.getKey()).append(", ");
                if (count > 1) {
                    repeatedVowelsDetail.append(count).append("(").append(entry.getKey()).append("), ");
                }
            }
        }

        // Remove trailing commas and spaces
        if (totalVowelsDetail.length() > 0) {
            totalVowelsDetail.setLength(totalVowelsDetail.length() - 2);
        }
        if (repeatedVowelsDetail.length() > 0) {
            repeatedVowelsDetail.setLength(repeatedVowelsDetail.length() - 2);
        } else {
            repeatedVowelsDetail.append("None");
        }
    }

    // Getters for results
    public String getTotalVowels() {
        return totalVowels + " (" + totalVowelsDetail.toString() + ")";
    }

    public String getRepeatedVowels() {
        return repeatedVowelsDetail.toString();
    }
}
