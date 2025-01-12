package excel.list;

import java.util.ArrayList;

public class Table {
    private String[][] tabular;

    public Table() {
        this.tabular = new String[26][50];
    }

    public boolean write(String text, Position position) {
        boolean readText = text != null;

        int row = position.obtainRowValue();
        int column = position.obtainColumnValue();
        boolean readPosition = column < 26 && row < 50;
        boolean write = readText && readPosition;
        if(write == true) {
            tabular[column][row] = text;
        }
        return write;
    }


    public boolean write(Double value, Position position) {
        boolean readText = value != null;

        int row = position.obtainRowValue();
        int column = position.obtainColumnValue();
        boolean readPosition = column < 26 &&row < 50;
        boolean write = readText && readPosition;

        if(write == true) {
            String result = value + "";
            tabular[column][row] = result;
        }
        return write;
    }

    public ArrayList<String> obtainRangeList(Position initialPosition, Position finalPosition) {
        ArrayList<String> textList = new ArrayList<String>();

        int initialColumn = initialPosition.obtainColumnValue();
        int finalColumn = finalPosition.obtainColumnValue();

        int initialRow = initialPosition.obtainRowValue();
        int finalRow = finalPosition.obtainRowValue();

        for (int row = initialRow; row <= finalRow; row++) {
            for (int column = initialColumn; column <= finalColumn; column++) {
                String value = tabular[column][row];
                if (value != null) {
                    textList.add(value);
                }
            }
        }
        return textList;
    }

    public String obtainText(Position position) {
        int column = position.obtainColumnValue();
        int row = position.obtainRowValue();
        return tabular[column][row];
    }

}
