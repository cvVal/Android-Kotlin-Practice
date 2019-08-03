package com.valpu.seve.applicationtest.activities

import android.os.Bundle
import android.support.v7.widget.Toolbar
import android.view.View
import com.valpu.seve.applicationtest.R
import com.valpu.seve.applicationtest.models.Student
import com.valpu.seve.mylibrary.ToolbarActivity
import kotlinx.android.synthetic.main.activity_intent_extras.*

class IntentExtrasActivity : ToolbarActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent_extras)

        toolbarToLoad(toolbar as Toolbar)
        enabledHomeDisplay(true)

        val isIntentExtrasSet = setIntentExtrasFromPreviousActivity()
        val isParelableSet = setParcelableFromPreviousActivity()

        if (!isIntentExtrasSet && !isParelableSet)
            check_box_developer.visibility = View.INVISIBLE

    }

    private fun setIntentExtrasFromPreviousActivity(): Boolean {

        val firstName: String? = intent.getStringExtra("firstName")
        val lastName: String? = intent.getStringExtra("lastName")
        val age: Int = intent.getIntExtra("age", 0)
        val developer: Boolean = intent.getBooleanExtra("developer", false)

        if (firstName != null && lastName != null && age >= 0) {
            tv_first_name.text = firstName
            tv_last_name.text = lastName
            tv_age.text = "$age"
            check_box_developer.text = "Developer"
            check_box_developer.isChecked = developer

            return true
        }
        return false
    }

    private fun setParcelableFromPreviousActivity(): Boolean {

        val student = intent.getParcelableExtra<Student>("student")
        student?.let {
            tv_first_name.text = student.name
            tv_last_name.text = student.lastName
            tv_age.text = "${student.age}"
            check_box_developer.text = "Developer"
            check_box_developer.isChecked = student.isDeveloper

            return true
        }

        return false
    }
}
