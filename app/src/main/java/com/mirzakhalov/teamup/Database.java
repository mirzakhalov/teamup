package com.mirzakhalov.teamup;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class Database extends AppCompatActivity {

    TextView info;

    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_database);

        info = findViewById(R.id.info);

        SQLiteHelper database = new SQLiteHelper(this);

        info.setText(database.login("", ""));

    }
}
