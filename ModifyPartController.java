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
import static ViewController.MainScreenController.getSelectedPart;
import static ViewController.MainScreenController.getSelectedPartInd;
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
import javafx.scene.control.ToggleGroup;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ajd34
 */
public class ModifyPartController implements Initializable {


    
    private boolean isOutsourced; 
    private String exceptionMessage = new String(); 
    private int partID; 
    @FXML
    private RadioButton inhouseRadio;
    @FXML
    private ToggleGroup RadioGRP;
    @FXML
    private RadioButton outsourcedRadio;
    @FXML
    private TextField ModPartID;
    @FXML
    private TextField ModpartName;
    @FXML
    private TextField ModPartInv;
    @FXML
    private TextField Modpartprice;
    @FXML
    private TextField ModpartMax;
    @FXML
    private TextField ModpartMin;
    @FXML
    private TextField CompanyName;
    @FXML
    private Text compNameLabel;
    @FXML
    private Button Save;
    @FXML
    private Button Cancel;
    
    


   
 /* @FXML
    private void modInHouse(ActionEvent event) {
        isOutsourced = false; 
        compNameLabel.setText("Machine ID") ;
        CompanyName.setPromptText("Machine ID"); 
        outsourcedRadio.setSelected(false);
    }

    @FXML
    private void modOutSourced(ActionEvent event) {
        isOutsourced = true; 
        compNameLabel.setText("Company Name"); 
        CompanyName.setPromptText("Company Name");
        inhouseRadio.setSelected(false); 
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        isOutsourced = true; 
        outsourcedRadio.setSelected(isOutsourced);
        CompanyName.setPromptText("Company Name");
        Part selectedPart = getSelectedPart(); 
       // partID = getSelectedPart().getPartID; 
        ModPartID.setText("AUTO GEN:" + partID); 
        ModpartName.setText(selectedPart.getName()); 
        ModPartInv.setText(Integer.toString(selectedPart.getInStock()));
        Modpartprice.setText(Double.toString(selectedPart.getPrice()));
        ModpartMax.setText(Integer.toString(selectedPart.getMax()));
        ModpartMin.setText(Integer.toString(selectedPart.getMin()));
        
    }
        
   @FXML
    public void modSave(ActionEvent event) throws IOException {
      String partName = ModpartName.getText(); 
      String compNameLabel = CompanyName.getText(); 
      String partInv = ModPartInv.getText(); 
      String partPrice = Modpartprice.getText(); 
      String partMax = ModpartMax.getText(); 
      String partMin = ModpartMin.getText(); 
      
      try {
          exceptionMessage = correctPart(partName, Integer.parseInt(partMin), Integer.parseInt(partMax), Integer.parseInt(partInv), Double.parseDouble(partPrice)); 

          
          if (exceptionMessage.length() >0 ) {
              Alert alert = new Alert(Alert.AlertType.INFORMATION); 
              alert.setTitle("ERROR"); 
              alert.setHeaderText("Error modifying Part"); 
              alert.setContentText(exceptionMessage); 
              alert.showAndWait(); 
              exceptionMessage = ""; 
          }
          else {
              if (!isOutsourced) {
                  Inhouse inhousePart = new Inhouse(); 
                  inhousePart.setPartID(partID); 
                  inhousePart.setName(partName); 
                  inhousePart.setPrice(Double.parseDouble(partPrice)); 
                  inhousePart.setMin(Integer.parseInt(partMin));
                  inhousePart.setMax(Integer.parseInt(partMax)); 
                  inhousePart.setMachineID(Integer.parseInt(compNameLabel));
                  Inventory.updatePart(getSelectedPartInd(), inhousePart);
              }
              else {
                  Outsourced outPart = new Outsourced(); 
                  outPart.setPartID(partID);
                  outPart.setName(partName);
                  outPart.setPrice(Double.parseDouble(partPrice));
                  outPart.setMin(Integer.parseInt(partMin));
                  outPart.setMax(Integer.parseInt(partMax));
                  outPart.setCompanyName(compNameLabel); 
                  Inventory.updatePart(getSelectedPartInd(), outPart); 
              }
              Parent modSavePart = FXMLLoader.load(getClass().getResource("MainScreen.fxml")); 
              Scene scene = new Scene(modSavePart); 
              Stage window = (Stage)((Node)event.getSource()).getScene().getWindow(); 
              window.setScene(scene); 
              window.show(); 
          }
      }
      catch(NumberFormatException e) {
              Alert alert = new Alert(Alert.AlertType.INFORMATION); 
              alert.setTitle("Error Modifying part"); 
              alert.setHeaderText("Error"); 
              alert.setContentText("Blank fields OR invalid values detected!"); 
              alert.showAndWait(); 
              }
    }

    @FXML
    private void modCancel(ActionEvent event) throws IOException {
          Alert alert = new Alert(Alert.AlertType.CONFIRMATION); 
        alert.setTitle("Confirm Cancel"); 
        alert.setHeaderText("Cancelling Part?"); 
        alert.setContentText("Are you sure you want to cancel update of part?"); 
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
        

    private String correctPart(String partName, int partMin, int partMax, int partInv, double partPrice) {
        String corrPart=""; 
        return corrPart; 
    }

   
   */

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    }

    @FXML
    private void modInHouse(ActionEvent event) {
    }

    @FXML
    private void modOutSourced(ActionEvent event) {
    }

    @FXML
    private void modSave(ActionEvent event) {
    }

    @FXML
    private void modCancel(ActionEvent event) {
    }

}