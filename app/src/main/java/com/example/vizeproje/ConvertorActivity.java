package com.example.vizeproje;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Spinner;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import java.util.ArrayList;

public class ConvertorActivity extends AppCompatActivity {
    TextView txtConvertor;
    TextView txtDecimal;
    TextView txtMegabyte;
    TextView txtCelsius;
    EditText editTextDecimalNumber;
    EditText editTextMegabyte;
    EditText editTextCelsius;
    Button convertButton1;
    Button convertButton2;
    Button convertButton3;
    TextView resultTextView;
    TextView resultTextView2;
    TextView resultTextView3;
    Spinner spinnerNumber;
    Spinner spinnerMegabyte;
    Spinner spinnerCelsius;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_convertor);
        txtConvertor=findViewById(R.id.txt_Convertor);
        txtDecimal=findViewById(R.id.txt_decimal);
        txtMegabyte=findViewById(R.id.txt_megabyte);
        convertButton1=findViewById(R.id.btn_convert1);
        convertButton2=findViewById(R.id.btn_convert2);
        convertButton3=findViewById(R.id.btn_convert3);
        editTextDecimalNumber=findViewById(R.id.editTextNumber_Decimal);
        editTextMegabyte=findViewById(R.id.editTextNumber_Megabyte);
        editTextCelsius=findViewById(R.id.editTextNumber_celsius);
        resultTextView=findViewById(R.id.txt_result);
        resultTextView2=findViewById(R.id.txt_result2);
        resultTextView3=findViewById(R.id.txt_result3);

        spinnerNumber=findViewById(R.id.spinner_Number);
        spinnerMegabyte=findViewById(R.id.spinner_Number2);
        spinnerCelsius=findViewById(R.id.spinner_celsius);
//Celsius
        ArrayList<String> options3 = new ArrayList<>();
        options3.add("Fahrenheit");
        options3.add("Kelvin");
        ArrayAdapter<String> adapter1 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, options3);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCelsius.setAdapter(adapter1);
        spinnerCelsius.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {

                String selectedOption = parentView.getItemAtPosition(position).toString();
                Toast.makeText(ConvertorActivity.this, "Seçildi: " + selectedOption, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {

                Toast.makeText(ConvertorActivity.this, "Hiçbir şey seçilmedi", Toast.LENGTH_SHORT).show();
            }
        });
//Megabyte
        ArrayList<String> options2 = new ArrayList<>();
        options2.add("Kilobyte");
        options2.add("Byte");
        options2.add("Kibibyte");
        options2.add("Bit");
        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, options2);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerMegabyte.setAdapter(adapter2);
        spinnerMegabyte.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {

                String selectedOption = parentView.getItemAtPosition(position).toString();
                Toast.makeText(ConvertorActivity.this, "Seçildi: " + selectedOption, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {

                Toast.makeText(ConvertorActivity.this, "Hiçbir şey seçilmedi", Toast.LENGTH_SHORT).show();
            }
        });
//Number
        ArrayList<String> options = new ArrayList<>();
        options.add("İkilik");
        options.add("Sekizlik");
        options.add("Onaltılık");
        ArrayAdapter<String> adapter3 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, options);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerNumber.setAdapter(adapter3);

        spinnerNumber.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {

                String selectedOption = parentView.getItemAtPosition(position).toString();
                Toast.makeText(ConvertorActivity.this, "Seçildi: " + selectedOption, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {

                Toast.makeText(ConvertorActivity.this, "Hiçbir şey seçilmedi", Toast.LENGTH_SHORT).show();
            }
        });
//--------------------Butonlar
        // Convert button click eventi
        convertButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                convertNumber();
            }
        });
        convertButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                convertMegabyte();
            }
        });
        convertButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                convertCelsius();
            }
        });
    }
    private void convertMegabyte() {
        String megabyteStr = editTextMegabyte.getText().toString();
        if (!megabyteStr.isEmpty()) {
            double megabyte = Double.parseDouble(megabyteStr);
            double convertedValue = 0;

            // Seçilen dönüşüm türüne göre değeri dönüştürür
            String selectedOption = spinnerMegabyte.getSelectedItem().toString();
            switch (selectedOption) {
                case "Kilobyte":
                    convertedValue = megabyte * 1024;
                    break;
                case "Byte":
                    convertedValue = megabyte * 1024 * 1024;
                    break;
                case "Kibibyte":
                    convertedValue = megabyte * 1024 / 1.024;
                    break;
                case "Bit":
                    convertedValue = megabyte * 1024 * 1024 * 8;
                    break;
            }

            String result = String.format("%s: %.2f", selectedOption, convertedValue);
            resultTextView2.setText(result);
        } else {
            Toast.makeText(ConvertorActivity.this, "Megabyte değeri girin", Toast.LENGTH_SHORT).show();
        }

    }
    private void convertNumber() {
        String decimalStr = editTextDecimalNumber.getText().toString();
        if (!decimalStr.isEmpty()) {
            int decimalNumber = Integer.parseInt(decimalStr);

            // Seçilen dönüşüm türüne göre sayıyı dönüştürür ve sonucu gösterir
            String selectedOption = spinnerNumber.getSelectedItem().toString();
            String result;

            switch (selectedOption) {
                case "İkilik":
                    result = Integer.toBinaryString(decimalNumber);
                    break;
                case "Sekizlik":
                    result = Integer.toOctalString(decimalNumber);
                    break;
                case "Onaltılık":
                    result = Integer.toHexString(decimalNumber);
                    break;
                default:
                    result = "Geçersiz Seçenek";
            }
            String RealResult = String.format("%s: %s", selectedOption, result);
            resultTextView.setText(RealResult);

            Toast.makeText(ConvertorActivity.this, "Dönüştürülmüş Sonuç: " + result, Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(ConvertorActivity.this, "Bir onluk tabanlı sayı girin", Toast.LENGTH_SHORT).show();
        }


    }
    private void convertCelsius(){
        String celsiusString = editTextCelsius.getText().toString();

        if (!celsiusString.isEmpty()) {
            double celsius = Double.parseDouble(celsiusString);

            // Seçilen birimlere göre dönüşüm yapar
            String selectedUnit = spinnerCelsius.getSelectedItem().toString();
            double result;

            if (selectedUnit.equals("Fahrenheit")) {
                result = (celsius * 9 / 5) + 32;
            } else { // Kelvin
                result = celsius + 273.15;
            }

            String resultText = String.format("%s: %.2f", selectedUnit, result);
            resultTextView3.setText(resultText);
            Toast.makeText(ConvertorActivity.this, "Dönüştürülmüş Sonuç: " + resultText, Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(ConvertorActivity.this, "Lütfen geçerli bir sıcaklık değeri girin", Toast.LENGTH_SHORT).show();
        }}


}