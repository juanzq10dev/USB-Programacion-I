package excel.list;

public class Product extends Operator {

	public Product(Table table) {
		super(table);
	}

	public double Calculate(Position initialPosition, Position finalPosition) {
		result = 1;
		
		transformList(initialPosition, finalPosition);
		for (double number : numbers) {
			result = result * number;
		}
		return result;
	}
}
