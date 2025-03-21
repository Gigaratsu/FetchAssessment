package com.thedomain.benboycefetchassessment;

import java.util.Comparator;

public class ItemComparator implements Comparator<Item> {

    public ItemComparator() {
    }

    @Override
    public int compare(Item item, Item t1) {
        int compareValue = 0;
        //is the listId a lower value?
        if (item.getListId() > t1.getListId()) {
//            compareValue = 1;
//            if (item.getName().compareTo(t1.getName()) > 0) {
//                compareValue = 1;
//            } else {
//                compareValue = -1;
//            }
            if (item.getName().compareTo(t1.getName()) > 0) {
                compareValue = 1;
            }
             else if (item.getName().compareTo(t1.getName()) < 0){
                compareValue = -1;
            }
        } else {
//            //the listId is not lower
//            compareValue = -1;
//            if (item.getName().compareTo(t1.getName()) > 0) {
//                compareValue  = 1;
//            } else {
//                compareValue = -1;
//            }
            compareValue = -1;
        }
        return compareValue;
    }
}
