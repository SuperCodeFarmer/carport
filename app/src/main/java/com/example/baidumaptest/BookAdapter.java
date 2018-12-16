package com.example.baidumaptest;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.zip.Inflater;

/**
 * Created by yly on 2018/12/14.
 */

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.ViewHolder>{
    private List<BookItem> bookItemsList;
    private OnRecyclerViewClickListener listener;


    public BookAdapter(List<BookItem> bookItemsList) {
        this.bookItemsList = bookItemsList;
    }
    public void setItemClickListener(OnRecyclerViewClickListener itemClickListener) {
        listener = itemClickListener;
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView bookCarport_image;
        private TextView bookCarport_address;
        private TextView bookCarport_timeout;
        private TextView bookCarport_releasetime;
        private TextView bookCarport_cost;
        public ViewHolder(View itemView) {
            super(itemView);
            bookCarport_image= (ImageView) itemView.findViewById(R.id.book_carport_image);
            bookCarport_address= (TextView) itemView.findViewById(R.id.book_carport_address);
            bookCarport_timeout= (TextView) itemView.findViewById(R.id.book_carport_timeout);
            bookCarport_releasetime= (TextView) itemView.findViewById(R.id.release_time);
            bookCarport_cost= (TextView) itemView.findViewById(R.id.book_carport_cost);
        }
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.book_item,parent,false);
        ViewHolder holder =new ViewHolder(view);
        if (listener!=null){
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClickListener(v);
                }
            });
        }
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        BookItem bookItem=bookItemsList.get(position);
        holder.bookCarport_image.setImageResource(bookItem.getCarportImage());
        holder.bookCarport_address.setText(bookItem.getCarportAddress());
        holder.bookCarport_timeout.setText("出租时长："+bookItem.getCarportTimeout());
        // ("yyyy年MM月dd日   HH:mm:ss");
        holder.bookCarport_releasetime.setText("发布时间："+new SimpleDateFormat   ("MM月dd日 HH:mm:ss")
                .format( new Date(System.currentTimeMillis())));
        holder.bookCarport_cost.setText(bookItem.getCarportCost());
    }

    @Override
    public int getItemCount() {
        return bookItemsList.size();
    }

}
