package com.ajjan.liquorstore.Bll;

import com.ajjan.liquorstore.Api.WineApi;
import com.ajjan.liquorstore.Api.RetrofitCaller;
import com.ajjan.liquorstore.model.Item;
import com.ajjan.liquorstore.strictmode.strictmodeclass;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WineBll {
    List<Item> itemList=  new ArrayList<>();
    Boolean status=false;
    WineApi wineApi  = RetrofitCaller.getInstance().create(WineApi.class);

    public  List<Item> getAllItems() {
        Call<List<Item>> itemsCall = wineApi.getAllItemsLIst();
        strictmodeclass.StrictMode();
        try {
            itemList=  itemsCall.execute().body();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return itemList;
    }

    public  Boolean insertItem(Item item){
        Call<Void> voidCall = wineApi.insertItem(item);
        voidCall.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                if(response.isSuccessful()){
                    status=true;
                }
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                status=false;
            }
        });
        return  status;
    }


}
