package com.example.administrator.cardio.adapter;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.cardio.MainActivity;
import com.example.administrator.cardio.R;
import com.example.administrator.cardio.model.CardioItem;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

/**
 * Created by Administrator on 10/12/2560.
 */

public class CardioListAdapter extends ArrayAdapter<CardioItem> {
    private Context mContext;
    private int mLayoutResId;
    private ArrayList<CardioItem> mcardioItemList;

    public CardioListAdapter(@NonNull MainActivity context,int layoutResId,@NonNull ArrayList<CardioItem> cardioItemList){
        super(context, layoutResId, cardioItemList);

        this.mContext = context;
        this.mLayoutResId = layoutResId;
        this.mcardioItemList = cardioItemList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View itemLayout = inflater.inflate(mLayoutResId, null);

        CardioItem item = mcardioItemList.get(position);

        ImageView phoneImageView = itemLayout.findViewById(R.id.cardio_image_view);
        TextView phoneTitleTextView = itemLayout.findViewById(R.id.cardio_text_view);

        phoneTitleTextView.setText(item.title);

        String pictureFileName = item.picture;

        AssetManager am = mContext.getAssets();
        try {
            InputStream stream = am.open(pictureFileName);
            Drawable drawable = Drawable.createFromStream(stream, null);
            phoneImageView.setImageDrawable(drawable);

        } catch (IOException e) {
            e.printStackTrace();

            File pictureFile = new File(mContext.getFilesDir(), pictureFileName);
            Drawable drawable = Drawable.createFromPath(pictureFile.getAbsolutePath());
            phoneImageView.setImageDrawable(drawable);
        }

        return itemLayout;
    }

}
