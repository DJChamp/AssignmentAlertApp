package com.example.android.assignmentalertapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;


/**
 * Created by Montya on 22-10-2015.
 */
public class DatabaseOperations extends SQLiteOpenHelper {
    public static final int database_version = 1;
    public String CREATE_QUERY_1 = "CREATE TABLE " + TableData.Tableinfo.TABLE_NAME_1 + "(" + TableData.Tableinfo.ASSIGNMENT_TITLE + " TEXT," + TableData.Tableinfo.ASSIGNMENT_INFO + " TEXT," + TableData.Tableinfo.ASSIGNMENT_END_DATE + " TEXT," + TableData.Tableinfo.ASSIGNMENT_TIME + " TEXT," + TableData.Tableinfo.ASSIGNMENT_ALARM_NUM + " INTEGER);";
    public String CREATE_QUERY_2 = "CREATE TABLE " + TableData.Tableinfo.TABLE_NAME_2 + "(" + TableData.Tableinfo.ASSIGNMENT_TITLE + " TEXT," + TableData.Tableinfo.ASSIGNMENT_INFO + " TEXT," + TableData.Tableinfo.ASSIGNMENT_END_DATE + " TEXT," + TableData.Tableinfo.ASSIGNMENT_TIME + " TEXT," + TableData.Tableinfo.ASSIGNMENT_ALARM_NUM + " INTEGER);";
    public String CREATE_QUERY_3 = "CREATE TABLE " + TableData.Tableinfo.TABLE_NAME_3 + "(" + TableData.Tableinfo.ASSIGNMENT_TITLE + " TEXT," + TableData.Tableinfo.ASSIGNMENT_INFO + " TEXT," + TableData.Tableinfo.ASSIGNMENT_END_DATE + " TEXT," + TableData.Tableinfo.ASSIGNMENT_TIME + " TEXT," + TableData.Tableinfo.ASSIGNMENT_ALARM_NUM + " INTEGER);";
    public String CREATE_QUERY_4 = "CREATE TABLE " + TableData.Tableinfo.TABLE_NAME_4 + "(" + TableData.Tableinfo.ASSIGNMENT_TITLE + " TEXT," + TableData.Tableinfo.ASSIGNMENT_INFO + " TEXT," + TableData.Tableinfo.ASSIGNMENT_END_DATE + " TEXT," + TableData.Tableinfo.ASSIGNMENT_TIME + " TEXT," + TableData.Tableinfo.ASSIGNMENT_ALARM_NUM + " INTEGER);";
    public String CREATE_QUERY_5 = "CREATE TABLE " + TableData.Tableinfo.TABLE_NAME_5 + "(" + TableData.Tableinfo.ASSIGNMENT_TITLE + " TEXT," + TableData.Tableinfo.ASSIGNMENT_INFO + " TEXT," + TableData.Tableinfo.ASSIGNMENT_END_DATE + " TEXT," + TableData.Tableinfo.ASSIGNMENT_TIME + " TEXT," + TableData.Tableinfo.ASSIGNMENT_ALARM_NUM + " INTEGER);";
    public String CREATE_QUERY_6 = "CREATE TABLE " + TableData.Tableinfo.TABLE_NAME_6 + "(" + TableData.Tableinfo.ASSIGNMENT_TITLE + " TEXT," + TableData.Tableinfo.ASSIGNMENT_INFO + " TEXT," + TableData.Tableinfo.ASSIGNMENT_END_DATE + " TEXT," + TableData.Tableinfo.ASSIGNMENT_TIME + " TEXT," + TableData.Tableinfo.ASSIGNMENT_ALARM_NUM + " INTEGER);";
    public String CREATE_QUERY_7 = "CREATE TABLE " + TableData.Tableinfo.TABLE_NAME_7 + "(" + TableData.Tableinfo.ASSIGNMENT_TITLE + " TEXT," + TableData.Tableinfo.ASSIGNMENT_INFO + " TEXT," + TableData.Tableinfo.ASSIGNMENT_END_DATE + " TEXT," + TableData.Tableinfo.ASSIGNMENT_TIME + " TEXT," + TableData.Tableinfo.ASSIGNMENT_ALARM_NUM + " INTEGER);";
    public String CREATE_QUERY_8 = "CREATE TABLE " + TableData.Tableinfo.TABLE_NAME_8 + "(" + TableData.Tableinfo.ASSIGNMENT_TITLE + " TEXT," + TableData.Tableinfo.ASSIGNMENT_INFO + " TEXT," + TableData.Tableinfo.ASSIGNMENT_END_DATE + " TEXT," + TableData.Tableinfo.ASSIGNMENT_TIME + " TEXT," + TableData.Tableinfo.ASSIGNMENT_ALARM_NUM + " INTEGER);";
    public String CREATE_QUERY_9 = "CREATE TABLE " + TableData.Tableinfo.TABLE_NAME_9 + "(" + TableData.Tableinfo.ASSIGNMENT_TITLE + " TEXT," + TableData.Tableinfo.ASSIGNMENT_INFO + " TEXT," + TableData.Tableinfo.ASSIGNMENT_END_DATE + " TEXT," + TableData.Tableinfo.ASSIGNMENT_TIME + " TEXT," + TableData.Tableinfo.ASSIGNMENT_ALARM_NUM + " INTEGER);";
    public String CREATE_QUERY_10 = "CREATE TABLE " + TableData.Tableinfo.TABLE_NAME_10 + "(" + TableData.Tableinfo.ASSIGNMENT_TITLE + " TEXT," + TableData.Tableinfo.ASSIGNMENT_INFO + " TEXT," + TableData.Tableinfo.ASSIGNMENT_END_DATE + " TEXT," + TableData.Tableinfo.ASSIGNMENT_TIME + " TEXT," + TableData.Tableinfo.ASSIGNMENT_ALARM_NUM + " INTEGER);";

    public String Subject_Query = "CREATE TABLE " + TableData.Tableinfo.TABLE_NAME_SUB + "(" + TableData.Tableinfo.SUBJECT_NAMES + " TEXT);";

    public DatabaseOperations(Context context) {
        super(context, TableData.Tableinfo.DATABASE_NAME, null, database_version);
        Log.d("Database Operations", "Database created");
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {


        sqLiteDatabase.execSQL(CREATE_QUERY_1);
        sqLiteDatabase.execSQL(CREATE_QUERY_2);
        sqLiteDatabase.execSQL(CREATE_QUERY_3);
        sqLiteDatabase.execSQL(CREATE_QUERY_4);
        sqLiteDatabase.execSQL(CREATE_QUERY_5);
        sqLiteDatabase.execSQL(CREATE_QUERY_6);
        sqLiteDatabase.execSQL(CREATE_QUERY_7);
        sqLiteDatabase.execSQL(CREATE_QUERY_8);
        sqLiteDatabase.execSQL(CREATE_QUERY_9);
        sqLiteDatabase.execSQL(CREATE_QUERY_10);
        sqLiteDatabase.execSQL(Subject_Query);
        Log.d("Database Operations", "Table created");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void putInformation(DatabaseOperations dop, String title, String info, String date, String time, int table, int alarmNum) {
        SQLiteDatabase SQ = dop.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(TableData.Tableinfo.ASSIGNMENT_TITLE, title);
        cv.put(TableData.Tableinfo.ASSIGNMENT_INFO, info);
        cv.put(TableData.Tableinfo.ASSIGNMENT_END_DATE, date);
        cv.put(TableData.Tableinfo.ASSIGNMENT_TIME, time);
        cv.put(TableData.Tableinfo.ASSIGNMENT_ALARM_NUM, alarmNum);
        switch (table) {
            case 1:
                SQ.insert(TableData.Tableinfo.TABLE_NAME_1, null, cv);
                break;
            case 2:
                SQ.insert(TableData.Tableinfo.TABLE_NAME_2, null, cv);
                break;
            case 3:
                SQ.insert(TableData.Tableinfo.TABLE_NAME_3, null, cv);
                break;
            case 4:
                SQ.insert(TableData.Tableinfo.TABLE_NAME_4, null, cv);
                break;
            case 5:
                SQ.insert(TableData.Tableinfo.TABLE_NAME_5, null, cv);
                break;
            case 6:
                SQ.insert(TableData.Tableinfo.TABLE_NAME_6, null, cv);
                break;
            case 7:
                SQ.insert(TableData.Tableinfo.TABLE_NAME_7, null, cv);
                break;
            case 8:
                SQ.insert(TableData.Tableinfo.TABLE_NAME_8, null, cv);
                break;
            case 9:
                SQ.insert(TableData.Tableinfo.TABLE_NAME_9, null, cv);
                break;
            case 10:
                SQ.insert(TableData.Tableinfo.TABLE_NAME_10, null, cv);
                break;
        }

        Log.d("Database Operations", "One row inserted");
    }

    public ArrayList<String> getAllTitles(int table) {
        ArrayList<String> array_list = new ArrayList<String>();

        Cursor res = select_table(table);
        res.moveToFirst();

        while (res.isAfterLast() == false) {
            array_list.add(res.getString(res.getColumnIndex(TableData.Tableinfo.ASSIGNMENT_TITLE)));
            res.moveToNext();
        }
        res.close();
        return array_list;
    }

    public String getTitle(int value, int table) {

        Cursor res = select_table(table);
        res.moveToPosition(value);
        String title = res.getString(res.getColumnIndex(TableData.Tableinfo.ASSIGNMENT_TITLE));
        res.close();
        return title;
    }

    public String getAssignmentInfo(int value, int table) {
        Cursor res = select_table(table);
        res.moveToPosition(value);
        String title = res.getString(res.getColumnIndex(TableData.Tableinfo.ASSIGNMENT_INFO));
        res.close();
        return title;
    }

    public String getDate(int value, int table) {
        Cursor res = select_table(table);
        res.moveToPosition(value);
        String title = res.getString(res.getColumnIndex(TableData.Tableinfo.ASSIGNMENT_END_DATE));
        res.close();
        return title;
    }

    public String getTime(int value, int table) {
        Cursor res = select_table(table);
        res.moveToPosition(value);
        String time = res.getString(res.getColumnIndex(TableData.Tableinfo.ASSIGNMENT_TIME));
        res.close();
        return time;
    }

    public int getAlarmNumber(int value, int table) {
        Cursor res = select_table(table);
        res.moveToPosition(value);
        int alarmNum = res.getInt(res.getColumnIndex(TableData.Tableinfo.ASSIGNMENT_ALARM_NUM));
        res.close();
        return alarmNum;
    }

    public void deleteAssignment(String title, String info, int table) {
        SQLiteDatabase db = this.getReadableDatabase();
        String selection = TableData.Tableinfo.ASSIGNMENT_TITLE + " LIKE ? AND " + TableData.Tableinfo.ASSIGNMENT_INFO + " LIKE ?";
        String args[] = {title, info};

        db.delete(TableData.Tableinfo.getTableName(table), selection, args);

    }

    public String getSubjectName(int value) {
        String name = "";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("select * from " + TableData.Tableinfo.TABLE_NAME_SUB, null);
        res.moveToPosition(value);
        name = res.getString(res.getColumnIndex(TableData.Tableinfo.SUBJECT_NAMES));
        return name;
    }

    public void putSubjects(String name)//String th1,String th2,String th3,String th4,String th5,String lab1,String lab2,String lab3,String tut1,String tut2)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(TableData.Tableinfo.SUBJECT_NAMES, name);

        db.insert(TableData.Tableinfo.TABLE_NAME_SUB, null, cv);
    }

    public void deleteSubs() {
        SQLiteDatabase db = this.getReadableDatabase();
        db.delete(TableData.Tableinfo.TABLE_NAME_SUB, null, null);
    }

    public Cursor select_table(int table) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("select * from " + TableData.Tableinfo.TABLE_NAME_1, null);
        switch (table) {
            case 1:
                res = db.rawQuery("select * from " + TableData.Tableinfo.TABLE_NAME_1, null);
                break;
            case 2:
                res = db.rawQuery("select * from " + TableData.Tableinfo.TABLE_NAME_2, null);
                break;
            case 3:
                res = db.rawQuery("select * from " + TableData.Tableinfo.TABLE_NAME_3, null);
                break;
            case 4:
                res = db.rawQuery("select * from " + TableData.Tableinfo.TABLE_NAME_4, null);
                break;
            case 5:
                res = db.rawQuery("select * from " + TableData.Tableinfo.TABLE_NAME_5, null);
                break;
            case 6:
                res = db.rawQuery("select * from " + TableData.Tableinfo.TABLE_NAME_6, null);
                break;
            case 7:
                res = db.rawQuery("select * from " + TableData.Tableinfo.TABLE_NAME_7, null);
                break;
            case 8:
                res = db.rawQuery("select * from " + TableData.Tableinfo.TABLE_NAME_8, null);
                break;
            case 9:
                res = db.rawQuery("select * from " + TableData.Tableinfo.TABLE_NAME_9, null);
                break;
            case 10:
                res = db.rawQuery("select * from " + TableData.Tableinfo.TABLE_NAME_10, null);
                break;
            case 11:
                res = db.rawQuery("select * from " + TableData.Tableinfo.TABLE_NAME_SUB, null);
                break;
        }
        return res;
    }
}
