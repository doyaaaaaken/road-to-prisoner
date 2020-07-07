package org.doyaaaaaken.prisonertraining

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock.EXTRA_MESSAGE
import android.view.View
import org.doyaaaaaken.prisonertraining.model.TrainingType

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    /**
     * click training menu button
     */
    fun onClickTrainingButton(view: View) {
        val trainingType = when(view.id) {
            R.id.btn_select_training_push_up -> TrainingType.PUSH_UP
            R.id.btn_select_training_squat -> TrainingType.SQUAT
            R.id.btn_select_training_pull_up -> TrainingType.PULL_UP
            R.id.btn_select_training_leg_raise -> TrainingType.LEG_RAISE
            R.id.btn_select_training_bridge -> TrainingType.BRIDGE
            R.id.btn_select_training_hand_stand_push_up -> TrainingType.HAND_STAND_PUSH_UP
            else -> error("undefined type. ${view.id}")
        }
        val intent = Intent(this, RecordCreateActivity::class.java).apply {
            putExtra(EXTRA_MESSAGE, trainingType.name)
        }
        startActivity(intent)
    }
}
