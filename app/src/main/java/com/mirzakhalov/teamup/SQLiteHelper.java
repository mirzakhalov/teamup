package com.mirzakhalov.teamup;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

public class SQLiteHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "teamup_database";

    public SQLiteHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(Register.CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + "Users");

        onCreate(sqLiteDatabase);
    }


    public void register(String username, String name, String dob, String phoneNumber, String password){
        SQLiteDatabase db = this.getWritableDatabase();

        try {
     //       String sql =
     //               "INSERT or replace INTO Users (Username, Name, DOB, Phone, Password) VALUES(" + username + "," + name + "," + dob + "," + phoneNumber + "," + password + ")";

           // String sql = "INSERT or replace INTO Users (Username, Name, DOB, Phone, Password) VALUES(\" + username + \",\" + name + \",\" + dob + \",\" +"
            ContentValues contentValues = new ContentValues();
            contentValues.put("Username", username);
            contentValues.put("Name", name);
            contentValues.put("DOB", dob);
            contentValues.put("Phone", phoneNumber);
            contentValues.put("Password", password);
            long result = db.insert("Users", null, contentValues);
            Log.d("Result", String.valueOf(result));
        }
        catch (Exception e) {
            e.printStackTrace();

        }

    }

    public String login(String username, String password){

        SQLiteDatabase db = this.getReadableDatabase();
        StringBuffer info = new StringBuffer();
        try {
            String sql =
                    "SELECT * FROM Users" ;
            Cursor res = db.rawQuery(sql,null);

            while (res.moveToNext()){
                info.append(res.getString(1));
                info.append(res.getString(2));
                info.append(res.getString(3));
                info.append("\n");
            }

        }
        catch (Exception e) {
           e.printStackTrace();

        }

        return info.toString();

    }
}