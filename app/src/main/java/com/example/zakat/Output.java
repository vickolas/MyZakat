package com.example.zakat;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class Output extends AppCompatActivity {
    private EditText etTG, etZP, etZ;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();

        setContentView(R.layout.output);

        etTG = findViewById(R.id.editTGV);
        etTG.setText(intent.getStringExtra("TOTALGOLDVALUE(RM)"));
        etZP = findViewById(R.id.editTZP);
        etZP.setText(intent.getStringExtra("TOTALZAKATPAYABLE(RM)"));
        etZ = findViewById(R.id.editTZ);
        etZ.setText(intent.getStringExtra("TOTALZAKAT(RM)"));

    }
}
