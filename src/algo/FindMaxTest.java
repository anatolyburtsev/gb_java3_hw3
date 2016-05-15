package algo;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by onotole on 15.05.16.
 */
public class FindMaxTest {
    @Test
    public void oneElementTest() throws Exception {
        int[] array = {17};
        assertEquals(17, FindMax.findMax(array));
    }

    @Test(expected = IllegalArgumentException.class)
    public void emptyTest() throws Exception {
        int[] array = {};
        FindMax.findMax(array);
    }

    @Test
    public void easyTest() throws Exception {
        int[] array = {-1, -5, -15};
        assertEquals(-1, FindMax.findMax(array));
    }

}