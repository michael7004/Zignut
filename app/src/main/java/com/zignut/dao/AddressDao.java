package com.zignut.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;

import com.zignut.model.AddressModel;

import java.util.List;

/**
 * Created by Lenovo on 21-03-2018.
 */

@Dao
public interface AddressDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insertAddressDB(List<AddressModel> addressModelList);
}
