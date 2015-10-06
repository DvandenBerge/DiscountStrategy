package DiscountStrategy;

/**
 * @author dvandenberge
 */
public class Customer {
    private static int customerCount=0;
    private String customerName;
    private final int customerID;
    
    public Customer(String customerName){
        this.customerName=customerName;
        this.customerID=++customerCount;
    }
    
    //default constructor to handle if a customer is not found in the Receipt lookup method
    public Customer(){
        this.customerName="New Customer";
        this.customerID=++customerCount;
    }
    
    public String getCustomerName(){
        return customerName;
    }
    public int getCustomerID(){
        return customerID;
    }
}
