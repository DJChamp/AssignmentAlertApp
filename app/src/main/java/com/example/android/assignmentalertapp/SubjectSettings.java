package com.example.android.assignmentalertapp;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.PrintWriter;

/**
 * Created by Montya on 30-10-2015.
 */
public class SubjectSettings extends AppCompatActivity {
    EditText th1, th2, th3, th4, th5, lab1, lab2, lab3, tut1, tut2;
    Button setsubs;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.subject_settings_layout);

        th1 = (EditText) findViewById(R.id.th_1);
        th2 = (EditText) findViewById(R.id.th_2);
        th3 = (EditText) findViewById(R.id.th_3);
        th4 = (EditText) findViewById(R.id.th_4);
        th5 = (EditText) findViewById(R.id.th_5);
        lab1 = (EditText) findViewById(R.id.lab_1);
        lab2 = (EditText) findViewById(R.id.lab_2);
        lab3 = (EditText) findViewById(R.id.lab_3);
        tut1 = (EditText) findViewById(R.id.tut_1);
        tut2 = (EditText) findViewById(R.id.tut_2);
        final DatabaseOperations DO = new DatabaseOperations(getBaseContext());
        final Cursor cr = DO.select_table(11);
        setsubs = (Button) findViewById(R.id.setSubjects);

        if (cr.getCount() == 10) {

            th1.setText(DO.getSubjectName(0));
            th2.setText(DO.getSubjectName(1));
            th3.setText(DO.getSubjectName(2));
            th4.setText(DO.getSubjectName(3));
            th5.setText(DO.getSubjectName(4));
            lab1.setText(DO.getSubjectName(5));
            lab2.setText(DO.getSubjectName(6));
            lab3.setText(DO.getSubjectName(7));
            tut1.setText(DO.getSubjectName(8));
            tut2.setText(DO.getSubjectName(9));
        }
        setsubs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                DO.deleteSubs();
                DO.putSubjects(th1.getText().toString());
                DO.putSubjects(th2.getText().toString());
                DO.putSubjects(th3.getText().toString());
                DO.putSubjects(th4.getText().toString());
                DO.putSubjects(th5.getText().toString());
                DO.putSubjects(lab1.getText().toString());
                DO.putSubjects(lab2.getText().toString());
                DO.putSubjects(lab3.getText().toString());
                DO.putSubjects(tut1.getText().toString());
                DO.putSubjects(tut2.getText().toString());
                Log.d("Count", cr.getCount() + "");
                //db.delete(TableData.Tableinfo.getTableName(11),null,null);

                finish();
            }
        });

    }

}
