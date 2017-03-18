package com.example.jinhwan.myapplication;

import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.GridLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.TimePicker;

import java.sql.Time;
import java.util.Calendar;

import static java.sql.DriverManager.println;

public class Main3Activity extends AppCompatActivity {
    Switch start;
    Chronometer chrono;
    DatePicker calender;
    TimePicker timePicker;
    Button button_prev,button_next;
    int year, month, day,hour,minute,adult,teen,child;
    TextView textCrono,result_date,result_time,result_adult,result_teen,result_child;
    EditText e1,e2,e3;
    GridLayout count,result;
    FrameLayout picker;
    int imageIndex;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        init();
    }
    void init(){
        start=(Switch)findViewById(R.id.switch_start);
        chrono=(Chronometer)findViewById(R.id.chronometer);
        calender=(DatePicker)findViewById(R.id.datePicker);
        timePicker=(TimePicker)findViewById(R.id.timePicker);
        button_prev=(Button)findViewById(R.id.button_prev);
        button_next=(Button)findViewById(R.id.button_next);
        textCrono=(TextView)findViewById(R.id.textView_chrono);
        e1=(EditText)findViewById(R.id.editText_adult);
        e2=(EditText)findViewById(R.id.editText_teen);
        e3=(EditText)findViewById(R.id.editText_child);
        count=(GridLayout)findViewById(R.id.countLayout);
        result=(GridLayout)findViewById(R.id.resultLayout);
        picker=(FrameLayout)findViewById(R.id.pickerLayout);
        result_date=(TextView)findViewById(R.id.textView_date);
        result_time=(TextView)findViewById(R.id.textView_time);
        result_adult=(TextView)findViewById(R.id.textView_adult);
        result_teen=(TextView)findViewById(R.id.textView_teen);
        result_child=(TextView)findViewById(R.id.textView_child);



    }
    public void onMyClick(View v) {
        switch (v.getId()) {
            case R.id.switch_start:
                if(start.isChecked()){

                    imageIndex=0;
                    changeImage();
                    chrono.setBase(SystemClock.elapsedRealtime());
                    textCrono.setVisibility(View.VISIBLE);
                    chrono.setVisibility(View.VISIBLE);
                    chrono.start();
                    picker.setVisibility(View.VISIBLE);
                    button_prev.setVisibility(View.VISIBLE);
                    button_next.setVisibility(View.VISIBLE);
                }
                else{
                    chrono.setBase(SystemClock.elapsedRealtime());
                    textCrono.setVisibility(View.INVISIBLE);
                    chrono.setVisibility(View.INVISIBLE);
                    button_prev.setVisibility(View.INVISIBLE);
                    button_next.setVisibility(View.INVISIBLE);
                    picker.setVisibility(View.INVISIBLE);


                }
                break;
            case R.id.button_next:
                if (imageIndex < 3 ) {
                    imageIndex ++;
                }
                changeImage();
                break;

            case R.id.button_prev:
                if (imageIndex > 0){
                    imageIndex --;
                }
                changeImage();
                break;
        }
    }
    private void changeImage(){

        if (imageIndex == 0) {
            calender.setVisibility(View.VISIBLE);
            timePicker.setVisibility(View.INVISIBLE);
            count.setVisibility(View.INVISIBLE);
            result.setVisibility(View.INVISIBLE);

        }else if (imageIndex == 1){
            calender.setVisibility(View.INVISIBLE);
            timePicker.setVisibility(View.VISIBLE);
            count.setVisibility(View.INVISIBLE);
            result.setVisibility(View.INVISIBLE);

        }else if (imageIndex == 2) {
            calender.setVisibility(View.INVISIBLE);
            timePicker.setVisibility(View.INVISIBLE);
            count.setVisibility(View.VISIBLE);
            result.setVisibility(View.INVISIBLE);

        }else if(imageIndex == 3){
            getValue();
            showValue();
            calender.setVisibility(View.INVISIBLE);
            timePicker.setVisibility(View.INVISIBLE);
            count.setVisibility(View.INVISIBLE);
            result.setVisibility(View.VISIBLE);
        }

    }
    void getValue(){
        year=calender.getYear();
        month=calender.getMonth();
        day=calender.getDayOfMonth();
        int currentApiVersion = android.os.Build.VERSION.SDK_INT;
        if (currentApiVersion > android.os.Build.VERSION_CODES.LOLLIPOP_MR1){
            hour = timePicker.getHour();
            minute = timePicker.getMinute();
        } else {
            hour = timePicker.getCurrentHour();
            minute= timePicker.getCurrentMinute();
        }
        adult=checkEmptyandGetValue(e1);
        teen=checkEmptyandGetValue(e2);
        child=checkEmptyandGetValue(e3);
    }
    void showValue(){
        result_date.setText(year+"년 "+(month+1)+"월 "+day+"일");
        result_time.setText(hour+"시 "+minute+"분");
        result_adult.setText(adult+"명");
        result_teen.setText(teen+"명");
        result_child.setText(child+"명");
    }
    int checkEmptyandGetValue(EditText e){
        if(e.getText().toString().length()==0)
            return 0;
        else
            return Integer.parseInt(e.getText().toString());
    }
}
