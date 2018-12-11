package com.example.baidumaptest;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ReleaseActivity extends AppCompatActivity {

    private EditText carportAddress;
    private EditText carportNumber;
    private EditText bookTime;
    private EditText bookCost;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_release);

        carportAddress= (EditText) findViewById(R.id.carport_address);
        carportNumber= (EditText) findViewById(R.id.carport_number);
        bookTime= (EditText) findViewById(R.id.book_time);
        bookCost= (EditText) findViewById(R.id.book_cost);

        Button releaseInfo= (Button) findViewById(R.id.release_button);
        releaseInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences.Editor editor=getSharedPreferences("carportdata",MODE_PRIVATE).edit();
                editor.putString("carportaddress",carportAddress.getText().toString());
                editor.putString("carportnumber",carportNumber.getText().toString());
                editor.putString("booktime",bookTime.getText().toString());
                editor.putString("bookcost",bookCost.getText().toString());
                editor.apply();
                Toast.makeText(ReleaseActivity.this,"发布成功",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
