package org.doyaaaaaken.prisonertraining.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import org.doyaaaaaken.prisonertraining.model.AppRepository
import org.doyaaaaaken.prisonertraining.model.db.entity.TrainingRecordEntity

class TrainingRecordViewModel(application: Application) : AndroidViewModel(application) {
    private val mRepository: AppRepository = AppRepository(application)
    private var mAlltrainingRecords: LiveData<List<TrainingRecordEntity>>

    init {
        mAlltrainingRecords = mRepository.getAllTrainingRecords()
    }

    fun getAllTrainingRecords(): LiveData<List<TrainingRecordEntity>> {
        return mAlltrainingRecords
    }

    fun insert(word: TrainingRecordEntity) {
        mRepository.insert(word)
    }
}