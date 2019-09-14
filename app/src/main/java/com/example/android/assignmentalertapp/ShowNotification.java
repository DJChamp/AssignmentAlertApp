package com.example.android.assignmentalertapp;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Montya on 10-12-2015.
 */
public class ShowNotification extends AppCompatActivity {

    TextView TitleText, InfoText, Date, Time;
    Button btn;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.display_assignment);

        TitleText = (TextView) findViewById(R.id.display_assignment_title);
        InfoText = (TextView) findViewById(R.id.display_assignment_info);
        Date = (TextView) findViewById(R.id.display_assignment_date);
        btn = (Button) findViewById(R.id.delete_btn);
        Time = (TextView) findViewById(R.id.display_assignment_time);

        Bundle extras = getIntent().getExtras();
        btn.setVisibility(View.GONE);
        TitleText.setText(extras.getString("title"));
        InfoText.setText(extras.getString("info"));
        Date.setText(extras.getString("date"));
        Time.setText(extras.getString("time"));
    }
}
