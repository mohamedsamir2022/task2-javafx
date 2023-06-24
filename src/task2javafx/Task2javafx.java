
package task2javafx;

import javafx.application.Application;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author wak
 */
public class Task2javafx extends Application {
    
   @Override
   public void start(Stage primaryStage) {
       
       
 Text text = new Text(15, 20, "JavaFX Example");
Pane center = new Pane();
center.getChildren().add(text);
center.setStyle("-fx-border-color: black");

Label label1 = new Label("Enter Text: ");
TextField textField = new TextField("Press Enter to change Text");
HBox top = new HBox(10);
top.setPadding(new Insets(15));
top.getChildren().addAll(label1, textField);
top.setAlignment(Pos.CENTER);

Label label2 = new Label("Select Color: ");
RadioButton radioButton1 = new RadioButton("Red");
RadioButton radioButton2 = new RadioButton("Green");
RadioButton radioButton3 = new RadioButton("Blue");
ToggleGroup toggleGroup = new ToggleGroup();
radioButton1.setToggleGroup(toggleGroup);
radioButton2.setToggleGroup(toggleGroup);
radioButton3.setToggleGroup(toggleGroup);
GridPane left = new GridPane();
left.setVgap(8);
left.setPadding(new Insets(10));
left.addColumn(0, label2, radioButton1, radioButton2, radioButton3);
       


Label label3 = new Label("Select Font Size: ");
ComboBox<Integer> comboBox = new ComboBox<>();
comboBox.getItems().add(10);
comboBox.getItems().add(12);
comboBox.getItems().add(14);
comboBox.getItems().add(16);
comboBox.getItems().add(18);
comboBox.getItems().add(20);
comboBox.setValue(10);
Label label4 = new Label("Select Style:");
CheckBox checkBox1 = new CheckBox("Bold");
CheckBox checkBox2 = new CheckBox("Italic");
VBox right = new VBox(10);
right.setPadding(new Insets(15));
right.getChildren().addAll(label3, comboBox, label4, checkBox1, checkBox2);





Button button1 = new Button("Move Left" );
Button button2 = new Button("Move Right");
HBox bottom = new HBox(10);
bottom.setPadding(new Insets(15));
bottom.getChildren().addAll(button1, button2);
bottom.setAlignment(Pos.CENTER);
       
BorderPane borderPane = new BorderPane();
borderPane.setTop(top);
borderPane.setLeft(left);
borderPane.setRight(right);
borderPane.setBottom(bottom);
borderPane.setCenter(center);





textField.setOnAction(e -> {
text.setText(textField.getText());
});

radioButton1.setOnAction(e -> {
text.setFill(Color.RED);
});

radioButton2.setOnAction(e -> {
text.setFill(Color.GREEN);
});

radioButton3.setOnAction(e -> {
text.setFill(Color.BLUE);
});


checkBox1.setOnAction(e -> {
if(checkBox1.isSelected() && checkBox2.isSelected()){
text.setFont(Font.font("Times New Roman", FontWeight.BOLD,
FontPosture.ITALIC, comboBox.getValue()));
}else if (checkBox1.isSelected() && !checkBox2.isSelected()){
text.setFont(Font.font("Times New Roman", FontWeight.BOLD,
FontPosture.REGULAR, comboBox.getValue())); 
}
else if (!checkBox1.isSelected() && checkBox2.isSelected()){
text.setFont(Font.font("Times New Roman",FontWeight.NORMAL,
FontPosture.ITALIC, comboBox.getValue())); 
}
else if( !checkBox1.isSelected() && !checkBox2.isSelected()){
text.setFont(Font.font("Times New Roman", FontWeight.NORMAL,
FontPosture.REGULAR, comboBox.getValue()));
}
});



checkBox2.setOnAction(e -> {
if(checkBox1.isSelected() && checkBox2.isSelected()){
text.setFont(Font.font("Times New Roman", FontWeight.BOLD,
FontPosture.ITALIC, comboBox.getValue())); }
else if (checkBox1.isSelected() && !checkBox2.isSelected() ){
text.setFont(Font.font("Times New Roman", FontWeight.BOLD,
FontPosture.REGULAR, comboBox.getValue())); }
else if (!checkBox1.isSelected() && checkBox2.isSelected()){
text.setFont(Font.font("Times New Roman",FontWeight.NORMAL,
FontPosture.ITALIC, comboBox.getValue())); }
else if( !checkBox1.isSelected() && !checkBox2.isSelected()){
text.setFont(Font.font("Times New Roman", FontWeight.NORMAL,
FontPosture.REGULAR, comboBox.getValue())); }
});


Scene scene = new Scene(borderPane,700,500);
primaryStage.setTitle("Example 1");
primaryStage.setScene(scene);
primaryStage.show();
 }
   public static void main(String[] args) {
launch(args); } }
   