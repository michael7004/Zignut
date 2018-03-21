package com.zignut.jobscheduler;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.os.AsyncTask;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.Log;
import android.widget.Toast;

import com.zignut.database.AppDatabase;
import com.zignut.model.AddressModel;

import java.util.ArrayList;

/**
 * Created by Lenovo on 20-03-2018.
 */

@RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
public class JobSchedulerPeriodic extends JobService {
    JobParameters params;
    DoItTask doIt;

    @Override
    public boolean onStartJob(JobParameters params) {
        this.params = params;
        Toast.makeText(this, "Job Startes", Toast.LENGTH_SHORT).show();
        Log.d("TestService", "Work to be called from here");
        doIt = new DoItTask();
        doIt.execute();
        return false;
    }

    @Override
    public boolean onStopJob(JobParameters params) {
        Log.d("TestService", "System calling to stop the job here");
        if (doIt != null)
            doIt.cancel(true);
        return false;
    }

    private class DoItTask extends AsyncTask<Void, Void, Void> {

        AddressModel addressModel = new AddressModel();
        ArrayList<AddressModel> addressModelArrayList = new ArrayList<>(10);


        @Override
        protected Void doInBackground(Void... params) {
            Log.d("DoItTask", "Working here...");

            addressModelArrayList = AddressModel.getDummyData();
            AppDatabase.getAppDatabase(JobSchedulerPeriodic.this).addressModelDao().insertAddressDB(addressModelArrayList);
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {

            Toast.makeText(JobSchedulerPeriodic.this, "Job finished", Toast.LENGTH_SHORT).show();
            Log.d("DoItTask", "Clean up the task here and call jobFinished...");
            jobFinished(params, false);
            super.onPostExecute(aVoid);
        }
    }

}
