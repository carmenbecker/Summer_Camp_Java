import java.io.File;

/**
 * Driver for Markov Model classes
 * Uses WordGrams and Markov Model to generate
 * random text based on a training text. Prints
 * text and runtime measurements.
 * For use in Java Summer Camp @Madrid_Innovation_Lab 
 * @author Ola
 * @author Brandon 
 * @author Carmen 
 */

public class MarkovDriver {
	
	private static int TEXT_SIZE = 100;
	private static long RANDOM_SEED = 1234;
	private static int MODEL_ORDER = 2;
	private static boolean PRINT_MODE = true;
	
	public static void main(String[] args) {
		// Can change the training text here
		String filename = "data/alice.txt";
		File f = new File(filename);
		String text = TextSource.textFromFile(f);

		// only one line below should be uncommented
		MarkovInterface generator = new BaseMarkov(MODEL_ORDER);
		//MarkovInterface generator = new HashMarkov(MODEL_ORDER);
		
		generator.setSeed(RANDOM_SEED);

		double beforeTraining = System.nanoTime();
		generator.setTraining(text);
		double afterTraining = System.nanoTime();
		double trainingTimeMS = (afterTraining - beforeTraining)/1e9; 
		

		double beforeGenerating = System.nanoTime();
		String random = generator.getRandomText(TEXT_SIZE);
		double afterGenerating = System.nanoTime();
		double generatingTimeMS = (afterGenerating - beforeGenerating)/1e9; 

		int numTrainWords = text.split("\\s+").length;
		System.out.printf("\nTrained on text in %s with T=%d words\n", filename, numTrainWords);
		System.out.printf("Training time = %2.3f s\n", trainingTimeMS);
		System.out.printf("Generated N=%d random words with order %d Markov Model\n", TEXT_SIZE, MODEL_ORDER);
		System.out.printf("Generating time = %2.3f s\n", generatingTimeMS);
		if (PRINT_MODE) {
			printNicely(random,80);
		}
		
		

	}

	private static void printNicely(String random, int screenWidth) {
		String[] words = random.split("\\s+");
		int psize = 0;
		System.out.println("----------------------------------");
		for(int k=0; k < words.length; k++){
			System.out.print(words[k]+ " ");
			psize += words[k].length() + 1;
			if (psize > screenWidth) {
				System.out.println();
				psize = 0;
			}
		}
		System.out.println("\n----------------------------------");
	}

}
