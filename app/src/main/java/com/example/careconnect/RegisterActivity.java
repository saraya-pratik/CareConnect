package com.example.careconnect;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {

    EditText edUsername, edEmail, edPassword, edConfirm;
    Button btn;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        edUsername = findViewById(R.id.editTextRegUserName);
        edEmail = findViewById(R.id.editTextRegEmail);
        edPassword = findViewById(R.id.editTextRegPassword);
        edConfirm = findViewById(R.id.editTextRegConfirmPassword);
        btn = findViewById(R.id.buttonRegister);
        tv = findViewById(R.id.textViewExistingUser);

        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RegisterActivity.this , LoginActivity.class));
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = edUsername.getText().toString();
                String email = edEmail.getText().toString();
                String password = edPassword.getText().toString();
                String confirm = edConfirm.getText().toString();
                Database db = new Database(getApplicationContext() , "Care Connect" , null , 1);
                if(username.length() == 0 || password.length() == 0|| email.length() == 0 || confirm.length() == 0){
                    Toast.makeText(getApplicationContext(), "Please fill all details!", Toast.LENGTH_SHORT).show();
                }
                else{
                    if(password.compareTo(confirm) == 0){
                        if(isValid(password)){
                            db.register(username ,email, password);
                            Toast.makeText(getApplicationContext(), "Successfully Registered", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(RegisterActivity.this , LoginActivity.class));
                        }
                        else{
                            Toast.makeText(getApplicationContext() , "Password must contains letters, numbers, special charcters and should be 8 characters long!", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else{
                        Toast.makeText(getApplicationContext(), "Password does not match with confirm password!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
    public static boolean isValid(String password){
        int f1 = 0 , f2 = 0 , f3 = 0;
        if(password.length() < 8){
            return false;
        }
        else{
            for(int p=0; p<password.length();p++){
                char ch = password.charAt(p);
                if(Character.isLetter(ch)){
                    f1++;
                }
                else if(Character.isDigit(ch)){
                    f2++;
                }
                else if(ch >= 33 && ch <= 46 || ch == 64){
                    f3++;
                }
            }
        }
        if(f1 > 0 && f2 > 0 && f3 > 0){
            return true;
        }
        return false;
    }
}