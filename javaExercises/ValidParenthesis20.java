package javaExercises;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

// I asked ChatGPT for help and suggested a
public class ValidParenthesis20 {
    public static boolean isValid(String s) {
        Map<Character, Character> parMap = new HashMap<>() {
            {
                put('(', ')');
                put('[', ']');
                put('{', '}');

            }
        };
        Stack<Character> stack = new Stack<>();
        for (int x = 0; x < s.length(); x++) {
            char c = s.charAt(x);

            if (parMap.containsKey(c)) {
                stack.push(c); // Opening parenthesis, push to stack
            } else if (parMap.containsValue(c)) {
                if (stack.isEmpty()) {
                    return false; // No matching opening parenthesis
                }

                char openingPar = stack.pop();
                if (parMap.get(openingPar) != c) {
                    return false; // Mismatched parentheses
                }
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        // Arrange
        String s0 = "()";
        String s1 = "()[]{}";
        String s2 = "(}";
        String s3 = "{[]}";
        String s4 = "([)]";

        // Act
        boolean result0 = isValid(s0);
        boolean result1 = isValid(s1);
        boolean result2 = isValid(s2);
        boolean result3 = isValid(s3);
        boolean result4 = isValid(s4);

        // Assert
        boolean expected0 = true;
        boolean expected1 = true;
        boolean expected2 = false;
        boolean expected3 = true;
        boolean expected4 = false;

        System.out.println(result0 == expected0);
        System.out.println(result1 == expected1);
        System.out.println(result2 == expected2);
        System.out.println(result3 == expected3);
        System.out.println(result4 == expected4);

    }
}
