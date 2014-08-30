import java.io.EOFException;


public abstract class Filter implements Runnable {

	private Pipe pipeIn, pipeOut;
	
	public void setPipeIn(Pipe pipeIn) {
		this.pipeIn = pipeIn;
	}
	
	public void setPipeOut(Pipe pipeOut) {
		this.pipeOut = pipeOut;
	}
	
	public String read() throws EOFException {
		return pipeIn.read();
	}
	
	public void write(String string) {
		if (string != null) {
			pipeOut.write(string);
		} else {
			pipeOut.close();
		}
	}

}
