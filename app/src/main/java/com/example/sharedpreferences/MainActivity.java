package com.example.sharedpreferences;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.sharedpreferences.SqliteController.DBManager;
import com.example.sharedpreferences.SqliteController.StudentLogModel;

import java.util.Vector;

public class MainActivity extends AppCompatActivity {

    DBManager dbManager;
    Vector<StudentLogModel> studentLogModels;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeDB();
    }

    private void initializeDB() {

        try {
            if (dbManager == null)
                dbManager = new DBManager(this);

            dbManager.open();

            insertStuRecords();

            getStudentsListFromDB();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private void insertStuRecords() {

        if (dbManager!=null)

            try {
                dbManager.insertIntoStudentLogTable("Sharmila");
                dbManager.insertIntoStudentLogTable("Venkateshwari");
                dbManager.insertIntoStudentLogTable("Subbu");
                dbManager.insertIntoStudentLogTable("Arjun");
            }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private void getStudentsListFromDB() {

        if (dbManager!=null)
        {
            studentLogModels = dbManager.fetchFromLogDB();

        }
    }

}
