public class ArrayGL<E> implements MyList<E> {

    E[] elements;
    int size;

    public ArrayGL(E[] initialElements) {
        this.elements = initialElements;
        this.size = initialElements.length;
    }

    // Helper methods
    @SuppressWarnings("unchecked")
    private void expandCapacity() {
  	  // NOTE: I changed currentSize to currentCapacity below
  	  // because it's a better name for the variable
  	  int currentCapacity = this.elements.length;
  	  if(this.size < currentCapacity) { return; }

  	  E[] expanded = (E[])new Object[currentCapacity * 2];

  	  for(int i = 0; i < this.size; i += 1) {
  		  expanded[i] = this.elements[i];
  	  }

  	  this.elements = (E[]) expanded;
    }

    public void add(E s) {
        expandCapacity();
        this.elements[this.size] = s;
        this.size += 1;
    }

    @Override
    public E[] toArray() {
		E[] arr = (E[])new Object[size];
		for (int i = 0; i < this.size; i++) {
			arr[i] = elements[i];
		}
		return arr;
    }

    @Override
    public void transformAll(MyTransformer<E> mt) {
		for (int i = 0; i < this.size; i++) {
			elements[i] = (E) mt.transformElement(elements[i]);
		}        
    }

    @Override
    public void chooseAll(MyChooser<E> mc) {
		int arrSize = 0;
		int arrIterator = 0;
		for (int i = 0; i < this.size; i++) {
			if (mc.chooseElement(elements[i]) == true) {
				arrSize++;
			}
		}
		E[] arr = (E[])new Object[arrSize];
		for (int i = 0; i < arrSize; i++) {
			if (mc.chooseElement(elements[i]) == true) {
				arr[arrIterator] = elements[i];
			}

		}
		elements = arr;        
    }

    @Override
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    // Fill in all required methods here
}