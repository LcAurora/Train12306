package com.example.train12306.Londing;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.train12306.R;

public class RegisterActivity extends Activity {

    private Button yesbutton, getzhucema;
    private EditText edtName, edtPwd, edtRepwd, phone, zhucema;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        edtName = findViewById(R.id.name);
        edtPwd = findViewById(R.id.possword);
        edtRepwd = findViewById(R.id.posswordagain);

        phone = findViewById(R.id.phone);
        zhucema = findViewById(R.id.zhucema);

        yesbutton = findViewById(R.id.yesbutton);
        getzhucema = findViewById(R.id.getzhucema);

        getzhucema.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"验证码已发送至您的手机",Toast.LENGTH_SHORT).show();
            }
        });

        yesbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = edtName.getText().toString();
                String pwd = edtPwd.getText().toString();
                String repwd = edtRepwd.getText().toString();
                String phn = phone.getText().toString();
                String zcm = zhucema.getText().toString();
                Intent intent = new Intent();
                if (name.equals("")) {
                    Toast.makeText(RegisterActivity.this, "请输入用户名", Toast.LENGTH_SHORT).show();
                } else if (phn.equals("")) {
                    Toast.makeText(RegisterActivity.this, "请输入手机号", Toast.LENGTH_SHORT).show();
                } else if (zcm.equals("")){
                    Toast.makeText(RegisterActivity.this, "请输入验证码", Toast.LENGTH_SHORT).show();
                } else if(!"".equals(pwd)&&pwd.equals(repwd)&&zcm.equals("12306")){
                    Toast.makeText(RegisterActivity.this, "注册登录成功,请牢记你的账户密码", Toast.LENGTH_SHORT).show();
                    intent.setClass(RegisterActivity.this,MainActivity.class);
                    intent.putExtra("name",name);
                    intent.putExtra("pwd",pwd);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(RegisterActivity.this, "注册失败", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
