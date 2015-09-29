package DiscountStrategy;

/**
 * @author dvandenberge
 */
public class NoDiscount implements DiscountStrategy{
        private double discountRate;
    
    public NoDiscount(double discountRate){
        this.discountRate=discountRate;
    }
    
    public double getDiscountAmount(double unitPrice,double qty){
        return 0;
    }

    public double getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(double discountRate) {
        this.discountRate = discountRate;
    }
}
