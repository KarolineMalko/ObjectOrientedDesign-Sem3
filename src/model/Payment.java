package model;


public class Payment {

    public Payment(int totPrice, int amountPayment) {
    }

    /**
     * this fucntion calculate the change that will be given back to the client.
     * @param totPrice      the total price of the items
     * @param amountPayed   the amount money that the client paid
     * @return              return the amount change
     */
    public int calculateChange(int totPrice,  int amountPayed){

            int returnedChange = amountPayed - totPrice;
            System.out.println("Change to be returned: ");
            return returnedChange;
    }

}
