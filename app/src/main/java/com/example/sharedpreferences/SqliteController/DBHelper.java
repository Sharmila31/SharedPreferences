package com.example.sharedpreferences.SqliteController;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    static final String DB_NAME = "Student_DB";
    static final int DB_Version = 1;


    public static final String Log_Table = "stu_Log";
    public static final String Marks_Table = "stu_Marks";

    //Log_Table columns
    public static final String ID = "stu_id", NAME = "stu_name";

    private static final String Create_Log_Table = "Create table " + Log_Table + "(" + ID + " INTEGER Primary Key AUTOINCREMENT," + NAME + " TEXT Not null)";

    //Marks_Table columns
    public static final String stu_Id = "stu_Id";
    public static final String sub_English = "sub_Eng";
    public static final String sub_Maths = "sub_Maths";
    public static final String stu_Total_Marks = "stu_TotalMarks";

    private static final String Create_Marks_Table = "Create table " + Marks_Table
            + "(" + sub_English + " INTEGER," + sub_Maths + " INTEGER," + stu_Total_Marks
            + " INTEGER,"+stu_Id+" INTEGER ,FOREIGN KEY (" + stu_Id + ") REFERENCES " + DBHelper.Log_Table + "(" + DBHelper.ID + "))";

    public DBHelper(@Nullable Context context) {
        super(context, DB_NAME, null, DB_Version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        if (sqLiteDatabase != null) {
            sqLiteDatabase.execSQL(Create_Log_Table);

            sqLiteDatabase.execSQL(Create_Marks_Table);
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
