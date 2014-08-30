import java.io.EOFException;
import java.util.concurrent.ConcurrentSkipListSet;

public class SortFilter extends Filter {

	private ConcurrentSkipListSet<String> sortedBuffer =
			new ConcurrentSkipListSet<String>(String.CASE_INSENSITIVE_ORDER); 
	
	@Override
	public void run() {
		while(true) {
			String line;
			try {
				line = read();
				sortedBuffer.add(line);
			} catch (EOFException e) {
				break;
			}
		}
		
		while(!sortedBuffer.isEmpty()) {
			write(sortedBuffer.pollFirst());
		}
		write(null);

	}

}
