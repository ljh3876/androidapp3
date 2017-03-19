package com.example.jinhwan.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FirstActivity extends AppCompatActivity {
    Button btn1,btn2,btn3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        init();
    }
    void init(){
        btn1=(Button)findViewById(R.id.button_rel);
        btn2=(Button)findViewById(R.id.button_cal);
        btn3=(Button)findViewById(R.id.button_res);

    }
    public void onMyClick(View v){
        Intent intent;
        if(v.getId()==R.id.button_rel){
            intent=new Intent(FirstActivity.this,MainActivity.class);
            startActivity(intent);
        }
        else if(v.getId()==R.id.button_cal){
            intent=new Intent(FirstActivity.this,Main2Activity.class);
            startActivity(intent);
        }
        else if(v.getId()==R.id.button_res){
            intent = new Intent(FirstActivity.this, Main3Activity.class);
            startActivity(intent);
        }
    }
}
