import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Source extends Filter {
	
	private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
	
	@Override
	public void run() {
		String line;
		while(true) {
			try {
				line = reader.readLine();
				if (line.equals("")) {
					write(null);
					break;
				}
				write(line);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
