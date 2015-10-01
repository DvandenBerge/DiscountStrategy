package DiscountStrategy;

/**
 * @author dvandenberge
 */
public class Product {
    private String productId;
    private String name;
    private double unitPrice;
    private DiscountStrategy discount;

    public Product(String productId, String name, double price, DiscountStrategy discount) {
        this.productId = productId;
        this.name = name;
        this.unitPrice=price;
        this.discount = discount;
    }
    
    public double getDiscountAmt(double qty){
        return discount.getDiscountAmount(unitPrice, qty);
    }
    
    public void setPrice(double price) {
        this.unitPrice = price;
    }
    public void setProductId(String productId) {
        this.productId = productId;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setDiscount(DiscountStrategy discount) {
        this.discount = discount;
    }
    
    public double getPrice() {
        return unitPrice;
    }
    public String getProductId() {
        return productId;
    }
    public String getName() {
        return name;
    }
    public DiscountStrategy getDiscount() {
        return discount;
    }
    
}
