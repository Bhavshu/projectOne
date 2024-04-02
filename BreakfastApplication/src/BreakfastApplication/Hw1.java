/*
*	HW1 - Joe's Deli menu dashboard
*
*	
*	NAME -  BHAVESH BALAJI 
*	ID:		1228405687
*	ASURITE bbalaji2
*
*
*/
package BreakfastApplication;

import java.util.Map;
import java.util.HashMap;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.text.*;
import javafx.stage.Stage;
import javafx.scene.control.CheckBox;
 
public class Hw1 extends Application {

	//Map used for storing the items and cost
	private Map<String, Double> map = new HashMap<>();
	double totalCost = 0;

    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) {
    	
    	//console messages
    	System.out.println("Joe's dashboard");
    	System.out.println("It started!");
    	
    	//title
        primaryStage.setTitle("Joe's dashboard");
        
        //This part contains the headings (Joe's Deli, Eat, Drink).
        Text text1 = new Text();  
        text1.setText("Joe's Deli");
        text1.setX(555);  
        text1.setY(30);  
        text1.setFont(Font.font("Abyssinica SIL",FontWeight.BOLD,FontPosture.REGULAR,26));
        Text text2 = new Text();
        text2.setText("Eat:");
        text2.setX(220);
        text2.setY(100);
        text2.setFont(Font.font("Abyssinica SIL",FontWeight.BOLD,FontPosture.REGULAR,20));
        Text text3 = new Text();
        text3.setText("Drink:");
        text3.setX(555);
        text3.setY(100);
        text3.setFont(Font.font("Abyssinica SIL",FontWeight.BOLD,FontPosture.REGULAR,20));
        
        //CheckBox for food to eat.
        CheckBox c1 = new CheckBox("      Egg sandwich");
        c1.setLayoutX(190);
        c1.setLayoutY(130);
        c1.setFont(Font.font("Abyssinica SIL",FontWeight.BOLD,FontPosture.REGULAR,14));
        CheckBox c2 = new CheckBox("      Chicken sandwich");
        c2.setLayoutX(190);
        c2.setLayoutY(200);
        c2.setFont(Font.font("Abyssinica SIL",FontWeight.BOLD,FontPosture.REGULAR,14));
        CheckBox c3 = new CheckBox("      Bagel");
        c3.setLayoutX(190);
        c3.setLayoutY(270);
        c3.setFont(Font.font("Abyssinica SIL",FontWeight.BOLD,FontPosture.REGULAR,14));
        CheckBox c4 = new CheckBox("      Potato salad");
        c4.setLayoutX(190);
        c4.setLayoutY(340);
        c4.setFont(Font.font("Abyssinica SIL",FontWeight.BOLD,FontPosture.REGULAR,14));
        
        //Radiobutton for drinks
        ToggleGroup toggleGroup = new ToggleGroup();
        RadioButton rb1 = new RadioButton("      Black Tea");
        rb1.setLayoutX(530);
        rb1.setLayoutY(130);
        rb1.setFont(Font.font("Abyssinica SIL",FontWeight.BOLD,FontPosture.REGULAR,14));
        rb1.setToggleGroup(toggleGroup);
        RadioButton rb2 = new RadioButton("      Green Tea");
        rb2.setLayoutX(530);
        rb2.setLayoutY(200);
        rb2.setFont(Font.font("Abyssinica SIL",FontWeight.BOLD,FontPosture.REGULAR,14));
        rb2.setToggleGroup(toggleGroup);
        RadioButton rb3 = new RadioButton("      Coffee");
        rb3.setLayoutX(530);
        rb3.setLayoutY(270);
        rb3.setFont(Font.font("Abyssinica SIL",FontWeight.BOLD,FontPosture.REGULAR,14));
        rb3.setToggleGroup(toggleGroup);
        RadioButton rb4 = new RadioButton("      Orange Juice");
        rb4.setLayoutX(530);
        rb4.setLayoutY(340);
        rb4.setFont(Font.font("Abyssinica SIL",FontWeight.BOLD,FontPosture.REGULAR,14));
        rb4.setToggleGroup(toggleGroup);
        
        //Order, cancel, confirm buttons
        Button btn1 = new Button();
        btn1.setText("Order");
        btn1.setLayoutX(200);
        btn1.setLayoutY(450);
        btn1.setPrefSize(100, 60);
        btn1.setFont(Font.font("Abyssinica SIL",FontWeight.BOLD,FontPosture.REGULAR,15));
        Button btn2 = new Button();
        btn2.setText("Cancel");
        btn2.setLayoutX(550);
        btn2.setLayoutY(450);
        btn2.setPrefSize(100, 60);
        btn2.setFont(Font.font("Abyssinica SIL",FontWeight.BOLD,FontPosture.REGULAR,15));
        Button btn3 = new Button();
        btn3.setText("Confirm");
        btn3.setLayoutX(896);
        btn3.setLayoutY(450);
        btn3.setPrefSize(100, 60);
        btn3.setFont(Font.font("Abyssinica SIL",FontWeight.BOLD,FontPosture.REGULAR,15));
        
        //event handling for checkboxes, radiobuttons. Adding the item name and the cost into a map
        c1.setOnAction(event -> {map.put(c1.getText(), 7.99);});
        c2.setOnAction(event -> {map.put(c2.getText(), 9.99);});
        c3.setOnAction(event -> {map.put(c3.getText(), 2.50);});
        c4.setOnAction(event -> {map.put(c4.getText(), 4.49);});

        rb1.setOnAction(event -> {map.put(rb1.getText(), 1.25);});
        rb2.setOnAction(event -> {map.put(rb2.getText(), 0.99);});
        rb3.setOnAction(event -> {map.put(rb3.getText(), 1.99);});
        rb4.setOnAction(event -> {map.put(rb4.getText(), 2.25);});
        
        //Text Area for Bill.
        TextArea ta = new TextArea();  
        ta.setLayoutX(795);
        ta.setLayoutY(65);
        ta.setPrefSize(300, 360);
        ta.setText("\t\t\t       BILL");
        ta.setFont(Font.font("Abyssinica SIL",FontWeight.BOLD,FontPosture.REGULAR,15));
        ta.appendText("\n");
        ta.setEditable(false);              //User cannot edit the text area.
        ta.setFocusTraversable(false);
        
        
        //event handling for buttons order, cancel, confirm.
        
        //order button
        btn1.setOnAction(event -> {
            

            // Append a newline character to move to the next line below "BILL"
            ta.appendText("\n\n");
            
            //iterating through the map to get the item name, and the price
            for (Map.Entry<String, Double> entry : map.entrySet()) {
                String item = entry.getKey();
                Double price = entry.getValue();
                
                //adding totalCost with price of the item 
                totalCost += price;
                if(item.length() == 22) {
                	ta.appendText(item + "\t\t" + "$  " + price + "\n\n");
                }
                else if(item.length() == 18) {
                	ta.appendText(item + "\t\t\t" + "$  " + price + "\n\n");
                }
                else if(item.length() == 15) {                             //Black tea
                	ta.appendText(item + "\t\t\t\t" + "$  " + price + "\n\n");
                }
                else if(item.length() == 12) {
                	ta.appendText(item + "\t\t\t\t" + "$  " + price + "\n\n");
                }
                else {
                	ta.appendText(item + "\t\t\t\t\t" + "$  " + price + "\n\n");
                }
            }
            String formattedTotal = String.format("%.2f", totalCost);
            ta.appendText("      Total:" + "\t\t\t\t\t" + "$  " + formattedTotal);

            // Clear the list after updating
            //map.clear();
            System.out.println("Order received.");
        });

        //cancel button
        btn2.setOnAction(new EventHandler<>() {
        	public void handle(ActionEvent event) {
        		toggleGroup.selectToggle(null);
                c1.setSelected(false);
                c2.setSelected(false);
                c3.setSelected(false);
                c4.setSelected(false);
                map.clear();
                totalCost = 0;
                ta.setText("\t\t\t       BILL");
                System.out.println("Order canceled.");
        	}
        });
        
        //confirm button
        btn3.setOnAction(event -> {
            

            // Append a newline character to move to the next line below "BILL"
            ta.appendText("\n\n");
            double finalCost = totalCost + totalCost * 0.07;
            toggleGroup.selectToggle(null);
            c1.setSelected(false);
            c2.setSelected(false);
            c3.setSelected(false);
            c4.setSelected(false);
            String formattedTotal = String.format("%.2f", finalCost);
            ta.appendText("      Final Cost(sales 7%):" + "\t" + "$  " + formattedTotal);

            // Clear the map after updating
            map.clear();
            System.out.println("Order confirmed.");
        });
        
        //UI layout
        Group root = new Group();
        root.getChildren().addAll(text1, text2, text3, rb1, rb2, rb3, rb4, btn1, btn2, btn3, c1, c2, c3, c4, ta);
        primaryStage.setTitle("Joe's Deli");
        primaryStage.setScene(new Scene(root, 1200, 600));
        primaryStage.show();
        
        
    }
    
}