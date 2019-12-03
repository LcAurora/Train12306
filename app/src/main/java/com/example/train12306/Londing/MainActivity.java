package com.example.train12306.Londing;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.train12306.R;

public class MainActivity extends AppCompatActivity {

    private Button longding, register;
    private EditText adm,pow;
    private TextView textView;
    private CheckBox chb;

    private static final int REQUEST_CODE = 1001;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        longding = findViewById(R.id.longdingbutton);
        adm = findViewById(R.id.adm);
        pow = findViewById(R.id.pow);
        textView = findViewById(R.id.textView);
        chb = findViewById(R.id.chb);
        register = findViewById(R.id.registerbutton);

        textView.setOnClickListener(myClickListener);
        register.setOnClickListener(myClickListener);

        Intent intent1 = getIntent();
        String n = intent1.getStringExtra("name");
        String p = intent1.getStringExtra("pwd");
        adm.setText(n);
        pow.setText(p);

        SharedPreferences sharedPreferencesa = getSharedPreferences("isChecked", 0);
        boolean result = sharedPreferencesa.getBoolean("choose", false);
        if (result == true) {

            SharedPreferences sharedPreferences = getSharedPreferences("data",Context.MODE_PRIVATE);
            String strId = sharedPreferences.getString("id", "");
            String strpowds = sharedPreferences.getString("pwdss", "");
            adm.setText(strId);
            pow.setText(strpowds);
            chb.setChecked(true);
        }


        chb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                boolean ischecked = chb.isChecked();
                if(isChecked){
                    SharedPreferences sharedPreferencesa = getSharedPreferences("isChecked", 0);
                    // 使用编辑器来进行操作
                    SharedPreferences.Editor edit = sharedPreferencesa.edit();
                    // 将勾选的状态保存起来
                    edit.putBoolean("choose", true); // 这里的choose就是一个key 通过这个key我们就可以得到对应的值
                    // 最好我们别忘记提交一下
                    edit.commit();
                    Toast.makeText(getApplicationContext(),"自动登陆",Toast.LENGTH_SHORT).show();
                }else {
                    adm.setText("");
                    pow.setText("");
                    Toast.makeText(getApplicationContext(),"取消自动登陆",Toast.LENGTH_SHORT).show();
                }
            }
        });

        longding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String names = adm.getText().toString();
                String pwds = pow.getText().toString();
                Intent intent = new Intent(MainActivity.this, MyFragmentActivity.class);
                startActivity(intent);
//                if (names.equals("")) {
//                    Toast.makeText(MainActivity.this, "请输入正确账户", Toast.LENGTH_SHORT).show();
//                }else if(names.equals("1")&&pwds.equals("")) {
//                    Toast.makeText(MainActivity.this, "请输入正确密码", Toast.LENGTH_SHORT).show();
//                }else if(names.equals("1")&&pwds.equals("1")){
//                    SharedPreferences sharedPreferences = getSharedPreferences("data", Context.MODE_PRIVATE);
//                    SharedPreferences.Editor editor = sharedPreferences.edit();
//                    editor.putString("id", names);
//                    editor.putString("pwdss", pwds);
//                    editor.commit();
//
//                    Toast.makeText(MainActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
//                    intent.putExtra("names", names);
//                    intent.putExtra("pwds", pwds);
//                    startActivity(intent);
//                    finish();
//                }else{
//                    Toast.makeText(MainActivity.this, "密码错误", Toast.LENGTH_SHORT).show();
//                }
            }
        });
    }
    View.OnClickListener myClickListener = new View.OnClickListener(){
        @Override
        public void onClick(View view) {
            Intent intent = new Intent();
            switch (view.getId()){
                case R.id.textView:
                    break;
                case R.id.registerbutton:
                    intent.setClass(MainActivity.this, RegisterActivity.class);
                    startActivityForResult(intent,REQUEST_CODE);
                    MainActivity.this.finish();
                    break;
            }
        }
    };
}
