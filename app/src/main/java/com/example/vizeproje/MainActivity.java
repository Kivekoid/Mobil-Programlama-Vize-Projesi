package com.example.vizeproje;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView txtNo;
    TextView txtIsim;
    Button btnSms;
    Button btnConvertor;
    Button btnRandom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtNo=findViewById(R.id.txt_No);
        txtIsim=findViewById(R.id.txt_Isim);
        btnSms=findViewById(R.id.btn_sms);
        btnConvertor=findViewById(R.id.btn_convertor);
        btnRandom=findViewById(R.id.btn_random);

        btnConvertor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, ConvertorActivity.class);
                startActivity(i);
            }
        });
        btnRandom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i2 = new Intent(MainActivity.this, RandomGeneratorActivity.class);
                startActivity(i2);
            }
        });
        btnSms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i3 = new Intent(MainActivity.this, SmsActivity.class);
                startActivity(i3);
            }
        });
    }
}