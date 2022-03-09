package model;

import DTO.RegistryDTO;

public class Registry {
    RegistryDTO registryDTO = new RegistryDTO(5000);


    /**
     * @return returns the amount money in the registry
     */
    public int getAmountMoneyInReg (){

        return registryDTO.getAmountMoney();

    }

    /**
     * set money to the registry
     * @param AddedMoneyToRegistry  the fist money which will be added to the registry when the application runs for the first time.
     */
    public void setRegistryAmount(int AddedMoneyToRegistry){
        registryDTO.setAmountMoney(AddedMoneyToRegistry);
    }

}
