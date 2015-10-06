package DiscountStrategy;

/**
 *
 * @author dvandenberge
 */
public interface OutputStrategy {
    public abstract void addLineItem(String productID, double qty);
    public abstract int getCustomerID();
    public abstract  DatabaseStrategy getDatabase();
    public abstract String getOutputLineItems();
    public abstract String getLineItemInfo();
    public abstract void setCustomerID(int customerID);
    public abstract void setDatabase(DatabaseStrategy database);
}
