package view;

import DTO.ReceiptItemsDTO;
import controller.Controller;
import model.ExceptionNotFountItem;
import model.FileLogger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class View {

    FileLogger fileLogger = new FileLogger();
    public ArrayList<ReceiptItemsDTO> itemsList = new ArrayList<>();



    public View(Controller controller) throws IOException {
        startUp(controller);
    }

    public void startUp(Controller controller) throws IOException {
        try {
            controller.setRegistryMoney();
            controller.runTheInventorySystem();
            while(true) {
                int i = 0;
                controller.resetReceipt();
                System.out.println("------------- START A NEW SALE -------------------");
                while (i == 0) {
                    InputStreamReader InReader = new InputStreamReader(System.in);
                    BufferedReader br = new BufferedReader(InReader);
                    System.out.println("Enter the item id or \"No\" if the customer is done:  " );
                    try {
                        String userInput = br.readLine();
                        if (userInput.equals("No") | userInput.equals("no")) {
                            controller.createReceiptAndShowPrice(itemsList);
                            while (true) {
                                System.out.println("Enter the amount payed: ");
                                String userPayment = br.readLine();
                                try {
                                    int payedMoney = Integer.parseInt(userPayment);
                                    if (controller.pay(payedMoney)) {
                                        controller.showReceipt();
                                        System.out.println(" \n \n ");
                                        controller.updateRegAmount();
                                        i = 1;
                                        break;
                                    } else {
                                        System.out.println("The payment is not enough for completing the sale process");
                                    }
                                }catch (Exception NumberFormatException){
                                    fileLogger.printMsgForUser("Try to enter a number not a character!");
                                }
                            }
                        } else {
                            int id = Integer.parseInt(userInput);
                            ArrayList<ReceiptItemsDTO> theItemList = controller.enterItem(id);
                                this.itemsList = theItemList;
                                controller.setRegistryMoney();
                        }
                    }

                    catch(ExceptionNotFountItem e){
                        fileLogger.printMsgForUser(e.getMessage());
                    }
                    catch(NumberFormatException e){
                        fileLogger.printMsgForUser("Try to enter a number not a character!");
                    }
                    catch (Exception e){
                        fileLogger.printMsgForDev(e);
                    }


                }

            }

        } catch (Exception e) {
            fileLogger.printMsgForDev(e);
        }
    }
}
