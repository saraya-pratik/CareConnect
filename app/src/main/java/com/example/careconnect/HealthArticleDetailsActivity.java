package com.example.careconnect;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class HealthArticleDetailsActivity extends AppCompatActivity {


    TextView tv;
    ImageView img;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_article_details);

        tv = findViewById(R.id.textViewHADTitle);
        img = findViewById(R.id.imageView);
        btn = findViewById(R.id.buttonHADBack);

        Intent it= new Intent();
        tv.setText(it.getStringExtra("text1"));

        Bundle b = getIntent().getExtras();
        if(b != null){
            int resId = b.getInt("text2");
            img.setImageResource(resId);
        }

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HealthArticleDetailsActivity.this , HealthArticleActivity.class));
            }
        });
    }
}