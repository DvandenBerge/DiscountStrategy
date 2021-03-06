package DiscountStrategy;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * 
 * @author dvandenberge
 */
public class InvoiceFile implements OutputStrategy{
    
    private LineItem[] lineItems;
    private Customer customer;
    private DatabaseStrategy database;
    private PrintWriter writer;
    
    public InvoiceFile() throws IOException{
        DatabaseStrategy fakeDatabase = new FakeDatabase();
        this.lineItems=new LineItem[0];
        this.database=fakeDatabase;
        writer=new PrintWriter("C:\\invoice.txt","UTF-8");
    }
    
    @Override
    public void addLineItem(String productID, double qty) {
        if(productID.length()!=PRODUCT_ID_LENGTH){
            throw new IllegalArgumentException(INVALID_ITEM_ID_ERROR);
        }
        LineItem[] temp=new LineItem[lineItems.length+1];
        for(int i=0;i<lineItems.length;i++){
            temp[i]=lineItems[i];
        }
        lineItems=temp;
        temp=null;
        lineItems[lineItems.length-1]=new LineItem(database.lookupProduct(productID),qty);
    }

    @Override
    public int getCustomerID() {
        return customer.getCustomerID();
    }
    @Override
    public void setCustomerID(int customerID){
        this.customer=database.lookupCustomer(customerID);
    }

    @Override
    public String getOutputLineItems(){
        double totalCost=0;
        double totalDiscounted=0;
        for(LineItem l:lineItems){
            writer.println(l.displayLineItemInfo());
            totalCost+=l.getDiscountedLineItemPrice();
            totalDiscounted+=l.getLineItemDiscountAmt();
        }
        writer.println("Total Price: $"+totalCost);
        writer.print("Total Saved: $"+totalDiscounted);
        writer.close();
        return "Invoice created!!";
    }

    @Override
    public void setDatabase(DatabaseStrategy database) {
        this.database=database;
    }
    
}
