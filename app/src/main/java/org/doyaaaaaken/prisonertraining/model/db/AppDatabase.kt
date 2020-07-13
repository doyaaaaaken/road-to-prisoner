package org.doyaaaaaken.prisonertraining.model.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import org.doyaaaaaken.prisonertraining.model.db.converter.TrainingConverter
import org.doyaaaaaken.prisonertraining.model.db.dao.TrainingRecordDao
import org.doyaaaaaken.prisonertraining.model.db.entity.TrainingRecordEntity


@Database(
    entities = [TrainingRecordEntity::class],
    version = 1
)
@TypeConverters(
    TrainingConverter::class
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun trainingDao(): TrainingRecordDao

    companion object {
        private const val dbName = "prisoner.db"
        private var instance: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase {
            if (instance == null) {
                instance = Room.databaseBuilder(context, AppDatabase::class.java, dbName)
                    .fallbackToDestructiveMigration()
                    .build()
            }
            return requireNotNull(instance)
        }
    }
}