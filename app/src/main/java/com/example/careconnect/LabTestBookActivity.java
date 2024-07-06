package com.example.careconnect;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LabTestBookActivity extends AppCompatActivity {

    EditText edname , edaddress, edcontact, edpincode;
    Button btnBook;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_test_book);

        edname = findViewById(R.id.editTextBookFullName);
        edaddress = findViewById(R.id.editTextBookAddress);
        edcontact = findViewById(R.id.editTextBookContact);
        edpincode = findViewById(R.id.editTextBookPin);
        btnBook = findViewById(R.id.buttonBook);

        Intent it= getIntent();
        String [] price = it.getStringExtra("price").toString().split(java.util.regex.Pattern.quote(":"));
        String date = it.getStringExtra("date");
        String time = it.getStringExtra("time");

        btnBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedpreferences = getSharedPreferences("shared_prefs" , Context.MODE_PRIVATE);
                String username = sharedpreferences.getString("username" , "").toString();

                Database db = new Database(getApplicationContext() , "CareConnect" , null , 1);
                db.addOrder(username , edname.getText().toString() , edaddress.getText().toString() , edcontact.getText().toString() , Integer.parseInt(edpincode.getText().toString()) , date.toString() , time.toString() , Float.parseFloat(price[1].toString()), "lab");
                db.removeCart(username , "lab");
                Toast.makeText(getApplicationContext() , "Your booking is done successfully" , Toast.LENGTH_LONG).show();
                startActivity(new Intent(LabTestBookActivity.this , HomeActivity.class));
            }
        });
    }
}