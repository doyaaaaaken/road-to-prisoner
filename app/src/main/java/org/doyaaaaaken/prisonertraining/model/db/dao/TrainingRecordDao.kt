package org.doyaaaaaken.prisonertraining.model.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import org.doyaaaaaken.prisonertraining.model.db.entity.TrainingRecordEntity

@Dao
interface TrainingRecordDao {
    @Query("SELECT * FROM trainingRecords")
    fun getAllTrainingRecords(): LiveData<List<TrainingRecordEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(trainingEntity: TrainingRecordEntity)
}