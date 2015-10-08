package DiscountStrategy;

/**
 * @author dvandenberge
 */
public class Receipt implements OutputStrategy {
    private final String INVALID_ITEM_ID_ERROR="That is not a valid item ID";
    private final int PRODUCT_ID_LENGTH=5;
    
    private LineItem[] scannedProducts;
    private Customer customer;
    private DatabaseStrategy database;
    
    public Receipt(){
        DatabaseStrategy fakeDatabase = new FakeDatabase();
        this.scannedProducts=new LineItem[0];
        this.database=fakeDatabase;
    }
    
    @Override
    public String getOutputLineItems(){
        String formattedReceipt="Billed to "+getCustomerInfo()+"\n";
        double totalPrice=0;
        double totalAmtDiscounted=0;
        for(LineItem l:scannedProducts){
            formattedReceipt+=l.displayLineItemInfo()+"\n";
            totalPrice+=l.getDiscountedLineItemPrice();
            totalAmtDiscounted+=l.getLineItemDiscountAmt();
        }
        formattedReceipt+="Total Price: $"+totalPrice+"\n";
        formattedReceipt+="Total Saved: $"+totalAmtDiscounted;
        
        return formattedReceipt;
    }
    
    @Override
    public void addLineItem(String productID,double qty){
        //Makes sure all products scanned have a valid productID length 
        //only accepts IDs with length of 5
        if(productID.length()!=PRODUCT_ID_LENGTH){
            throw new IllegalArgumentException(INVALID_ITEM_ID_ERROR);
        }
        LineItem l=new LineItem(database.lookupProduct(productID),qty);
        LineItem[] temp = new LineItem[scannedProducts.length+1];
        for(int i=0;i<scannedProducts.length;i++){
            temp[i]=scannedProducts[i];
        }
        scannedProducts=temp;
        temp=null;
        scannedProducts[scannedProducts.length-1]=l;
    }
    
    @Override
    public int getCustomerID(){
        return customer.getCustomerID();
    }
    @Override
    public void setCustomerID(int customerID){
        this.customer=database.lookupCustomer(customerID);
    }

    @Override
    public void setDatabase(DatabaseStrategy database) {
        this.database = database;
    }
    
    private String getCustomerInfo(){
        return this.customer.getCustomerName()+" ID:"+this.customer.getCustomerID();
    }
    
}
