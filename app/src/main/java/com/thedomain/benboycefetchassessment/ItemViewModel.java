package com.thedomain.benboycefetchassessment;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ItemViewModel extends ViewModel {

    private MyRetrofit myRetrofit;

    public ItemViewModel () {
        myRetrofit = new MyRetrofit();
    }

    public void getItems(Context context, RecyclerView myRecycler) {
        myRetrofit.getInstance().create(AmazonAPI.class)
                .getItems().enqueue(new Callback<List<Item>>() {
                    @Override
                    public void onResponse(@NonNull Call<List<Item>> call, @NonNull Response<List<Item>> response) {
                        Log.d("ItemTag", "onResponse - Response code: " + response.code());
                        if (response.isSuccessful()) {
                            Log.d("ItemTag", "Response Data: " + response.body());

                            ArrayList<Item> myData = new ArrayList<>();
                            if (response.body() != null) {
                                myData.addAll(response.body());
                            }

                            //remove null and empty data
                            myData.removeIf(new Predicate<Item>() {
                                @Override
                                public boolean test(Item item) {
                                    //check for Null value, remove if null
                                    if (item.getName() != null) {
                                        //check if value is blank/empty, remove if true
                                        if (item.getName().isEmpty()) {
                                            return true;
                                        } else {
                                            return false;
                                        }
                                    } else {
                                        return true;
                                    }
                                }// end test method
                            });

                            //sort data by List Id

                            myData.sort(Comparator.comparing(Item::getListId)
                                    .thenComparing(Item::getNameWithNumber));
//                            myData.sort(new ItemComparator());
//                            myData.sort(new Comparator<Item>() {
//                                @Override
//                                public int compare(Item item, Item t1) {
//                                    if (item.getListId() > t1.getListId() &&
//                                            (item.getName().compareTo(t1.getName()) > 0)) {
//                                        return 1;
//                                    } else {
//                                        return -1;
//                                    }
//                                }
//                            });

//                            //sort data by Name
//                            myData.sort(new Comparator<Item>() {
//                                @Override
//                                public int compare(Item item, Item t1) {
//                                    if (item.getName().compareTo(t1.getName()) > 0) {
//                                        return 1;
//                                    } else if (item.getName().compareTo(t1.getName()) < 0) {
//                                        return -1;
//                                    } else {
//                                        return 0;
//                                    }
//                                }
//                            });

                            //assign data to adapter
                            ItemAdapter itemAdapter = new ItemAdapter(context, myData);
                            myRecycler.setAdapter(itemAdapter);
                            myRecycler.setLayoutManager(new LinearLayoutManager(context));
                        } else {
                            Log.e("ItemTag", "onResponse - error:\n" + response.message());
                        }
                    }

                    @Override
                    public void onFailure(@NonNull Call<List<Item>> call, @NonNull Throwable t) {
                        Log.e("ItemTag", "onFailure: " + t.getMessage());
                    }
                });
    }
}
