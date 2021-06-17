package com.example.time;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Add extends Activity {

    private static String DATABASE = "anniversary.db";
    private static int DB_VERSION = 1;
    int t_year,t_month,t_day;

    EditText descr;
    RadioGroup radiogroup;
    RadioButton no,i_month,i_year;
    String isOrNot;

    Spinner remind_spinner,tag_spinner;
    String[] remindArray,tagArray;
    String t_remind,tag;

    TextView timeET;
    Button btn_setDay;
    Button finish;
    DBOpenHelper helper;
    SQLiteDatabase db;

    RelativeLayout layout;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_activity);

//        getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        WindowManager m = getWindowManager();
        Display d = m.getDefaultDisplay(); // 为获取屏幕宽、高
        android.view.WindowManager.LayoutParams p = getWindow().getAttributes();
        p.height = (int) (d.getHeight() * 0.9); // 高度设置为屏幕的0.3
        p.width = (int) (d.getWidth() * 1); // 宽度设置为屏幕的0.7
        getWindow().setAttributes(p);

        layout= (RelativeLayout) findViewById(R.id.huadong);


        helper = new DBOpenHelper(Add.this, "anniversary.db");
        db = helper.getWritableDatabase();


        no = (RadioButton)findViewById(R.id.btnX1);
        i_month = (RadioButton)findViewById(R.id.btnX2);
        i_year = (RadioButton)findViewById(R.id.btnX3);
        radiogroup=(RadioGroup)findViewById(R.id.btnX);

        remind_spinner = (Spinner) findViewById(R.id.set_remind);
        tag_spinner = (Spinner) findViewById(R.id.set_tag);

        btn_setDay = (Button) findViewById(R.id.btn_setDay);
        timeET = (TextView) findViewById(R.id.timeET);
        descr = (EditText)findViewById(R.id.descr);
        finish = (Button)findViewById(R.id.title_finish);


        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日");
        Date date = new Date(System.currentTimeMillis());
        timeET.setText(simpleDateFormat.format(date));
        btn_setDay.setOnClickListener(new View.OnClickListener() {

            final Calendar c = Calendar.getInstance();

            public int m_year =c.get(Calendar.YEAR);
            public int m_month = c.get(Calendar.MONTH);
            public int m_day = c.get(Calendar.DAY_OF_MONTH);

            public void onClick(View v) {
                if(v==btn_setDay) {
                    DatePickerDialog.OnDateSetListener dateListener = new DatePickerDialog.OnDateSetListener() {
                        @Override
                        public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                            m_year = year;
                            m_month = month+1;
                            m_day = dayOfMonth;
                            timeET.setText( m_year + "年" + m_month + "月" + m_day + "日");
                            t_year = m_year;
                            t_month = m_month;
                            t_day = m_day;
                        }
                    };
                    DatePickerDialog date = new DatePickerDialog(Add.this, dateListener, m_year, m_month, m_day);
                    date.setTitle("日期对话框");
                    date.show();
                }

            }
        });


        radiogroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener(){
            @Override
             public void onCheckedChanged(RadioGroup group, int checkId) {
                                switch (checkId){
                                    case R.id.btnX1:
                                        isOrNot = no.getText().toString();
                                                break;
                                    case R.id.btnX2:
                                        isOrNot = i_month.getText().toString();
                                                break;
                                    case R.id.btnX3:
                                        isOrNot = i_year.getText().toString();
                                        break;
                                        default:
                                                break;
                                    }
                            }
        });

        remind_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int pos, long id) {

                remindArray = getResources().getStringArray(R.array.remindArray);
                t_remind = remindArray[pos];
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Another interface callback
            }
        });

        tag_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                                       int pos, long id) {

                tagArray = getResources().getStringArray(R.array.tagArray);
                tag = tagArray[pos];
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Another interface callback
            }
        });

        finish.setOnClickListener(new Button.OnClickListener(){

            @Override
            public void onClick(View v) {
//                db.execSQL("insert into TB_anniversary(descr,isOrNot,t_year,t_month,t_day,t_remind,tag)" +
//                        "values(descr.getText().toString().trim(),'女',26)");
                ContentValues values = new ContentValues();
                values.put("descr", descr.getText().toString());
                values.put("isOrNot", isOrNot);
                values.put("t_year",t_year);
                values.put("t_month",t_month);
                values.put("t_day",t_day);
                values.put("t_remind",t_remind);
                values.put("tag",tag);
                db.insert("TB_anniversary",null,values);
                Toast.makeText(Add.this,"添加成功！",Toast.LENGTH_SHORT).show();
                finish();
//                db.execSQL("insert into TB_anniversary(descr,isOrNot,t_year,t_month,t_day,t_remind,tag) values('第五次添加','非纪念日',2021,6,6,'一天前提醒','私人')");
            }
        });

    }
//    //实现onTouchEvent触屏函数但点击屏幕时销毁本Activity
//    @Override
//    public boolean onTouchEvent(MotionEvent event){
//        finish();
//        return true;
//    }


}