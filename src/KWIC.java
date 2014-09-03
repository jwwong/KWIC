import java.util.ArrayList;
import java.util.List;


public class KWIC {
	
	private static final String MESSAGE_CMDLINE_ARG = "KWIC <ignore word 1> <ignore word 2> ...";
	private static final String MESSAGE_WELCOME = "Welcome to KWIC. Please enter your lines:";

	public static void main(String[] args) {

		// Check user input
		if(args.length == 0) {
			System.out.println(MESSAGE_CMDLINE_ARG);
			return;
		}
		
		List<String> noiseWords = generateListOfNoiseWords(args); 
		showWelcomeMessage();
		
		new Pipeline(
				new Source(),
				new CircularShiftFilter(),
				new NoiseWordsFilter(noiseWords),
				new AlphabetizeFilter(noiseWords),
				new SortFilter(),
				new Sink()).run();
	}

	private static List<String> generateListOfNoiseWords(String[] args) {
		List<String> noiseWords = new ArrayList<String>();
		for (String token : args) {
			noiseWords.add(token.toLowerCase());
		}
		return noiseWords;
	}

	private static void showWelcomeMessage() {
		System.out.println(MESSAGE_WELCOME);
	}
	

}
