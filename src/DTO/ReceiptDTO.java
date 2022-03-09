package DTO;

import java.util.ArrayList;

public class ReceiptDTO {
    String storeName;
    ArrayList<ReceiptItemsDTO> receiptItemsDTO;
    //ArrayList<ItemDTO> itemsList;
    String timeOfPurchase;
    int totalPrice;
    int payedCash;
    int returnedChange;

    /*public ReceiptDTO(ArrayList<ItemDTO> itemDTOArrayList, LocalDateTime timeOfPurchase, int totalPrice){
        this.itemDTOArrayList = itemDTOArrayList;
        this.timeOfPurchase = timeOfPurchase;
        this.totalPrice = totalPrice;
    }*/

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public void setPayedCash(int payedCash) {
        this.payedCash = payedCash;
    }

    public ReceiptDTO(String storeName, ArrayList<ReceiptItemsDTO> receiptItemsDTO, String timeOfPurchase, int totalPrice, int payedCash, int returnedChange){
        //this.itemDTOArrayList = itemDTOArrayList;
        this.storeName = storeName;
        this.receiptItemsDTO = receiptItemsDTO;
        //this.itemsList = itemsList;
        this.timeOfPurchase = timeOfPurchase;
        this.totalPrice = totalPrice;
        this.payedCash = payedCash;
        this.returnedChange = returnedChange;

    }

    public int getPayedCash() {
        return payedCash;
    }

    /*public ArrayList<ItemDTO> getItemDTOArrayList() {
        return itemDTOArrayList;
    }*/

    /*public ArrayList<ItemDTO> itemsList() {
        return itemsList;
    }*/

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
