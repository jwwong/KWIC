import java.io.EOFException;
import java.util.LinkedList;
import java.util.Queue;


public class Pipe {
	
	private static final int THREAD_SLEEPTIME = 10;
	private Queue<String> buffer = new LinkedList<String>();
	private boolean isClosed = false;

	public String read() throws EOFException {
		while(true) {
			if(!buffer.isEmpty()) {
				String string = buffer.poll();
				return string;
			} else {
				if(isClosed) {
					throw new EOFException();
				}
				try {
					Thread.sleep(THREAD_SLEEPTIME);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public void write(String string) {
		if(!isClosed){
			buffer.offer(string);
		}
	}
	
	public void close() {
		this.isClosed = true;
	}
}
