/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Model.Inhouse;
import Model.Inventory;
import Model.Outsourced;
import Model.Part;
import Model.Product;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author ajd34
 */
public class Main extends Application {
    
    @Override
    public void start(Stage stage) throws Exception { 
        addTableData(); 
        
        FXMLLoader loader =  new FXMLLoader(getClass().getResource("/ViewController/MainScreen.fxml"));
       // ViewController.MainScreenController controller = new ViewController.MainScreenController();
       // loader.setController(controller); 
        Parent root = loader.load(); 
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public void addTableData() {
   
     //adding parts to products
    
     
     // Inhouse Parts 
     Part x1 = new Inhouse(121, "Chain", 23.99, 18, 2, 44, 471);
     Part x2 = new Inhouse(152, "Right Gear", 9.99, 22, 1, 19, 472); 
     Part x3 = new Inhouse(853, "Break Pad", 8.50, 41, 11, 15, 473); 
     
     Inventory.addPart(x1); 
     Inventory.addPart(x2); 
     Inventory.addPart(x3); 
     
     Inventory.addPart(new Inhouse(954, "Bottle Holder", 1.89, 15, 1, 85, 474));
     Inventory.addPart(new Inhouse(455, "Left Pedal", 3.99, 18, 2, 44, 475));
     
     
     //outsourced parts 
     
     Part p1 = new Outsourced(568, "Right Pedal", 3.99, 16, 4, 75, "USA and CO.");
     Part p2 = new Outsourced(747, "Left Gear", 9.99, 27, 11, 89, "Parts R US"); 
     Part k3 = new Outsourced(788, "Axel", 7.49, 4, 18, 47, "We got the Parts"); 
     
     Inventory.addPart(p1); 
     Inventory.addPart(p2); 
     Inventory.addPart(k3); 
     
     Inventory.addPart(new Outsourced(945, "Reflector", 2.22, 14, 19, 68, "Part Guys"));
     Inventory.addPart(new Outsourced(101, "Bell", 6.85, 8, 1, 25, "Part-Time"));
     
    
     
     Product product1 = new Product (47, "Product 1", 102.50, 11, 1, 13);
            product1.addAssociatedPart(x1); 
            product1.addAssociatedPart(k3);
            product1.addAssociatedPart(p2);
            Inventory.addProduct(product1); 
     Product product2 = new Product (48, "Product 2", 89.50, 21, 2, 14);
            product1.addAssociatedPart(x2); 
            product1.addAssociatedPart(k3);
            product1.addAssociatedPart(p2);
            Inventory.addProduct(product2);
     Product product3 = new Product (49, "Product 3", 11.90, 42, 5, 15);
            product1.addAssociatedPart(x3); 
            product1.addAssociatedPart(k3);
            Inventory.addProduct(product3);
     
     Inventory.addProduct(new Product(50, "Product 4", 0.89, 8, 10, 45));
     Inventory.addProduct(new Product(51, "Product 5", 3.99, 41, 12, 33));
     
    
   
    
 }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    
}
