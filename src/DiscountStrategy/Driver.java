package DiscountStrategy;

/**
 *
 * @author dvandenberge
 */
public class Driver {
    public static void main(String[] args) {
        DatabaseStrategy fakeDatabase = new FakeDatabase();
        Register register1 = new Register(fakeDatabase);
        
        register1.setCustomerID(0);
        register1.scanProductUPC("BC100", 4);
        register1.scanProductUPC("BJ111", 2);
        register1.scanProductUPC("BM210", 3);
        System.out.println(register1.printReceipt());
    }
}
