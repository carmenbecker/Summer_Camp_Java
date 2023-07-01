package javaExercises;

public class LengthLastWord58 {
    public static int lengthOfLastWord(String s) {
        String[] words = s.trim().split(" ");
        String lastWord = words[words.length - 1];
        return lastWord.length();
    }

    public static void main(String[] args) {
        // Arrange
        String s0 = "Hello World";
        String s1 = "   fly me   to   the moon  ";
        String s2 = "luffy is still joyboy";

        // Act
        int result0 = lengthOfLastWord(s0);
        int result1 = lengthOfLastWord(s1);
        int result2 = lengthOfLastWord(s2);

        // Assert
        int expected0 = 5;
        int expected1 = 4;
        int expected2 = 6;

        System.out.println(result0 == expected0);
        System.out.println(result1 == expected1);
        System.out.println(result2 == expected2);

    }
}
