/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ViewController;

import Model.Inventory;
import Model.Part;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ajd34
 */
public class AddProductController implements Initializable {

    @FXML
    private TextField ProductID;
    @FXML
    private TextField ProductName;
    @FXML
    private TextField ProductInv;
    @FXML
    private TextField ProductPrice;
    @FXML
    private TextField ProductMax;
    @FXML
    private TextField ProductMin;
    @FXML
    private TextField ProductCompanyName;
    @FXML
    private Button SaveProduct;
    @FXML
    private Button CancelProuct;
    @FXML
    private Button DeleteProduct;
    @FXML
    private Button addSearch;
    @FXML
    private TextField SearchProduct;
    @FXML
    private Button AddProduct;
    
    private ObservableList<Part> partInventory = FXCollections.observableArrayList(); 
    private String exceptionMessage = new String(); 
    private int productID; 

   /* @FXML
    private void onSaveProduct(ActionEvent event) throws IOException{
      String productName = ProductName.getText();  
      String productInv = ProductInv.getText(); 
      String productPrice = ProductPrice.getText(); 
      String productMax = ProductMax.getText(); 
      String productMin = ProductMin.getText(); 
      
      try {
          exceptionMessage = validateProduct(productName, Integer.parseInt(productMin), Integer.parseInt(productMax), Integer.parseInt(productInv), Double.parseDouble(productPrice)); 
          
          if (exceptionMessage.length() >0 ) {
              Alert alert = new Alert(Alert.AlertType.INFORMATION); 
              alert.setTitle("ERROR"); 
              alert.setHeaderText("Error adding Part"); 
              alert.setContentText(exceptionMessage); 
              alert.showAndWait(); 
              exceptionMessage = ""; 
          }
              else {
                  System.out.println("Product name:" + productName);
                  Product newProduct = new Product(); 
                   
                  newProduct.setProductID(productID);
                  newProduct.setName(productName);
                  newProduct.setPrice(Double.parseDouble(productPrice));
                  newProduct.setInStock(Integer.parseInt(productInv));
                  newProduct.setMin(Integer.parseInt(productMin));
                  newProduct.setMax(Integer.parseInt(productMax));
                  Inventory.addProduct(newProduct); 
            
              Parent saveProducts = FXMLLoader.load(getClass().getResource("MainScreen.fxml")); 
              Scene scene = new Scene(saveProducts); 
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
    

    @FXML
     private void onCancelProduct(ActionEvent event) throws IOException {
         Alert alert = new Alert(Alert.AlertType.CONFIRMATION); 
        alert.setTitle("Confirm Cancel"); 
        alert.setHeaderText("Cancelling Part?"); 
        alert.setContentText("Are you sure you want to cancel part?"); 
        Optional<ButtonType> result = alert.showAndWait(); 
        
          if(result.get() == ButtonType.OK) {
            Parent cancelProduct = FXMLLoader.load(getClass().getResource("MainScreen.fxml")); 
              Scene scene = new Scene(cancelProduct); 
              Stage window = (Stage)((Node)event.getSource()).getScene().getWindow(); 
              window.setScene(scene); 
              window.show(); 
    } 
          else {
              System.out.println("Cancel has been clicked.");
          }
    }

   /*@FXML
    private void onSearch(ActionEvent event) {
        String searchPart = AddProductPart.getText(); 
        int partIndex = -1; 
        
        if(Inventory.lookUpPart(searchPart)==-1) {
            
        }
    }

    @FXML
    private void onAdd(ActionEvent event) {
    } */

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //todo
    }

    
}
