package com.example.time;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Add extends AppCompatActivity {
    TextView timeET;
    Button btn_setDay;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_activity);

        btn_setDay = (Button) findViewById(R.id.btn_setDay);
        timeET = (TextView) findViewById(R.id.timeET);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日");
        Date date = new Date(System.currentTimeMillis());
        timeET.setText(simpleDateFormat.format(date));
        btn_setDay.setOnClickListener(new mClick());


    }



    class mClick implements View.OnClickListener {

        final Calendar c = Calendar.getInstance();

        int m_year =c.get(Calendar.YEAR);
        int m_month = c.get(Calendar.MONTH)+1;
        int m_day = c.get(Calendar.DAY_OF_MONTH);

        public void onClick(View v) {
            if(v==btn_setDay) {
                DatePickerDialog.OnDateSetListener dateListener = new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        m_year = year;
                        m_month = month;
                        m_day = dayOfMonth;
                        timeET.setText( m_year + "年" + m_month + "月" + m_day + "日");
                    }
                };
                DatePickerDialog date = new DatePickerDialog(Add.this, dateListener, m_year, m_month, m_day);
                date.setTitle("日期对话框");
                date.show();
            }

        }

    }

}
