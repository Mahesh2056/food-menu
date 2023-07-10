package com.mahe.foodmenu;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Button Login,Register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Login=findViewById(R.id.login);
        Register=findViewById(R.id.register);

        Login.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this,LoginActivity.class);
            startActivity(intent);

        });
        Register.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this,RegisterActivity.class);
            startActivity(intent);

        });


    }
}