package integration;

import DTO.ItemDTO;

import java.util.ArrayList;

public class InventorySystem {
    public static ArrayList<ItemDTO> itemsList;


    /**
     * it create an arraylist containing the items of the store stock and the info of them.
     */
    public static void createItemList() {
        ArrayList<ItemDTO> itemsList = new ArrayList<ItemDTO>();
        ItemDTO itemDTOProduct1 = new ItemDTO(1, 15, " Milk 1 liter", 0.25);
        ItemDTO ItemDTOProduct2 = new ItemDTO(2, 25, "Tomato 1 bag", 0.25);
        ItemDTO ItemDTOProduct3 = new ItemDTO(3, 50, "Cafe 1 kg", 0.25);
        ItemDTO ItemDTOProduct4 = new ItemDTO(4, 10, "Gum 1 bag", 0.25);
        ItemDTO ItemDTOProduct5 = new ItemDTO(5, 45, "Cheese 1 kg", 0.25);
        ItemDTO ItemDTOProduct6 = new ItemDTO(6, 70, "Salmon 1 kg", 0.25);
        ItemDTO ItemDTOProduct7 = new ItemDTO(7, 20, "bread 1 kg", 0.25);
        itemsList.add(itemDTOProduct1);
        itemsList.add(ItemDTOProduct2);
        itemsList.add(ItemDTOProduct3);
        itemsList.add(ItemDTOProduct4);
        itemsList.add(ItemDTOProduct5);
        itemsList.add(ItemDTOProduct6);
        itemsList.add(ItemDTOProduct7);

        InventorySystem.itemsList = itemsList;
        //String itemList = arrayListToString(itemsList);
        //System.out.println(itemList);
    }

    /**
     * this function return the user chosen item and its info.
     * @param id  the id of the item which is antered by the user.
     * @return it returns ItemDTO which contains the item info.
     */
    public static ItemDTO itemInfo(int id){
        for(int j = 0; j < itemsList.size(); j++) {
            if (itemsList.get(j).getId() == id){
                return itemsList.get(j);
            }
        }
        return null;
    }
}
