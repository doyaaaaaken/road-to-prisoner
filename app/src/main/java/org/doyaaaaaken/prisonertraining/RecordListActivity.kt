package org.doyaaaaaken.prisonertraining

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.doyaaaaaken.prisonertraining.RecordCreateActivity.Companion.EXTRA_TRAINING_TYPE
import org.doyaaaaaken.prisonertraining.model.TrainingType
import org.doyaaaaaken.prisonertraining.model.db.entity.TrainingRecordEntity
import org.doyaaaaaken.prisonertraining.viewmodel.TrainingRecordListAdapter
import org.doyaaaaaken.prisonertraining.viewmodel.TrainingRecordViewModel

class RecordListActivity : AppCompatActivity() {

    private var mTrainingRecordViewModel: TrainingRecordViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_record_list)

        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view_list_record)
        val adapter = TrainingRecordListAdapter(this)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        mTrainingRecordViewModel = ViewModelProviders.of(this).get(TrainingRecordViewModel::class.java)
        mTrainingRecordViewModel!!.getAllTrainingRecords().observe(this, Observer {
            adapter.setTrainingRecords(it!!)
        })

        // 記録内容を登録する
        val trainingType = intent.getSerializableExtra(EXTRA_TRAINING_TYPE) as TrainingType?
        if (trainingType != null) {
            //TODO: いったん種目のみだが、各項目を登録するようにする。
            val trainingRecord = TrainingRecordEntity(0, trainingType)
            mTrainingRecordViewModel!!.insert(trainingRecord)
        }
    }

    fun onClickRecordCreateButton(view: View) {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}