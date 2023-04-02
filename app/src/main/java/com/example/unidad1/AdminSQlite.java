package com.example.unidad1;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class AdminSQlite extends SQLiteOpenHelper {
    protected AdminSQlite(@Nullable Context context,
                          @Nullable String name,
                          @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("Create Table usuario(Documento interger primary key, nombre text, email text, pass text)");
        db.execSQL("insert into usuarios values('admin admin')");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("drop table if exists usuario");
        db.execSQL("Create Table usuario(documento interger primary key, nombre text, email text)");
        db.execSQL("insert into usuarios values('admin admin')");
    }
}

