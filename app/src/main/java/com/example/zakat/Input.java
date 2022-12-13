package com.example.zakat;


import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Input extends AppCompatActivity {

    private EditText etGW, etCV;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        setContentView(R.layout.input);
        etGW = findViewById(R.id.gWeight);
        etCV = findViewById(R.id.cGoldValue);

        findViewById(R.id.btnKEEP).setOnClickListener(view -> {
            calculate(true);
        });

        findViewById(R.id.btnWEAR).setOnClickListener(view -> {
            calculate(false);
        });
    }
    private void calculate (boolean keep){
        float sub = 200;
        float weight = 0, currentGold = 0;
        try{
            weight = Float.parseFloat(etGW.getText().toString());
            currentGold = Float.parseFloat(etCV.getText().toString());
        }catch (Exception e){
            Toast.makeText(this, String.format("error: %s", e.getMessage()), Toast.LENGTH_SHORT).show();
        }

        if (keep){
            sub = 85;
        }
        float amount = weight - sub;
        if (amount < 0)amount=0;
        float zakatPayable = amount * currentGold;
        float zakat = zakatPayable * 0.025f;
        Intent intent = new Intent(this, Output.class);
        intent.putExtra("TOTALGOLDVALUE(RM)",String.format("%.2f",weight*currentGold));
        intent.putExtra("TOTALZAKATPAYABLE(RM)",String.format("%.2f",zakatPayable));
        intent.putExtra("TOTALZAKAT(RM)",String.format("%.2f",zakat));

        startActivity(intent);
    }

}
