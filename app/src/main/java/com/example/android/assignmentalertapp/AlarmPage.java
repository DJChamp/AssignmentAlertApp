package com.example.android.assignmentalertapp;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.PowerManager;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Montya on 27-10-2015.
 */
public class AlarmPage extends AppCompatActivity {
    MediaPlayer mp;
    PowerManager.WakeLock wakeLock;
    TextView title, info, date;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alarm_page_layout);

        title = (TextView) findViewById(R.id.alarm_title);
        info = (TextView) findViewById(R.id.alarm_info);
        date = (TextView) findViewById(R.id.alarm_date);

        final Bundle extras = getIntent().getExtras();
        int table = extras.getInt("table");
        int alarmNum = extras.getInt("alarmNum");

        DatabaseOperations DO = new DatabaseOperations(this);
        Cursor cr = DO.select_table(table);
        cr.moveToFirst();
        int alarm;
        boolean flag = false;

        while (!cr.isAfterLast()) {

            alarm = cr.getInt(cr.getColumnIndex(TableData.Tableinfo.ASSIGNMENT_ALARM_NUM));
            if (alarmNum == alarm) {
                flag = true;
                break;
            }
            cr.moveToNext();
        }
        if (flag) {
            mp = MediaPlayer.create(this, R.raw.matar);
            mp.start();
            PowerManager pm = (PowerManager) getSystemService(Context.POWER_SERVICE);
            wakeLock = pm.newWakeLock(PowerManager.FULL_WAKE_LOCK | PowerManager.ACQUIRE_CAUSES_WAKEUP,
                    "My wakelook");
            if(!wakeLock.isHeld())
                wakeLock.acquire();

            title.setText(extras.getString("title"));
            info.setText(extras.getString("info"));
            date.setText(extras.getString("date"));

            new CountDownTimer(50000, 1000) {
                public void onFinish() {
                    if(wakeLock.isHeld())
                        wakeLock.release();
                    try {
                        if (mp != null) {
                            if (mp.isPlaying()) {
                                mp.stop();
                                mp.release();
                            }
                            createNotification();
                        }
                    }catch (IllegalStateException ie)
                    {}

                    finish();

                    // When timer is finished
                    // Execute your code here
                }

                public void onTick(long millisUntilFinished) {
                    // millisUntilFinished    The amount of time until finished.
                }
            }.start();
        } else {
            Log.d("AlarmPage", "No alarm");
            finish();
        }
    }

    public void stopAlarm(View view) {
        if(wakeLock.isHeld())
            wakeLock.release();
        if(mp != null) {
            if (mp.isPlaying()) {
                mp.stop();
                mp.release();
            }
        }
        finish();
    }

    public void createNotification() {
        Bundle extras = getIntent().getExtras();
        NotificationCompat.Builder n = new NotificationCompat.Builder(this);
        n.setContentTitle(extras.getString("title"));
        n.setContentText(extras.getString("info"));
        n.setSmallIcon(R.mipmap.ic_launcher);
        n.setAutoCancel(true);
        Intent intent = new Intent(this, ShowNotification.class);

        Bundle bundle;
        bundle = getIntent().getExtras();
        intent.putExtras(bundle);
        PendingIntent pt = PendingIntent.getActivity(this, 1, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        n.setContentIntent(pt);

        Notification no = n.build();

        NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        nm.notify(1, no);
    }
}
