package org.doyaaaaaken.prisonertraining.model.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import org.doyaaaaaken.prisonertraining.model.TrainingType

@Entity(tableName = "trainingRecords")
data class TrainingRecordEntity(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val trainingType: TrainingType,
    //TODO: 各項目の形式に合わせて修正
    val date: String? = null,
    val firstSet: String? = null,
    val secondSet: String? = null,
    val thirdSet: String? = null,
    val comment: String? = null,
    val createdAt: Long = System.currentTimeMillis()


)