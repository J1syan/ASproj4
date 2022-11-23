package com.example.provider;

import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

public class MyDAO {
    private Context context;
    private SQLiteDatabase database;

    public MyDAO(Context context) {
        this.context = context;
        MyDBHelper dBHelper = new MyDBHelper(context, "jsyDB", null, 1);
        database = dBHelper.getWritableDatabase();
    }

    public Uri DAOInsert(ContentValues contentValues) {
        long rowId=database.insert("student", null, contentValues);
//        Uri uri=Uri.parse("content://zt.provider2/student/10");//取第10行
        Uri uri=Uri.parse("content://jsy.provider2");
        Uri insertUri=ContentUris.withAppendedId(uri,rowId);
        context.getContentResolver().notifyChange(insertUri,null);
        return insertUri;
    }

}
