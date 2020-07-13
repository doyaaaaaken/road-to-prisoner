package org.doyaaaaaken.prisonertraining.model

import android.app.Application
import android.os.AsyncTask
import androidx.lifecycle.LiveData
import org.doyaaaaaken.prisonertraining.model.db.AppDatabase
import org.doyaaaaaken.prisonertraining.model.db.dao.TrainingRecordDao
import org.doyaaaaaken.prisonertraining.model.db.entity.TrainingRecordEntity


class AppRepository(application: Application) {
    private val mTrainingRecordDao: TrainingRecordDao
    private val mAllTrainingRecords: LiveData<List<TrainingRecordEntity>>

    init {
        val db =
            AppDatabase.getInstance(
                application
            )
        mTrainingRecordDao = db.trainingDao()
        mAllTrainingRecords = mTrainingRecordDao.getAllTrainingRecords()
    }

    fun getAllTrainingRecords(): LiveData<List<TrainingRecordEntity>> {
        return mAllTrainingRecords
    }

    fun insert(word: TrainingRecordEntity) {
        InsertAsyncTask(
            mTrainingRecordDao
        ).execute(word)
    }

    class InsertAsyncTask(trainingRecordDao: TrainingRecordDao): AsyncTask<TrainingRecordEntity, Void, Void>() {
        private val mAsyncTaskDao: TrainingRecordDao = trainingRecordDao
        override fun doInBackground(vararg params: TrainingRecordEntity?): Void? {
            mAsyncTaskDao.insert(params[0]!!)
            return null
        }
    }

}