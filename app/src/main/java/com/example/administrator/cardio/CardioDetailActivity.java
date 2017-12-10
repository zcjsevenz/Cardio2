package com.example.administrator.cardio;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.cardio.model.CardioItem;

public class CardioDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cardio_detail);

        ImageView cardioImageView = findViewById(R.id.CardioImageView);
        TextView cardioTextView = findViewById(R.id.CardioDetailView);

        Intent intent = getIntent();
        int position = intent.getIntExtra("position",0);
        CardioData cardioData = CardioData.getsInstance();
        CardioItem cardio = cardioData.cardioList.get(position);

        String title = cardio.title;
        String detail = cardio.detail;
        Drawable drawable = cardio.getPictureDrawable(this);

        cardioImageView.setImageDrawable(drawable);
        cardioTextView.setText(detail);

        getSupportActionBar().setTitle(title);

    }
}
