# VowelCounter - Object-Oriented Version

## Description
`VowelCounter` is a Java class designed to count vowels in a string and provide detailed statistics on:
- Total vowels found.
- List of unique vowels.
- Repeated vowels with their counts.

This implementation follows an object-oriented approach for better modularity and reusability.

## Features
1. Encapsulation of logic into a dedicated class `VowelCounter`.
2. Modular methods for initialization, processing, and result construction.
3. Supports handling multiple strings through separate instances.

## Code Explanation

### Class: `VowelCounter`
The `VowelCounter` class handles all logic for counting vowels and generating results.

#### **Constructor**
```java
public VowelCounter(String input) {
    this.input = input.toLowerCase();
    this.vowelMap = new HashMap<>();
    this.totalVowels = 0;
    this.totalVowelsDetail = new StringBuilder();
    this.repeatedVowelsDetail = new StringBuilder();
    initializeVowelMap();
}
```
- Accepts the input string.
- Converts the string to lowercase to ensure case-insensitive comparison.
- Initializes the vowel map and supporting variables.

#### **Method: `initializeVowelMap`**
```java
private void initializeVowelMap() {
    char[] vowels = {'a', 'e', 'i', 'o', 'u'};
    for (char vowel : vowels) {
        vowelMap.put(vowel, 0);
    }
}
```
- Prepares the vowel map with keys for each vowel (`a, e, i, o, u`) and sets their initial counts to `0`.

#### **Method: `process`**
```java
public void process() {
    for (char ch : input.toCharArray()) {
        if (vowelMap.containsKey(ch)) {
            vowelMap.put(ch, vowelMap.get(ch) + 1);
        }
    }
    buildDetails();
}
```
- Iterates over each character of the input string.
- Checks if the character is a vowel and updates its count in the map.
- Calls `buildDetails` to construct the result strings.

#### **Method: `buildDetails`**
```java
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

    if (totalVowelsDetail.length() > 0) {
        totalVowelsDetail.setLength(totalVowelsDetail.length() - 2);
    }
    if (repeatedVowelsDetail.length() > 0) {
        repeatedVowelsDetail.setLength(repeatedVowelsDetail.length() - 2);
    } else {
        repeatedVowelsDetail.append("None");
    }
}
```
- Processes the map to generate two detailed strings:
  - **Total vowels**: Includes all vowels found.
  - **Repeated vowels**: Lists vowels that appear more than once with their counts.
- Removes trailing commas and spaces for cleaner output.

#### **Getters**
```java
public String getTotalVowels() {
    return totalVowels + " (" + totalVowelsDetail.toString() + ")";
}

public String getRepeatedVowels() {
    return repeatedVowelsDetail.toString();
}
```
- Provide formatted strings for total vowels and repeated vowels.

### Main Class: `Main`
The `Main` class demonstrates the usage of `VowelCounter`.

#### Example Usage
```java
public class Main {
    public static void main(String[] args) {
        String name = "Rodrigo de Freitas Marcilio";

        // Create an instance of VowelCounter
        VowelCounter vowelCounter = new VowelCounter(name);

        // Process the input
        vowelCounter.process();

        // Print results
        System.out.println("Total Vowels: " + vowelCounter.getTotalVowels());
        System.out.println("Repeated Vowels: " + vowelCounter.getRepeatedVowels());
    }
}
```

## Explanation of Output
### Total Vowels
```java
System.out.println("Total Vowels: " + vowelCounter.getTotalVowels());
```
Example Output:
```
Total Vowels: 11 (a, e, i, o)
```
- Displays the total count of vowels found (`11`).
- Lists unique vowels in the order they appear.

### Repeated Vowels
```java
System.out.println("Repeated Vowels: " + vowelCounter.getRepeatedVowels());
```
Example Output:
```
Repeated Vowels: 2(a), 2(e), 4(i), 3(o)
```
- Lists vowels that appear more than once.
- Each entry shows the count followed by the vowel.

## How to Compile and Run
1. Save the files `VowelCounter.java` and `Main.java` in the same directory.
2. Compile both files:
   ```
   javac VowelCounter.java Main.java
   ```
3. Run the program:
   ```
   java Main
   ```

## Possible Improvements
- Add support for accented characters (`á`, `é`, `í`, etc.).
- Allow custom vowel sets for different languages.
- Optimize resource usage for very large strings.

## Contribution
If you want to contribute improvements or fixes, please submit a Pull Request to the GitHub repository.

