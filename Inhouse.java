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
public class Inhouse extends Part{
    private int machineID;
   
    /**
     *
     * @param partID
     * @param partName
     * @param price
     * @param numInStock
     * @param min
     * @param max
     * @param machineID
     */
    public Inhouse(int partID, String partName, double price, int numInStock, int min, int max, int machineID) {
        setPartID(partID); 
        setName(partName); 
        setPrice(price); 
        setInStock(numInStock); 
        setMin(min); 
        setMax(max); 
        setMachineID(machineID); 
        
        
    }

    public Inhouse() {
    }

    public void setMachineID(int id) {
        this.machineID = id; 
    }
    public int getMachineID(){
        return machineID;
    }
}