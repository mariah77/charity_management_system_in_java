package application;

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

public class Controller implements Initializable {
	  private Stage stage;
	  private Scene scene;
	  private Parent root;
	  Account acc=new Account(); 
	  NGO ngo=new NGO(); 

	@FXML
	//final ObservableList<String> listItems = FXCollections.observableArrayList("HELLO :'(");        

	public Label l1=new Label();
	public Label desc=new Label();
	public Button ok;
	public TextField newCaseName=new TextField();
	public TextArea newCaseDescription=new TextArea();
	public TextField newCaseGoal=new TextField();
	public TextField adminUsername=new TextField();
	public TextField caseName=new TextField();
	public TextField newModeratorName=new TextField();
	public TextField newModeratorUsername=new TextField();
	public TextField newModeratorCNIC=new TextField();
	public TextField newModeratorEmail=new TextField();
	public PasswordField newModeratorPassword=new PasswordField();
	public TextField caseGoal=new TextField();
	public TextArea caseDescription=new TextArea();
	public PasswordField adminPassword=new PasswordField();
	public TextField donorUsername=new TextField();
	public PasswordField donorPassword=new PasswordField();
	public TextField newUsername=new TextField();
	public TextField newName=new TextField();
	public TextField newEmail=new TextField();
	public PasswordField newPassword=new PasswordField();
	public TextField moderatorUsername=new TextField();
	public TextField moderatorPassword=new TextField();

	//public TextField t1=new TextField();
	//private ListView<String> cases;

	
	public String newDonorUsername;
	public String newDonorEmail;
	public String newDonorName;
	public String newDonorPass;
	public String donor;
	public String donorPass;
	public String admin;
	public String adminPass;
	public String caseID;
	public RadioButton c1=new RadioButton();
	//public RadioButton c2=new RadioButton();
	//=adminPassword.getText();

	
	//////////////////////////////-----------DONOR--------///////////////////////////////////////////////////
	public void donorSelected(ActionEvent e) throws IOException
	{
		    root=FXMLLoader.load(getClass().getResource("DonorLogin.fxml"));
	        stage=(Stage)((Node)e.getSource()).getScene().getWindow();
	        scene=new Scene(root);
	        stage.setScene(scene);
	        stage.show();
	        stage.setTitle("Donor Login");
		
	}
	
	public void donorSignUp(ActionEvent e) throws IOException
	{
		 	root=FXMLLoader.load(getClass().getResource("DonorSignup.fxml"));
	        stage=(Stage)((Node)e.getSource()).getScene().getWindow();
	        scene=new Scene(root);
	        stage.setScene(scene);
	        stage.show();
	        stage.setTitle("Donor Login");
		
	}
	
	public void donorAfterSignup(ActionEvent e) throws IOException, ClassNotFoundException, SQLException
	{
		newDonorName=newName.getText();
		System.out.println(newDonorName);
		newDonorUsername=newUsername.getText();
		System.out.println(newDonorUsername);
		newDonorEmail=newEmail.getText();
		System.out.println(newDonorEmail);
		newDonorPass=newPassword.getText();
		System.out.println(newDonorPass);
		
		acc.signUp(newDonorName,newDonorUsername, newDonorEmail, newDonorPass);
		root=FXMLLoader.load(getClass().getResource("DonorMenu.fxml"));
        stage=(Stage)((Node)e.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Donations Proposal Addition");
        stage.show();   
		//System.out.println("IM GETTING DATA NOW");
		//System.out.print(acc.getData());
		//ADD LOGIN WALA HERE TO ATTACH SIGNUP TO SIGNIN
	}
	
	public void donorAfterLogin(ActionEvent e) throws IOException, ClassNotFoundException, SQLException 
	{
		donor=donorUsername.getText();
		System.out.println(donor);
		donorPass=donorPassword.getText();
		System.out.println(donorPass);
		
		if(acc.signIn(donor, donorPass))
		{
			root=FXMLLoader.load(getClass().getResource("DonorMenu.fxml"));
	        stage=(Stage)((Node)e.getSource()).getScene().getWindow();
	        scene=new Scene(root);
	        stage.setScene(scene);
	        stage.setTitle("Donations Proposal Addition");
	        stage.show();
	
		}
		else 
		{
			Stage stage=new Stage();
	        FXMLLoader fxmlLoader = new FXMLLoader(Controller.class.getResource("DonorLoginFailed.fxml"));
	        Scene scene = new Scene((Parent) fxmlLoader.load(), 520, 440);
	        stage.setTitle("Electronic Voting Machine");
	        stage.setScene(scene);
	        stage.show();
		}
		
		
	}
	/*
	public void signinAfterSignup(ActionEvent e) throws IOException
	{
		root=FXMLLoader.load(getClass().getResource("DonorLogin.fxml"));
        stage=(Stage)((Node)e.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Donations Proposal Addition");
        stage.show();   
	}
	*/
	public void proposeDonationForm(ActionEvent e) throws IOException
	{
		root=FXMLLoader.load(getClass().getResource("ProposeDonationForm.fxml"));
        stage=(Stage)((Node)e.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Donations Proposal Addition");
        stage.show();   
	}
	
	public void onProposition(ActionEvent e) throws IOException
	{	
		root=FXMLLoader.load(getClass().getResource("ProposeDonationForm.fxml"));
        stage=(Stage)((Node)e.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Donations Proposal Addition");
        stage.show();   
	}
	
	public void onProposalSubmission(ActionEvent e) throws IOException, ClassNotFoundException, SQLException
	{	
		String cname=caseName.getText();
		System.out.println(cname);
		String cdesc=caseDescription.getText();
		System.out.println(cdesc);
		String goal=caseGoal.getText();
		System.out.println(goal);
		int cgoal=Integer.parseInt(goal);
		System.out.println("I am now an integer "+cgoal);
		
		ngo.proposedCases(cname, cdesc, cgoal);
		
		root=FXMLLoader.load(getClass().getResource("ProposalSuccessful.fxml"));
        stage=(Stage)((Node)e.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Donations Proposal Submission Successful");
        stage.show();   
	}
	
	/*
	public void donorAfterLogin(ActionEvent e) throws IOException, ClassNotFoundException, SQLException
	{
		donor=donorUsername.getText();
		System.out.println(donor);
		donorPass=donorPassword.getText();
		System.out.println(donorPass);

		
		
		//Donor d=new Donor(newDonorName,newDonorUsername,newDonorEmail,newDonorPass);
		/*if(d.searchDonor(donor, donorPass))
		{
			root=FXMLLoader.load(getClass().getResource("DonorMenu.fxml"));
	        stage=(Stage)((Node)e.getSource()).getScene().getWindow();
	        scene=new Scene(root);
	        stage.setScene(scene);
	        stage.setTitle("Donor Login");
	        stage.show();   
		}
	        
		else 
		{
			Stage primaryStage=new Stage();
			FXMLLoader loader = new FXMLLoader();
	        String fxmlDocPath = "C:\\Users\\S F\\eclipse-workspace\\CharityManagementSystem\\src\\application\\DonorLoginFailed.fxml";
	        FileInputStream fxmlStream = new FileInputStream(fxmlDocPath);
	        AnchorPane root = (AnchorPane) loader.load(fxmlStream);
	        Scene scene = new Scene(root);
	        primaryStage.setScene(scene);
	        primaryStage.setTitle("Donor Login Failed");
	        primaryStage.show();
		}
		
		
	}
	public void donorSignUp(ActionEvent e) throws IOException
	{
		 	root=FXMLLoader.load(getClass().getResource("DonorSignup.fxml"));
	        stage=(Stage)((Node)e.getSource()).getScene().getWindow();
	        scene=new Scene(root);
	        stage.setScene(scene);
	        stage.show();
	        stage.setTitle("Donor Login");
		
	}
	
	
	public void donorAfterSignup(ActionEvent e) throws IOException, ClassNotFoundException, SQLException
	{
		newDonorName=newName.getText();
		System.out.println(newDonorName);
		newDonorUsername=newUsername.getText();
		System.out.println(newDonorUsername);
		newDonorEmail=newEmail.getText();
		System.out.println(newDonorEmail);
		newDonorPass=newPassword.getText();
		System.out.println(newDonorPass);
		//Donor d=new Donor(newDonorName,newDonorUsername,newDonorEmail,newDonorPass);
		d.addDonor(newDonorName, newDonorUsername, newDonorEmail, newDonorPass);
		Stage primaryStage=new Stage();
		FXMLLoader loader = new FXMLLoader();
        String fxmlDocPath = "C:\\Users\\S F\\eclipse-workspace\\CharityManagementSystem\\src\\application\\DonorMenu.fxml";
        FileInputStream fxmlStream = new FileInputStream(fxmlDocPath);
        AnchorPane root = (AnchorPane) loader.load(fxmlStream);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Donor Menu");
        primaryStage.show();
		
	}
	*/
	public void makeDonationFirst(ActionEvent e) throws IOException
	{
		root=FXMLLoader.load(getClass().getResource("ActiveDonations.fxml"));
        stage=(Stage)((Node)e.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Donations Dashboard");
        stage.show();   
	}

	public void selectCase(ActionEvent e) throws IOException
	{
		root=FXMLLoader.load(getClass().getResource("caseDescription.fxml"));
        stage=(Stage)((Node)e.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Donations Dashboard");
        stage.show();   
	}
	
	public void dislayDescription(ActionEvent e) throws IOException, ClassNotFoundException, SQLException
	{
		//c1=new RadioButton();
		System.out.println(c1.getText());
		
		//c.getaCase(c1.getText());
		//c.getAll();
		/*root=FXMLLoader.load(getClass().getResource("ProposeDonationForm.fxml"));
        stage=(Stage)((Node)e.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Donations Proposal Addition");
        stage.show(); */  
	} //azkaUser
	/*
	public void proposeDonationForm(ActionEvent e) throws IOException
	{
		root=FXMLLoader.load(getClass().getResource("ProposeDonationForm.fxml"));
        stage=(Stage)((Node)e.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Donations Proposal Addition");
        stage.show();   
	}
	
	public void onProposition(ActionEvent e) throws IOException
	{
		
		root=FXMLLoader.load(getClass().getResource("ProposeDonationForm.fxml"));
        stage=(Stage)((Node)e.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Donations Proposal Addition");
        stage.show();   
	}
	/*  
	t1.textProperty().addListener(new ChangeListener<String>() {
	    @Override
	    public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
	    if (!newValue.matches("\\d*")) 
		        {
		            t1.setText(newValue.replaceAll("[^\\d]", ""));
		        }
	    }

		
	});
	
}
*/
	
	
	
	
	//////////////////////////////-----------MODERATOR--------///////////////////////////////////////////////////

	public void moderatorSelected(ActionEvent e) throws IOException
	{
		    root=FXMLLoader.load(getClass().getResource("ModeratorLogin.fxml"));
	        stage=(Stage)((Node)e.getSource()).getScene().getWindow();
	        scene=new Scene(root);
	        stage.setScene(scene);
	        stage.show();
	        stage.setTitle("Moderator Login");
		
	}
	
	public void tomoderatorMenu(ActionEvent e) throws IOException, ClassNotFoundException, SQLException
	{
			String moderator=moderatorUsername.getText();
			System.out.println(moderator);
			String moderatorPass=moderatorPassword.getText();
			System.out.println(moderatorPass);
			
			
			if(acc.moderatorsignIn(moderator, moderatorPass))
			{
				root=FXMLLoader.load(getClass().getResource("ModeratorMenu.fxml"));
		        stage=(Stage)((Node)e.getSource()).getScene().getWindow();
		        scene=new Scene(root);
		        stage.setScene(scene);
		        stage.setTitle("Donations Proposal Addition");
		        stage.show();
		
			}
			else 
			{
				Stage stage=new Stage();
		        FXMLLoader fxmlLoader = new FXMLLoader(Controller.class.getResource("ModeratorLoginFailed.fxml"));
		        Scene scene = new Scene((Parent) fxmlLoader.load(), 520, 440);
		        stage.setTitle("Moderator Login Failed");
		        stage.setScene(scene);
		        stage.show();
			}
			
		
	}
	
	
	public void toProposedCases(ActionEvent e) throws IOException
	{
		root=FXMLLoader.load(getClass().getResource("CasesPendingApproval.fxml"));
        stage=(Stage)((Node)e.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Cases Pending Approval");
        stage.show(); 
	}

	
	
	public void toAddCase(ActionEvent e) throws IOException
	{
		    root=FXMLLoader.load(getClass().getResource("CaseAdditionForm.fxml"));
	        stage=(Stage)((Node)e.getSource()).getScene().getWindow();
	        scene=new Scene(root);
	        stage.setScene(scene);
	        stage.show();
	        stage.setTitle("Adding a new Case");
		
	}
	
	public void caseAdditionSuccessful(ActionEvent e) throws IOException, ClassNotFoundException, SQLException
	{
		String newcase=newCaseName.getText();
		System.out.println(newcase);
		String newCaseDesc=newCaseDescription.getText();
		System.out.println(newCaseDesc);
		String newgoal=newCaseGoal.getText();
		System.out.println(newgoal);
		int newGoal=Integer.parseInt(newgoal);
		System.out.println("IM NOW AN INTEGER"+newGoal);

		ngo.addCases(newcase, newCaseDesc, newGoal);
		
		
		    root=FXMLLoader.load(getClass().getResource("CaseAdditionSuccessfulMesage.fxml"));
	        stage=(Stage)((Node)e.getSource()).getScene().getWindow();
	        scene=new Scene(root);
	        stage.setScene(scene);
	        stage.show();
	        stage.setTitle("Successful Case Addition");
		
	}
	
	
	
	//////////////////////////////-----------ADMIN--------///////////////////////////////////////////////////

	
	@FXML
    protected void adminSelected(ActionEvent e) throws IOException {

        root=FXMLLoader.load(getClass().getResource("AdminLogin.fxml"));
        stage=(Stage)((Node)e.getSource()).getScene().getWindow();
        scene=new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
	
	public void getCredentials(ActionEvent e)  throws IOException
	{
		System.out.println(adminUsername.getText());

		System.out.println(adminPassword.getText());	
	}

	
	public void toAdminMenu(ActionEvent e) throws IOException
	{
		admin=adminUsername.getText();
		System.out.println(admin);
		adminPass=adminPassword.getText();
		System.out.println(adminPass);	
		if((admin.equalsIgnoreCase("azka")||admin.equalsIgnoreCase("vara")||admin.equalsIgnoreCase("usman")||admin.equalsIgnoreCase("shanzay"))&&adminPass.equalsIgnoreCase("1234"))
		{
			 root=FXMLLoader.load(getClass().getResource("AdminMenu.fxml"));
		        stage=(Stage)((Node)e.getSource()).getScene().getWindow();
		        scene=new Scene(root);
		        stage.setScene(scene);
		        stage.setTitle("Admin Menu");
		        stage.show();
		 }
		else
		{
			Stage stage=new Stage();
	        FXMLLoader fxmlLoader = new FXMLLoader(Controller.class.getResource("DonorLoginFailed.fxml"));
	        Scene scene = new Scene((Parent) fxmlLoader.load(), 520, 440);
	        stage.setTitle("Electronic Voting Machine");
	        stage.setScene(scene);
	        stage.show();
		}
		
	}
	
	public void toAddModerator(ActionEvent e) throws IOException
	{
		    root=FXMLLoader.load(getClass().getResource("ModeratorAdditionForm.fxml"));
	        stage=(Stage)((Node)e.getSource()).getScene().getWindow();
	        scene=new Scene(root);
	        stage.setScene(scene);
	        stage.show();
	        stage.setTitle("Adding a new Moderator");
		
	}
	
	public void moderatorAdditionSuccessful(ActionEvent e) throws IOException, ClassNotFoundException, SQLException
	{
		
		String newMName=newModeratorName.getText();
		String newMUsername=newModeratorUsername.getText();
		String newMCNIC=newModeratorCNIC.getText();
		String newMEmail=newModeratorEmail.getText();
		String newMPassword=newModeratorPassword.getText();//PasswordField();
		
		acc.moderatorAddition(newMName,newMUsername,newMEmail,newMPassword);
		    root=FXMLLoader.load(getClass().getResource("ModeratorAdditionSuccessful.fxml"));
	        stage=(Stage)((Node)e.getSource()).getScene().getWindow();
	        scene=new Scene(root);
	        stage.setScene(scene);
	        stage.show();
	        stage.setTitle("Adding a new Moderator");
		
	}
	
	public void loginFailed(ActionEvent e) throws IOException
	{
		
		Stage stage=(Stage) ok.getScene().getWindow();
	    // do what you have to do
	    stage.close();
		
	}

	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
	
	
}
