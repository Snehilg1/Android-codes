package com.example.jobscheduler;

import android.app.Service;
import android.app.job.JobParameters;
import android.app.job.JobScheduler;
import android.app.job.JobService;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

public class JobSch extends JobService {
    String TAG="okay";
    public JobSch() {
    }

    @Override
    public boolean onStartJob(JobParameters params) {
        Log.i(TAG, "onStartJob: start job");
        Toast.makeText(this,"Job Started",Toast.LENGTH_SHORT).show();
        return false;
    }

    @Override
    public boolean onStopJob(JobParameters params) {
        Log.i(TAG, "onStopJob: stop job");
        Toast.makeText(this,"Job Stopped",Toast.LENGTH_SHORT).show();
        return false;
    }
}
