package com.example.time;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

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

        final Button page_Fragment1 = (Button)findViewById(R.id.page_Fragment1);
        final Button page_Fragment2 = (Button)findViewById(R.id.page_Fragment2);
        final Button page_Fragment3 = (Button)findViewById(R.id.page_Fragment3);
        Button title_2=(Button)findViewById(R.id.title_2);

        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        Fragment1 frag1 = new Fragment1();
        transaction.add(R.id.fragment_container, frag1);
        transaction.commit();

        page_Fragment1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                page_Fragment1.setBackgroundColor(getResources().getColor(R.color.gray));
                page_Fragment2.setBackgroundColor(getResources().getColor(R.color.oliveLight));
                page_Fragment3.setBackgroundColor(getResources().getColor(R.color.oliveLight));

                page_Fragment1.setTextColor(getResources().getColor(R.color.white));
                page_Fragment2.setTextColor(getResources().getColor(R.color.black));
                page_Fragment3.setTextColor(getResources().getColor(R.color.black));

                FragmentManager manager = getSupportFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();
                Fragment1 frag1 = new Fragment1();
                transaction.replace(R.id.fragment_container, frag1);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        page_Fragment2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                page_Fragment2.setBackgroundColor(getResources().getColor(R.color.gray));
                page_Fragment1.setBackgroundColor(getResources().getColor(R.color.oliveLight));
                page_Fragment3.setBackgroundColor(getResources().getColor(R.color.oliveLight));

                page_Fragment2.setTextColor(getResources().getColor(R.color.white));
                page_Fragment1.setTextColor(getResources().getColor(R.color.black));
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
                page_Fragment3.setBackgroundColor(getResources().getColor(R.color.gray));
                page_Fragment1.setBackgroundColor(getResources().getColor(R.color.oliveLight));
                page_Fragment2.setBackgroundColor(getResources().getColor(R.color.oliveLight));

                page_Fragment3.setTextColor(getResources().getColor(R.color.white));
                page_Fragment1.setTextColor(getResources().getColor(R.color.black));
                page_Fragment2.setTextColor(getResources().getColor(R.color.black));

                FragmentManager manager = getSupportFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();
                Fragment3 frag3 = new Fragment3();
                transaction.replace(R.id.fragment_container, frag3);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
        title_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,Add.class);
                startActivity(intent);
            }
        });

    }
}
