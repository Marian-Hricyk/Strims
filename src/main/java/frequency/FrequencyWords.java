package frequency;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FrequencyWords {
    public static void main(String[] args) throws FileNotFoundException {
        String file = "src/words.txt";
        Map<String, Integer> wordFrequencyMap = worDreed(file);
        for (String word : wordFrequencyMap.keySet()) {
            int frequency = wordFrequencyMap.get(word);
            System.out.println(word + " " + frequency);
        }
    }

    private static Map<String, Integer> worDreed(String file) throws FileNotFoundException {
        Map<String, Integer> frequency = new HashMap<>();

        Scanner scanner = new Scanner(new File(file));
        while (scanner.hasNext()) {
            String[] words = scanner.nextLine().split("\\s+");
            for (String word : words) {
                word = word.toLowerCase();
                frequency.put(word, frequency.getOrDefault(word, 0) + 1);
            }
        }
        scanner.close();
        return frequency;
    }
}
