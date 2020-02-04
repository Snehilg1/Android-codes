package com.example.jobscheduler;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.CompoundButton;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {
    String TAG="hello";
    ToggleButton tb;
    JobInfo ji;
    JobScheduler js;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.i(TAG, "onCreate: intiallising");
        tb=(ToggleButton)findViewById(R.id.tb);
        tb.setOnCheckedChangeListener(this);

        Log.i(TAG, "onCreate: service alloted");
        js=(JobScheduler)getSystemService(JOB_SCHEDULER_SERVICE);
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if(isChecked){
            JobInfo.Builder jb=new JobInfo.Builder(1,new ComponentName(getPackageName(),JobSch.class.getName()))
                    .setRequiresCharging(true)
                    .setRequiredNetworkType(JobInfo.NETWORK_TYPE_ANY)
                    .setRequiresDeviceIdle(false);

            Log.i(TAG, "onCheckedChanged: builder built");
            ji=jb.build();
            Log.i(TAG, "onCheckedChanged: going to schedule");
            js.schedule(ji);
        }
        else {
            Log.i(TAG, "onCheckedChanged: going to stop");
            js.cancelAll();
        }
    }
}
