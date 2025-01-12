package excel.list;

public class Subtract extends Operator{

	public Subtract(Table table) {
		super(table);
	}
	
	@Override
	public double Calculate(Position initialPosition, Position finalPosition) {
		transformList(initialPosition, finalPosition);
		result = numbers.get(0);
		for (int index = 1; index<numbers.size(); index ++) {
			result = result - numbers.get(index);
		}
		return result;
	}
}
