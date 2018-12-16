package com.example.baidumaptest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Carport_Details extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carport__details);
        TextView title= (TextView) findViewById(R.id.title_text);
        title.setText("订单详情");

    }
}
