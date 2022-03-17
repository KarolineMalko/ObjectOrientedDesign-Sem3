package controller;

import DTO.ItemDTO;
import DTO.ReceiptDTO;
import DTO.ReceiptItemsDTO;
import integration.InventorySystem;
import model.*;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;


/**
 * the controller class is responsible for making all the connection between the view class all all other model classes.
 */
public class Controller {
    String storeName = "Sky Supermarket  \nStorgatan 3 \n15435 Stockholm ";

    Registry registry = new Registry();
    Sale sale;
    ItemDTO itemInfo;
    LocalDateTime now = LocalDateTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    String dateTimeString = now.format(formatter);
    public ArrayList<ItemDTO> itemsList = new ArrayList<>();
    public ArrayList<ReceiptItemsDTO> receiptItemsDTOS = new ArrayList<>();
    public ReceiptItemsDTO receiptItemsDTO;
    public Receipt receipt;
    public ReceiptDTO receiptDTO;
    public int price = 0;
    public int changeToBeReturned = 0;
    int amountPayment;
    int updatedAmountInReg;
    private ArrayList<RegisterObserver> observers;
    InventorySystem inventorySystem;



    public Controller(){
        this.inventorySystem = new InventorySystem();
        this.sale = new Sale();
        this.observers = new ArrayList<>();
    }


    /**
     * this function run the function createItemList in the InventorySystem which creates the Item list of the store stock.
     */
    public void runTheInventorySystem(){

    }

    /**
     * this function takes the id of the item as a parameter, it gets the item info from the InventorySystem class. if the InventorySystems function "itemInfo" returns true, it means that the
     * item is available in the stock.
     * it creates a new sale and add the item to the list of the entered items
     * @param {int} i which is the item id which will be entered by the user
     * @return array list of receiptItemsDto.
     */
    public ArrayList<ReceiptItemsDTO> enterItem(int i) throws ExceptionNotFountItem {
        if(inventorySystem.itemInfo(i) != null) {
            ItemDTO itemInfo = inventorySystem.itemInfo(i);
            this.itemInfo = inventorySystem.itemInfo(i);

            return sale.addItemsToListAndCalculatePrice(receiptItemsDTOS, itemInfo, receipt);
        }
        return null;
    }


    /**
     * this function add the price of every item to create the total price for the receipt.
     * it creates the receipt and adds the total price to it.
     * @param receiptItemsDTOS
     */
    public void createReceiptAndShowPrice(ArrayList<ReceiptItemsDTO> receiptItemsDTOS){
        for (ReceiptItemsDTO itemsDTO : receiptItemsDTOS) {

            this.price += itemsDTO.getPrice();
        }
        this.receipt = new Receipt(this.storeName, receiptItemsDTOS, dateTimeString, this.price, amountPayment, changeToBeReturned);;
        System.out.println("Total price: " + price);
        this.receiptDTO = this.receipt.returnReceiptDTO();
    }

    public void resetReceipt(){
        this.now = LocalDateTime.now();
        this.formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        this.dateTimeString = now.format(formatter);
        this.itemsList = new ArrayList<>();
        this.receiptItemsDTOS = new ArrayList<>();
        this.price = 0;
        this.changeToBeReturned = 0;
        this.amountPayment = 0;
        this.receipt = new Receipt(this.storeName, this.receiptItemsDTOS,
                this.dateTimeString, this.price,this.amountPayment, this.changeToBeReturned);
        //emptyObservers();

    }

    /**
     * print the receipt on the screen
     */
    public void showReceipt(){
        System.out.println("RECEIPT: \n \n" + ReceiptDTOToString(this.receiptDTO));

    }

    /**
     * it creates an instance of the payment class,  and calculate the change.
     * the pay function checks if the paid amount money is enough for completing the paying process.
     * if the payed money is enough it makes a new instance from the payment class with the total price and the amount payed as parameters.
     * @param {int} amountPayment which the user is paying
     * @return  the function return 1 if the the money is enough so the view can check it before printing the receipt.
     */
    public boolean pay(int amountPayment){
        this.amountPayment = amountPayment;
        if(amountPayment >= price) {
            int totPrice = this.receiptDTO.getTotalPrice();
            Payment payment = new Payment(totPrice, amountPayment);
            changeToBeReturned = payment.calculateChange(totPrice, amountPayment);
            receipt.updatePayedCash(amountPayment);
            receiptDTO.setReturnedChange(changeToBeReturned);
            System.out.println(changeToBeReturned + "\n\n");
            return true;
        }
        else {
            return false;
        }
    }


    /**
     *  this function run the registry to get the amount money in it.
     */
    public void setRegistryMoney(){
        registry.getAmountMoneyInReg();
    }

    /**
     *it adds the total price of the receipt to the amount money of the registry and it updates the registry with the new amount of
     * money.
     * we notify the observer
     */
    public void updateRegAmount() {
        this.updatedAmountInReg = registry.getAmountMoneyInReg() + receiptDTO.getTotalPrice();
        registry.setRegistryAmount(updatedAmountInReg);
        //System.out.println(observers.size());
        //observers.get(0).newSale(this.updatedAmountInReg);
        notifyObserver();
    }

    /**
     * this function go through all the observers and notify them about the changes.
     */

    private void notifyObserver(){
        for(RegisterObserver obs : observers){
            obs.newSale(this.updatedAmountInReg);
        }
    }

    /**
     * this function adds observer to the observers list.
     * @param obs
     */
    public void addObserver (RegisterObserver obs){
        observers.add(obs);
    }

    /**
     * this function makes a new list of the observers so the observers are empty.
     */
    public void emptyObservers (){
        this.observers = new ArrayList<>();
    }

    /**
     * this function converts a receiptDTO to String
     * @param {ReceiptItemsDTO} receiptItemsDTO which contains the quantity of the items, the info of them and the price.
     * @return the receiptItemsDTO as a String
     */
    public String receiptItemDtoToString(ReceiptItemsDTO receiptItemsDTO){
        StringBuilder sb = new StringBuilder();
        sb.append(receiptItemsDTO.getQuantity());
        sb.append("---> ");
        sb.append(itemDtoToString(receiptItemsDTO.getItemDTO()));
        sb.append("  ");
        sb.append(receiptItemsDTO.getPrice());
        /**/
        sb.append("\n");
        String str = sb.toString();
        return str;

    }

    /**
     *this function converts a itemDTO to String
     * @param itemDTO which contains the id, price, description and the vat for each item.
     * @return  the itemDTO as a String
     */
    public String itemDtoToString(ItemDTO itemDTO){
        StringBuilder sb = new StringBuilder();
        sb.append(itemDTO.getId());
        sb.append(" ");
        sb.append(itemDTO.getProductPrice());
        sb.append(" ");
        sb.append(itemDTO.getProductDescription());
        sb.append(" ");
        sb.append(itemDTO.getVAT());

        String str = sb.toString();
        return str;
    }

    /**
     * this function converts a receiptDTO to String
     * @param receiptDTO whcih contains the name of the store, the date, the list of the item and the payment info
     * @return the receiptDTO as a String
     */
    public String ReceiptDTOToString(ReceiptDTO receiptDTO){
        StringBuilder sb = new StringBuilder();
        sb.append(receiptDTO.getStoreName());
        sb.append("\n");
        sb.append(receiptDTO.getTimeOfPurchase());
        sb.append("\n");

        for(ReceiptItemsDTO receiptItemsDTO: receiptDTO.getReceiptItemsDTO()){
            sb.append(receiptItemDtoToString(receiptItemsDTO));
        }
        sb.append("\n");
        sb.append("Total price: " + receiptDTO.getTotalPrice());
        sb.append("\n");
        sb.append("payed cash: " + receiptDTO.getPayedCash());
        sb.append("\n");
        sb.append("Returned change: " + receiptDTO.getReturnedChange());


        String str = sb.toString();
        return str;
    }
}
