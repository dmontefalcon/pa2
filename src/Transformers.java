
class UpperCaseTransformer implements MyTransformer<String> {

	public String transformElement(String s) {
		if (s == null) {
			return s;
		}
		return s.toUpperCase();
	}

}

class additionTransformer implements MyTransformer<Integer> {

	@Override
	public Integer transformElement(Integer e) {
		if (e == null) {
			return e;
		}
		return e + 1;
	}
	
}