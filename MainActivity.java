package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button but=findViewById(R.id.button);
        but.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                AlertDialog.Builder builder=
                        new AlertDialog.Builder(MainActivity.this);
                final View viewDialog= LayoutInflater.from(MainActivity.this).inflate(R.layout.dialogcustom,null,false);
                builder.setTitle("登录对话框") .setView(viewDialog)
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {

                            public void onClick(DialogInterface dialogInterface,int which){
                                EditText editTextUserId=viewDialog.findViewById(R.id.userId);
                                EditText editTextUserPassword=viewDialog.findViewById(R.id.userP);
                                if((editTextUserId.getText().toString().equals("abc"))&&
                                        (editTextUserPassword.getText().toString().equals("123")))
                                    Toast.makeText(MainActivity.this,"登陆成功",Toast.LENGTH_LONG).show();
                                else
                                    Toast.makeText(MainActivity.this,"登陆失败",Toast.LENGTH_LONG).show();
                                Toast.makeText(MainActivity.this,"UserId:"+editTextUserId.getText().toString(),Toast.LENGTH_LONG).show();

                            }
                        });

                builder.setNegativeButton("取消",new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialogInterface,int which){
                        Toast.makeText(MainActivity.this, "用户按下了取消按钮", Toast.LENGTH_LONG).show();
                    }
                });
                builder.create().show();
            }
        });
    }
}


