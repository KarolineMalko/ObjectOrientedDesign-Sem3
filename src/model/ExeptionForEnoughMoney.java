package model;

public class ExeptionForEnoughMoney extends Throwable {
    public ExeptionForEnoughMoney(String message){
        super(message);
    }
}
