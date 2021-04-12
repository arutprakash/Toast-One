package com.arut.toastone;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AlarmManager alarmMgr = (AlarmManager)this.getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(this, AlarmReceivers.class);
        PendingIntent alarmIntent = PendingIntent.getBroadcast(this, 0,intent , 0);


        Button button = (Button) findViewById(R.id.button_1);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //toastCountDown.start();
                alarmMgr.set(AlarmManager.ELAPSED_REALTIME_WAKEUP, SystemClock.elapsedRealtime() + 60 * 1000, alarmIntent);

            }
        });

    }
}