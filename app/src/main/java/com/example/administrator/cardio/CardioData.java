package com.example.administrator.cardio;

import com.example.administrator.cardio.model.CardioItem;

import java.util.ArrayList;

/**
 * Created by Administrator on 10/12/2560.
 */
public class CardioData {

    private  static CardioData sInstance;
    public ArrayList<CardioItem> cardioList;


    public static CardioData getsInstance(){
        if(sInstance==null){
            sInstance=new CardioData();
        }
        return sInstance;
    }
}
