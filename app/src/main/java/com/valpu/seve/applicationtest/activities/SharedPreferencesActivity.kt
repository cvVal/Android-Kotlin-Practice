package com.valpu.seve.applicationtest.activities

import android.os.Bundle
import android.support.v7.widget.Toolbar
import android.widget.Toast
import com.valpu.seve.applicationtest.R
import com.valpu.seve.applicationtest.app.preferences
import com.valpu.seve.mylibrary.ToolbarActivity
import kotlinx.android.synthetic.main.activity_shared_preferences.*

class SharedPreferencesActivity : ToolbarActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shared_preferences)

        toolbarToLoad(toolbar as Toolbar)

        button_shared_save.setOnClickListener { setValuesSharedPreferences(); cleanEditText(); getValuesSharedPreferences()}

        getValuesSharedPreferences()
    }

    private fun getValuesSharedPreferences() {
        if (preferences.name.isNotEmpty() && preferences.age >= 0)
            tv_shared_prefs.text = "Welcome ${preferences.name}, your age is ${preferences.age}"
        else
            tv_shared_prefs.text = "Welcome. Please save your name and age"
    }

    private fun setValuesSharedPreferences() {
        if (edit_text_name.text.toString().isNotEmpty() && edit_text_age.text.toString().isNotEmpty()) {
            preferences.name = edit_text_name.text.toString()
            preferences.age = edit_text_age.text.toString().toInt()
            Toast.makeText(this, "Values have been saved successfuly", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "Please, fill the name and age before saving", Toast.LENGTH_SHORT).show()
        }
    }

    private fun cleanEditText() {
        edit_text_name.text.clear()
        edit_text_age.setText("")
    }
}
