package com.example.baidumaptest;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class ReleaseActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText carportAddress;
    private EditText carportNumber;
    private EditText bookTime;
    private EditText bookCost;
    private ImageView imageView_L;
    private ImageView imageView_R;
    private Uri imageUri;
    private String imageleft;
    private String imageright;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_release);
        //设置头布局为我的发布
        TextView title= (TextView) findViewById(R.id.title_text);
        title.setText("我的发布");

        carportAddress= (EditText) findViewById(R.id.carport_address);
        carportNumber= (EditText) findViewById(R.id.carport_number);
        bookTime= (EditText) findViewById(R.id.book_time);
        bookCost= (EditText) findViewById(R.id.book_cost);

        imageView_L= (ImageView) findViewById(R.id.imageview_l);//左边图片
        imageView_R= (ImageView) findViewById(R.id.imageview_r);//右边图片
        Button releaseInfo= (Button) findViewById(R.id.release_button);//发布车位

        //左边图片和右边图片的名称
        imageleft="image_left.jpg";
        imageright="image_left.jpg";

        imageView_L.setOnClickListener(this);
        imageView_R.setOnClickListener(this);
        releaseInfo.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.imageview_l:
                showDialog();
                break;
            case R.id.imageview_r:
                showDialog();
                break;
            case R.id.release_button:
                SharedPreferences.Editor editor = getSharedPreferences("carportdata", MODE_PRIVATE).edit();
                editor.putString("carportaddress", carportAddress.getText().toString());
                editor.putString("carportnumber", carportNumber.getText().toString());
                editor.putString("booktime", bookTime.getText().toString());
                editor.putString("bookcost", bookCost.getText().toString());
                Toast.makeText(ReleaseActivity.this, "发布成功", Toast.LENGTH_SHORT).show();
                editor.apply();
                break;
            default:
        }
    }
    private void showDialog(){
        View view = LayoutInflater.from(this).inflate(R.layout.dialog_layout,null,false);
        final AlertDialog dialog = new AlertDialog.Builder(this).setView(view).create();
        Button takePhoto = (Button) view.findViewById(R.id.take_photo);
        Button takeGallery = (Button) view.findViewById(R.id.gallay);
        //设置点击事件
        takePhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                takephoto();
                dialog.cancel();
            }
        });
        takeGallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.cancel();
                opoenGallery();
            }
        });
        dialog.show();

        //这个方法是用来设置对话框的大小的，下面的ScreenUtil里面的方法即使设置了也不会起作用
        //dialog.getWindow().setLayout(width,height);

        //此处设置位置窗体大小，我这里设置为了手机屏幕宽度的3/4
        dialog.getWindow().setLayout((ScreenUtils.getScreenWidth(this)/4*3), LinearLayout.LayoutParams.WRAP_CONTENT);
    }

    //拍照
    private void takephoto() {
        File outputStream=new File(getExternalCacheDir(),"output_image.jpg");
        try{
            if (outputStream.exists()){
                outputStream.delete();
            }
            outputStream.createNewFile();
        }catch(Exception e){
            e.printStackTrace();
        }
        if (Build.VERSION.SDK_INT>=24){

        }else{
            imageUri=Uri.fromFile(outputStream);
        }
        Intent intent=new Intent("android.media.action.IMAGE_CAPTURE");
        intent.putExtra(MediaStore.EXTRA_OUTPUT,imageUri);
        startActivityForResult(intent,0);
    }
    //从相册中选择
    public void opoenGallery(){

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode){
            case 0:
                if (resultCode==RESULT_OK){
                    try {
                        Bitmap bitmap= BitmapFactory.decodeStream(getContentResolver().openInputStream(imageUri));
                        if (imageView_L.getDrawable()==null){
                            imageView_L.setImageBitmap(bitmap);
                        }else if (imageView_R.getDrawable()==null){
                            imageView_R.setImageBitmap(bitmap);
                        }
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }

                }
                break;
            default:
                break;
        }
    }

    static class ScreenUtils{
        //设置对话框的告诉占整个屏幕的几分之几
        public static int getScreenHeight(Context context) {
            return context.getResources().getDisplayMetrics().heightPixels;
        }
        //设置对话框的宽度占整个屏幕的几分之几
        public static int getScreenWidth(Context context) {
            return context.getResources().getDisplayMetrics().widthPixels;
        }
    }
}

