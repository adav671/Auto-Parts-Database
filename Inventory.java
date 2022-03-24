/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author ajd34
 */
public class Inventory {
    
    private static ObservableList<Product> allProducts = FXCollections.observableArrayList();
    private static ObservableList<Part> allParts = FXCollections.observableArrayList(); 
    private static int partIDCount = 0; 
    private static int productIDCount = 0; 
    //products 
    
    public static void addProduct(Product productToAdd){
        if (productToAdd !=null) {
            allProducts.add(productToAdd);
        }
        
    }
    
    public static void deleteProduct(Product selectedProduct) {
          allProducts.remove(selectedProduct); 
    }
    
    public static Product lookUpProduct(int productToSearch){
       if (!allProducts.isEmpty()) {
           for (int i =0; i<allProducts.size(); i++) {
               if (allProducts.get(i).getProductID()==productToSearch){
                   return allProducts.get(i);
               }
           }
       }
       return null; 
    }
    
    public static void updateProduct(int productInd, Product product) {
        allProducts.set(productInd, product);
    }
          
    public static ObservableList<Product> getAllProducts() {
       return allProducts; 
   }
    
  //parts 
       
     public static void addPart(Part partToAdd){
        if (partToAdd !=null) {
            allParts.add(partToAdd);
        }
    }
    
public static void deletePart(Part selectedPart) {
    allParts.remove(selectedPart);
    }
    
    public static Part lookUpPart(int partToSearch){
       if (!allParts.isEmpty()) {
           for (int i =0; i<allParts.size(); i++) {
               if (allParts.get(i).getPartID()==partToSearch){
                   return allParts.get(i);
               }
           }
       }
       return null; 
    }
    
     public static void updatePart(int partInd, Part part) {
        allParts.set(partInd, part);
    }
   public static ObservableList<Part> getAllParts() {
       return allParts; 
   }

    public static int getPartIDCount() {
       partIDCount++; 
       return partIDCount; 
    }

}
    
    
  
