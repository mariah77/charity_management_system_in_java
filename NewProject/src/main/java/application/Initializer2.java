package application;

import java.io.FileInputStream;

import business.Case;
import javafx.scene.Node;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ResourceBundle;

import java.io.FileInputStream;
import javafx.scene.Node;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import business.Account;
import business.CaseDescription;
import business.Donor;
import business.NGO;
import javafx.scene.control.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import business.Account;
import business.CaseDescription;
import business.Donor;
import javafx.scene.control.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;

public class Initializer2  implements Initializable {
	
	/*
	 * IDHARV PROBLEM ARAHI HAI
	 * 
	 */
  //  private static final ArrayList<CaseDescription> CasesDesc = null;
	private Stage stage;
    private Scene scene;
    private Parent root;
    CaseDescription cd;

    @FXML
    private ResourceBundle resources;

    @FXML
    public ListView<String> ListCase = new ListView<String>();

    @FXML
    private Label label1;

    @FXML
    public TextField AmountLabel=new TextField();

    @FXML
    private Button donateDone;
    @FXML
    private Button DonateNow;

    String titleGot;
    String titleGot2;
    String amountGot;

    public void initialize(URL url, ResourceBundle resourceBundle) {
        cd = new CaseDescription();

        ArrayList<CaseDescription> CasesDesc =new ArrayList<CaseDescription>();
        try {
        	CasesDesc = cd.getAll();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("in main");
        for(int i=0;i<CasesDesc.size();i++) {
			System.out.println("im in loop of getDAta");

			System.out.println("Name "+CasesDesc.get(i).getTitle());
			ListCase.getItems().add(CasesDesc.get(i).getTitle());
		}
            //cases.getItems(temp2.get(i).getTitle());
            
        

        final ArrayList<CaseDescription> finalTemp = CasesDesc;
        ListCase.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>(){

            public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {
                // TODO Auto-generated method stub
                titleGot=ListCase.getSelectionModel().getSelectedItem();
                //CandidateController.party=party;
                for (int i = 0; i < finalTemp.size(); i++) {
                    //System.out.println( "Title " + finalTemp.get(i).getTitle());
                    if(titleGot.equals(finalTemp.get(i).getTitle()))
                    {
                        titleGot2 = "Title: " + "\n" + titleGot + "\n\n\n" + "Description: " +"\n"+
                                finalTemp.get(i).getDesc() + "\n\n\n"
                                + "Target: " + "\n" + String.valueOf(finalTemp.get(i).getTarget()) ;
                        System.out.println("INSIDE FTN " + titleGot2);
                    }
                }
                label1.setText(titleGot2);
            }
        });

    }
    @FXML
    void donateToCase(ActionEvent event) throws IOException{

    	
        Stage stage=new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(Controller.class.getResource("VerifiedSuccessfully.fxml"));
        Scene scene = new Scene((Parent) fxmlLoader.load(), 520, 440);
        stage.setTitle("Verified Case!");
        stage.setScene(scene);
        stage.show();
    }

    

}