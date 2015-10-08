package DiscountStrategy;

/**
 *
 * @author dvandenberge
 */
public interface OutputStrategy {
    public static final String INVALID_ITEM_ID_ERROR="That is not a valid item ID";
    public static final int PRODUCT_ID_LENGTH=5;
    
    public abstract void addLineItem(String productID, double qty);
    public abstract int getCustomerID();
    public abstract String getOutputLineItems();
    public abstract void setCustomerID(int customerID);
    public abstract void setDatabase(DatabaseStrategy database);
}
