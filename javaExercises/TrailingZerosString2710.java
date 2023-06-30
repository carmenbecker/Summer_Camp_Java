package javaExercises;

public class TrailingZerosString2710 {
    public static String removeTrailingZeros(String num) {

        for (int x = num.length() - 1; x >= 0; x--) {

            if (num.charAt(num.length() - 1) == '0') {
                num = num.substring(0, num.length() - 1);

            }
        }

        return num;
    }

    public static void main(String[] args) {
        // Arrange
        String num0 = "51230100";
        String num1 = "123";

        // Act
        String result0 = removeTrailingZeros(num0);
        String result1 = removeTrailingZeros(num1);

        // Assert
        String expected0 = "512301";
        String expected1 = "123";

        System.out.println(result0.equals(expected0));
        System.out.println(result1.equals(expected1));

    }
}
