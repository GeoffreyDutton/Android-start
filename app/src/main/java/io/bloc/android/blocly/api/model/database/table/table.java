package io.bloc.android.blocly.api.model.database.table;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by Geoff on 3/20/2017.
 */

public abstract class Table {

    public static interface Builder{
        public long insert(SQLiteDatabase writableDB);
    }

    protected static final String COLUMN_ID = "id";
    public abstract String getName();
    public abstract String getCreateStatement();

    public void onUpgrade(SQLiteDatabase writableDatabse, int oldVersion, int newVersion ){

    }

    public Cursor fetchRow(SQLiteDatabase readonlyDatabase, long rowID){
        return readonlyDatabase.query(true, getName(), null, COLUMN_ID + " = ?",
                new String[]{String.valueOf(rowID)},null,null,null, null);
    }

    protected static String getString(Cursor cursor, String column){
        int columnIndex = cursor.getColumnIndex(column);
        if(columnIndex == -1){
            return "";
        }
        return cursor.getString(columnIndex);
    }

    protected static long getLong(Cursor cursor, String column){
        int columnIndex = cursor.getColumnIndex(column);
        if(columnIndex == -1){
            return -1;
        }
        return cursor.getLong(columnIndex);
    }

    protected static boolean getBoolean(Cursor cursor, String column){
        return getLong(cursor,column) == 1l;
    }
}
