package com.example.time;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBOpenHelper extends SQLiteOpenHelper {

    public DBOpenHelper(Context context, String name) {
        super(context, name, null, 1);
    }

    public DBOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory,
                        int version) {
        super(context, name, factory, version);
    }


    @Override
    // 首次创建数据库的时候调用 一般可以把建库 建表的操作
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table TB_anniversary(_id integer primary key autoincrement," +
                "descr text ,isOrNot text,t_year integer ,t_month integer ," +
                "t_day integer ,t_remind text ,tag text )");
//        db.execSQL("create table if not exists girldb(_id integer primary key autoincrement,name text not null,sex text not null,age integer not null)");
//        db.execSQL("insert into girldb(name,sex,age)values('baby','女',26)");
    }

    @Override
    // 当数据库的版本发生变化的时候 会自动执行
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

}
