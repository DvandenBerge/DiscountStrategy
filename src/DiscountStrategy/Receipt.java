package DiscountStrategy;

/**
 * @author dvandenberge
 */
public class Receipt {
    private final String INVALID_ITEM_ID_ERROR="That is not a valid item ID";
    private final int PRODUCT_ID_LENGTH=5;
    
    private LineItem[] scannedProducts;
    private Customer customer;
    
    public Receipt(int customerID){
        this.scannedProducts=new LineItem[0];
        this.customer=lookupCustomer(customerID);
    }
    
    public String getReceiptLineItems(){
        String formattedReceipt="Billed to "+getCustomerInfo()+"\n";
        for(LineItem l:scannedProducts){
            formattedReceipt+=l.displayLineItem()+"\n";
        }
        return formattedReceipt;
    }
    
    public void addLineItem(String productID,double qty){
        //Makes sure all products scanned have a valid productID length 
        //only accepts IDs with length of 5
        if(productID.length()!=PRODUCT_ID_LENGTH){
            throw new IllegalArgumentException(INVALID_ITEM_ID_ERROR);
        }
        LineItem l=new LineItem(productID,qty);
        LineItem[] temp = new LineItem[scannedProducts.length+1];
        for(int i=0;i<scannedProducts.length;i++){
            temp[i]=scannedProducts[i];
        }
        scannedProducts=temp;
        temp=null;
        scannedProducts[scannedProducts.length-1]=l;
    }
    
    private Customer lookupCustomer(int customerID){
        Customer c=null;
        for(Customer cust:FakeDatabase.getCustomers()){
            if(cust.getCustomerID()==customerID){
                c=cust;
                return c;
            }
        }
        c=new Customer();
        FakeDatabase.addCustomer(c);
        return c;
    }
    
    private String getCustomerInfo(){
        return this.customer.getCustomerName()+" ID:"+this.customer.getCustomerID();
    }

    public static void main(String[] args) {
        Receipt r1 = new Receipt(0);
        r1.addLineItem("BJ111",3);
        r1.addLineItem("BC100",1);
        System.out.println(r1.getReceiptLineItems());
    }
}
