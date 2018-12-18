package com.example.baidumaptest;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class BookActivity extends AppCompatActivity implements View.OnClickListener {
    private List<BookItem> listBook=new ArrayList<>();
    private RecyclerView recyclerView;
    private TextView textView1;
    private TextView textView2;
    private TextView textView3;
    private TextView textView4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);
        //设置头布局为我的发布
        TextView title= (TextView) findViewById(R.id.title_text);
        title.setText("车位预定");
        initData();

        textView1= (TextView) findViewById(R.id.text_view_1);
        textView2= (TextView) findViewById(R.id.text_view_2);
        textView3= (TextView) findViewById(R.id.text_view_3);
        textView4= (TextView) findViewById(R.id.text_view_3);

        textView1.setOnClickListener(this);
        textView2.setOnClickListener(this);
        textView3.setOnClickListener(this);
        textView4.setOnClickListener(this);

        recyclerView= (RecyclerView) findViewById(R.id.book_recyclerview);
        LinearLayoutManager linear=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linear);
        BookAdapter bookAdapter=new BookAdapter(listBook);
        recyclerView.setAdapter(bookAdapter);
        bookAdapter.setItemClickListener(new OnRecyclerViewClickListener() {
            @Override
            public void onItemClickListener(View view) {
                int position = recyclerView.getChildAdapterPosition(view);
                BookItem bookItem=listBook.get(position);
                switch (position) {
                    case 0:
                        Intent intent1=new Intent(BookActivity.this, Carport_Details.class);
                        intent1.putExtra("address",bookItem.getCarportAddress());
                        intent1.putExtra("timeout",bookItem.getCarportTimeout());
                        intent1.putExtra("carportimage",
                                BitmapFactory.decodeResource(getResources(),bookItem.getCarportImage()));
                        intent1.putExtra("carportcost",bookItem.getCarportCost());
                        startActivity(intent1);
                        break;
                    case 1:
                        Intent intent2=new Intent(BookActivity.this, Carport_Details.class);
                        intent2.putExtra("address",bookItem.getCarportAddress());
                        intent2.putExtra("timeout",bookItem.getCarportTimeout());
                        intent2.putExtra("carportimage",
                                BitmapFactory.decodeResource(getResources(),bookItem.getCarportImage()));
                        intent2.putExtra("carportcost",bookItem.getCarportCost());
                        startActivity(intent2);
                        break;
                    case 2:
                        Intent intent3=new Intent(BookActivity.this, Carport_Details.class);
                        intent3.putExtra("address",bookItem.getCarportAddress());
                        intent3.putExtra("timeout",bookItem.getCarportTimeout());
                        intent3.putExtra("carportimage",
                                BitmapFactory.decodeResource(getResources(),bookItem.getCarportImage()));
                        intent3.putExtra("carportcost",bookItem.getCarportCost());
                        startActivity(intent3);
                        break;
                    case 3:
                        Intent intent4=new Intent(BookActivity.this, Carport_Details.class);
                        intent4.putExtra("address",bookItem.getCarportAddress());
                        intent4.putExtra("timeout",bookItem.getCarportTimeout());
                        intent4.putExtra("carportimage",
                                BitmapFactory.decodeResource(getResources(),bookItem.getCarportImage()));
                        intent4.putExtra("carportcost",bookItem.getCarportCost());
                        startActivity(intent4);
                        break;
                    case 4:
                        Intent intent5=new Intent(BookActivity.this, Carport_Details.class);
                        intent5.putExtra("address",bookItem.getCarportAddress());
                        intent5.putExtra("timeout",bookItem.getCarportTimeout());
                        intent5.putExtra("carportimage",
                                BitmapFactory.decodeResource(getResources(),bookItem.getCarportImage()));
                        intent5.putExtra("carportcost",bookItem.getCarportCost());
                        startActivity(intent5);
                        break;
                    case 5:
                        Intent intent6=new Intent(BookActivity.this, Carport_Details.class);
                        intent6.putExtra("address",bookItem.getCarportAddress());
                        intent6.putExtra("timeout",bookItem.getCarportTimeout());
                        intent6.putExtra("carportimage",
                                BitmapFactory.decodeResource(getResources(),bookItem.getCarportImage()));
                        intent6.putExtra("carportcost",bookItem.getCarportCost());
                        startActivity(intent6);
                        break;
                    case 6:
                        Intent intent7=new Intent(BookActivity.this, Carport_Details.class);
                        intent7.putExtra("address",bookItem.getCarportAddress());
                        intent7.putExtra("timeout",bookItem.getCarportTimeout());
                        intent7.putExtra("carportimage",
                                BitmapFactory.decodeResource(getResources(),bookItem.getCarportImage()));
                        intent7.putExtra("carportcost",bookItem.getCarportCost());
                        startActivity(intent7);
                        break;
                        default:
                            break;

                }
            }
        });
    }
    public void initData(){
        SharedPreferences pref =getSharedPreferences("carportdata",MODE_PRIVATE) ;
        BookItem bookItem1=new BookItem(R.drawable.th_qq,pref.getString("carportaddress","东王庄小区"),
                pref.getString("bookcost","30元/小时"),pref.getString("carporttimeout","8小时"));
        listBook.add(bookItem1);
        BookItem bookItem2=new BookItem(R.drawable.th_qq,"矿大家属院","20元/小时","6小时");
        listBook.add(bookItem2);
       /* BookItem bookItem1=new BookItem(R.drawable.th_qq,"东王庄小区","10元/小时","4小时");
        listBook.add(bookItem1);
        BookItem bookItem2=new BookItem(R.drawable.th_qq,"矿大家属院","20元/小时","6小时");
        listBook.add(bookItem2);*/
        BookItem bookItem3=new BookItem(R.drawable.th_qq,"丰台科技园","30元/小时","1小时");
        listBook.add(bookItem3);
        BookItem bookItem4=new BookItem(R.drawable.th_qq,"五道口地铁站","40元/小时","8小时");
        listBook.add(bookItem4);
        BookItem bookItem5=new BookItem(R.drawable.th_qq,"太阳宫大厦","50元/小时","2小时");
        listBook.add(bookItem5);
        BookItem bookItem6=new BookItem(R.drawable.th_qq,"西二旗地铁站","60元/小时","8小时");
        listBook.add(bookItem6);
        BookItem bookItem7=new BookItem(R.drawable.th_qq,"成府路口西","70元/小时","5小时");
        listBook.add(bookItem7);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.text_view_1:
                Toast.makeText(BookActivity.this,"筛选功能正在实现中，请绕道",Toast.LENGTH_LONG).show();
                break;
            case R.id.text_view_2:
                Toast.makeText(BookActivity.this,"筛选功能正在实现中，请绕道",Toast.LENGTH_LONG).show();
                break;
            case R.id.text_view_3:
                Toast.makeText(BookActivity.this,"筛选功能正在实现中，请绕道",Toast.LENGTH_LONG).show();
                break;
            case R.id.text_view_4:
                Toast.makeText(BookActivity.this,"筛选功能正在实现中，请绕道",Toast.LENGTH_LONG).show();
                break;
            default:
                break;
        }
    }
}
