package com.example.baidumaptest;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LogInActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        //login button
        final Button login = (Button) findViewById(R.id.button);
        final String user = "admin";
        final String pass = "hello";

        login.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                //从输入框输入用户名
                String username = "";
                EditText editText1 = (EditText) findViewById(R.id.editText);
                username = editText1.getText().toString();
                //从输入框获取密码
                String password = "";
                EditText editText2 = (EditText) findViewById(R.id.editText2);
                password = editText2.getText().toString();

                if (username.equals(user) & password.equals(pass)) {
                    Intent intent = new Intent(LogInActivity.this, MainActivity.class);
                    startActivity(intent);
                } else {
                    new AlertDialog.Builder(LogInActivity.this).setTitle("Error!").setMessage("Wrong username or password.")
                            .setNegativeButton("OK", null)
                            .show();
                }
            }
        });
        //register button
        final Button register = (Button) findViewById(R.id.button2);
        register.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                //提示框确定是否跳转
                new AlertDialog.Builder(LogInActivity.this).setTitle("Jump").setMessage("Ready to jump?")
                        .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                Intent intent = new Intent(LogInActivity.this,RegisterActivity.class);
                                startActivity(intent);
                            }
                        })
                        .setNegativeButton("No", null)
                        .show();
            }
        });
    }
}