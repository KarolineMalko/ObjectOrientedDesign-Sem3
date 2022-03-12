package payment;

import model.Payment;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestPaymentCalcChange {
    @Test
    public void testCalculateChange(){
        int totPrice = 150;
        int amountPayment = 300;
        Payment payment = new Payment(150, 300);
        int changeToBeReturn = payment.calculateChange(150,300);
        int change = amountPayment - totPrice;
        boolean changeCalculatedCorrectly = changeToBeReturn == change;
        Assertions.assertTrue(changeCalculatedCorrectly);
    }

}
