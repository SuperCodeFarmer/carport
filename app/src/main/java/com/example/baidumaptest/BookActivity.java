package com.example.baidumaptest;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class BookActivity extends AppCompatActivity {
    private EditText bookName;
    private EditText bookPhone;
    private EditText timeLong;
    private EditText bookNumber;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);
        //设置头布局为我的发布
        TextView title= (TextView) findViewById(R.id.title_text);
        title.setText("我的发布");

        SharedPreferences pref=getSharedPreferences("carportdata",MODE_PRIVATE);
        bookName= (EditText) findViewById(R.id.name);
        bookPhone= (EditText) findViewById(R.id.phone);
        timeLong= (EditText) findViewById(R.id.timelong);
        bookNumber= (EditText) findViewById(R.id.book_number);
        bookNumber.setText(pref.getString("carportnumber",null));

        Button bookCarport= (Button) findViewById(R.id.book_carport);
        bookCarport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                
            }
        });

    }
}
