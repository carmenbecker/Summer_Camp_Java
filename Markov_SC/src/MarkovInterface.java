import java.util.List;

/**
 * Interface for Markov models for random text generation. 
 * Note that the order of the Markov model would be 
 * typically set via a constructor.
 * For use in Java Summer Camp @Madrid_Innovation_Lab 
 * @author Ola
 * @author Brandon
 * @author Carmen 
 *
 */

public interface MarkovInterface {
	
	/**
	 * Set the training text for subsequent random text generation.
	 * Should always be called prior to calling getRandomText.
	 * @param text is the training text
	 */
	public void setTraining(String text);
	

	/**
	 * Get a list of Strings containing all words that follow
	 * from wgram in the training text. Result may be an empty list.
	 * @param wgram is a WordGram to search for in the text
	 * @return List of words following wgram in training text.
	 * May be empty.
	 */
	public List<String> getFollows(WordGram wgram);

	
	/**
	 * Get randomly generated text based on the training text.
	 * Details of how random text is generated are left to the 
	 * implementing class.
	 * @param length is the number of characters or words generated
	 * @return randomly generated text 
	 */
	public String getRandomText(int length);
	

	/**
	 * Returns the order of the Markov Model, typically set at construction 
	 * @return the order of this model
	 */
	public int getOrder();
	
	
	/**
	 * Sets the random seed and initializes the random 
	 * number generator. A given implementing class should
	 * always produce the same randomText given the same 
	 * training text and random seed.
	 * @param seed initial seed for java.util.Random
	 */
	public void setSeed(long seed);
}
