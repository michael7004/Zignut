package com.zignut.activity;

import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.zignut.R;
import com.zignut.adapter.AddressAdapter;
import com.zignut.dialog.TripDialogFragment;
import com.zignut.model.AddressModel;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity  implements TripDialogFragment.OnCompleteListener{

    @BindView(R.id.rv_list)
    RecyclerView rv_list;

    private LinearLayoutManager linearLayoutManager;

    private AddressAdapter addressAdapter;

    private FragmentManager fragmentManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // intialize the instance of butterknife
        ButterKnife.bind(this);

        //get the instance of fragment manager
        fragmentManager=getFragmentManager();

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
            addressAdapter = new AddressAdapter(this,fragmentManager,AddressModel.getDummyData());
            rv_list.setAdapter(addressAdapter);
        } else {
            addressAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onComplete(String place) {
        Toast.makeText(this, ""+place, Toast.LENGTH_SHORT).show();
    }
}
