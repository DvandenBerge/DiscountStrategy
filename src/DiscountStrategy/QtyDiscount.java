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
    
    @Override
    public double getDiscountAmount(double unitPrice,double qty){        
        return (qty>=minQty)?(unitPrice*qty*discountRate):0;
    }

    @Override
    public double getDiscountRate() {
        return discountRate;
    }

    @Override
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
