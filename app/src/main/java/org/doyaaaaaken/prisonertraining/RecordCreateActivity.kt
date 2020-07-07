package org.doyaaaaaken.prisonertraining

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock.EXTRA_MESSAGE
import android.view.View
import android.widget.TextView
import org.doyaaaaaken.prisonertraining.model.TrainingType

class RecordCreateActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_message)

        val trainingType = TrainingType.valueOf(intent.getStringExtra(EXTRA_MESSAGE))
        findViewById<TextView>(R.id.text_create_record_title).apply {
            text = "${trainingType.displayName}の記録"
        }
    }

    fun onClickRecordCreateButton(view: View) {
        val intent = Intent(this, RecordListActivity::class.java)
        startActivity(intent)
    }
}