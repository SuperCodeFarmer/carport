package com.example.baidumaptest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;

import java.util.ArrayList;
import java.util.List;

import jp.wasabeef.glide.transformations.BlurTransformation;
import jp.wasabeef.glide.transformations.CropCircleTransformation;

public class MyActivity extends AppCompatActivity {

    private ImageView mHBack;
    private ImageView mHHead;
    List<MyItem> listItem=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        //标题：个人中心
        TextView textView= (TextView) findViewById(R.id.title);
        textView.setText("个人中心");


        mHBack= (ImageView) findViewById(R.id.h_back);
        mHHead= (ImageView) findViewById(R.id.h_head);
        //设置背景磨砂效果
        Glide.with(this).load(R.drawable.head)
                .bitmapTransform(new BlurTransformation(this, 25), new CenterCrop(this))
                .into(mHBack);
        //设置圆形图像
        Glide.with(this).load(R.drawable.head)
                .bitmapTransform(new CropCircleTransformation(this))
                .into(mHHead);

        RecyclerView recyclerView= (RecyclerView) findViewById(R.id.recycler_view);
        initData();
        LinearLayoutManager linear=new LinearLayoutManager(this);
        MyAdapter myAdapter=new MyAdapter(listItem);
        recyclerView.setLayoutManager(linear);
        recyclerView.setAdapter(myAdapter);
    }

    public void initData(){
        MyItem item1=new MyItem(R.drawable.ic_pass,"我的钱包");
        listItem.add(item1);
        MyItem item2=new MyItem(R.drawable.ic_pass,"我的钱包");
        listItem.add(item2);
        MyItem item3=new MyItem(R.drawable.ic_pass,"我的车位");
        listItem.add(item3);
        MyItem item4=new MyItem(R.drawable.ic_pass,"我的服务");
        listItem.add(item4);
        MyItem item5=new MyItem(R.drawable.ic_pass,"我的设置");
        listItem.add(item5);
    }

}
