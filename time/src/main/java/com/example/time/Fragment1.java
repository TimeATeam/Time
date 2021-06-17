package com.example.time;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Fragment1 extends Fragment {
    TextView timeET;
    Button btn_setDay;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment1, container, false);

    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        btn_setDay = (Button) getActivity().findViewById(R.id.btn_setDay);
        timeET = (TextView)  getActivity().findViewById(R.id.timeET);

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
                DatePickerDialog date = new DatePickerDialog(getContext(), dateListener, m_year, m_month, m_day);
                date.setTitle("日期对话框");
                date.show();
            }

        }

    }
}