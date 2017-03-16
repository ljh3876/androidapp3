package com.example.jinhwan.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {
    EditText e1, e2, e3;
    TextView total_view, avg_view;
    ImageView image;
    int total, avg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        init();
    }
    void init(){
        e1= (EditText)findViewById(R.id.editText);
        e2= (EditText)findViewById(R.id.editText2);
        e3= (EditText)findViewById(R.id.editText3);
        image = (ImageView)findViewById(R.id.imageView_grade);
        total_view = (TextView)findViewById(R.id.textView_total);
        avg_view = (TextView)findViewById(R.id.textView_avg);

    }
    public void onMyClick(View v){

        if(v.getId()==R.id.button_calc){
            total = Integer.parseInt(e1.getText().toString()) + Integer.parseInt(e2.getText().toString()) + Integer.parseInt(e3.getText().toString());
            avg = total/3;
            if(avg>=90){
                image.setImageResource(R.drawable.letter_a);
                image.invalidate();
            }
            else if(avg>=80){
                image.setImageResource(R.drawable.letter_b);
                image.invalidate();
            }
            else if(avg>=70){
                image.setImageResource(R.drawable.letter_c);
                image.invalidate();
            }
            else if(avg>=60){
                image.setImageResource(R.drawable.letter_d);
                image.invalidate();
            }
            else{
                image.setImageResource(R.drawable.letter_f);
                image.invalidate();
            }


            total_view.setText(total+"점");
            avg_view.setText(avg+"점");

        }
        else if(v.getId()==R.id.button_init){
            e1.setText("");
            e2.setText("");
            e3.setText("");
            total_view.setText("0점");
            avg_view.setText("0점");
            image.setImageResource(0);
            Toast.makeText(getApplicationContext(),"초기화 되었습니다.",Toast.LENGTH_SHORT).show();

        }
    }
}
