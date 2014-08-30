
public class Pipeline implements Runnable {
	
	private Filter[] filters;
	
	public Pipeline(Filter...filters) {
		this.filters = filters;
		connectFilters(this.filters);
	}

	private void connectFilters(Filter... filters) {
		for(int i = 0; i < (filters.length - 1); i++) {
			Pipe pipe = new Pipe();
			filters[i].setPipeOut(pipe);
			filters[i+1].setPipeIn(pipe);
		}
	}

	@Override
	public void run() {
		for(Filter filter : filters) {
			new Thread(filter).start();
		}
	}

}
