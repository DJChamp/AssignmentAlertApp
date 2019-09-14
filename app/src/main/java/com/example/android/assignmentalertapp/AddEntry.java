package com.example.android.assignmentalertapp;

import android.annotation.TargetApi;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Random;

public class AddEntry extends AppCompatActivity {

    EditText titlePicker, infoPicker;
    DatePicker datePicker;
    Button ADD;
    TimePicker timePicker;
    String title, info, date, time;
    int alarmNum;
    public Context ctx = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_entry);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Bundle extras = getIntent().getExtras();
        final int button = extras.getInt("button");
        titlePicker = (EditText) findViewById(R.id.entry_title);
        infoPicker = (EditText) findViewById(R.id.entry_info);
        datePicker = (DatePicker) findViewById(R.id.entry_end_date);
        ADD = (Button) findViewById(R.id.entry_btn);
        timePicker = (TimePicker) findViewById(R.id.entry_time);

        ADD.setOnClickListener(new View.OnClickListener() {
            @TargetApi(Build.VERSION_CODES.M)
            @Override
            public void onClick(View view) {

                title = titlePicker.getText().toString();
                info = infoPicker.getText().toString();
                date = "" + datePicker.getDayOfMonth() + "/" + datePicker.getMonth() + "/" + datePicker.getYear();

                int hour = 0;
                int min = 0;

                int currentApiVersion = android.os.Build.VERSION.SDK_INT;
                if (currentApiVersion > android.os.Build.VERSION_CODES.LOLLIPOP_MR1) {
                    hour = timePicker.getHour();
                    min = timePicker.getMinute();
                    Log.d("Add Entry", "getTime");
                } else {
                    hour = timePicker.getCurrentHour();
                    min = timePicker.getCurrentMinute();
                    Log.d("Add Entry", "getCurrentTime");
                }
                time = hour + ":" + min;
                if ((title.equals("") || info.equals(""))) {
                    Toast.makeText(getBaseContext(), "Please fill all Details", Toast.LENGTH_SHORT).show();
                } else {
                    Random rd = new Random(10000); //to genetare alarm number
                    alarmNum = rd.nextInt();
                    DatabaseOperations DB = new DatabaseOperations(ctx);
                    DB.putInformation(DB, title, info, date, time, button, alarmNum);

                    Calendar calendar = Calendar.getInstance();
                    calendar.set(datePicker.getYear(), datePicker.getMonth(), datePicker.getDayOfMonth(), hour, min);
                    createAlarm(calendar, button);
    //                Log.d("Random no", "" + alarmNum);
                    Toast.makeText(getBaseContext(), "Entry added Successfully", Toast.LENGTH_SHORT).show();
                    finish();
                }

            }
        });

    }

    /*This function creates the alarm*/
    @TargetApi(Build.VERSION_CODES.KITKAT)
    void createAlarm(Calendar calender, int button) {
        Calendar cal = Calendar.getInstance();
        Intent intent = new Intent(ctx, AlarmPage.class);
        Bundle dataBundle = new Bundle();
        dataBundle.putString("title", title);
        dataBundle.putString("info", info);
        dataBundle.putString("date", date);
        dataBundle.putInt("alarmNum", alarmNum);
        dataBundle.putInt("table", button);
        dataBundle.putString("time",time);
        intent.putExtras(dataBundle);
        PendingIntent pendingIntent = PendingIntent.getActivity(ctx, alarmNum, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        AlarmManager am = (AlarmManager) getSystemService(ALARM_SERVICE);

        am.setExact(AlarmManager.RTC_WAKEUP, calender.getTimeInMillis(), pendingIntent);

//        Log.d("created alarm", "" + calender.getTimeInMillis());
  //      Log.d("current time alarm", "" + cal.getTimeInMillis());
    }

}
