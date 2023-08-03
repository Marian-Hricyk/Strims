package frequency;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class FrequencyWords {
    public static void main(String[] args) throws FileNotFoundException {
        String file = "src/words.txt";
        Map<String, Integer> wordFrequencyMap = worDreed(file);
        Map<String,Integer> sorte=sortMap(wordFrequencyMap);
        for (String word : sorte.keySet()) {
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

    private  static Map<String,Integer> sortMap(Map<String,Integer> map) {
        List<Map.Entry<String, Integer>> list = new LinkedList<>(map.entrySet());

        Collections.sort(list,new Comparator<Map.Entry<String,Integer>>(){

            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });

        Map<String,Integer> sortmap=new LinkedHashMap<>();
        for (Map.Entry<String,Integer> entry:list){
            sortmap.put(entry.getKey(),entry.getValue());
        }
return sortmap;
    }
}
