package DiscountStrategy;

/**
 * @author dvandenberge
 */
public class FakeDatabase implements DatabaseStrategy{
    private Product[] products={
        new Product("BC100","Baseball Cap White",20.00,new QtyDiscount(.10,2)),
        new Product("BJ111","Baseball Jersey White/Blue",45.00,new PercentOffDiscount(.15)),
        new Product("BM210","Baseball Mitt Easton",32.00,new NoDiscount(0))
    };
    
    private Customer[] customers={
        new Customer("Bob Jones"),
        new Customer("Jane Willaims"),
        new Customer("Bill Warsaw")
    };
    
    @Override
    public Product[] getProducts(){
        return products;
    }
    
    @Override
    public Customer[] getCustomers(){
        return customers;
    }
    
    @Override
    public void addCustomer(Customer c){
        Customer[] temp=new Customer[customers.length+1];
        for(int i=0;i<customers.length;i++){
            temp[i]=customers[i];
        }
        customers=temp;
        temp=null;
        customers[customers.length-1]=c;
    }
    
    @Override
    public void addProduct(Product p){
        Product[] temp=new Product[products.length+1];
        for(int i=0;i<products.length;i++){
            temp[i]=products[i];
        }
        products=temp;
        temp=null;
        products[products.length-1]=p;
    }
}
