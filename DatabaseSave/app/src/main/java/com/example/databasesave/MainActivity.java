package com.example.databasesave;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btn_create, btn_add, btn_update, btn_delete, btn_query;
    private MyDatabaseHelper helper;
    public static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        initView();//初始化UI控件
    }

    private void initData() {
        helper = new MyDatabaseHelper(MainActivity.this, "BookStore.db", null, 2);
    }

    private void initView() {
        btn_create = (Button) findViewById(R.id.btn_create);
        btn_add = (Button) findViewById(R.id.btn_add);
        btn_update = (Button) findViewById(R.id.btn_update);
        btn_delete = (Button) findViewById(R.id.btn_delete);
        btn_query = (Button) findViewById(R.id.btn_query);

        btn_create.setOnClickListener(this);
        btn_add.setOnClickListener(this);
        btn_update.setOnClickListener(this);
        btn_delete.setOnClickListener(this);
        btn_query.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_create:
                helper.getWritableDatabase();//以可写的方式，创建或打开数据库
                break;
            case R.id.btn_add:
                addData();//添加数据
                Toast.makeText(this, "Add Data successfully", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_update:
                updateData();//更新数据
                Toast.makeText(this, "Update Data successfully", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_delete:
                deleteData();//删除数据
                Toast.makeText(this, "Delete Data successfully", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_query:
                queryData();//查询数据
                Toast.makeText(this, "Query Data successfully", Toast.LENGTH_SHORT).show();
                break;
        }
    }


    private void addData() {
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues cv = new ContentValues();
        //开始组装第一条数据
        cv.put("name", "Math");
        cv.put("author", "Dan Brown");
        cv.put("pages", 300);
        cv.put("price", 10.00);
        db.insert("Book", null, cv);
        cv.clear();

        //开始组装第二条数据
        cv.put("name", "English");
        cv.put("author", "Dan Brown");
        cv.put("pages", 510);
        cv.put("price", 20.00);
        db.insert("Book", null, cv);
    }

    private void updateData() {
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("price", 15.00);
        db.update("Book", cv, "name=?", new String[]{"The Da Vinci Code"});
    }

    private void deleteData() {
        SQLiteDatabase db = helper.getWritableDatabase();
        db.delete("Book", "pages>?", new String[]{"100"});//删除Book表中pages>500的这一行数据。
    }

    private void queryData() {
        SQLiteDatabase db = helper.getWritableDatabase();
        //查询Book表中的所有数据
        Cursor cursor = db.query("Book", null, null, null, null, null, null);
        if (cursor.moveToFirst()) {
            do {
                //遍历Cursor对象，取出数据并打印
                String name = cursor.getString(cursor.getColumnIndex("name"));
                String author = cursor.getString(cursor.getColumnIndex("author"));
                int pages = cursor.getInt(cursor.getColumnIndex("pages"));
                double price = cursor.getDouble(cursor.getColumnIndex("price"));
                Log.e(TAG, "name: " + name);
                Log.e(TAG, "author: " + author);
                Log.e(TAG, "pages: " + pages);
                Log.e(TAG, "price: " + price);
            } while (cursor.moveToNext());
        }
        cursor.close();
    }

}