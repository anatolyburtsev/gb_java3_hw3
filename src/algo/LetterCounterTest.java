package algo;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Created by onotole on 16.05.16.
 */
public class LetterCounterTest {
    @Test
    public void EmptyString() throws Exception {
        Map<Character, Integer> map = new HashMap<>();
        assertEquals(map, LetterCounter.letterCounter(""));
    }

    @Test
    public void letterCounter() throws Exception {
        Map<Character, Integer> map = new HashMap<>();
        map.put('a', 4);
        map.put('p', 4);
        map.put('r', 1);
        assertEquals(LetterCounter.letterCounter("parappapa"), map);
    }

}