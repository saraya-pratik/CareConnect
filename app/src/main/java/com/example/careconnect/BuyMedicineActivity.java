package com.example.careconnect;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;

public class BuyMedicineActivity extends AppCompatActivity {
    private String [][] packages ={
        {"Uprise-D3 1000IU Capsule" , "", "" ,"", "750"},
            {"HealthVIT Chromium Capsule" , "", "" ,"", "550"},
            {"Vitamin B-Com Capsule" , "", "" ,"", "650"},
            {"Crocin Capsule" , "", "" ,"", "450"},
            {"Strepsils Capsule" , "", "" ,"", "950"},
            {"Feronia Capsule" , "", "" ,"", "50"}
    };
    private String [] package_details ={
            "Maiintains Teeth and Bones Strong\n" ,
                    "Insulin Regulator\n" ,
            "RBCs formation\n" ,
            "Releives Headache\n" ,
            "Helps in Throat Infection\n" ,
            "Reduces Iron deficiency"
    };
    HashMap<String , String> item;
    ArrayList list;
    SimpleAdapter sa;
    ListView lst;
    Button btnBack , btnGotocart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_medicine);

        lst = findViewById(R.id.listViewBD);
        btnBack = findViewById(R.id.buttonBDBack);
        btnGotocart = findViewById(R.id.buttonBDGotoCart);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(BuyMedicineActivity.this , HomeActivity.class));
            }
        });

        btnGotocart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(BuyMedicineActivity.this , CartBuyMedicineActivity.class));
            }
        });

        list = new ArrayList();
        for(int i=0;i<packages.length;i++){
            item = new HashMap<>();
            item.put("line1" , packages[i][0]);
            item.put("line2" , packages[i][1]);
            item.put("line3" , packages[i][2]);
            item.put("line4" , packages[i][3]);
            item.put("line5" , "Total Cost" + packages[i][4] + "/-") ;
            list.add(item);
        }

        sa = new SimpleAdapter(this , list,
                R.layout.multi_lines ,
                new String [] {"line1","line2","line3","line4","line5"} ,
                new int [] {R.id.line_a , R.id.line_b , R.id.line_c , R.id.line_d , R.id.line_e});

        lst.setAdapter(sa);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i , long l){
                Intent it = new Intent(BuyMedicineActivity.this , BuyMedicineDetailsActivity.class);
                it.putExtra("price" , packages[i][0]);
                it.putExtra("date" , package_details[i]);
                it.putExtra("time" , packages[i][4]);
                startActivity(it);
            }
        });
    }
}