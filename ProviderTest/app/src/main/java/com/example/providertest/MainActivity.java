package com.example.providertest;


import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "MainActivity";
    private Button btn_add, btn_query, btn_update, btn_delete;
    private String newId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();//初始化UI控件
    }

    private void initView() {
        btn_add = (Button) findViewById(R.id.btn_add);
        btn_query = (Button) findViewById(R.id.btn_query);
        btn_update = (Button) findViewById(R.id.btn_update);
        btn_delete = (Button) findViewById(R.id.btn_delete);

        btn_add.setOnClickListener(this);
        btn_query.setOnClickListener(this);
        btn_update.setOnClickListener(this);
        btn_delete.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_add:
                add();//添加数据
                Toast.makeText(this, "add successfully", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_query:
                query();//查询数据
                Toast.makeText(this, "query successfully", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_update:
                update();//更新数据
                Toast.makeText(this, "update successfully", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_delete:
                delete();//删除数据
                Toast.makeText(this, "delete successfully", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
    }


    private void add() {
        Uri uri = Uri.parse("content://com.example.databasesave.provider/book");
        ContentValues cv = new ContentValues();
        cv.put("name", "Chinese");
        cv.put("author", "George Martin");
        cv.put("pages", 1000);
        cv.put("price", 32.85);
        Uri newUri = getContentResolver().insert(uri, cv);
        newId = newUri.getPathSegments().get(1);
    }

    private void query() {
        Uri uri = Uri.parse("content://com.example.databasesave.provider/book");
        Cursor cursor = getContentResolver().query(uri, null, null, null, null);
        if (cursor != null) {
            while (cursor.moveToNext()) {
                String name = cursor.getString(cursor.getColumnIndex("name"));
                String author = cursor.getString(cursor.getColumnIndex("author"));
                int pages = cursor.getInt(cursor.getColumnIndex("pages"));
                double price = cursor.getDouble(cursor.getColumnIndex("price"));
                Log.e(TAG, "book name is " + name);
                Log.e(TAG, "book author is " + author);
                Log.e(TAG, "book pages are " + pages);
                Log.e(TAG, "book price is " + price);
            }
            cursor.close();
        }
    }

    private void update() {
        Uri uri = Uri.parse("content://com.example.databasesave.provider/book/" + newId);
        ContentValues cv = new ContentValues();
        cv.put("name", "Sports");
        cv.put("pages", 1100);
        cv.put("price", 24.05);
        getContentResolver().update(uri, cv, null, null);
    }

    private void delete() {
        Uri uri = Uri.parse("content://com.example.databasesave.provider/book/" + newId);
        getContentResolver().delete(uri, null, null);
    }
}