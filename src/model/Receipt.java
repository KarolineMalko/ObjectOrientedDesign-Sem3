package model;

import DTO.ItemDTO;
import DTO.ReceiptDTO;
import DTO.ReceiptItemsDTO;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Receipt {
    //public ArrayList<ReceiptDTO> receiptDTOS  = new ArrayList<>();
    ReceiptDTO receiptDTO;
    public Receipt(String storeName,ArrayList<ReceiptItemsDTO> receiptItemsDTO, String timeOfPurchase,
                   int totalPrice, int payedCash, int returnChange){
        this.receiptDTO = new ReceiptDTO(storeName,receiptItemsDTO,timeOfPurchase , totalPrice, payedCash, returnChange);
    }

    /**
     * it is responsible for creating the receipt
     * @param storeName    the name of the store.
     * @param receiptItemsDTO   list of the items which are in the receipt.
     * @param timeOfPurchase    date of the sale
     * @param totalPrice        the total price which the client needs to pay
     * @param payedCash         the amount money the client is paying
     * @param returnChange      the change which will  be returned to the client.
     * @return                  the receiptDTO which contains the receipt info.
     */
    /*public ReceiptDTO createReceipt(String storeName,ArrayList<ReceiptItemsDTO> receiptItemsDTO, String timeOfPurchase,
                                    int totalPrice, int payedCash, int returnChange){
        ReceiptDTO receiptDTO = new ReceiptDTO(storeName,receiptItemsDTO,timeOfPurchase , totalPrice, payedCash, returnChange);
        return receiptDTO;
    }*/

    public ReceiptDTO returnReceiptDTO() {
        return this.receiptDTO;
    }

    public void updatePayedCash(int payment) {
        this.receiptDTO.setPayedCash(payment);
    }

}
