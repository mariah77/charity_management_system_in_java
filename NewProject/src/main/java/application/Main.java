package application;

import java.io.FileInputStream;
import java.util.ArrayList;

import business.Account;
import business.Case;
import business.NGO;
import db.MySQLHandler;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Main extends Application {
	 private Stage stage;
	 private Scene scene;
	 private Parent root;

	@Override
	public void start(Stage arg0) throws Exception {
		// stage=new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(Controller.class.getResource("FirstPage.fxml"));
        Scene scene = new Scene((Parent) fxmlLoader.load(), 520, 440);
        arg0.setScene(scene);
        arg0.show();
		arg0.setTitle("Charity Management System");

		/*
		 FXMLLoader f=new FXMLLoader();
		 String path="C:\\Users\\S F\\eclipse-workspace\\CharityManagementSystem\\src\\application\\FirstPage.fxml";
		 FileInputStream f1=new FileInputStream(path);
		 AnchorPane a=(AnchorPane)f.load(f1);
		 Scene s=new Scene(a);
		 arg0.setScene(s);
		 arg0.show();
		 NGO b=new NGO();
		b.getData();
		
		//Account acc=new Account();
		//acc.moderatorAddition("Vara", "v","v@madadgar.org.pk","v");
		 /* root=FXMLLoader.load(getClass().getResource("AdminMenu.fxml"));
	        stage=(Stage)((Node)e.getSource()).getScene().getWindow();
	        scene=new Scene(root);
	        stage.setScene(scene);
	        stage.setTitle("Admin Menu");
	        stage.show();
		*/
	
	}
	
	
	 public static void main(String[] args) {
		 
	        launch(args);
	    }

}
