import java.util.ArrayList;
import java.util.List;


public class KWIC {
	
	public static void main(String[] args) {

		// Check user input
		if(args.length == 0) {
			System.out.println("KWIC <ignore word 1> <ignore word 2> ...");
			return;
		}
		
		List<String> noiseWords = generateIgnoreWords(args); 
		showWelcomeMessage();
		
		new Pipeline(
				new Source(),
				new CircularShiftFilter(),
				new NoiseWordsFilter(noiseWords),
				new AlphabetizeFilter(noiseWords),
				new SortFilter(),
				new Sink()).run();
	}

	private static List<String> generateIgnoreWords(String[] args) {
		List<String> noiseWords = new ArrayList<String>();
		for (String token : args) {
			noiseWords.add(token.toLowerCase());
		}
		return noiseWords;
	}

	private static void showWelcomeMessage() {
		System.out.println("Welcome to KWIC. Please enter your lines:");
	}
	

}
