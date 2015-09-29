package DiscountStrategy;

/**
 *
 * @author dvandenberge
 */
public interface DiscountStrategy {

    double getDiscountAmount(double unitPrice, double qty);

    double getDiscountRate();

    void setDiscountRate(double discountRate);
    
}
