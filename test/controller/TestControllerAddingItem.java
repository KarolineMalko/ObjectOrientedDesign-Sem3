package controller;

import DTO.ReceiptItemsDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class TestControllerAddingItem {
    @Test
    public void testEnterItem(){
        Controller ctr = new Controller();
        ctr.runTheInventorySystem();
        int arraySizeBeforeAdd;
        int arraysSizeAfterAdd;
        arraySizeBeforeAdd = ctr.enterItem(1).size();
        arraysSizeAfterAdd = ctr.enterItem(2).size();
        boolean itemAddedSuccessfully = arraysSizeAfterAdd > arraySizeBeforeAdd;
        Assertions.assertTrue(itemAddedSuccessfully);


    }

}
