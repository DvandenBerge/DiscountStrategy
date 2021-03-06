package DiscountStrategy;

/**
 * @author dvandenberge
 */
public interface DatabaseStrategy {
    public abstract Product[] getProducts();
    public abstract Customer[] getCustomers();
    public abstract void addCustomer(Customer c);
    public abstract void addProduct(Product p);
    public abstract Product lookupProduct(String productID);
    public abstract Customer lookupCustomer(int customerID);
    @Override
    public abstract String toString();
}
