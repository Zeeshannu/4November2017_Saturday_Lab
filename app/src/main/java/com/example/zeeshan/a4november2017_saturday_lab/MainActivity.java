package com.example.zeeshan.a4november2017_saturday_lab;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void add_records(View view) {
        Toast.makeText(this, "THis is upfsted", Toast.LENGTH_SHORT).show();
        Intent intent=new Intent(getApplicationContext(),AddActivity.class);
        startActivity(intent);

    }
    public void ListRecords(View view) {
        Intent intent=new Intent(getApplicationContext(),ListActivity.class);
        startActivity(intent);
    }
}
