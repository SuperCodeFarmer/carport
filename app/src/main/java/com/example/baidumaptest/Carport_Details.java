package com.example.baidumaptest;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Carport_Details extends AppCompatActivity implements View.OnClickListener {
    private Button submit;
    private TextView carportDetailCost;
    private TextView carportDetailAddress;
    private ImageView carportImageDetail_1;
    private ImageView carportImageDetail_2;
    private ImageView carportImageDetail_3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carport__details);
        //标题栏
        TextView title= (TextView) findViewById(R.id.title_text);
        title.setText("订单详情");

        carportDetailAddress= (TextView) findViewById(R.id.carport_detail_address);
        carportDetailCost= (TextView) findViewById(R.id.carport_detail_cost);
        carportImageDetail_1= (ImageView) findViewById(R.id.image_detail_1);
        carportImageDetail_2= (ImageView) findViewById(R.id.image_detail_2);
        carportImageDetail_3= (ImageView) findViewById(R.id.image_detail_3);

        Intent intent=getIntent();
        carportDetailAddress.setText(intent.getStringExtra("address"));
        carportDetailCost.setText(intent.getStringExtra("carportcost"));
        carportImageDetail_1.setImageBitmap((Bitmap) intent.getParcelableExtra("carportimage"));
        submit= (Button) findViewById(R.id.submit_button);
        submit.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.submit_button:
                Toast.makeText(this,"订单已经提交，请前往个人中心查看订单详情",Toast.LENGTH_LONG).show();;
                break;
        }
    }
}
