/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author ajd34
 */
public abstract class Part {
   protected int partID; 
   protected String partName; 
   protected int partInStock; 
   protected double partPrice; 
   protected int min; 
   protected int max;
   
   
   //partID 
   public void setPartID (int partID) {
       this.partID = partID; 
   }
   public int getPartID() {
       return this.partID; 
   }
   
   
  //name 
    public void setName (String name) {
       this.partName = name; 
   }
   public String getName() {
       return this.partName; 
   }
   
   //stock 
    public void setInStock (int quantity) {
       this.partInStock = quantity; 
   }
   public int getInStock() {
       return this.partInStock; 
   }
   //price 
   
    public void setPrice (double price) {
       this.partPrice = price; 
   }
   public double getPrice() {
       return partPrice; 
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
}

