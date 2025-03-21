package com.thedomain.benboycefetchassessment;

import com.google.gson.annotations.SerializedName;

public class Item {

    @SerializedName("id")
    private int id;

    @SerializedName("listId")
    private int listId;

    @SerializedName("name")
    private String name;

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", listId=" + listId +
                ", name='" + name + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public int getNameWithNumber() {
        String num = name.replaceAll("[^\\d.]", "");
        num = num.trim();
        return Integer.parseInt(num);
    }

    public int getListId() {
        return listId;
    }

    public String getName() {
        return name;
    }
}
