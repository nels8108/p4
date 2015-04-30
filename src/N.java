// adapted directly from class resources

public class N {
	// instance variables
	private Object data;
	private N next, previous;

	// constructors
	public N() {

	}

	public N(Object o, N link) {
		data = o;
		next = link;
		// previous = plink;
	}

	// selectors
	public Object getData() {
		return data;
	}

	public void setData(Object o) {
		data = o;
	}

	public N getNext() {
		return next;
	}

	public N getPrevious() {
		return previous;
	}

	public void setNext(N link) {
		next = link;
	}

	public void setPrevious(N link) {
		previous = link;
	}
}
