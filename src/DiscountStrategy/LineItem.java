package DiscountStrategy;

/**
 * @author dvandenberge
 */
public class LineItem {
    
    private final String NOT_A_PRODUCT_ERROR="That is not a valid product, please re-scan";
    
    private Product product;
    private double qty;
    
    /**
     *
     * @param product a LineItem is only created if a valid product is passed into the constructor. This is checked in the receipt against the database
     * @param qty a double value for the quantity purchased/scanned
     */
    public LineItem(Product product,double qty){
        if(product==null){
            throw new IllegalArgumentException(NOT_A_PRODUCT_ERROR);
        }else{
            this.product=(product);
            this.qty=qty;
        }
    }

    public Product getProduct() {
        return product;
    }
    public void setProduct(Product product) {
        this.product = product;
    }

    public double getQty() {
        return qty;
    }
    public void setQty(double qty) {
        this.qty = qty;
    }
    
    private double getMaxPrice(){
        return product.getPrice()*qty;
    }

    /**
     *
     * @return the max price with the discount applied
     */
    public double getDiscountedLineItemPrice(){
        return getMaxPrice()-product.getDiscountAmt(qty);
    }
    
    /**
     *
     * @return the amount to be discounted for that quantity
     */
    public double getLineItemDiscountAmt(){
        return product.getDiscountAmt(qty);
    }
    
    public String displayLineItemInfo(){     
        return (product.getProductId()+" "+product.getName()+" $"+product.getPrice()+"x"+
                qty+" $"+getMaxPrice()+" - $"+getLineItemDiscountAmt()+
                " = $"+(getMaxPrice()-getLineItemDiscountAmt()));
    }
    
    @Override
    public String toString(){
        return product.getProductId()+" "+product.getName()+" "+qty+" "+getMaxPrice();
    }
}
