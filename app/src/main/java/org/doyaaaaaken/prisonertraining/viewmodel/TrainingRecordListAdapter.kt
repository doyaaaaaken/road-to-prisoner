package org.doyaaaaaken.prisonertraining.viewmodel

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import org.doyaaaaaken.prisonertraining.R
import org.doyaaaaaken.prisonertraining.model.db.entity.TrainingRecordEntity


class TrainingRecordListAdapter(context: Context): RecyclerView.Adapter<TrainingRecordListAdapter.TrainingRecordViewHolder>() {

    class TrainingRecordViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val trainingTypeView: TextView = itemView.findViewById(R.id.text_recycler_record_type)
        val dateView: TextView = itemView.findViewById(R.id.text_recycler_record_date)
        val firstSetView: TextView = itemView.findViewById(R.id.text_recycler_record_first_set)
        val secondSetView: TextView = itemView.findViewById(R.id.text_recycler_record_second_set)
        val thirdSetView: TextView = itemView.findViewById(R.id.text_recycler_record_third_set)
        val commentView: TextView = itemView.findViewById(R.id.text_recycler_record_comment)
    }

    private val mInflater: LayoutInflater = LayoutInflater.from(context)
    private var mTrainingRecords: List<TrainingRecordEntity>? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrainingRecordViewHolder {
        val itemView = mInflater.inflate(R.layout.recyclerview_item, parent, false)
        return TrainingRecordViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: TrainingRecordViewHolder, position: Int) {
        if (mTrainingRecords != null) {
            val current = mTrainingRecords!![position]
            holder.trainingTypeView.text = current.trainingType.displayName
            //TODO: 各項目の形式に合わせて修正
//            holder.dateView.text = current.date
//            holder.firstSetView.text = current.firstSet
//            holder.secondSetView.text = current.secondSet
//            holder.thirdSetView.text = current.thirdSet
//            holder.commentView.text = current.comment
        } else {
            holder.trainingTypeView.text = "No Record"
        }
    }

    fun setTrainingRecords(trainingRecords: List<TrainingRecordEntity>) {
        mTrainingRecords = trainingRecords
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return if (mTrainingRecords != null) {
            mTrainingRecords!!.size
        } else {
            0
        }
    }
}