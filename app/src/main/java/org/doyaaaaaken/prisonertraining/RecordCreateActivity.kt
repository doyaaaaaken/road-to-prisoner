package org.doyaaaaaken.prisonertraining

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock.EXTRA_MESSAGE
import android.view.View
import android.widget.EditText
import android.widget.TextView
import org.doyaaaaaken.prisonertraining.model.TrainingType

class RecordCreateActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_TRAINING_TYPE: String = "org.doyaaaaaken.prisonertraining.EXTRA_TRAINING_TYPE"
        const val EXTRA_DATE: String = "org.doyaaaaaken.prisonertraining.EXTRA_DATE"
        const val EXTRA_FIRST_SET: String = "org.doyaaaaaken.prisonertraining.EXTRA_FIRST_SET"
        const val EXTRA_SECOND_SET: String = "org.doyaaaaaken.prisonertraining.EXTRA_SECOND_SET"
        const val EXTRA_THIRD_SET: String = "org.doyaaaaaken.prisonertraining.EXTRA_THIRD_SET"
        const val EXTRA_COMMENT_SET: String = "org.doyaaaaaken.prisonertraining.EXTRA_COMMENT_SET"
    }

    private lateinit var mTrainingType: TrainingType

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_message)

        mTrainingType = TrainingType.valueOf(intent.getStringExtra(EXTRA_MESSAGE))
        findViewById<TextView>(R.id.text_create_record_title).apply {
            text = "${mTrainingType.displayName}の記録"
        }
    }

    /**
     * click record create button
     */
    fun onClickRecordCreateButton(view: View) {
        val intent = Intent(this, RecordListActivity::class.java)
        intent.putExtra(EXTRA_TRAINING_TYPE, mTrainingType)
        //TODO: 各項目の形式に合わせて修正
//        intent.putExtra(EXTRA_DATE, (R.id.input_create_record_date as EditText).text.toString())
//        intent.putExtra(EXTRA_FIRST_SET, (R.id.input_create_record_first_set as EditText).text.toString())
//        intent.putExtra(EXTRA_SECOND_SET, (R.id.input_create_record_second_set as EditText).text.toString())
//        intent.putExtra(EXTRA_THIRD_SET, (R.id.input_create_record_third_set as EditText).text.toString())
//        intent.putExtra(EXTRA_COMMENT_SET, (R.id.input_create_record_comment as EditText).text.toString())

        //TODO: 記録し続けるとアクティビティがたまっていくので、画面遷移を変える。
        startActivity(intent)
    }
}