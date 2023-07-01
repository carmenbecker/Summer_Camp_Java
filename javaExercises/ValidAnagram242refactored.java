package javaExercises;

import java.util.HashMap;
import java.util.Map;

public class ValidAnagram242refactored {
    public static boolean isAnagram(String s, String t) {
        Map<Character, Integer> firstWordMap = new HashMap<>();
        Map<Character, Integer> secondWordMap = new HashMap<>();

        extracted(s, firstWordMap);
        extracted(t, secondWordMap);
        return firstWordMap.equals(secondWordMap);

    }

    private static void extracted(String s, Map<Character, Integer> firstWordMap) {
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (firstWordMap.containsKey(c)) {
                int currentValue = firstWordMap.get(c);
                currentValue++;
                firstWordMap.put(c, currentValue);
            } else {
                firstWordMap.put(c, 1);
            }
        }
    }

    public static void main(String[] args) {
        // Arrange
        String s0 = "anagram";
        String t0 = "nagaram";
        String s1 = "a";
        String t1 = "ab";
        String s2 = "rat";
        String t2 = "car";

        // Act
        boolean result0 = isAnagram(s0, t0);
        boolean result1 = isAnagram(s1, t1);
        boolean result2 = isAnagram(s2, t2);

        // Assert
        boolean expected0 = true;
        boolean expected1 = false;
        boolean expected2 = false;

        System.out.println(result0 == expected0);
        System.out.println(result1 == expected1);
        System.out.println(result2 == expected2);
        /*
         * 
         * System.out.println(result3 == expected3);
         * System.out.println(result4 == expected4);
         */

    }
}
