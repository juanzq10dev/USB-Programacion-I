package excel.list;

public class Sum extends Operator {

    public Sum(Table table) {
        super(table);
    }
    
    @Override 
    public double Calculate(Position initialPosition, Position finalPosition) {
        transformList(initialPosition, finalPosition);
        for (double number : numbers) {
            result = result + number;
        }
        return result;
    }
}