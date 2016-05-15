package algo;

/**
 * Created by onotole on 16.05.16.
 */
public class RevertString {
    public static String revertString(String input) {
        StringBuilder output = new StringBuilder();
        for (int i = input.length()-1; i >= 0; i--) {
            output.append(input.charAt(i));
        }
        return output.toString();
    }

    public static void main(String[] args) {
        String input = "abc";
        System.out.println(revertString(input));
    }

}
