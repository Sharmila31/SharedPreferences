package com.example.sharedpreferences.Controller;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.sharedpreferences.R;
import com.example.sharedpreferences.SqliteController.DBManager;
import com.example.sharedpreferences.SqliteController.StudentLogModel;

import org.w3c.dom.Text;

import java.util.Vector;

public class MainActivity extends AppCompatActivity {

    DBManager dbManager;
    Vector<StudentLogModel> studentLogModels;
    TextView UserId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SharedPreference.mSaveUserId("10001",MainActivity.this);

        initializeDB();
    }

    private void initializeDB() {
        UserId = findViewById(R.id.UserId);

        UserId.setText(SharedPreference.mGetUserId(MainActivity.this));


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
