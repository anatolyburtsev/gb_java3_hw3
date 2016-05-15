package algo;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by onotole on 16.05.16.
 */
public class LetterCounter {
    public static Map<Character, Integer> letterCounter(String input) {
        Map<Character, Integer> map = new HashMap<>();
        char currentChar;
        int letterCounter;

        for (int i = 0; i < input.length(); i++) {
            currentChar = input.charAt(i);
            letterCounter = map.get(currentChar) == null ? 1 : map.get(currentChar) + 1;
            map.put(currentChar, letterCounter);
        }
        return map;
    }
}
