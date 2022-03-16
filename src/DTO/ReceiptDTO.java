package DTO;

import java.util.ArrayList;

public class ReceiptDTO {
    String storeName;
    ArrayList<ReceiptItemsDTO> receiptItemsDTO;
    String timeOfPurchase;
    int totalPrice;
    int payedCash;
    int returnedChange;


    public ReceiptDTO(String storeName, ArrayList<ReceiptItemsDTO> receiptItemsDTO, String timeOfPurchase, int totalPrice, int payedCash, int returnedChange){
        this.storeName = storeName;
        this.receiptItemsDTO = receiptItemsDTO;
        this.timeOfPurchase = timeOfPurchase;
        this.totalPrice = totalPrice;
        this.payedCash = payedCash;
        this.returnedChange = returnedChange;

    }

    public String getStoreName() {
        return storeName;
    }


    public void setPayedCash(int payedCash) {
        this.payedCash = payedCash;
    }



    public int getPayedCash() {
        return payedCash;
    }


    public ArrayList<ReceiptItemsDTO> getReceiptItemsDTO() {
        return receiptItemsDTO;
    }

    public String getTimeOfPurchase() {
        return timeOfPurchase;
    }

    public void setReturnedChange(int returnedChange) {
        this.returnedChange = returnedChange;
    }

    public int getReturnedChange() {
        return returnedChange;
    }

    public int getTotalPrice() {
        return totalPrice;
    }
}
