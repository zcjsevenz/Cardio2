package com.example.administrator.cardio.model;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.drawable.Drawable;
import android.util.Log;

import com.example.administrator.cardio.CardioDetailActivity;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Administrator on 10/12/2560.
 */

public class CardioItem {
    public final String title;
    public final String picture;
    public final String detail;

    public CardioItem(String title, String picture,String detail) {
        this.title = title;
        this.picture = picture;
        this.detail = detail;
    }

    @Override
    public String toString() {
        return title;
    }

    public Drawable getPictureDrawable(Context context){
        AssetManager lc = context.getAssets();

        try {
            InputStream inputStream = lc.open(picture);
            Drawable drawable = Drawable.createFromStream(inputStream, "");
            return drawable;
        } catch (IOException e){
            Log.e("Cardio","Error Openning File : " + picture);
            e.printStackTrace();
            return null;
        }
    }
}

