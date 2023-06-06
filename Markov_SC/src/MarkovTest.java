import org.junit.jupiter.api.Test;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test suite for HashMarkov
 *
 * @author Emily Du
 * @author Havish Malladi
 * @author Carmen 
 */
public class MarkovTest {

    private MarkovInterface getModel(int order) {
        // Choose which implementation to test here
        return new BaseMarkov(order);
        // return new HashMarkov(order);

    }


    /**
     * Tests correctness by checking finding certain substrings that
     * must be in the generated text and k-grams that can't be in the text.
     */
    @Test
    public void testSimpleKgram() {
        String training = "h h i i h h i i h h i i h h i i h h i i h"
                + " h i i h h i i h h i i h h i i h h i i h h i i h h i i";
        String[] must = {"h h i", "h i i", "i i h", "i h h", "h h i i h h i i"};
        String[] notExist = {"h h h", "i i i", "h i h", "i h i"};

        MarkovInterface markov = getModel(2);
        markov.setTraining(training);
        String output = "";
        while (output.length() < 15) {
            output = markov.getRandomText(100);
        }

        for (String s : must) {
            assertTrue(output.contains(s));
        }
        for (String s : notExist) {
            assertFalse(output.contains(s));
        }
    }


    /**
     * This test checks if MarkovModel makes a correct " Ngram when the source
     * contains only one pattern of distinct letters
     */
    @Test
    public void testMapAllRepeats() {
        int length = 100;
        int maxOrder = 10;

        StringBuilder testStringBuilder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            testStringBuilder.append("cdf ");
            if (i < length - 1)
                testStringBuilder.append(' ');
        }
        String testString = testStringBuilder.toString();

        for (int k = 1; k <= maxOrder; k++) {
            MarkovInterface markov = getModel(1);
            markov.setTraining(testString);
            String output = markov.getRandomText(length / 5);
            assertEquals("cdf cdf cdf cdf cdf cdf cdf cdf cdf cdf cdf cdf cdf cdf cdf cdf cdf cdf cdf cdf", output);
        }
    }


    /**
     * This test checks if MarkovModel makes a correct Ngram when the source
     * contains no repeat patterns
     */
    @Test
    public void testMapNoRepeats() {
        String testString = "q w e r t y u i o p a s d f g h j k l z x c v b n m aa ab ac ad ae af ag";
        int length = 100;
        int maxOrder = 10;

        for (int k = 1; k <= maxOrder; k++) {
            MarkovInterface markov = getModel(k);
            markov.setSeed(123);
            markov.setTraining(testString);
            String output = markov.getRandomText(length / 5);
            assertTrue(checkOutputOfNoRepeatInput(output, k));
        }
    }


    /**
     * This test checks your return value of getFollows() contains
     * all characters that follow the k-gram.
     */
    @Test
    public void testGetFollows() {

        String testString = "e f g e f g f e f g g e f g h e f g x e f g y e f g z y efg x h g f e";  // Note it sterts with "efg" insteeh of "efge"
        String[][] inStrings = {
                {"e", "f", "g"},
                {"f", "g"},
                {"g", "g"},
                {"f", "g", "h", "e"},
                {"y"},
                {"h", "g", "f"}};
        String[][] out = {
                {"e", "f", "g", "h", "x", "y", "z"},
                {"e", "f", "g", "h", "x", "y", "z"},
                {"e"},
                {"f"},
                {"e", "efg"},
                {"e"}};


        WordGram[] in = new WordGram[inStrings.length];
        for (int i = 0; i < inStrings.length; i++) {
            in[i] = new WordGram(inStrings[i], 0, inStrings[i].length);
        }

        for (int i = 0; i < in.length; i++) {
            int k = in[i].length();
            MarkovInterface markov = getModel(k);
            markov.setTraining(testString);
            List<String> expected = Arrays.asList(out[i]);
            List<String> actual = markov.getFollows(in[i]);
            checkListUnordered(expected, actual);
        }
    }

    /**
     * This test checks your return value of getFollows() contains all characters that follow the k-gram,
     * with the corresponding frequencies for duplicates.
     */
    @Test
    public void testGetFollowsRepeats() {
        String testString = "w x y w w x y x w x y x w x y y w x y y w x y y w x y z w x y z w x y z w x y z y y x w";
        String[][] inStrings = {
                {"w", "x", "y"},
                {"x", "y"},
                {"y", "y"},
                {"z"},
                {"w", "x", "y", "y"}};
        String[][] out = {
                {"w", "x", "x", "y", "y", "y", "z", "z", "z", "z"},
                {"w", "x", "x", "y", "y", "y", "z", "z", "z", "z"},
                {"w", "w", "w", "x"},
                {"w", "w", "w", "y"},
                {"w", "w", "w"}};

        WordGram[] in = new WordGram[inStrings.length];
        for (int i = 0; i < inStrings.length; i++) {
            in[i] = new WordGram(inStrings[i], 0, inStrings[i].length);
        }

        for (int i = 0; i < in.length; i++) {
            int k = in[i].length();
            MarkovInterface markov = getModel(k);
            markov.setTraining(testString);
            List<String> expected = Arrays.asList(out[i]);
            List<String> actual = markov.getFollows(in[i]);
            checkListUnordered(expected, actual);
        }
    }


    /**
     * @param expected elements of correct result
     * @param actual elements of generated result from student code
     * Helper method to verify tested elements in list
     */
    private static void checkListUnordered(List<String> expected, List<String> actual) {
        HashMap<String, Integer> expectedFreq = new HashMap<>();
        HashMap<String, Integer> actualFreq = new HashMap<>();
        for (String s : expected) {
            if (!expectedFreq.containsKey(s))
                expectedFreq.put(s, 0);
            expectedFreq.put(s, expectedFreq.get(s) + 1);
        }
        for (String s : actual) {
            if (!actualFreq.containsKey(s))
                actualFreq.put(s, 0);
            actualFreq.put(s, actualFreq.get(s) + 1);
        }

        for (String s : expectedFreq.keySet()) {
            if (!actualFreq.containsKey(s)) {
                fail("\nExpected element " + s + " does not exist");
            }
            assertEquals(expectedFreq.get(s), actualFreq.get(s));
        }
        for (String s : actualFreq.keySet()) {
            if (!expectedFreq.containsKey(s)) {
                fail("\nElement " + s + " in returned list should not exist");
            }
        }
    }

    /**
     * Helper method to verify output data from an input with no repeats
     */
    private static boolean checkOutputOfNoRepeatInput(String actual, int k) {
        String[] acceptedOutputs1 = new String[] {
                "ag x c v b n m aa ab ac ad ae af ag ae af ag ae af ag",
                "b n m aa ab ac ad ae af ag i p o ae aa ae r y y v",
                "g h j k l z x c v b n m aa ab ac ad ae af ag aa",
                "e r t y u i o p a s d f g h j k l z x c",
                "w e r t y u i o p a s d f g h j k l z x",
                "g h j k l z x c v b n m aa ab ac ad ae af ag a",
                "k l z x c v b n m aa ab ac ad ae af ag s x a k",
                "t y u i o p a s d f g h j k l z x c v b",
                "i o p a s d f g h j k l z x c v b n m aa",
                "g h j k l z x c v b n m aa ab ac ad ae af ag s"
        };
        String[] acceptedOutputs2 = new String[] {
                "ag x c v b n m aa ab ac ad ae af ag a s d f g h",
                "b n m aa ab ac ad ae af ag i s p x o a ae k aa u",
                "g h j k l z x c v b n m aa ab ac ad ae af ag aa",
                "e r t y u i o p a s d f g h j k l z x c",
                "w e r t y u i o p a s d f g h j k l z x",
                "g h j k l z x c v b n m aa ab ac ad ae af ag a",
                "k l z x c v b n m aa ab ac ad ae af ag s p x o",
                "t y u i o p a s d f g h j k l z x c v b",
                "i o p a s d f g h j k l z x c v b n m aa",
                "g h j k l z x c v b n m aa ab ac ad ae af ag s"
        };

        return actual.equals(acceptedOutputs1[k - 1]) || actual.equals(acceptedOutputs2[k-1]);
    }

}
