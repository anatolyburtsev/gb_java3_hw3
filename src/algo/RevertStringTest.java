package algo;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by onotole on 16.05.16.
 */
public class RevertStringTest {
    @Test
    public void revertString() throws Exception {
        String input = "abc";
        assertEquals("cba", RevertString.revertString(input));
    }

    @Test
    public void emptyString() throws Exception {
        String input = "";
        assertEquals("", RevertString.revertString(input));
    }

    @Test
    public void oneElementString() throws Exception {
        String input = "1";
        assertEquals("1", RevertString.revertString(input));
    }

    @Test
    public void strangeElementsString() throws Exception {
        String input = "¥ø";
        assertEquals("ø¥", RevertString.revertString(input));
    }

}