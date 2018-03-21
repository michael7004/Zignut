package com.zignut.activity;

import android.app.FragmentManager;
import android.location.Location;
import android.location.LocationListener;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationRequest;
import com.zignut.R;
import com.zignut.adapter.AddressAdapter;
import com.zignut.dialog.TripDialogFragment;
import com.zignut.model.AddressModel;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements TripDialogFragment.OnCompleteListener ,LocationListener,GoogleApiClient.ConnectionCallbacks,GoogleApiClient.OnConnectionFailedListener{

    private static final String TAG = "LocationActivity";
    private static final long INTERVAL = 1000 * 10;
    private static final long FASTEST_INTERVAL = 1000 * 5;


    @BindView(R.id.rv_list)
    RecyclerView rv_list;

    private LinearLayoutManager linearLayoutManager;

    private AddressAdapter addressAdapter;

    private FragmentManager fragmentManager;

   /* LocationRequest mLocationRequest;
    GoogleApiClient mGoogleApiClient;
    Location mCurrentLocation;
    String mLastUpdateTime;*/




    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       /* JobScheduler jobScheduler = (JobScheduler) getApplicationContext().getSystemService(JOB_SCHEDULER_SERVICE);
        ComponentName componentName = new ComponentName(getApplicationContext(), JobSchedulerPeriodic.class);
        JobInfo jobInfo = new JobInfo.Builder(1, componentName).setOverrideDeadline(10).setRequiresCharging(true).build();
        jobScheduler.schedule(jobInfo);*/

        // intialize the instance of butterknife
        ButterKnife.bind(this);

        //get the instance of fragment manager
        fragmentManager = getFragmentManager();

        //intialize  the adater and set the data
        linearLayoutManager = new LinearLayoutManager(this);
        rv_list.setLayoutManager(linearLayoutManager);
        //  rv_list.addItemDecoration(new DividerItemDecoration(getResources().getDrawable(R.drawable.divider)));
        setAdapter();
    }

    /*
    * This method uses to set the adapter
    * */

    private void setAdapter() {
        if (addressAdapter == null) {
            addressAdapter = new AddressAdapter(this, fragmentManager, AddressModel.getDummyData());
            rv_list.setAdapter(addressAdapter);
        } else {
            addressAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onComplete(String place) {
        Toast.makeText(this, "" + place, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onLocationChanged(Location location) {

    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }

    @Override
    public void onConnected(@Nullable Bundle bundle) {

    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }
}
