package controller;


import model.ExceptionNotFountItem;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class TestControllerAddingItem {
    public Controller ctr = new Controller();
    @Test
    public void testEnterItem() throws ExceptionNotFountItem {

        ctr.runTheInventorySystem();
        int arraySizeBeforeAdd = ctr.enterItem(1).size();
        int arraysSizeAfterAdd = ctr.enterItem(2).size();
        boolean itemAddedSuccessfully = arraysSizeAfterAdd > arraySizeBeforeAdd;
        Assertions.assertTrue(itemAddedSuccessfully);


    }

    @Test
    void ItemNotFoundErrorTest() throws ExceptionNotFountItem {
        boolean check = false;


        try {
            ctr.runTheInventorySystem();
            ctr.enterItem(9);

        }catch (ExceptionNotFountItem exceptionNotFountItem){
            System.out.println(exceptionNotFountItem.getMessage());
            check = true;
        }
        Assertions.assertTrue(check, "The exception has been thrown");

    }

}
