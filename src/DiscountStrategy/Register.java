package DiscountStrategy;

/**
 * @author dvandenberge
 */
public class Register {
    private OutputStrategy outputStrategy;
    
    public void beginNewTransaction(int customerID, OutputStrategy output){
        this.outputStrategy=output;
        output.setCustomerID(customerID);
    }
    
    public void scanProductUPC(String productID,double qty){
        outputStrategy.addLineItem(productID, qty);
    }
    
    public void setCustomerID(int customerID){
        outputStrategy.setCustomerID(customerID);
    }
    
    public String finalizeTransaction(){
        return outputStrategy.getOutputLineItems();
    }
    
}
