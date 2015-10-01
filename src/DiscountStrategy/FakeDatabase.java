package DiscountStrategy;

/**
 * @author dvandenberge
 */
public class FakeDatabase {
    private static Product[] products={
        new Product("BC100","Baseball Cap White",20.00,new QtyDiscount(.10,2)),
        new Product("BJ111","Baseball Jersey White/Blue",45.00,new PercentOffDiscount(.15)),
        new Product("BM210","Baseball Mitt Easton",32.00,new NoDiscount(0))
    };
    
    private static Customer[] customers={
        new Customer("Bob Jones"),
        new Customer("Jane Willaims"),
        new Customer("Bill Warsaw")
    };
    
    public static Product[] getProducts(){
        return products;
    }
    
    public static Customer[] getCustomers(){
        return customers;
    }
    
    public static void addCustomer(Customer c){
        Customer[] temp=new Customer[customers.length+1];
        for(int i=0;i<customers.length;i++){
            temp[i]=customers[i];
        }
        customers=temp;
        temp=null;
        customers[customers.length-1]=c;
    }
}
