import java.io.EOFException;
import java.util.List;



public class AlphabetizeFilter extends Filter {
	
	List<String> ignoreWords;
	
	public AlphabetizeFilter(List<String> ignoreWords) {
		this.ignoreWords = ignoreWords;
	}

	@Override
	public void run() {
		while(true) {
			try {
				String incomingLine = read();
				String outgoingLine = alphabetizeLine(incomingLine);
				write(outgoingLine);
			} catch (EOFException e) {
				// propagate null to close pipeline
				write(null);
				break;
			}
			
		}
	}

	private String alphabetizeLine(String line) {
		String[] tokens = line.split("\\s");
		StringBuilder lineBuilder = new StringBuilder();
		for(String word : tokens) {
			String wordLowerCase = word.toLowerCase();
			if(ignoreWords.contains(wordLowerCase)) {
				lineBuilder.append(word);
			} else {
				lineBuilder.append(word.toUpperCase());
			}
			lineBuilder.append(" ");
		}
		String alphabetizedLine = lineBuilder.toString().trim();
		return alphabetizedLine;
	}

}
