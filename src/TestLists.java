
import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection; 
import java.util.NoSuchElementException;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class TestLists {

	public static Collection<Object[]> LISTNUMS =
			Arrays.asList(new Object[][] { {"Linked"}, {"Array"} });
	private String listType;

	public TestLists(String listType) {
		super();
		this.listType = listType;
	}

	@Parameterized.Parameters(name = "{0}List")
	public static Collection<Object[]> bags() {
		return LISTNUMS;
	}

	private <E> MyList<E> makeList(E[] contents) {
		switch (this.listType) {
		case "Linked":
			return new LinkedGL<E>(contents);
		case "Array":
			return new ArrayGL<E>(contents);
		}
		return null;
	}

  // Don't change code above this line, it ensures the autograder works as
  // expected


  // This is a sample test; you can keep it, change it, or remove it as you like.
  // Note that it uses the method `assertArrayEquals`, which you should use to
  // test equality of arrays in this PA.
	@Test
	public void testSimpleToArray() {
		// Using the generic list to create an Integer list
		Integer[] int_input = {1, 2, 3};
		MyList<Integer> int_s = makeList(int_input);
		assertArrayEquals(int_input, int_s.toArray());
		
		// Using the generic list to create a String list
		String[] string_input = {"a", "b", "c"};
		MyList<String> string_s = makeList(string_input);
		assertArrayEquals(string_input, string_s.toArray());
	}
	
	@Test
	public <E> void testLlistInt() {
		// Using the generic list to create an Integer list
		Integer[] indepVar = {1, 2, 3};
		LinkedGL<Integer> list = new LinkedGL<Integer>(indepVar);
		E[] expVar = (E[]) list.toArray();
		assertArrayEquals(indepVar, expVar);
	}
	
	@Test
	public <E> void testLlistStr() {
		String[] indepVar = {"Hello", "Hi", "Greetings"};
		LinkedGL<String> list = new LinkedGL<String>(indepVar);
		E[] expVar = (E[]) list.toArray();
		assertArrayEquals(indepVar, expVar);
	}
	
	@Test
	public <E> void testCompArrInt()	 {
		Integer[] indepVar = {5, 4, 3};
		ArrayGL<Integer> list = new ArrayGL<Integer>(indepVar);
		E[] expVar = (E[]) list.toArray();
		assertArrayEquals(indepVar, expVar);
	}
	
	@Test
	public <E> void testCompArrStr()	 {
		String[] indepVar = {"Leg", "Arm", "Neck"};
		ArrayGL<String> list = new ArrayGL<String>(indepVar);
		E[] expVar = (E[]) list.toArray();
		assertArrayEquals(indepVar, expVar);
	}
	
	@Test
	public <E> void testTransformersArrStr() {
		String[] indepVar = {"Leg", "Arm", "Neck"};
		ArrayGL<String> list = new ArrayGL<String>(indepVar);
		list.transformAll(new UpperCaseTransformer());
		E[] expVar = (E[]) list.toArray();
		String[] var = {"LEG", "ARM", "NECK"};
		assertArrayEquals(var, expVar);
	}
	
	@Test
	public <E> void testTransformersArrInt() {
		Integer[] indepVar = {5, 10, 15};
		ArrayGL<Integer> list = new ArrayGL<Integer>(indepVar);
		list.transformAll(new additionTransformer());
		E[] expVar = (E[]) list.toArray();
		Integer[] var = {6, 11, 16};
		assertArrayEquals(var, expVar);
	}
	
	@Test
	public <E> void testTransformersLlistStr() {
		String[] indepVar = {"Leg", "Arm", "Neck"};
		LinkedGL<String> list = new LinkedGL<String>(indepVar);
		list.transformAll(new UpperCaseTransformer());
		E[] expVar = (E[]) list.toArray();
		String[] var = {"LEG", "ARM", "NECK"};
		assertArrayEquals(var, expVar);
	}
	
	
	

}