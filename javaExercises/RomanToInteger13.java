package javaExercises;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger13 {
    public static int romanToInt(String s) {
        Map<Character, Integer> romanMap = new HashMap<>() {
            {
                put('I', 1);
                put('V', 5);
                put('X', 10);
                put('L', 50);
                put('C', 100);
                put('D', 500);
                put('M', 1000);
            }
        };
        int accumulator = 0;
        for (int x = 0; x < s.length(); x++) {
            Character roman = s.charAt(x);
            if ((roman == 'I' || roman == 'X' || roman == 'C' || roman == 'M') && x < s.length() - 1) {

                if (roman == 'I' && s.charAt(x + 1) == 'V') {
                    accumulator -= romanMap.get(roman);

                } else if (roman == 'I' && s.charAt(x + 1) == 'X') {
                    accumulator -= romanMap.get(roman);

                } else if (roman == 'X' && s.charAt(x + 1) == 'L') {
                    accumulator -= romanMap.get(roman);

                } else if (roman == 'X' && s.charAt(x + 1) == 'C') {
                    accumulator -= romanMap.get(roman);

                } else if (roman == 'C' && s.charAt(x + 1) == 'D') {
                    accumulator -= romanMap.get(roman);
                } else if (roman == 'C' && s.charAt(x + 1) == 'M') {
                    accumulator -= romanMap.get(roman);
                } else {

                    accumulator += romanMap.get(roman);
                }
            } else {
                accumulator += romanMap.get(roman);
            }

        }
        return accumulator;
    }

    public static void main(String[] args) {
        // Arrange
        String s0 = "III";
        String s1 = "LVIII";
        String s2 = "MCMXCIV";

        // Act
        int result0 = romanToInt(s0);
        int result1 = romanToInt(s1);
        int result2 = romanToInt(s2);

        // Assert
        int expected0 = 3;
        int expected1 = 58;
        int expected2 = 1994;

        System.out.println(result0 == expected0);
        System.out.println(result1 == expected1);
        System.out.println(result2 == expected2);

    }
}
