//database for adding data
//to add the data do findViewById(R.id.user_id)
//from notes
package com.example.study;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;


public class localDatabase extends SQLiteOpenHelper {

    private Context context;
    private static final String DATABASE_NAME = "UserCondition.db";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_NAME = "user_condition";
    private static final String COLUMN_ID = "user_id";
    private static final String Date = "date";
    private static final String Stress_Level = "stress level";
    private static final String Temperature = "temperature";
    private static final String Heart_Rate = "Heart Rate";
    private static final String timestamp = "Timestamp";
    private static final String eda= "eda";

    //constructor
    localDatabase(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    //methods
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        //creates the user condition table
        String query = "CREATE TABLE " + TABLE_NAME +
                " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                Stress_Level + "INTEGER, " +
                Date + " TEXT, " +
                Temperature + "INTEGER, " +
                timestamp + " INTEGER, " +
                eda + " INTEGER, " +
                Heart_Rate + "INTEGER);";
        sqLiteDatabase.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(sqLiteDatabase);
    }


    //dummy data for now
    void addData(String userIDString, String DateOfOccur, int timestamp, int stressLevel, int eda, int Temperature, int HeartRate){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(Date, DateOfOccur);
        cv.put(String.valueOf(timestamp), timestamp);
        cv.put(Stress_Level, stressLevel);
        cv.put(Heart_Rate, HeartRate);
        cv.put(String.valueOf(eda), eda);
        cv.put(String.valueOf(Temperature), Temperature);

        //values that we imported is added to database
        long result = sqLiteDatabase.insert(TABLE_NAME,null, cv);

        if(result == -1){ //failed to insert the data
            Toast.makeText(context, "Failed to add data", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(context, "Added data successfully!", Toast.LENGTH_SHORT).show();
        }
    }

    //updates row
    void updateData(String userID, String DateOfOccur, int stressLevel, int eda, int HeartRate){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(Date, DateOfOccur);
        cv.put(Temperature, Temperature);
        cv.put(Stress_Level, stressLevel);
        cv.put(String.valueOf(eda), eda);
        cv.put(Heart_Rate, HeartRate);

        //values that we imported is added to database
        long result = sqLiteDatabase.update(TABLE_NAME, cv, "userID=?",  new String[]{userID});

        if(result == -1){ //failed to insert the data
            Toast.makeText(context, "Failed to add data", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(context, "Added data successfully!", Toast.LENGTH_SHORT).show();
        }
    }

    //going to be called when user closes the app
    void deleteAllData(){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        sqLiteDatabase.execSQL("DELETE FROM " + TABLE_NAME);
    }
}



