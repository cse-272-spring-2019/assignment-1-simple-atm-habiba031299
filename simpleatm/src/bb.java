import java.util.ArrayList;

import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
//import.
public class bb extends Application {
	private int i = 1;
	Stage window;
	Transactions t = new Transactions();
	Button d = new Button("Deposit");
	Button w = new Button("Withdraw");
	Button button = new Button("logout");
	Button back = new Button("back");
	Button ok = new Button("Submit");
	Button previous = new Button("Previous");
	Button withdraw = new Button("Withdraw");
	Button deposit_withdraw = new Button("Deposit/withdraw");
	Button history = new Button("history");
	Button next = new Button("Next");
	Button b = new Button("back");
	PasswordField passwordField = new PasswordField();

	public static void main(String[] args) {
		launch(args);
	}

	HBox box1 = new HBox();
	GridPane box2 = new GridPane();
	GridPane box3 = new GridPane();
	GridPane grid = new GridPane();
	GridPane bbb = new GridPane();
	Scene scene1 = new Scene(box1, 500, 500);
	Scene login = new Scene(bbb, 500, 500, Color.BLACK);
	Scene scene3 = new Scene(box2, 500, 500);
	Scene scene4 = new Scene(grid, 500, 500);
	Label labels = new Label();
	Label label2 = new Label();
	Label tra = new Label();
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		window = primaryStage;
        window.setTitle("ATM");
	     	
        Label amountlabel = new Label("amount:");
		GridPane.setConstraints(amountlabel, 0, 1);
		final TextField amountInput = new TextField();
		GridPane.setConstraints(amountInput, 1, 1);

		TextField nameInput = new TextField("account 1");
        Label label = new Label("username:");
		GridPane.setConstraints(label, 0, 0);
		GridPane.setConstraints(nameInput, 1, 0);
		
		Label passlabel = new Label("password:");
		GridPane.setConstraints(passlabel, 0, 1);
		GridPane.setConstraints(ok, 1, 2);
		
		
       
		Label Input = new Label("Current Balance:");
		
		GridPane.setConstraints(labels, 1, 0);
		GridPane.setConstraints(Input, 0, 0);
		GridPane.setConstraints(w, 0, 1);
		GridPane.setConstraints(d,1, 1);
		GridPane.setConstraints(b, 4, 1);
		GridPane.setConstraints(previous, 3, 3);
		GridPane.setConstraints(next, 5, 3);
		GridPane.setConstraints(back, 7, 3);
		
		GridPane.setConstraints(passwordField, 1, 1);
		GridPane.setConstraints(tra, 0, 2);
		GridPane.setConstraints(label2, 2, 2);
		
		box1.getChildren().addAll(button, history, deposit_withdraw);
		box2.getChildren().addAll(tra,previous, next, back,label2);
		bbb.getChildren().addAll(label, nameInput, passlabel, passwordField, ok);
		box3.getChildren().addAll(Input,labels,w, d, b);
		grid.getChildren().addAll(amountlabel, amountInput, box3);
		
		ok.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				if ((passwordField.getText().compareTo("")) == 0)
					window.setScene(scene1);
			}
		});
		w.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {

				t.wthdrwl(Double.parseDouble(amountInput.getText()));
				labels.setText(Double.toString(t.CurrentBalance()));
			}
		});
		d.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {

				t.dpst(Double.parseDouble(amountInput.getText()));
				labels.setText(Double.toString(t.CurrentBalance()));
			}
		});
		history.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				window.setScene(scene3);
			}
		});
		deposit_withdraw.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				window.setScene(scene4);

			}
		});
		button.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				window.setScene(login);
			}
		});
		back.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				window.setScene(scene1);
			}
		});
		b.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				window.setScene(scene1);
			}
		});ArrayList<String>a=new ArrayList<String>();
		ArrayList<String>c=new ArrayList<String>();
		previous.setOnAction(new EventHandler<ActionEvent>() {
		public void handle(ActionEvent event) {
				ArrayList<String>a=t.get_transactions();
				ArrayList<String>c=t.get_transactions2();
				int j;
				for(j=1;j<a.size();j++){
					if (i<1)i=1;
					tra.setText(a.get(a.size()-i));
					label2.setText(c.get(c.size()-i));
				}
				i++;
				if (i>0)next.setDisable(false);
				if (i>a.size())previous.setDisable(true);
			}
		});
		next.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				ArrayList<String>a=t.get_transactions();
				ArrayList<String>c=t.get_transactions2();
				int j;
				for(j=i;j<a.size();j++){
					if (i>a.size())i=a.size();
					tra.setText(a.get(a.size()-i));
					label2.setText(c.get(c.size()-i));
				}
				
				
				i--;
				if (i<1)next.setDisable(true);
				if (i<a.size())previous.setDisable(false);
			}
		});
		window.setScene(login);
        window.show();
	}

}

