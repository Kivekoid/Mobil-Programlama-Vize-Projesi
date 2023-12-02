package com.example.vizeproje;

import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;


import java.util.Random;

public class RandomGeneratorActivity extends AppCompatActivity {


    private LinearLayout progressBarContainer;
    private Button generateButton;
    private EditText adetEditText, minEditText, maxEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_random_generator);

        progressBarContainer = findViewById(R.id.progressBarContainer);
        generateButton = findViewById(R.id.generateButton);
        adetEditText = findViewById(R.id.adetEditText);
        minEditText = findViewById(R.id.minEditText);
        maxEditText = findViewById(R.id.maxEditText);

        generateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                generateProgressBars();
            }
        });
    }

    private void generateProgressBars() {
        progressBarContainer.removeAllViews(); // Mevcut progress barları temizler

        try {
            // Kullanıcının girdiği değerleri alır
            int adet = Integer.parseInt(adetEditText.getText().toString());
            int min = Integer.parseInt(minEditText.getText().toString());
            int max = Integer.parseInt(maxEditText.getText().toString());

            // Rastgele sayıları üretir
            Random random = new Random();

            for (int i = 0; i < adet; i++) {
                // Rastgele değeri üretir
                int randomValue = random.nextInt((max - min) + 1) + min;

                // Progress bar oluşturur
                ProgressBar progressBar = new ProgressBar(this, null, android.R.attr.progressBarStyleHorizontal);
                progressBar.setLayoutParams(new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT));
                progressBar.setMax(max - min);
                progressBar.setProgress(randomValue - min);

                // TextView oluşturur
                TextView textView = new TextView(this);
                textView.setText(((randomValue - min) * 100) / (max - min) + "% (" + randomValue + ")");

                // LinearLayout oluşturur
                LinearLayout linearLayout = new LinearLayout(this);
                linearLayout.setOrientation(LinearLayout.VERTICAL);
                linearLayout.addView(progressBar);
                linearLayout.addView(textView);

                // Container'a ekler
                progressBarContainer.addView(linearLayout);
            }
        } catch (NumberFormatException e) {
            // Sayısal bir değer girilmediğinde kullanıcıya uyarı verdirir
            Toast.makeText(this, "Lütfen geçerli sayısal değerler girin.", Toast.LENGTH_SHORT).show();
        }
    }
}