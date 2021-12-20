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

public class Initializer  implements Initializable {
    private Stage stage;
    private Scene scene;
    private Parent root;
    Case case1;

    @FXML
    private ResourceBundle resources;
    
    @FXML
    public TextField AmountLabel=new TextField();
    @FXML
    public TextField AccountLabel=new TextField();

    @FXML
    public ListView<String> ListCase = new ListView<String>();

    @FXML
    private Label label1;

  
    @FXML
    private Button donateDone;
    @FXML
    private Button DonateNow;
    String titleGot;
    String titleGot2 ;
    String amountGot, getTitle2;
    static String myStaticTitle; static Integer totalAmount,RecvAmount;
    Integer toBeUpdated;

    public void initialize(URL url, ResourceBundle resourceBundle) {
        case1 = new Case();

        ArrayList<CaseDescription> temp2 =new ArrayList<CaseDescription>();
        try {
            temp2 = case1.fetchDescription();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("in main");
        for (int i = 0; i < temp2.size(); i++) {
            System.out.println( "Title " + temp2.get(i).getTitle());
            //cases.getItems(temp2.get(i).getTitle());
            ListCase.getItems().add(temp2.get(i).getTitle());
        }

        final ArrayList<CaseDescription> finalTemp = temp2;
        ListCase.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>(){

            public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {
                // TODO Auto-generated method stub
                titleGot=ListCase.getSelectionModel().getSelectedItem();
                //CandidateController.party=party;
                for (int i = 0; i < finalTemp.size(); i++) {
                    //System.out.println( "Title " + finalTemp.get(i).getTitle());
                    if(titleGot.equals(finalTemp.get(i).getTitle()))
                    {
                    	myStaticTitle = finalTemp.get(i).getTitle();
                        totalAmount = finalTemp.get(i).getTarget();
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
  //I AM NEW
    @FXML
    void donateToCase(ActionEvent event) throws IOException{

        root=FXMLLoader.load(getClass().getResource("AddDonationAmount.fxml"));
        stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Donate Now");
        stage.show();
    }



    //I AM NEW
    public void donateToCaseDone(ActionEvent e) throws IOException, SQLException, ClassNotFoundException {
        Integer size = AccountLabel.getText().length();
        if(size.equals(13))
        {
            amountGot = AmountLabel.getText();
            System.out.println("Amount rec: " + amountGot + "For case: "  + myStaticTitle);
            RecvAmount = Integer.parseInt(amountGot);
            toBeUpdated = totalAmount-RecvAmount;
            if (totalAmount > RecvAmount )
            {
                case1.updateTarget(myStaticTitle, toBeUpdated);
            }

            root=FXMLLoader.load(getClass().getResource("SuccessfulTransaction.fxml"));
            stage=(Stage)((Node)e.getSource()).getScene().getWindow();
            scene=new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Donor Menu");
            stage.show();

        }

        else

        {
            root=FXMLLoader.load(getClass().getResource("InvalidAccountNo.fxml"));
            stage=(Stage)((Node)e.getSource()).getScene().getWindow();
            scene=new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Donations Proposal Addition");
            stage.show();
        }

    }

   public void okTransaction(ActionEvent e) throws IOException
    {
        root=FXMLLoader.load(getClass().getResource("DonorMenu.fxml"));
        stage=(Stage)((Node)e.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Donor Menu");
        stage.show();

    }
}