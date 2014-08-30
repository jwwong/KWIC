import java.io.EOFException;
import java.util.List;

/**
 * IgnoreWordsFilter does a case-insensitive check of the first word
 * of each incoming line. 
 * @author JunWei
 *
 */
public class NoiseWordsFilter extends Filter {
	
	List<String> noiseWords;
	
	NoiseWordsFilter(List<String> noiseWords) {
		this.noiseWords = noiseWords;
	}

	@Override
	public void run() {
		while(true) {
			try {
				String line = read();
				String firstWord = line.split("\\s")[0].toLowerCase();
				if (!noiseWords.contains(firstWord)) {
					write(line);
				}
			} catch (EOFException e) {
				// propagate null to close pipeline
				write(null);
				break;
			}
		}
	}


}
