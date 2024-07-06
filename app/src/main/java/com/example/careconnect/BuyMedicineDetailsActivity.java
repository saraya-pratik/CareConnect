package com.example.careconnect;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class BuyMedicineDetailsActivity extends AppCompatActivity {

    TextView tvPackageName , tvTotalCost;
    EditText edDetails;
    Button btnBack , btnAddtocart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_medicine_details);

        tvPackageName = findViewById(R.id.textViewBMPackageName);
        tvTotalCost = findViewById(R.id.textViewBMTotalCost);
        edDetails = findViewById(R.id.editTextBMMultiLine);
        edDetails.setKeyListener(null);
        btnBack = findViewById(R.id.buttonBMBack);
        btnAddtocart = findViewById(R.id.buttonBMAddtoCart);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(BuyMedicineDetailsActivity.this , BuyMedicineActivity.class));
            }
        });

        Intent it = getIntent();
        tvPackageName.setText(it.getStringExtra("price"));
        edDetails.setText(it.getStringExtra("date"));
        tvTotalCost.setText("Total Cost: "+ it.getStringExtra("time")+"/-");

        btnAddtocart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedpreferences = getSharedPreferences("shared_prefs" , Context.MODE_PRIVATE);
                String username = sharedpreferences.getString("username" , "").toString();
                String product = tvPackageName.getText().toString();
                float price = Float.parseFloat(it.getStringExtra("time").toString());
                Database db = new Database(getApplicationContext() , " CareConnect" , null , 1);

                if(db.checkCart(username , product) == 1){
                    Toast.makeText(getApplicationContext() , "Product Already Added", Toast.LENGTH_SHORT).show();
                }
                else{
                    db.addCart(username , product , price , "medicine");
                    Toast.makeText(getApplicationContext(), "Record Inserted to cart", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(BuyMedicineDetailsActivity.this , BuyMedicineActivity.class));
                }
            }
        });
    }
}