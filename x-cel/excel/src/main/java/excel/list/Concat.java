package excel.list;


public class Concat extends Operator{
    
    public Concat(Table table) {
        super(table);
    }

    public String concat(Object[] list) {
        String concatedString = ""; 
        if(listIsValid(list)) {
            for(Object object : list) {
                String text = obtainString(object);
                concatedString += text; 
            }
            return concatedString;
        } else {
            throw new IllegalArgumentException("Concat method only receives Position Or String");
        }
    } 

    private boolean listIsValid(Object[] list) {
        for(Object object: list) {

            boolean objectIsNotString = object.getClass() != String.class;
            boolean objectIsNotPosition = object.getClass() != Position.class;

            if (objectIsNotPosition && objectIsNotString) {
                return false; 
            }
        }
        
        return true;
    }

    private String obtainString (Object object) {
        String text = "";

        if(object.getClass() == Position.class) {
            Position position = (Position) object;
            text = table.obtainText(position);
        }

        if(object.getClass() == String.class) {
            text = (String) object;
        }

        return text; 
    }
}