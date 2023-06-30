package javaExercises;

import java.math.BigInteger;

// Solved using Test-driven development (Red,Green,Refactor)

public class SignProduct1822v2 {

    public static int arraySign(int[] nums) {

        return signFunc(nums);
    }

    // Use this option to track accumulator with the debugger and see how it
    // overflows
    /*
     * public static int signFunc(int[] product) {
     * int accumulator = 1;
     * int negativeCount = 0;
     * for (int x = 0; x < product.length; x++) {
     * 
     * accumulator = (accumulator * product[x]);
     * if (product[x] < 0) {
     * negativeCount++;
     * }
     * }
     * if (negativeCount % 2 != 0 && accumulator > 0) {
     * accumulator *= -1;
     * }
     * if (accumulator > 0) {
     * return 1;
     * }
     * if (accumulator < 0) {
     * return -1;
     * }
     * return 0;
     * }
     */
    // This solution works up to testcase 8.

    public static int signFunc(int[] product) {
        BigInteger accumulator = BigInteger.ONE;
        int negativeCount = 0;

        for (int x = 0; x < product.length; x++) {
            BigInteger num = BigInteger.valueOf(product[x]);
            accumulator = accumulator.multiply(num);

            if (product[x] < 0) {
                negativeCount++;
            }
        }

        if (negativeCount % 2 != 0 && accumulator.signum() == 1) {
            accumulator = accumulator.negate();
        }

        return accumulator.signum();
    }

    public static void main(String[] args) {
        // Arrange
        int[] testcase1 = { -1, -2, -3, -4, 3, 2, 1 };
        int[] testcase2 = { 1, -2, -3, -4, 3, 2, 1 };
        int[] testcase3 = { 0, -2, -3, -4, 3, 2, 1 };
        int[] testcase4 = { 9, 72, 34, 29, -49, -22, -77, -17, -66, -75, -44, -30, -24 };
        int[] testcase5 = { -1, 1, -1, 1, -1 };
        int[] testcase6 = { 51, 38, 73, 21, 27, 55, 18, 15, 79, 29, 13, 45, 8, -73, -92, -20, -50, -60, -70 };
        int[] testcase7 = { 74, -99, -77, -15, -20, -69, -99, -70, -95, -50, -19, -50, -17, -27, -79, -68, -30, -51, -6,
                -1, -52, -93, -76, -36, -5, -87, -21, -94, -88, -98, -81, -66, -19, -1, -98 };
        int[] testcase8 = { 41, 65, 14, 80, 20, 10, 55, 58, 24, 56, 28, 86, 96, 10, 3, 84, 4, 41, 13, 32, 42, 43, 83,
                78, 82, 70, 15, -41 };
        // Act
        int result1 = arraySign(testcase1);
        int result2 = arraySign(testcase2);
        int result3 = arraySign(testcase3);
        int result4 = arraySign(testcase4);
        int result5 = arraySign(testcase5);
        int result6 = arraySign(testcase6);
        int result7 = arraySign(testcase7);
        int result8 = arraySign(testcase8);
        // Assert
        System.out.println(result1 == 1);
        System.out.println(result2 == -1);
        System.out.println(result3 == 0);
        System.out.println(result4 == -1);
        System.out.println(result5 == -1);
        System.out.println(result6 == 1);
        System.out.println(result7 == 1);
        System.out.println(result8 == -1);
    }
}
