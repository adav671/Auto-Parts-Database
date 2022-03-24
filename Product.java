/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.util.ArrayList;

/**
 *
 * @author ajd34
 */
public class Product {
    
   private ArrayList<Part> associatedParts = new ArrayList<Part>();  
   private int productID; 
   private String name; 
   private int inStock=0; 
   private double price =0.0; 
   private int min; 
   private int max; 
   private double cost; 
   
   public Product(int productID, String name, double price, int inStock, int min, int max){
        setProductID(productID); 
        setName(name); 
        setPrice(price); 
        setInStock(inStock); 
        setMin(min); 
        setMax(max); 
        
   }
   
   //partID 
   public void setProductID (int productID) {
       this.productID = productID; 
   }
   public int getProductID() {
       return this.productID; 
   }
   
   
  //name 
    public void setName (String name) {
       this.name = name; 
   }
   public String getName() {
       return this.name; 
   }
   
   //stock 
    public void setInStock (int quantity) {
       this.inStock = quantity; 
   }
   public int getInStock() {
       return this.inStock; 
   }
   //price 
   
    public void setPrice (double price) {
       this.price = price; 
   }
   public double getPrice() {
       return price; 
   }
 
   
   //min 
     public void setMin (int min) {
       this.min = min; 
   }
   public int getMin() {
       return this.min; 
   }
   
   //max 
     public void setMax (int max) {
       this.max = max;  
   }
   public int getMax() {
       return this.max; 
   }
  
   
   //associatedParts 
   public void addAssociatedPart(Part part){
       associatedParts.add(part); 
   }
   
   public boolean deleteAssociatedPart(Part part) {
       return associatedParts.remove(part); 
   }
   
   public ArrayList<Part> getAllAssociatedParts() {
       return null;
   }
 
}

