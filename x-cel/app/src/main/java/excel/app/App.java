package excel.app;

import excel.list.Position;
import excel.list.Table;
import javafx.application.Application;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToolBar;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class App extends Application {
    private static final double POSITION_TEXTFIELD_WIDTH = 250;
    private static final double BORDER_PANE_MAX_LENGHT = 1000;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Table table = new Table();
        TableView<Position> tableView = new TableView<>();
        tableView.setEditable(true);
        tableView.getSelectionModel().setCellSelectionEnabled(true);

        createVoidColumn(tableView);

        TextField positionField = new TextField();
        positionField.setPrefWidth(POSITION_TEXTFIELD_WIDTH);
        createColumns(tableView, table, positionField);

        HBox hBox = new HBox();
        GridPane gridPane = createToolBar(hBox, positionField);

        BorderPane root = new BorderPane();
        root.setTop(gridPane);
        root.setCenter(tableView);
        Scene scene = new Scene(root, Double.MAX_VALUE, BORDER_PANE_MAX_LENGHT);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public GridPane createToolBar(HBox hBox, TextField positionField) {

        GridPane gridPane = new GridPane();
        hBox = new HBox();
        ToolBar toolBar = new ToolBar();
        Button fileButton = new Button("File");
        Button editButton = new Button("Edit");
        Button viewButton = new Button("View");
        Button insertButton = new Button("Insert");
        Button formatButton = new Button("Format");
        Label label = new Label("f(x)");
        TextField textField = new TextField();
        Label positionLabel = new Label("Position:");

        final double TEXTFIELD_WIDTH = 1500;
        textField.setPrefWidth(TEXTFIELD_WIDTH);

        hBox.getChildren().addAll(label, textField, positionLabel, positionField);
        toolBar.getItems().addAll(fileButton, editButton, viewButton, insertButton, formatButton);

        ColumnConstraints column1 = new ColumnConstraints();
        ColumnConstraints column2 = new ColumnConstraints();

        gridPane.getColumnConstraints().addAll(column1, column2);
        column1.setPrefWidth(100);
        column2.setPrefWidth(2000);

        gridPane.add(toolBar, 1, 0);

        gridPane.add(hBox, 1, 1);
        return gridPane;
    }

    public void createVoidColumn(TableView<Position> tableView) {
        TableColumn<Position, Integer> voidColumn = new TableColumn<>("");
        voidColumn.setCellValueFactory(
                data -> new SimpleIntegerProperty(data.getValue().obtainRowValue() + 1).asObject());
        tableView.getColumns().add(voidColumn);
        fillColumn(tableView);

    }

    private void fillColumn(TableView<Position> tableView) {
        for (int i = 1; i <= 50; i++) {
            Position position = new Position('B', i);
            tableView.getItems().add(position);
        }

    }

    public void createColumns(TableView<Position> tableView, Table table, TextField textField) {
        for (char alphabet = 'A'; alphabet <= 'Z'; alphabet++) {
            TableColumn<Position, String> column = new TableColumn<>(alphabet + "");
            column.setCellFactory(TextFieldTableCell.forTableColumn());

            column.setOnEditStart(new EventHandler<TableColumn.CellEditEvent<Position, String>>() {
                @Override
                public void handle(CellEditEvent<Position, String> event) {
                    TablePosition positionTable = event.getTablePosition();
                    int row = positionTable.getRow() + 1;
                    int columnValue = positionTable.getColumn() + 64;
                    char column = (char) columnValue;
                    textField.setText(column + "" + row);
                }

            });

            column.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<Position, String>>() {
                @Override
                public void handle(CellEditEvent<Position, String> event) {
                    TablePosition positionTable = event.getTablePosition();
                    Position position = obtainPosition(positionTable);

                    table.write(event.getNewValue(), position);
                }
            });
            column.setMinWidth(90);
            tableView.getColumns().add(column);
            column.setReorderable(false);
        }
    }

    private Position obtainPosition(TablePosition positionTable) {
        int row = positionTable.getRow() + 1;
        int columnValue = positionTable.getColumn() + 64;
        char column = (char) columnValue;

        Position position = new Position(column, row);
        return position;

    }
}
