package javaExercises;

import java.util.HashMap;
import java.util.Map;

// Solved using Test-driven development (Red,Green,Refactor)

public class SingleNumber136 {

    public static int singleNumber(int[] nums) {
        Map<Integer, Integer> freqDict = new HashMap<>();
        for (int i : nums) {
            freqDict.put(i, freqDict.getOrDefault(i, 0) + 1);
        }
        int key = 0;
        for (Map.Entry<Integer, Integer> entry : freqDict.entrySet()) {
            if (entry.getValue() == 1) {
                key = entry.getKey();
                break;
            }
        }

        // System.out.println(freqDict);
        // System.out.println(key);
        return key;

    }

    public static void main(String[] args) {
        // Arrange
        int[] nums0 = { 2, 2, 1 };
        int[] nums1 = { 4, 1, 2, 1, 2 };
        int[] nums2 = { 1 };
        // Act
        int result0 = singleNumber(nums0);
        int result1 = singleNumber(nums1);
        int result2 = singleNumber(nums2);
        // Assert
        System.out.println(result0 == 1);
        System.out.println(result1 == 4);
        System.out.println(result2 == 1);

    }
}
