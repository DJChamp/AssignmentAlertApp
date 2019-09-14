package com.example.android.assignmentalertapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Montya on 22-10-2015.
 */
public class DisplayAssignment extends AppCompatActivity {

    TextView TitleText, InfoText, Date, Time;
    Button DEL;
    DatabaseOperations DO;
    int value, table;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display_assignment);

        TitleText = (TextView) findViewById(R.id.display_assignment_title);
        InfoText = (TextView) findViewById(R.id.display_assignment_info);
        Date = (TextView) findViewById(R.id.display_assignment_date);
        DEL = (Button) findViewById(R.id.delete_btn);
        Time = (TextView) findViewById(R.id.display_assignment_time);
        DO = new DatabaseOperations(this);
        Bundle extras = getIntent().getExtras();

        value = extras.getInt("id");
        table = extras.getInt("table");
        if (value >= 0) {
            TitleText.setText(DO.getTitle(value, table));
            InfoText.setText(DO.getAssignmentInfo(value, table));
            Date.setText(DO.getDate(value, table));
            Time.setText(DO.getTime(value, table));

        }
        DEL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DO.deleteAssignment(DO.getTitle(value, table), DO.getAssignmentInfo(value, table), table);
                Log.d("display", "deleted entry");
                finish();
            }
        });
    }

}
