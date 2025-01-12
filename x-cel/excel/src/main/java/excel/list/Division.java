package excel.list;
public class Division extends Operator {

    public Division(Table table) {
        super(table);
    }

    @Override

    public double Calculate(Position initialPosition, Position finalPosition) {
        double division;
        double divisor = Double.parseDouble(table.obtainText(initialPosition));
        double dividend = Double.parseDouble(table.obtainText(finalPosition));

        if (dividend != 0) {
            division = divisor / dividend;
        } else {
            throw new IllegalArgumentException("dividend cannot be 0");
        }

        double roundedResult = (double) (Math.round(division * 100)) / 100;
        return roundedResult;
    }
}
