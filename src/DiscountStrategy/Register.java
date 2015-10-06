package DiscountStrategy;

import java.io.IOException;

/**
 * @author dvandenberge
 */
public class Register {
    private OutputStrategy outputStrategy;
    
    public Register(DatabaseStrategy db) throws IOException{
        this.outputStrategy=new Receipt(db);
    }
    
    public void scanProductUPC(String productID,double qty){
        outputStrategy.addLineItem(productID, qty);
        System.out.println(outputStrategy.getLineItemInfo());
    }
    
    public void setCustomerID(int customerID){
        outputStrategy.setCustomerID(customerID);
    }
    
    public String printReceipt(){
        return outputStrategy.getOutputLineItems();
    }
    
}
