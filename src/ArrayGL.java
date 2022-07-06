public class ArrayGL<E> implements MyList<E> {

    E[] elements;
    int size;

    public ArrayGL(E[] initialElements) {
        this.elements = initialElements;
        this.size = initialElements.length;
    }

    @Override
    public E[] toArray() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void transformAll(MyTransformer<E> mt) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void chooseAll(MyChooser<E> mc) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public boolean isEmpty() {
        // TODO Auto-generated method stub
        return false;
    }

    // Fill in all required methods here
}