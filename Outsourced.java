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
public class Outsourced extends Part{
    
    private String companyName; 
    
 
    public Outsourced(int partID, String partName, double price, int numInStock, int min, int max, String company) {
        setPartID(partID); 
        setName(partName); 
        setPrice(price); 
        setInStock(numInStock); 
        setMin(min); 
        setMax(max); 
        setCompanyName(company); 
        
    }

    public Outsourced() {
    }


   public void setCompanyName(String name) {
        this.companyName = name; 
      }
  
   public String getCompanyName(){
        return companyName;
   }   
}

