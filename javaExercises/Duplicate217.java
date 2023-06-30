package javaExercises;

// Solved using Test-driven development (Red,Green,Refactor)
import java.util.Arrays;

public class Duplicate217 {

    static boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int x = 1; x < nums.length; x++) {
            if (nums[x] == nums[x - 1]) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        // Arrange
        // No repeated numbers
        int[] nums0 = { 0, 1, 2, 3, 4 };
        // Repeated assorted numbers
        int[] nums1 = { 0, 1, 2, 2, 3, 4 };
        // Repeated unassorted numbers
        int[] nums2 = { 4, 12, 2, 0, 3, 2 };
        // Act
        boolean result0 = containsDuplicate(nums0);
        boolean result1 = containsDuplicate(nums1);
        boolean result2 = containsDuplicate(nums2);
        // Assert
        System.out.println(result0 == false);
        System.out.println(result1 == true);
        System.out.println(result2 == true);

    }
}
