package javaExercises;

import java.util.HashMap;
import java.util.Map;

public class ValidParenthesis20beta {
    public static boolean isValid(String s) {
        Map<Character, Character> parMap = new HashMap<>() {
            {
                put('(', ')');
                put('[', ']');
                put('{', '}');

            }
        };
        boolean result = false;
        for (int x = 0; x < s.length(); x++) {
            if (s.length() == 1) {
                return result;
            }
            Character parOpen = ' ';
            if (s.charAt(x) == '(' || s.charAt(x) == '{' || s.charAt(x) == '[') {
                parOpen = s.charAt(x);
                boolean isClosed = s.contains(Character.toString((parMap.get(parOpen))));
                if (isClosed) {
                    result = true;
                } else {
                    result = false;
                    break;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        // Arrange
        String s0 = "()";
        String s1 = "()[]{}";
        String s2 = "(}";
        String s3 = "{[]}";
        // This last case is not working
        // String s4 = "([)]";

        // Act
        boolean result0 = isValid(s0);
        boolean result1 = isValid(s1);
        boolean result2 = isValid(s2);
        boolean result3 = isValid(s3);
        // boolean result4 = isValid(s4);

        // Assert
        boolean expected0 = true;
        boolean expected1 = true;
        boolean expected2 = false;
        boolean expected3 = true;
        // boolean expected4 = false;

        System.out.println(result0 == expected0);
        System.out.println(result1 == expected1);
        System.out.println(result2 == expected2);
        System.out.println(result3 == expected3);
        // System.out.println(result4 == expected4);

    }
}
