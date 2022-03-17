package view;

import model.RegisterObserver;
import model.Registry;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class TotalRevenueViewRevenue implements RegisterObserver {
    private ArrayList<Integer> registryUpdates;


    public TotalRevenueViewRevenue(){
        this.registryUpdates = new ArrayList<>();
    }
    @Override
    public void newSale(int updatedAmountInReg){

        registryUpdates.add(updatedAmountInReg);
        System.out.println(" total money in registry =  " + updatedAmountInReg + "   Sale number:" +registryUpdates.size());
    }
}
