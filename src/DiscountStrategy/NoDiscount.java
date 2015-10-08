package DiscountStrategy;

/**
 * @author dvandenberge
 */
public class NoDiscount implements DiscountStrategy{
        private double discountRate;
    
    public NoDiscount(double discountRate){
        this.discountRate=discountRate;
    }
    
    @Override
    public double getDiscountAmount(double unitPrice,double qty){
        return 0;
    }

    @Override
    public double getDiscountRate() {
        return discountRate;
    }

    @Override
    public void setDiscountRate(double discountRate) {
        this.discountRate = discountRate;
    }
}
