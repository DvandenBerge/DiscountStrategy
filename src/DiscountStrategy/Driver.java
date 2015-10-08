package DiscountStrategy;

import java.io.IOException;

/**
 *
 * @author dvandenberge
 */
public class Driver {
    public static void main(String[] args) throws IOException{
        
        Register register1 = new Register();
        
        register1.beginNewTransaction(2,new InvoiceFile());
        register1.scanProductUPC("BC100", 4);
        register1.scanProductUPC("BJ111", 2);
        register1.scanProductUPC("BM210", 3);
        System.out.println(register1.printReceipt());
    }
}
