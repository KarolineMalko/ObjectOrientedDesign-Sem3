package view;

import DTO.ReceiptItemsDTO;
import controller.Controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class View {
    Controller controller;
    public ArrayList<ReceiptItemsDTO> itemsList = new ArrayList<>();

    public View(Controller controller){
        this.controller = controller;
    }

    public void startUp() throws IOException {
        try {
            controller.setRegistryMoney();
            while(true) {
                int i = 0;
                while (i == 0) {
                    InputStreamReader InReader = new InputStreamReader(System.in);
                    BufferedReader br = new BufferedReader(InReader);
                    controller.startSale();
                    System.out.println("Enter the item id: ");
                    try {
                        String userInput = br.readLine();
                        if (userInput.equals("No")) {
                            controller.createReceiptAndShowPrice(itemsList);
                            while (true) {
                                System.out.println("Enter the amount payed: ");
                                String userPayment = br.readLine();
                                int payedMoney = Integer.parseInt(userPayment);
                                if (controller.pay(payedMoney) == 1) {
                                    controller.showReceipt();
                                    controller.updateRegAmount();
                                    i = 1;
                                    break;
                                }
                            }
                        } else {
                            int id = Integer.parseInt(userInput);
                            ArrayList<ReceiptItemsDTO> theItemList = controller.enterItem(id);
                            if(!(theItemList == null)) {
                                //this.itemsList = controller.enterItem(id);
                                this.itemsList = theItemList;
                                controller.setRegistryMoney();
                            }else{
                                System.out.println("The item was not found in the stock!");
                            }
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (NumberFormatException e) {
                        //e.printStackTrace();
                        System.out.println("try to enter a number");
                    }

                }

            }

        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }
}
