package javaExercises;

public class FirstOccuranceIndexString28 {
    public static int strStr(String haystack, String needle) {
        int result = haystack.indexOf(needle);
        return result;
    }

    public static void main(String[] args) {
        // Arrange
        String haysack0 = "sadbutsad";
        String needle0 = "sad";
        String haysack1 = "leetcode";
        String needle1 = "leeto";

        // Act
        int result0 = strStr(haysack0, needle0);
        int result1 = strStr(haysack1, needle1);

        // Assert
        int expected0 = 0;
        int expected1 = -1;

        System.out.println(result0 == expected0);
        System.out.println(result1 == expected1);

    }
}
