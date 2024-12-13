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
