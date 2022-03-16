package model;

import DTO.ReceiptDTO;
import DTO.ReceiptItemsDTO;

import java.util.ArrayList;

/**
 * it is responsible for creating the receipt
 * storeName    the name of the store.
 * receiptItemsDTO   list of the items which are in the receipt.
 * timeOfPurchase    date of the sale
 * totalPrice        the total price which the client needs to pay
 * payedCash         the amount money the client is paying
 * returnChange      the change which will  be returned to the client.
 * @return                  the receiptDTO which contains the receipt info.
 */

public class Receipt {
    ReceiptDTO receiptDTO;
    public Receipt(String storeName, ArrayList<ReceiptItemsDTO> receiptItemsDTO, String timeOfPurchase,
                   int totalPrice, int payedCash, int returnChange){
        this.receiptDTO = new ReceiptDTO(storeName,receiptItemsDTO,timeOfPurchase , totalPrice, payedCash, returnChange);
    }



    public ReceiptDTO returnReceiptDTO() {
        return this.receiptDTO;
    }

    public void updatePayedCash(int payment) {
        this.receiptDTO.setPayedCash(payment);
    }

}
