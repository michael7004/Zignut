package com.zignut.adapter;

import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.zignut.R;
import com.zignut.activity.MapsActivity;
import com.zignut.dialog.TripDialogFragment;
import com.zignut.model.AddressModel;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class AddressAdapter extends RecyclerView.Adapter<AddressAdapter.Holder> {

    private LayoutInflater inflater;
    private ArrayList<AddressModel> addressArrayList;
    private Context context;
    private FragmentManager fragmentManager;

    public AddressAdapter(Context context,FragmentManager fragmentManager, ArrayList<AddressModel> addressArrayList) {
        inflater = LayoutInflater.from(context);
        this.context = context;
        this.fragmentManager=fragmentManager;
        this.addressArrayList = addressArrayList;


    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemview = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_map, parent, false);
        return new Holder(itemview);
    }


    @Override
    public void onBindViewHolder(final Holder holder, final int position) {

        AddressModel addressModel = addressArrayList.get(position);


        holder.tv_trip_name.setText(addressModel.getTripNmae());
        holder.tv_trip_src_name.setText(addressModel.getTripSrcAddress());
        holder.tv_trip_dest_name.setText(addressModel.getTripDestAddress());
        holder.tv_trip_start_date.setText(addressModel.getTripStartDate());
        holder.tv_trip_end_date.setText(addressModel.getTripEndDate());


        /*
        * Start new trip
        * */
        holder.btn_start_trip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                TripDialogFragment cdd = new TripDialogFragment();
                cdd.show(fragmentManager, "TRIP_FRAGMENT");

            }
        });

        /*
        * Show trip
        * */
        holder.btn_show_trip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.startActivity(new Intent(context, MapsActivity.class));

            }
        });


    }


    @Override
    public int getItemCount() {
        return addressArrayList.size();
    }

    public class Holder extends RecyclerView.ViewHolder {


        @Nullable
        @BindView(R.id.tv_trip_name)
        TextView tv_trip_name;

        @Nullable
        @BindView(R.id.tv_trip_src_name)
        TextView tv_trip_src_name;

        @Nullable
        @BindView(R.id.tv_trip_dest_name)
        TextView tv_trip_dest_name;

        @Nullable
        @BindView(R.id.tv_trip_start_date)
        TextView tv_trip_start_date;

        @Nullable
        @BindView(R.id.tv_trip_end_date)
        TextView tv_trip_end_date;

        @Nullable
        @BindView(R.id.btn_start_trip)
        Button btn_start_trip;

        @Nullable
        @BindView(R.id.btn_show_trip)
        Button btn_show_trip;


        public Holder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

    }


}
