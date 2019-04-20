package com.mirzakhalov.teamup;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends AppCompatActivity {


    EditText name;
    EditText phoneNumber;
    EditText birthday;
    EditText username;
    EditText password;

    Button register;

    public static String REGISTER_USER = "INSERT ";

    public static String CREATE_TABLE = "CREATE TABLE Users" +
            "(" +
            "    UserID INT IDENTITY PRIMARY KEY," +
            "    Name VARCHAR(100) NOT NULL," +
            "    DOB DATETIME NOT NULL," +
            "    Phone VARCHAR(10)," +
            "    Username VARCHAR(150)," +
            "    Password VARCHAR(150)" +
            ")";

    SQLiteDatabase db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);



        name = findViewById(R.id.name);
        phoneNumber = findViewById(R.id.phone);
        birthday = findViewById(R.id.birthday);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);

        register = findViewById(R.id.register);

        final SQLiteHelper database = new SQLiteHelper(this);


        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                database.register(username.getText().toString(), name.getText().toString(), birthday.getText().toString(), phoneNumber.getText().toString(), password.getText().toString());

            }
        });

    }
}
