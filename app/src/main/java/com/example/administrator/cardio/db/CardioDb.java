package com.example.administrator.cardio.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.administrator.cardio.R;

/**
 * Created by Administrator on 10/12/2560.
 */

public class CardioDb extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "cardio.db";
    private static final int DATABASE_VERSION = 90;

    public static final String TABLE_NAME = "phone_number";
    public static final String COL_ID = "_id";
    public static final String COL_TITLE = "title";
    public static final String COL_PICTURE= "picture";
    public static final String COL_DETAIL= "detail";

    private static final String CREATE_TABLE = " CREATE TABLE " + TABLE_NAME + "("
            + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COL_TITLE + " TEXT, "
            + COL_PICTURE + " TEXT, "
            + COL_DETAIL + " TEXT)";

    private Context mContext;

    public CardioDb(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        mContext  = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
        insertInitialData(db);
    }

    private void insertInitialData(SQLiteDatabase db) {
        ContentValues cv = new ContentValues();
        cv.put(COL_TITLE, "Butt Kick");
        cv.put(COL_PICTURE, "buttkick.jpg");

        cv.put(COL_DETAIL, mContext.getString(R.string.details_buttkick));
        db.insert(TABLE_NAME, null, cv);

        cv = new ContentValues();
        cv.put(COL_TITLE, "Mountain Climber");
        cv.put(COL_PICTURE, "mountain_climbers.jpg");
        cv.put(COL_DETAIL, mContext.getString(R.string.details_mountain_climber));
        db.insert(TABLE_NAME, null, cv);

        cv = new ContentValues();
        cv.put(COL_TITLE, "Jump Squat");
        cv.put(COL_PICTURE, "Jump Squat.jpg");
         cv.put(COL_DETAIL, mContext.getString(R.string.details_jumpsquat));
        db.insert(TABLE_NAME, null, cv);

        cv = new ContentValues();
        cv.put(COL_TITLE, "High Knee");
        cv.put(COL_PICTURE, "high knee.jpg");
         cv.put(COL_DETAIL, mContext.getString(R.string.details_hignknee));
        db.insert(TABLE_NAME, null, cv);

        cv = new ContentValues();
        cv.put(COL_TITLE, "Power Skip");
        cv.put(COL_PICTURE, "power skip.jpg");
        cv.put(COL_DETAIL, mContext.getString(R.string.details_powerskip));
        db.insert(TABLE_NAME, null, cv);

        cv = new ContentValues();
        cv.put(COL_TITLE, "Jumping Jacks");
        cv.put(COL_PICTURE, "jumping jacks.jpg");
        cv.put(COL_DETAIL, mContext.getString(R.string.details_jumpingjacks));
        db.insert(TABLE_NAME, null, cv);

        cv = new ContentValues();
        cv.put(COL_TITLE, "Tabata Crunch");
        cv.put(COL_PICTURE, "tabata crunch.jpg");
        cv.put(COL_DETAIL, mContext.getString(R.string.details_tabata_chunch));
        db.insert(TABLE_NAME, null, cv);

        cv = new ContentValues();
        cv.put(COL_TITLE, "Sprinter Sit-up");
        cv.put(COL_PICTURE, "sprinter sit-up.jpg");
        cv.put(COL_DETAIL, mContext.getString(R.string.details_sprinter_situp));
        db.insert(TABLE_NAME, null, cv);

        cv = new ContentValues();
        cv.put(COL_TITLE, "Push-up Burpee");
        cv.put(COL_PICTURE, "Push-Up Burpee.jpg");
        cv.put(COL_DETAIL, mContext.getString(R.string.details_pushupburpee));
        db.insert(TABLE_NAME, null, cv);

        cv = new ContentValues();
        cv.put(COL_TITLE, "Basic Burpee");
        cv.put(COL_PICTURE, "Basic burpee.jpg");
         cv.put(COL_DETAIL, mContext.getString(R.string.details_bacsicburpee));
        db.insert(TABLE_NAME, null, cv);

        cv = new ContentValues();
        cv.put(COL_TITLE, "Lunge Jump");
        cv.put(COL_PICTURE, "Lunge Jump.jpg");
        cv.put(COL_DETAIL, mContext.getString(R.string.details_lungejump));
        db.insert(TABLE_NAME, null, cv);

        cv = new ContentValues();
        cv.put(COL_TITLE, "Front Kicks");
        cv.put(COL_PICTURE, "front kicks.jpg");
         cv.put(COL_DETAIL, mContext.getString(R.string.details_frontkick));
        db.insert(TABLE_NAME, null, cv);

        cv = new ContentValues();
        cv.put(COL_TITLE, "Skaters");
        cv.put(COL_PICTURE, "Skaters.jpg");
         cv.put(COL_DETAIL, mContext.getString(R.string.details_skaters));
        db.insert(TABLE_NAME, null, cv);

        cv = new ContentValues();
        cv.put(COL_TITLE, "Plank Side-Jumps");
        cv.put(COL_PICTURE, "Plank Side-Jumps.jpg");
         cv.put(COL_DETAIL, mContext.getString(R.string.details_planksidejummps));
        db.insert(TABLE_NAME, null, cv);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int il) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME );
        onCreate(db);

    }
}
