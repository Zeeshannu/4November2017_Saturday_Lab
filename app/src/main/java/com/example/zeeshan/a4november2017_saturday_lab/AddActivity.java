package com.example.zeeshan.a4november2017_saturday_lab;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddActivity extends AppCompatActivity {

    String author,readingstatus,title;
    DBHelper dbHelper;

    private EditText mETName;
    private EditText mETAuthor;
    private EditText mETStatus;
    private Button mBTNSubmit;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

            mETName = (EditText) findViewById(R.id.ETName);
            mETAuthor = (EditText) findViewById(R.id.ETAuthor);
            mETStatus = (EditText) findViewById(R.id.ETStatus);
            mBTNSubmit = (Button) findViewById(R.id.BTNSubmit);

    }

    @Override
    protected void onStart() {
        super.onStart();
    dbHelper=new DBHelper(this);
    }
    public  void insert_mybooks(View view){
        author=mETAuthor.getText().toString();
        title=mETName.getText().toString();
        readingstatus=mETStatus.getText().toString();
        dbHelper.insetBookInDB(title,author,readingstatus);
        Toast.makeText(this, "Book Added", Toast.LENGTH_SHORT).show();
    }

}
