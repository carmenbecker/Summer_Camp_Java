package javaExercises;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// Solved using Test-driven development (Red,Green,Refactor)

public class TwoSum1 {

    public static int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> numMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (numMap.containsKey(complement)) {
                return new int[] { numMap.get(complement), i };
            }
            numMap.put(nums[i], i);
        }

        return new int[0];

    }

    public static void main(String[] args) {
        // Arrange
        int[] nums0 = { 2, 7, 11, 15 };
        int target0 = 9;
        int[] nums1 = { 3, 2, 4 };
        int target1 = 6;
        int[] nums2 = { 3, 3 };
        int target2 = 6;
        int[] nums3 = { 3, 2, 3 };
        int target3 = 6;
        int[] nums4 = { 2, 5, 5, 11 };
        int target4 = 10;

        // Act
        int[] result0 = twoSum(nums0, target0);
        int[] result1 = twoSum(nums1, target1);
        int[] result2 = twoSum(nums2, target2);
        int[] result3 = twoSum(nums3, target3);
        int[] result4 = twoSum(nums4, target4);

        // Assert
        int[] expected0 = { 0, 1 };
        int[] expected1 = { 1, 2 };
        int[] expected2 = { 0, 1 };
        int[] expected3 = { 0, 2 };
        int[] expected4 = { 1, 2 };
        System.out.println(Arrays.equals(result0, expected0));
        System.out.println(Arrays.equals(result1, expected1));
        System.out.println(Arrays.equals(result2, expected2));
        System.out.println(Arrays.equals(result3, expected3));
        System.out.println(Arrays.equals(result4, expected4));

    }
}
