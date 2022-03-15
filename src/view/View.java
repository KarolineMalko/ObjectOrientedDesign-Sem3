package view;

import DTO.ReceiptItemsDTO;
import controller.Controller;
//import model.ExceptionForDatabase;
import model.ExceptionNotFountItem;
import model.FileLogger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class View {
    //Controller controller;
    FileLogger fileLogger = new FileLogger();
    public ArrayList<ReceiptItemsDTO> itemsList = new ArrayList<>();
    //public ReceiptDTO receipt = new ReceiptDTO(itemsList);

    //private Object ExeptionForDatabase;

    public View(Controller controller) throws IOException {
        startUp(controller);
    }

    public void startUp(Controller controller) throws IOException {
        try {
            controller.setRegistryMoney();
            controller.runTheInventorySystem();
            while(true) {
                //controller = new Controller();
                //Controller controller1;
                int i = 0;
                controller.resetReceipt();
                while (i == 0) {
                    //controller.resetReceipt();
                    InputStreamReader InReader = new InputStreamReader(System.in);
                    BufferedReader br = new BufferedReader(InReader);
                    System.out.println("Enter the item id or (\"No\" if the customer doesn't want to buy anything else): " );
                    try {
                        String userInput = br.readLine();
                        if (userInput.equals("No")) {
                            controller.createReceiptAndShowPrice(itemsList);
                            while (true) {
                                System.out.println("Enter the amount payed: ");
                                String userPayment = br.readLine();
                                try {
                                    int payedMoney = Integer.parseInt(userPayment);
                                    if (controller.pay(payedMoney) == 1) {
                                        controller.showReceipt();
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
                            //if(theItemList == null) {
                                //throw new ExceptionNotFountItem("");
                            //}else {
                                this.itemsList = theItemList;
                                controller.setRegistryMoney();
                            //}
                        }
                    }
                    /*catch (IOException e) {
                        //e.printStackTrace();
                        fileLogger.printMsgForDev(e);

                    }*/
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
