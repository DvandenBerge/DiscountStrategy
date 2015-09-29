package DiscountStrategy;

/**
 * @author dvandenberge
 */
public class PercentOffDiscount implements DiscountStrategy {
    private double discountRate;
    
    public PercentOffDiscount(double discountRate){
        this.discountRate=discountRate;
    }
    
    @Override
    public double getDiscountAmount(double unitPrice,double qty){
        return unitPrice*qty*discountRate;
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
