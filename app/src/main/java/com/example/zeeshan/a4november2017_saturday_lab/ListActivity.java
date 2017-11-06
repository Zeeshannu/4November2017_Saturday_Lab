package com.example.zeeshan.a4november2017_saturday_lab;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ListActivity extends AppCompatActivity {


    DBHelper dbHelper;
    Cursor cursor;
    String values;
    int cursor_int;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        mTVrecord = (TextView) findViewById(R.id.TVrecord);
        mBTNNext = (Button) findViewById(R.id.BTNNext);
        mBTNPrevious = (Button) findViewById(R.id.BTNPrevious);

    }


    private TextView mTVrecord;
    private Button mBTNNext;
    private Button mBTNPrevious;

    public void next(View view) {

        if(!cursor.isLast()){
            cursor.moveToNext();
            values=cursor.getString(1)+":"+cursor.getString(2)+":"+cursor.getString(3);
        mTVrecord.setText(values);
        }
        else
            Toast.makeText(this, "Last  Records ", Toast.LENGTH_SHORT).show();
        //if(cursor)


    }

    public void previous(View view) {
    }

    @Override
    protected void onStart() {
        super.onStart();
        dbHelper=new DBHelper(this);
        cursor=dbHelper.lisetRecord();

        if(cursor.moveToFirst()){
            values=cursor.getString(1)+":"+cursor.getString(2)+" : "+cursor.getString(3);
            mTVrecord.setText(values);
        }


    }
}
