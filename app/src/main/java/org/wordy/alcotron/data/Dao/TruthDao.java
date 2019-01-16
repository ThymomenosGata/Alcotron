package org.wordy.alcotron.data.Dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import org.wordy.alcotron.data.tables.Truth;

import java.util.List;

@Dao
public interface TruthDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Truth truth);

    @Update
    void update(Truth truth);

    @Query("Select name from truth")
    LiveData<List<String>> getAllTruth();

    @Query("Select max(id) from truth")
    int getMaxId();

}
