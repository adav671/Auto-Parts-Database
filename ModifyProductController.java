/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ViewController;

import Model.Product;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author ajd34
 */
public class ModifyProductController implements Initializable {

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
    private TextField SearchProduct;
    @FXML
    private Button AddProduct;
    
    private Product modifiedProduct; 

    ModifyProductController(Product selectedProduct) {
        modifiedProduct = selectedProduct; 
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
