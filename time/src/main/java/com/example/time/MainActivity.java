package com.example.time;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionbar=getSupportActionBar();
        if(actionbar!=null)
        {
            actionbar.hide();
        }
        final Button page_Fragment0 = (Button)findViewById(R.id.page_Fragment0);
        Button tianjia = (Button)findViewById(R.id.title_2);

        final Button page_Fragment2 = (Button)findViewById(R.id.page_Fragment2);
        final Button page_Fragment3 = (Button)findViewById(R.id.page_Fragment3);
        TextView setText = (TextView) findViewById(R.id.title_text);

        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        Fragment0 frag0 = new Fragment0();
        transaction.add(R.id.fragment_container, frag0);
        transaction.commit();

        Button page_Fragment1 = (Button)findViewById(R.id.tianjia);


        tianjia.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        Intent intent=new Intent(MainActivity.this, Add.class);
                        startActivity(intent);
                    }
                });
        page_Fragment0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setText.setText("时间线");
                page_Fragment0.setBackgroundColor(getResources().getColor(R.color.white));
                page_Fragment2.setBackgroundColor(getResources().getColor(R.color.oliveLight));
                page_Fragment3.setBackgroundColor(getResources().getColor(R.color.oliveLight));

                page_Fragment0.setTextColor(getResources().getColor(R.color.black));
                page_Fragment2.setTextColor(getResources().getColor(R.color.black));
                page_Fragment3.setTextColor(getResources().getColor(R.color.black));

                FragmentManager manager = getSupportFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();
                Fragment0 frag0 = new Fragment0();
                transaction.replace(R.id.fragment_container, frag0);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        page_Fragment2.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                setText.setText("纪念日");
                page_Fragment2.setBackgroundColor(getResources().getColor(R.color.white));
                page_Fragment0.setBackgroundColor(getResources().getColor(R.color.oliveLight));
                page_Fragment3.setBackgroundColor(getResources().getColor(R.color.oliveLight));

                page_Fragment2.setTextColor(getResources().getColor(R.color.black));
                page_Fragment0.setTextColor(getResources().getColor(R.color.black));
                page_Fragment3.setTextColor(getResources().getColor(R.color.black));

                FragmentManager manager = getSupportFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();
                Fragment2 frag2 = new Fragment2();
                transaction.replace(R.id.fragment_container, frag2);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        page_Fragment3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setText.setText("我的");
                page_Fragment3.setBackgroundColor(getResources().getColor(R.color.white));
                page_Fragment0.setBackgroundColor(getResources().getColor(R.color.oliveLight));
                page_Fragment2.setBackgroundColor(getResources().getColor(R.color.oliveLight));

                page_Fragment3.setTextColor(getResources().getColor(R.color.black));
                page_Fragment0.setTextColor(getResources().getColor(R.color.black));
                page_Fragment2.setTextColor(getResources().getColor(R.color.black));

                FragmentManager manager = getSupportFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();
                Fragment3 frag3 = new Fragment3();
                transaction.replace(R.id.fragment_container, frag3);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });


    }
}
