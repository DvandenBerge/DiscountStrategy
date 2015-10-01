package DiscountStrategy;

/**
 * @author dvandenberge
 */
public class LineItem {
    
    private final String NOT_A_PRODUCT_ERROR="That is not a valid product, please re-scan";
    
    private Product product;
    private double qty;
    
    public LineItem(String productID,double qty){
        if(lookupProduct(productID)==null){
            throw new IllegalArgumentException(NOT_A_PRODUCT_ERROR);
        }else{
            this.product=lookupProduct(productID);
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
    
    public String displayLineItem(){     
        return (product.getProductId()+" "+product.getName()+" $"+product.getPrice()+"x"+
                qty+" $"+(product.getPrice()*qty)+" $"+product.getDiscountAmt(qty));
    }
    
    public final Product lookupProduct(String productID){
        Product product=null;
        for(Product p:FakeDatabase.getProducts()){
            if(p.getProductId().equals(productID)){
                product = p;
                break;
            }
        }
        return product;
    }
}
