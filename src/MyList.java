
public interface MyList<E> {
	  E[] toArray();
	  void transformAll(MyTransformer<E> mt);
	  void chooseAll(MyChooser<E> mc);
	  boolean isEmpty();
}