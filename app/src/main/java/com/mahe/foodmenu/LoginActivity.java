package com.mahe.foodmenu;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    EditText Username, Password;
    Button Login;
    CheckBox RememberMe;
    TextView ForgetPassword;
    RelativeLayout Container;

    String TAG = "LoginActivity";

    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);

        Log.i(TAG,"onCreate");

        sharedPreferences = getSharedPreferences("Userinfo", Context.MODE_PRIVATE);

        Username = findViewById(R.id.username);
        Password = findViewById(R.id.password);
        Login = findViewById(R.id.login);
        RememberMe = findViewById(R.id.rememberme);
        ForgetPassword = findViewById(R.id.forgetpassword);
        Container = findViewById(R.id.container);

        Login.setOnClickListener(view -> {
            if(RegisterActivity.isFieldEmpty(Username) && RegisterActivity.isFieldEmpty(Password)) {
                String UsernameValue = Username.getText().toString();
                String PasswordValue = Password.getText().toString();
                changeBackgroundcolor();
                String RegisteredUsername = sharedPreferences.getString("username", "");
                String RegisteredPassword = sharedPreferences.getString("password", "");
                if (UsernameValue.equals(RegisteredUsername) && PasswordValue.equals(RegisteredPassword)) {
                    Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                    startActivity(intent);
                    Toast.makeText(LoginActivity.this, UsernameValue + "Login Success", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(LoginActivity.this, UsernameValue + "Login Failure", Toast.LENGTH_SHORT).show();
                }


                Log.i(TAG, UsernameValue + ":" + PasswordValue);
            }

        });
    }

    int i = 0;

    public void changeBackgroundcolor() {
        int[] colors = new int[]{R.color.primary, R.color.barunred, R.color.purple_200};
        Container.setBackgroundColor(getResources().getColor(colors[i % colors.length]));
        i++;
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG,"onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG,"onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG,"onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG,"onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG,"onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG,"onDestroy");
    }
}