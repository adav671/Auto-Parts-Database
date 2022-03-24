/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ViewController;

import Model.Inventory;
import static Model.Inventory.getAllParts;
import static Model.Inventory.getAllProducts;
import Model.Part;
import Model.Product;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.application.Platform;
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
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ajd34
 */
public class MainScreenController implements Initializable {
    
    @FXML
    private TextField partSearchBox;
    @FXML
    private TableView<Part> partsTable;
    @FXML
    private TextField productSearchBox;
    @FXML
    private TableView<Product> productsTable;
    @FXML 
    private TableColumn ProductIDCol; 
    @FXML 
    private TableColumn ProductNameCol; 
    @FXML 
    private TableColumn PartIDColumn; 
    
    private ObservableList<Part> partInventory = FXCollections.observableArrayList(); 
    private ObservableList<Product> productInventory = FXCollections.observableArrayList(); 
    private ObservableList<Part> partsInventorySearch = FXCollections.observableArrayList(); 
    private ObservableList<Product> productInventorySearch = FXCollections.observableArrayList(); 
    ArrayList<Integer> partIDList; 
    ArrayList<Integer> productIDList; 
    @FXML
    private Button exitProgram;
    @FXML
    private Button partsSearchButton;
    @FXML
    private Button addPart;
    @FXML
    private Button modifyPart;
    @FXML
    private Button deletePart;
    @FXML
    private TableColumn<?, ?> partNameColumn;
    @FXML
    private TableColumn<?, ?> partInventoryColumn;
    @FXML
    private Button deleteProduct;
    @FXML
    private Button modifyProduct;
    @FXML
    private Button addProduct;
    @FXML
    private TableColumn<?, ?> productInvCol;
    @FXML
    private Button productSearchButton;
    @FXML
    private TableColumn<?, ?> partPriceColumn;
    @FXML
    private TableColumn<?, ?> productPriceCol;
   
   private static Part selectedPart; 
   private static int selectedPartInd; 
   
   public static Part getSelectedPart() {
       return selectedPart; 
   }
   public static int getSelectedPartInd() {
       return selectedPartInd; 
   }
   
   private static Product selectedProduct; 
   private static int selectedProductInd; 
   
   public static Product getSelectedProduct() {
       return selectedProduct; 
   }
   public static int getSelectedProductInd() {
       return selectedProductInd; 
   }
   

    
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    
     @Override
    public void initialize(URL url, ResourceBundle rb) {
        partNameColumn.setCellValueFactory(new PropertyValueFactory <>("name"));
        PartIDColumn.setCellValueFactory(new PropertyValueFactory <>("partID"));
        partInventoryColumn.setCellValueFactory(new PropertyValueFactory <>("InStock"));
        partPriceColumn.setCellValueFactory(new PropertyValueFactory <>("price"));
        ProductIDCol.setCellValueFactory(new PropertyValueFactory <>("productID"));
        ProductNameCol.setCellValueFactory(new PropertyValueFactory <>("name"));
        productInvCol.setCellValueFactory(new PropertyValueFactory <>("InStock"));
        productPriceCol.setCellValueFactory(new PropertyValueFactory <>("price"));
        
      generatePartsTable(); 
      generateProductsTable(); 
    }
       
    
    private void generateProductsTable() {
        productInventory.setAll(Inventory.getAllProducts()); 
        
        productsTable.setItems(productInventory);
        productsTable.refresh(); 
    }
    
    private void generatePartsTable() {
        partInventory.setAll(Inventory.getAllParts()); 
        
        partsTable.setItems(partInventory);
        partsTable.refresh(); 
    }
    

    
    private void exitProgram(ActionEvent event) {
        Platform.exit(); 
        }
    @FXML
    private void exitProgramButton(MouseEvent event) {
        Platform.exit();
    }
    //Parts Side 
   
 

    public void partSeachBox(MouseEvent event) {
     if (!partSearchBox.getText().trim().isEmpty()) {
         partsInventorySearch.clear(); 
         for (int i = 0; i<partIDList.size(); i++) {
             if (Inventory.lookUpPart(partIDList.get(i)).getName().contains(partSearchBox.getText().trim())) {
                 partsInventorySearch.add(Inventory.lookUpPart(partIDList.get(i))); 
             }
         }
         partsTable.setItems(partsInventorySearch); 
         partsTable.refresh();
     }
    }

   
    
    public void productSeachBox(MouseEvent event) {
     if (!productSearchBox.getText().trim().isEmpty()) {
         productInventorySearch.clear(); 
         for (int i = 0; i<productIDList.size(); i++) {
             if (Inventory.lookUpProduct(productIDList.get(i)).getName().contains(productSearchBox.getText().trim())) {
                 productInventorySearch.add(Inventory.lookUpProduct(productIDList.get(i))); 
             }
         }
         productsTable.setItems(productInventorySearch); 
         productsTable.refresh();
     }
    }
    
    void clearText(MouseEvent event) { 
        Object source = event.getSource(); 
        TextField field = (TextField) source; 
        field.setText(""); 
        if(partSearchBox == field) {
            if(partInventory.size() !=0) {
                partsTable.setItems(partInventory); 
            }
        }
        if(productSearchBox == field) {
            if(productInventory.size() !=0) {
                productsTable.setItems(productInventory); 
            }
        }
    }
    
  private void errorWindow (int code) {
    if (code == 11) {
        Alert alert = new Alert(AlertType.ERROR); 
        alert.setTitle("Error"); 
        alert.setHeaderText("Empty!!"); 
        alert.setContentText("Nothing can be selected here."); 
        alert.showAndWait();          
    }
    if (code == 21) {
        Alert alert = new Alert(AlertType.ERROR); 
        alert.setTitle("Error"); 
        alert.setHeaderText("Invalid"); 
        alert.setContentText("An item must be selected"); 
        alert.showAndWait();          
    }
}

private boolean confirmationWindow(String PartName) {
        Alert alert = new Alert(AlertType.CONFIRMATION); 
        alert.setTitle("Delete Part"); 
        alert.setHeaderText("Are you sure you want to delete: " + PartName); 
        alert.setContentText("Click to finalize"); 
        Optional<ButtonType> result = alert.showAndWait(); 
        if(result.get() == ButtonType.OK) {
            return true; 
    }
        else { 
            return false; 
        }
}
private boolean confirmDelete(String name) {
        Alert alert = new Alert(AlertType.CONFIRMATION); 
        alert.setTitle("Delete Product"); 
        alert.setHeaderText("Are you sure you want to delete: " + name + "there are parts still assigned to this product."); 
        alert.setContentText("Click to finalize"); 
        Optional<ButtonType> result = alert.showAndWait(); 
        if (result.get() == ButtonType.OK) {
            return true; 
        }
        else {
            return false; 
        }
}

private void infoWindow(int code, String name) {
    if (code !=21) {
        Alert alert = new Alert(AlertType.INFORMATION); 
        alert.setTitle("Confirmed"); 
        alert.setHeaderText(null); 
        alert.setContentText(name + "has been deleted"); 
       alert.showAndWait(); 
    }
    else {
        Alert alert = new Alert(AlertType.INFORMATION); 
        alert.setTitle("ERROR"); 
        alert.setHeaderText(null); 
        alert.setContentText("An error has occured");
    }
}


    @FXML
    private void partSearchBox(javafx.scene.input.MouseEvent event) {
    }



    @FXML
    private void productSearchBox(javafx.scene.input.MouseEvent event) {
    }

 
    

    @FXML
    private void onPartSearch(ActionEvent event) {
         if (!partSearchBox.getText().trim().isEmpty()) {
         partsInventorySearch.clear(); 
         for (int i = 0; i<partIDList.size(); i++) {
             if (Inventory.lookUpPart(partIDList.get(i)).getName().contains(partSearchBox.getText().trim())) {
                 partsInventorySearch.add(Inventory.lookUpPart(partIDList.get(i))); 
             }
         }
         partsTable.setItems(partsInventorySearch); 
         partsTable.refresh();
     }

    }

    @FXML
    private void onAddPart(ActionEvent event) throws IOException{
     
       Stage stage; 
       Parent root; 
       stage=(Stage)addPart.getScene().getWindow(); 
       FXMLLoader loader = new FXMLLoader(getClass().getResource("/ViewController/AddPart.fxml")); 
       root = loader.load(); 
       Scene scene = new Scene(root); 
       stage.setScene(scene); 
       stage.show(); 
      
    }

    @FXML
    private void onModifyPart(ActionEvent event) throws IOException { 
        
          selectedPart = partsTable.getSelectionModel().getSelectedItem();   
         if(selectedPart == null) {
                 Alert alert = new Alert(AlertType.ERROR); 
                 alert.setTitle("Modify Error"); 
                 alert.setHeaderText("Part not able to be modified"); 
                 alert.setContentText("No Part was Selected!"); 
                 alert.showAndWait();  
                 return; 
         }
            
            selectedPartInd = getAllParts().indexOf(selectedPart);

             
                try {
              Parent modsPart = FXMLLoader.load(getClass().getResource("/ViewController/ModifyPart.fxml")); 
              Scene scene = new Scene(modsPart); 
              Stage window = (Stage)((Node)event.getSource()).getScene().getWindow(); 
              window.setScene(scene); 
              window.show(); 
                
            }
                catch (IOException e){}
                }

    @FXML
    private void onDeletePart(ActionEvent event) {
        Part removePart = partsTable.getSelectionModel().getSelectedItem(); 
   if(partInventory.isEmpty()) {
       errorWindow(11); 
       return; 
        }
   if(!partInventory.isEmpty() && removePart == null){
       errorWindow(21); 
       return; 
   }
   else 
   {
       boolean confirm = confirmationWindow(removePart.getName()); 
       if(!confirm) {
           return; 
       }
       Inventory.deletePart(removePart); 
       partInventory.remove(removePart); 
       partsTable.refresh(); 
   }
    }

    @FXML
    private void onDeleteProduct(ActionEvent event) {
         boolean deleted= false; 
   Product removeProduct = productsTable.getSelectionModel().getSelectedItem(); 
   if(productInventory.isEmpty()) {
       errorWindow(11); 
       return; 
        }
   if(!productInventory.isEmpty() && removeProduct == null){
       errorWindow(21); 
       return; 
   }
   else 
   {
       boolean confirm = confirmationWindow(removeProduct.getName()); 
       if(!confirm) {
           return; 
       }
       Inventory.deleteProduct(removeProduct);
       productInventory.remove(removeProduct); 
       productsTable.refresh(); 
   }
    }
   
    @FXML
    private void onModifyProduct(ActionEvent event) {
       
        selectedProduct = productsTable.getSelectionModel().getSelectedItem(); 
            if(selectedProduct == null) {
                 Alert alert = new Alert(AlertType.ERROR); 
                 alert.setTitle("Modify Error"); 
                 alert.setHeaderText("Product not able to be modified"); 
                 alert.setContentText("No Product was Selected!"); 
                 alert.showAndWait();
                 return; }
             selectedPartInd = getAllProducts().indexOf(selectedPart);
                try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/ViewController/modifyProduct.fxml")); 
        ModifyProductController controller = new ModifyProductController(selectedProduct);
        
        loader.setController(controller);
        Parent root = loader.load(); 
        Scene scene = new Scene(root); 
        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow(); 
        stage.setScene(scene); 
        stage.setResizable(false); 
        stage.show(); 
    } 
    catch (IOException e) {}
    }
    

    @FXML
    private void onAddProduct(ActionEvent event) {try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/ViewController/addProduct.fxml")); 
        AddProductController controller = new AddProductController();
        
        loader.setController(controller);
        Parent root = loader.load(); 
        Scene scene = new Scene(root); 
        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow(); 
        stage.setScene(scene); 
        stage.setResizable(false); 
        stage.show(); 
    } 
    catch (IOException e) {}
    }

    @FXML
    private void onProductSearch(ActionEvent event) {
        if (!productSearchBox.getText().trim().isEmpty()) {
         productInventorySearch.clear(); 
         for (int i = 0; i<productIDList.size(); i++) {
             if (Inventory.lookUpProduct(productIDList.get(i)).getName().contains(productSearchBox.getText().trim())) {
                 productInventorySearch.add(Inventory.lookUpProduct(productIDList.get(i))); 
             }
         }
         productsTable.setItems(productInventorySearch); 
         productsTable.refresh();
     }
    }

}


