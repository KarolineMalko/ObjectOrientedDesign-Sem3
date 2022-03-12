package DTO;

public class ReceiptItemsDTO {

    int quantity;
    ItemDTO itemDTO;


    public void setPrice(int price) {
        this.price = price;
    }

    int price;

    public int getPrice() {
        return price;
    }

    public ReceiptItemsDTO(int quantity, ItemDTO itemDTO){
        this.quantity = quantity;
        this.itemDTO = itemDTO;

    }

    public void setItemDTO(ItemDTO itemDTO) {
        this.itemDTO = itemDTO;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public ItemDTO getItemDTO() {
        return itemDTO;
    }
}
