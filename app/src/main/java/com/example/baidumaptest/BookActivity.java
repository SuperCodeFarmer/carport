package com.example.baidumaptest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class BookActivity extends AppCompatActivity {
    private List<BookItem> listBook=new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);
        //设置头布局为我的发布
        TextView title= (TextView) findViewById(R.id.title_text);
        title.setText("我的预定");
        initData();
        RecyclerView recyclerView= (RecyclerView) findViewById(R.id.book_recyclerview);
        LinearLayoutManager linear=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linear);
        BookAdapter bookAdapter=new BookAdapter(listBook);
        recyclerView.setAdapter(bookAdapter);
    }
    public void initData(){
        for (int i=0;i<=6;i++){
            BookItem bookItem1=new BookItem(R.drawable.th_qq,"东王庄小区","30元/小时","4小时");
            listBook.add(bookItem1);
        }
    }
}
