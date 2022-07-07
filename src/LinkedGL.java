public class LinkedGL<E> implements MyList<E> {

    class Node {
        E value;
        Node next;

        public Node(E value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    Node front;
    int size;

    public LinkedGL(E[] contents) {
        // Fill in this constructor
    }

    // Helper method
    public void add(E s) {
        Node current = this.front;
        while(current.next != null) {
          current = current.next;
        }
        current.next = new Node(s, null);
        this.size += 1;
      }

    @Override
    public E[] toArray() {
		Node temp = this.front;
		@SuppressWarnings("unchecked")
		E[] arr = (E[])new Object[size];
        for (int i = 0; i < size; i++) {
        	if (temp.next != null) {
        		temp = temp.next;
    			arr[i] = temp.value;
        	}
		}
		return arr;      
    }

	@SuppressWarnings("unchecked")
	@Override
	public void transformAll(MyTransformer mt) {
		Node temp = front;
		for (int i = 0; i < size; i++) {
			temp = temp.next;
			temp.value = (E) mt.transformElement(temp.value);
		}
	}

	@Override
	public void chooseAll(MyChooser mc) {
		Node temp = this.front, prev = null;
		this.front = new Node(null, null);
		
		// if the head node is not in chooser
		while (temp != null && (mc.chooseElement(temp.value) == true)) {
			this.add(temp.next.value);
		}
	}

    @Override
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }


}