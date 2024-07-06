package com.example.careconnect;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;

public class DoctorDetailsActivity extends AppCompatActivity {
    private String [][] doctor_details1 =
            {
                    {"Doctor Name : Ajit Saste" , "Hospital Address : Pimpri" , "Exp : 5yrs" , "Mobile Number : 9898989898" , "600"},
                    {"Doctor Name : Prasad Pawar" , "Hospital Address : Nigdi" , "Exp : 15yrs" , "Mobile Number : 9098989898" , "900"},
                    {"Doctor Name : Swapnil Kale" , "Hospital Address : Pune" , "Exp : 8yrs" , "Mobile Number : 9808989898" , "650"},
                    {"Doctor Name : Deepak DeshMukh" , "Hospital Address : Chinchwad" , "Exp : 6yrs" , "Mobile Number : 9890989898" , "800"},
                    {"Doctor Name : Ashok Panda" , "Hospital Address : Katraj" , "Exp : 7yrs" , "Mobile Number : 9898089898" , "500"}
            };
    private String [][] doctor_details2 =
            {
                    {"Doctor Name : Neelam Saste" , "Hospital Address : Pimpri" , "Exp : 5yrs" , "Mobile Number : 9898989898" , "600"},
                    {"Doctor Name : Ajit Pawar" , "Hospital Address : Nigdi" , "Exp : 15yrs" , "Mobile Number : 9098989898" , "900"},
                    {"Doctor Name : Deepak Kale" , "Hospital Address : Pune" , "Exp : 8yrs" , "Mobile Number : 9808989898" , "650"},
                    {"Doctor Name : Ritesh DeshMukh" , "Hospital Address : Chinchwad" , "Exp : 6yrs" , "Mobile Number : 9890989898" , "800"},
                    {"Doctor Name : Prasad Panda" , "Hospital Address : Katraj" , "Exp : 7yrs" , "Mobile Number : 9898089898" , "500"}
            };
    private String [][] doctor_details3 =
            {
                    {"Doctor Name : Prasad Saste" , "Hospital Address : Pimpri" , "Exp : 5yrs" , "Mobile Number : 9898989898" , "600"},
                    {"Doctor Name : Deepak Pawar" , "Hospital Address : Nigdi" , "Exp : 15yrs" , "Mobile Number : 9098989898" , "900"},
                    {"Doctor Name : Ashok Kale" , "Hospital Address : Pune" , "Exp : 8yrs" , "Mobile Number : 9808989898" , "650"},
                    {"Doctor Name : Swapnil DeshMukh" , "Hospital Address : Chinchwad" , "Exp : 6yrs" , "Mobile Number : 9890989898" , "800"},
                    {"Doctor Name : Ritesh Panda" , "Hospital Address : Katraj" , "Exp : 7yrs" , "Mobile Number : 9898089898" , "500"}
            };
    private String [][] doctor_details4 =
            {
                    {"Doctor Name : Ashok Saste" , "Hospital Address : Pimpri" , "Exp : 5yrs" , "Mobile Number : 9898989898" , "600"},
                    {"Doctor Name : Prasad Pawar" , "Hospital Address : Nigdi" , "Exp : 15yrs" , "Mobile Number : 9098989898" , "900"},
                    {"Doctor Name : Jay Kale" , "Hospital Address : Pune" , "Exp : 8yrs" , "Mobile Number : 9808989898" , "650"},
                    {"Doctor Name : Reitesh DeshMukh" , "Hospital Address : Chinchwad" , "Exp : 6yrs" , "Mobile Number : 9890989898" , "800"},
                    {"Doctor Name : Ajit Panda" , "Hospital Address : Katraj" , "Exp : 7yrs" , "Mobile Number : 9898089898" , "500"}
            };
    private String [][] doctor_details5 =
            {
                    {"Doctor Name : Deepak Saste" , "Hospital Address : Pimpri" , "Exp : 5yrs" , "Mobile Number : 9898989898" , "600"},
                    {"Doctor Name : Swapnil Pawar" , "Hospital Address : Nigdi" , "Exp : 15yrs" , "Mobile Number : 9098989898" , "900"},
                    {"Doctor Name : Pawar Kale" , "Hospital Address : Pune" , "Exp : 8yrs" , "Mobile Number : 9808989898" , "650"},
                    {"Doctor Name : Ajit DeshMukh" , "Hospital Address : Chinchwad" , "Exp : 6yrs" , "Mobile Number : 9890989898" , "800"},
                    {"Doctor Name : Neelam Panda" , "Hospital Address : Katraj" , "Exp : 7yrs" , "Mobile Number : 9898089898" , "500"}
            };
    TextView tv;
    Button btn;
    String [][] doctor_details = {};
    HashMap<String  , String> item;
    ArrayList list;
    SimpleAdapter sa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_details);

        tv=  findViewById(R.id.textViewCartTitle);
        btn = findViewById(R.id.buttonDDBack);

        Intent it = getIntent();
        String title = it.getStringExtra("title");
        tv.setText(title);
        if(title.compareTo("Family Physicians") == 0){
            doctor_details = doctor_details1;
        }
        else if(title.compareTo("Dieticians") == 0){
            doctor_details = doctor_details2;
        }
        else if(title.compareTo("Dentist") == 0){
            doctor_details = doctor_details3;
        }
        else if(title.compareTo("Surgeon") == 0){
            doctor_details = doctor_details4;
        }
        else{
            doctor_details = doctor_details5;
        }

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DoctorDetailsActivity.this , FindDoctorActivity.class));
            }
        });

        list = new ArrayList();
        for(int i=0;i<doctor_details.length; i++){
            item = new HashMap<>();
            item.put("line1" , doctor_details[i][0]);
            item.put("line2" , doctor_details[i][1]);
            item.put("line3" , doctor_details[i][2]);
            item.put("line4" , doctor_details[i][3]);
            item.put("line5" , " Cons Fees" + doctor_details[i][4] + "/-");
            list.add(item);
        }
        sa = new SimpleAdapter(this , list,
                R.layout.multi_lines ,
                new String [] {"line1","line2","line3","line4","line5"} ,
                new int [] {R.id.line_a , R.id.line_b , R.id.line_c , R.id.line_d , R.id.line_e});

        ListView lst = findViewById(R.id.listViewDD);
        lst.setAdapter(sa);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it = new Intent(DoctorDetailsActivity.this , BookAppointmentActivity.class);
                it.putExtra("text1" , title);
                it.putExtra("text2" , doctor_details[i][0]);
                it.putExtra("text3" , doctor_details[i][1]);
                it.putExtra("text4" , doctor_details[i][3]);
                it.putExtra("text5" , doctor_details[i][4]);
                startActivity(it);
            }
        });
    }
}