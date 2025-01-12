package excel.list;

public class SubString extends Operator{
    
    public SubString(Table table) {
        super(table);
    }

    public String substring(Position position, int index) {
        String text = table.obtainText(position);
        if(index < text.length()) {
            return text.substring(index);
        } else {
            throw new IndexOutOfBoundsException("index is not valid");
        }

    }
}
