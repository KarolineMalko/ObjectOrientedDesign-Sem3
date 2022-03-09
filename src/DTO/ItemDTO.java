package DTO;

public class ItemDTO {
    int id;
    int productPrice;
    String productDescription;
    double VAT;


    public ItemDTO(int id, int productPrice, String productDescription, double VAT){
        this.id = id;
        this.productPrice = productPrice;
        this.productDescription = productDescription;
        this.VAT = VAT;
    }



    public int getId() {
        return id;
    }


    public double getVAT() {
        return VAT;
    }

    public int getProductPrice() {
        return productPrice;
    }

    public String getProductDescription() {
        return productDescription;
    }
}
