import java.io.EOFException;


public class Sink extends Filter {

	@Override
	public void run() {
		while(true) {
			try {
				String line = read();
				System.out.println(line);
			} catch (EOFException e) {
				break;
			}
		}
	}

}
