/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ViewController;

import Model.Inhouse;
import Model.Inventory;
import Model.Outsourced;
import Model.Part;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ajd34
 */
public class AddPartController implements Initializable {

    @FXML
    private Button cancelPart;
    @FXML
    private RadioButton inHouse;
    @FXML
    private RadioButton outSourced;
    @FXML
    private Button savePart;
 
    @FXML
    private TextField AddpartID;
    @FXML
    private TextField AddpartName;
    @FXML
    private TextField AddpartInv;
    @FXML
    private TextField AddpartPrice;
    @FXML
    private TextField AddpartMax;
    @FXML
    private TextField AddpartMin;
    @FXML
    private TextField AddCompanyName;
    @FXML
    private Text companyLabel; 
    
    Part part; 
    private boolean isOutsourced; 
    private String exceptionMessage = new String(); 
    private int partID; 
  

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        isOutsourced = true; 
        outSourced.setSelected(isOutsourced);
        AddCompanyName.setPromptText("Company Name");
        partID = Inventory.getPartIDCount(); 
        AddpartID.setText("AUTO GEN:" + partID);
    }

    @FXML
    private void onSavePart(ActionEvent event) throws IOException {
      String partName = AddpartName.getText(); 
      String partCompanyName = AddCompanyName.getText(); 
      String partInv = AddpartInv.getText(); 
      String partPrice = AddpartPrice.getText(); 
      String partMax = AddpartMax.getText(); 
      String partMin = AddpartMin.getText(); 
      
      try {
          exceptionMessage = validatePart(partName, Integer.parseInt(partMin), Integer.parseInt(partMax), Integer.parseInt(partInv), Double.parseDouble(partPrice)); 
          
          if (exceptionMessage.length() >0 ) {
              Alert alert = new Alert(Alert.AlertType.INFORMATION); 
              alert.setTitle("ERROR"); 
              alert.setHeaderText("Error adding Part"); 
              alert.setContentText(exceptionMessage); 
              alert.showAndWait(); 
              exceptionMessage = ""; 
          }
          else {
              if (!isOutsourced) {
                  System.out.println("Part name:" + partName);
                  Inhouse inPart = new Inhouse(); 
                  inPart.setPartID(partID); 
                  inPart.setName(partName); 
                  inPart.setPrice(Double.parseDouble(partPrice)); 
                  inPart.setMin(Integer.parseInt(partMin));
                  inPart.setMax(Integer.parseInt(partMax)); 
                  inPart.setMachineID(Integer.parseInt(partCompanyName));
                  Inventory.addPart(inPart);
              }
              else {
                  Outsourced outPart = new Outsourced(); 
                  outPart.setPartID(partID);
                  outPart.setName(partName);
                  outPart.setPrice(Double.parseDouble(partPrice));
                  outPart.setMin(Integer.parseInt(partMin));
                  outPart.setMax(Integer.parseInt(partMax));
                  outPart.setCompanyName(partCompanyName); 
                  Inventory.addPart(outPart); 
              }
              Parent savePart = FXMLLoader.load(getClass().getResource("MainScreen.fxml")); 
              Scene scene = new Scene(savePart); 
              Stage window = (Stage)((Node)event.getSource()).getScene().getWindow(); 
              window.setScene(scene); 
              window.show(); 
          }
      }
      catch(NumberFormatException e) {
              Alert alert = new Alert(Alert.AlertType.INFORMATION); 
              alert.setTitle("Error Adding part"); 
              alert.setHeaderText("Error"); 
              alert.setContentText("Blank fields OR invalid values detected"); 
              alert.showAndWait(); 
              }
    }

    @FXML
    private void onCancelPart(ActionEvent event) throws IOException {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION); 
        alert.setTitle("Confirm Cancel"); 
        alert.setHeaderText("Cancelling Part?"); 
        alert.setContentText("Are you sure you want to cancel part?"); 
        Optional<ButtonType> result = alert.showAndWait(); 
        
          if(result.get() == ButtonType.OK) {
            Parent cancelPart = FXMLLoader.load(getClass().getResource("MainScreen.fxml")); 
              Scene scene = new Scene(cancelPart); 
              Stage window = (Stage)((Node)event.getSource()).getScene().getWindow(); 
              window.setScene(scene); 
              window.show(); 
    } 
          else {
              System.out.println("Cancel has been clicked.");
          }
  
}
        
    

    @FXML
    private void inHousePressed(ActionEvent event) {
        isOutsourced = false; 
        companyLabel.setText("Machine ID") ;
        AddCompanyName.setPromptText("Machine ID"); 
    }

    @FXML
    private void outSourcedPressed(ActionEvent event) {
        isOutsourced = true; 
        companyLabel.setText("Company Name"); 
        AddCompanyName.setPromptText("Company Name");
    }

    private String validatePart(String partName, int partMin, int partMax, int partInv, double partPrice) {
        String valPart = ""; 
        return valPart;
   
    }
    

}
