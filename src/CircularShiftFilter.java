import java.io.EOFException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;


public class CircularShiftFilter extends Filter {

	@Override
	public void run() {
		while(true) {
			try {
				String incomingLine = read().trim();
				Queue<String> words = new LinkedList<String>(Arrays.asList(incomingLine.split("\\s")));
				
				for(int i = 0; i < words.size(); i++) {
					String outgoingLine = toLine(words);
					write(outgoingLine);
					circularShift(words);
				}
				
			} catch (EOFException e) {
				write(null);
				break;
			}
		}
	}
	
	private String toLine(Queue<String> words) {
		StringBuilder lineBuilder = new StringBuilder();
		for(String word : words) {
			lineBuilder.append(word);
			lineBuilder.append(" ");
		}
		String line = lineBuilder.toString().trim();
		return line;
	}

	private void circularShift(Queue<String> words) {
		String firstWord = words.poll();
		words.offer(firstWord);
	}


	

}
