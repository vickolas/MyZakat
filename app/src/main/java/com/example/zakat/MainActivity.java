package com.example.zakat;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btnZ).setOnClickListener(view ->{
            Intent intent  = new Intent(this, Input.class);
            startActivity(intent);
                }
        );
    }


    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);

        return true;

    }

    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.about:

                //Toast.makeText(this, "This is about", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this,AboutActivity.class);
                startActivity(intent);
                break;

        }
    return super.onOptionsItemSelected(item);
    }

}