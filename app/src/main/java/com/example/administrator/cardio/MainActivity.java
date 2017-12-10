package com.example.administrator.cardio;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.administrator.cardio.adapter.CardioListAdapter;
import com.example.administrator.cardio.db.CardioDb;
import com.example.administrator.cardio.model.CardioItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private  ListView mListView;

    private  final CardioData cardioData = CardioData.getsInstance();

    private CardioDb mHelper;
    private SQLiteDatabase mDb;
    private CardioListAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mListView = findViewById(R.id.list_view);

        cardioData.cardioList = new ArrayList<>();

        mHelper = new CardioDb(this);
        mDb = mHelper.getReadableDatabase();

        Cursor cursor = mDb.query(
                CardioDb.TABLE_NAME,
                null,
                null,
                null,
                null,
                null,
                null
        );
        while (cursor.moveToNext()) {
            String title = cursor.getString(cursor.getColumnIndex(CardioDb.COL_TITLE));
            String picture = cursor.getString(cursor.getColumnIndex(CardioDb.COL_PICTURE));
            String detail = cursor.getString(cursor.getColumnIndex(CardioDb.COL_DETAIL));

            cardioData.cardioList.add(new CardioItem(title,picture,detail));
        }




        mAdapter = new CardioListAdapter(
                this,
                R.layout.item,
                cardioData.cardioList
        );

        mListView.setAdapter(mAdapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                CardioItem cardio = cardioData.cardioList.get(i);
                Toast t = Toast.makeText(MainActivity.this,cardio.title,Toast.LENGTH_SHORT);
                t.show();

                Intent intent = new Intent(MainActivity.this,CardioDetailActivity.class);
                intent.putExtra("position",i);
                startActivity(intent);
            }
        });

    }


}
