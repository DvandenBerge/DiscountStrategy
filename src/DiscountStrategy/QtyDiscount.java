package DiscountStrategy;

/**

 * @author dvandenberge
 */
public class QtyDiscount implements DiscountStrategy{
        private double discountRate;
        private double minQty;
    
    public QtyDiscount(double discountRate, double minQty){
        this.discountRate=discountRate;
        this.minQty=minQty;
    }
    
    public double getDiscountAmount(double unitPrice,double qty){        
        return (qty>=minQty)?(unitPrice*qty*discountRate):0;
    }

    public double getDiscountRate() {
        return discountRate;
    }

    public void setDiscountRate(double discountRate) {
        this.discountRate = discountRate;
    }
    
    public double getMinQty(){
        return minQty;
    }
    
    public void setMinQty(double minQty){
        this.minQty=minQty;
    }
}
