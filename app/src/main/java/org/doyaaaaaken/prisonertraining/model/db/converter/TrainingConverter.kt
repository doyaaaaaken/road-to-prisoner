package org.doyaaaaaken.prisonertraining.model.db.converter

import androidx.room.TypeConverter
import org.doyaaaaaken.prisonertraining.model.TrainingType

class TrainingConverter {
    @TypeConverter
    fun fromTrainingType(value: TrainingType): Int = value.ordinal

    @TypeConverter
    fun toTrainingType(value: Int): TrainingType = enumValues<TrainingType>()[(value)]
}