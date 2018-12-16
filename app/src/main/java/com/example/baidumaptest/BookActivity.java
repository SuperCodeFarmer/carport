package com.example.baidumaptest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class BookActivity extends AppCompatActivity{
    private List<BookItem> listBook=new ArrayList<>();
    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);
        //设置头布局为我的发布
        TextView title= (TextView) findViewById(R.id.title_text);
        title.setText("车位预定");
        initData();
        recyclerView= (RecyclerView) findViewById(R.id.book_recyclerview);
        LinearLayoutManager linear=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linear);
        BookAdapter bookAdapter=new BookAdapter(listBook);
        recyclerView.setAdapter(bookAdapter);
        bookAdapter.setItemClickListener(new OnRecyclerViewClickListener() {
            @Override
            public void onItemClickListener(View view) {
                int position = recyclerView.getChildAdapterPosition(view);
                switch (position) {
                    case 0:
                        startActivity(new Intent(BookActivity.this, Carport_Details.class));
                        break;
                    case 1:
                        startActivity(new Intent(BookActivity.this, Carport_Details.class));
                        break;
                    case 2:
                        startActivity(new Intent(BookActivity.this, Carport_Details.class));
                        break;
                    case 3:
                        startActivity(new Intent(BookActivity.this, Carport_Details.class));
                        break;
                    case 4:
                        startActivity(new Intent(BookActivity.this, Carport_Details.class));
                        break;
                    case 5:
                        startActivity(new Intent(BookActivity.this, Carport_Details.class));
                        break;
                    case 6:
                        startActivity(new Intent(BookActivity.this, Carport_Details.class));
                        break;
                    case 7:
                        startActivity(new Intent(BookActivity.this, Carport_Details.class));
                        break;
                }
            }
        });
    }
    public void initData(){
        for (int i=0;i<=6;i++){
            BookItem bookItem1=new BookItem(R.drawable.th_qq,"东王庄小区","30元/小时","4小时");
            listBook.add(bookItem1);
        }
    }

}
