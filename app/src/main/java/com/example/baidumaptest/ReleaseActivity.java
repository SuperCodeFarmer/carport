package com.example.baidumaptest;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class ReleaseActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText carportAddress;
    private EditText carportNumber;
    private EditText bookTime;
    private EditText bookCost;
    private String name;
    private String filename;
    private ImageView imageView;
    protected com.nex3z.flowlayout.FlowLayout mFlowLayout;
    private ArrayList<String> addresses = new ArrayList<>();
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
        //imageView= (ImageView) findViewById(R.id.image_view);

        Button releaseInfo= (Button) findViewById(R.id.release_button);
        Button uploadCarport= (Button) findViewById(R.id.upload_carport);
        releaseInfo.setOnClickListener(this);
        uploadCarport.setOnClickListener(this);
        //存储照片的路径
        mFlowLayout = (com.nex3z.flowlayout.FlowLayout) findViewById(R.id.mFlowLayout);
        filename = Environment.getExternalStorageDirectory().getAbsolutePath() + "/photos/";
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.upload_carport:
                showDialogg();
                break;
            case R.id.release:
                SharedPreferences.Editor editor = getSharedPreferences("carportdata", MODE_PRIVATE).edit();
                editor.putString("carportaddress", carportAddress.getText().toString());
                editor.putString("carportnumber", carportNumber.getText().toString());
                editor.putString("booktime", bookTime.getText().toString());
                editor.putString("bookcost", bookCost.getText().toString());
                editor.apply();
                Toast.makeText(ReleaseActivity.this, "发布成功", Toast.LENGTH_SHORT).show();
                break;
            default:
        }
    }
    private void showDialogg(){
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
            name = getPhotoFileName();
            File mFile = new File(filename);
            if (!mFile.exists()) {
                mFile.mkdirs();
            }
            File mPhotoFile = new File(filename, name);
            Intent captureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            Uri fileUri = Uri.fromFile(mPhotoFile);
            captureIntent.putExtra(MediaStore.EXTRA_OUTPUT, fileUri);
            startActivityForResult(captureIntent, 0);
    }
    //从相册中选择
    public void opoenGallery(){
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("image/*");
        intent.putExtra("crop", true);
        intent.putExtra("return-data", true);
        startActivityForResult(intent, 1);

    }
    private String getPhotoFileName() {
        Date date = new Date(System.currentTimeMillis());
        SimpleDateFormat dateFormat = new SimpleDateFormat(
                "'IMG'_yyyyMMdd_HH-mm-ss");
        return dateFormat.format(date) + ".jpg";
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            //获取到相机拍的照片
            if (requestCode == 0) {
                String filestr = filename + "/" + name;
                //向flowlayout中添加图片
                addPhotoToFlow(filestr);

            }
            //获取到图库的照片
            if (requestCode == 1) {
                Uri selectedImage = data.getData();
                String[] filePathColumn = {MediaStore.Images.Media.DATA};
                Cursor cursor = this.getContentResolver().query(selectedImage,
                        filePathColumn, null, null, null);
                cursor.moveToFirst();
                int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
                //picturePath就是图片在储存卡所在的位置
                String picturePath = cursor.getString(columnIndex);
                Log.e("aaa","pocture===>"+picturePath);
                cursor.close();
                addPhotoToFlow(picturePath);
            }

        }
    }

        private void addPhotoToFlow(String filestr) {
            //获取旋转角度
            int degree = PhotoUtils.getBitmapDegree(filestr);
            //压缩图片
            Bitmap bitmap1 = PhotoUtils.decodeSampledBitmapFromFd(filestr, 500, 250);
            //根据旋转角度旋转图片
            Bitmap bitmap2 = PhotoUtils.rotateBitmapByDegree(bitmap1, degree);

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            ImageView imageView = new ImageView(this);
            params.setMargins(15, 15, 15, 15);
            imageView.setLayoutParams(params);

            imageView.setPadding(18, 18, 18, 18);
            imageView.setTag(filestr);
            imageView.setImageBitmap(bitmap2);
            addresses.add(filestr);
            mFlowLayout.addView(imageView);
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

