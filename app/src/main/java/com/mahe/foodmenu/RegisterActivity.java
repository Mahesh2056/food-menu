package com.mahe.foodmenu;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Patterns;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {
    EditText Username, Email, Address, Phone_no, Dob, Password, ConfirmPassword;
    RadioGroup Gender;
    ImageView Image;
    Button Cancel, Register;

    SharedPreferences sharedPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_layout);

        sharedPreferences = getSharedPreferences("Userinfo", Context.MODE_PRIVATE);

        Username = findViewById(R.id.username);
        Email = findViewById(R.id.email);
        Address = findViewById(R.id.address);
        Phone_no = findViewById(R.id.phone);
        Dob = findViewById(R.id.dob);
        Password = findViewById(R.id.password);
        ConfirmPassword = findViewById(R.id.confirmpassword);
        Gender = findViewById(R.id.gender);
        Image = findViewById(R.id.image);
        Cancel = findViewById(R.id.cancel);
        Register = findViewById(R.id.register);

        Register.setOnClickListener(view -> {
            if (isFieldEmpty(Username) && isValidEmail(Email) && isFieldEmpty(Address) && isFieldEmpty(Phone_no)
                    && isFieldEmpty(Dob) && isFieldEmpty(Password) && isFieldEmpty(ConfirmPassword)) {

                String UsernameValue = Username.getText().toString();
                String EmailValue = Email.getText().toString();
                String AddressValue = Address.getText().toString();
                String Phone_noValue = Phone_no.getText().toString();
                String DobValue = Dob.getText().toString();
                RadioButton CheckedButton = findViewById(Gender.getCheckedRadioButtonId());
                String GenderValue = CheckedButton.getText().toString();
                String PasswordValue = Password.getText().toString();
                String ConfirmPasswordValue = ConfirmPassword.getText().toString();

                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("username", UsernameValue);
                editor.putString("email", EmailValue);
                editor.putString("address", AddressValue);
                editor.putString("Phone_no", Phone_noValue);
                editor.putString("dob", DobValue);
                editor.putString("gender", GenderValue);
                editor.putString("password", PasswordValue);
                editor.putString("Confirm-password", ConfirmPasswordValue);

                editor.apply();
                Toast.makeText(RegisterActivity.this, "User saved", Toast.LENGTH_SHORT).show();

            }

        });


    }

    //validation
    public static boolean isFieldEmpty(EditText editText) {
        String value = editText.getText().toString();
        if (value.length() > 0) {
            return true;
        } else {
            editText.setError("Enter value");
            return false;
        }
    }

    public boolean isValidEmail(EditText editText) {
        String value = editText.getText().toString();
        if (Patterns.EMAIL_ADDRESS.matcher(value).matches()) {
            return true;
        } else {
            editText.setError("Enter valid email");
            return false;
        }
    }
}