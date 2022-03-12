package view;

import DTO.ReceiptDTO;
import DTO.ReceiptItemsDTO;
import controller.Controller;
import model.ExeptionForDatabase;
import model.ExeptionForEnoughMoney;
import model.FileLogger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class View {
    //Controller controller;
    FileLogger fileLogger = new FileLogger();
    public ArrayList<ReceiptItemsDTO> itemsList = new ArrayList<>();
    public ReceiptDTO receipt = new ReceiptDTO(itemsList);

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
                while (i == 0) {
                    //controller.resetReceipt();
                    InputStreamReader InReader = new InputStreamReader(System.in);
                    BufferedReader br = new BufferedReader(InReader);
                    System.out.println("Enter the item id: ");
                    try {
                        String userInput = br.readLine();
                        if (userInput.equals("No")) {
                            this.receipt = controller.createReceiptAndShowPrice(itemsList);
                            while (true) {
                                System.out.println("Enter the amount payed: ");
                                String userPayment = br.readLine();
                                int payedMoney = Integer.parseInt(userPayment);
                                if (controller.pay(payedMoney) == 1) {
                                    controller.showReceipt();
                                    controller.updateRegAmount();
                                    //ArrayList<ReceiptItemsDTO> itemsList = new ArrayList<>();
                                    //this.receipt = new ReceiptDTO(itemsList);
                                    //this.receipt = controller.createReceiptAndShowPrice(itemsList);
                                    i = 1;
                                    break;
                                }
                                else {
                                    throw new ExeptionForEnoughMoney("the payment is not enough for completing the sale process");
                                }
                            }
                        } else {
                            int id = Integer.parseInt(userInput);
                            ArrayList<ReceiptItemsDTO> theItemList = controller.enterItem(id);
                            if(theItemList == null) {
                                throw new ExeptionForDatabase("");
                            }else {
                                this.itemsList = theItemList;
                                controller.setRegistryMoney();
                            }
                        }
                    } /*catch (NumberFormatException e) {
                        System.out.println("try to enter a number");
                    }*/
                    catch (IOException | ExeptionForDatabase | ExeptionForEnoughMoney | NumberFormatException e) {
                        //e.printStackTrace();
                        //fileLogger.logForUser(new Exception());
                        fileLogger.printMsgForUser("Try to enter a number not a character!");
                        //fileLogger.printMsgForDev((NumberFormatException) e);
                        //fileLogger.printMsgForDev(e);
                        //fileLogger.printMsgForDev((ExeptionForDatabase) e);

                    } catch (Exception e){
                        fileLogger.printMsgForDev(e);
                    }

                }

            }

        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
    }
    public void logger(){

    }
}
