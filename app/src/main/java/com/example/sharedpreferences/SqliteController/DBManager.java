package com.example.sharedpreferences.SqliteController;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.sql.SQLException;
import java.util.Vector;

public class DBManager {

    Context context;
    DBHelper dbHelper;
    SQLiteDatabase database;

    public DBManager(Context c) {
        context = c;
    }

    public DBManager open() throws SQLException {
        dbHelper = new DBHelper(context);
        database = dbHelper.getWritableDatabase();
        return this;
    }

    public void close() {
        dbHelper.close();
    }

    public void insertIntoStudentLogTable(String name) {
        ContentValues contentValue = new ContentValues();
        contentValue.put(DBHelper.NAME, name);
        database.insert(DBHelper.Log_Table, null, contentValue);
    }

    public Vector<StudentLogModel> fetchFromLogDB() {

        Cursor cursor = null;

        String[] columns = new String[] { DBHelper.ID, DBHelper.NAME };

        Vector<StudentLogModel> studentLogs = new Vector<>();

        if (database!=null) {

            cursor = database.query(DBHelper.Log_Table, columns, null, null, null, null, null);

            if (cursor != null) {
                cursor.moveToFirst();



                do {
                    StudentLogModel studentLogModel = new StudentLogModel();

                    studentLogModel.setID(cursor.getInt(cursor.getColumnIndex(DBHelper.ID)));

                    studentLogModel.setName(cursor.getString(cursor.getColumnIndex(DBHelper.NAME)));

                    studentLogs.add(studentLogModel);
                }while (cursor.moveToNext());

            }
        }
        return studentLogs;
    }

    public int update(int id, String name) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DBHelper.NAME, name);

        //Example
        return database.update(DBHelper.Log_Table, contentValues, DBHelper.ID + " = " + 1, null);
    }

    public int delete(int _id) {
        return database.delete(DBHelper.Log_Table, DBHelper.ID + "=" + _id, null);
    }
}
