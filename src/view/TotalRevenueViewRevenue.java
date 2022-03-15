package view;

import model.RegisterObserver;
import model.Registry;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class TotalRevenueViewRevenue implements RegisterObserver {
    private ArrayList<Integer> registryUpdates;


    public TotalRevenueViewRevenue(){
        this.registryUpdates = new ArrayList<Integer>();
    }
    @Override
    public void newRegistryUpdate(int updatedAmountInReg){
        registryUpdates.add(updatedAmountInReg);
        print();
    //public void update(Observable o, Object arg) {

    }
    public void print(){
        int numberOfUpdates = registryUpdates.size();
        System.out.println("show me!--------------------------> : " + numberOfUpdates);
    }
}
