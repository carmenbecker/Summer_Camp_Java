import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

/**
 * Convenience class to open file or URL and return
 * entire resource as a single string
 * @author Ola
 * @author Carmen 
 *
 */
public class TextSource {
	
	/**
	 * Read a URL and return the text read as a string
	 * @param url the URL for reading
	 * @return one string, the text from the URL
	 */
	public static String textFromURL(String url){
		BufferedInputStream source;
		Scanner scan = null;
		try {
			source = new BufferedInputStream(new URL(url).openStream());
			source.mark(Integer.MAX_VALUE);
			scan = new Scanner(source);
		} catch (MalformedURLException e) {
			System.err.println("error malformed "+url);
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println("error reading "+url);
			e.printStackTrace();
		}
		scan.useDelimiter("\\Z");
		String s = scan.next();
		s = s.replaceAll("\\s+"," ");
		return s;
	}
	
	/**
	 * Read a file and return the file contents as a string
	 * @param f is the file for reading
	 * @return the text of the file as a string
	 */
	public static String textFromFile(File f){
		BufferedInputStream source;
		Scanner scan = null;
		try {
			source = new BufferedInputStream(new FileInputStream(f));
			source.mark(Integer.MAX_VALUE);
			scan = new Scanner(source);
		} catch (IOException e) {
			System.err.println("error reading "+f);
			e.printStackTrace();
		}
		scan.useDelimiter("\\Z");
		String s = scan.next();
		s = s.replaceAll("\\s+"," ");
		return s;
	}
}
