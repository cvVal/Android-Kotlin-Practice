package com.valpu.seve.applicationtest.activities

import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.Toolbar
import com.valpu.seve.applicationtest.R
import com.valpu.seve.applicationtest.models.Student
import com.valpu.seve.mylibrary.ToolbarActivity
import kotlinx.android.synthetic.main.activity_intents.*

class IntentsActivity : ToolbarActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intents)

        toolbarToLoad(toolbar as Toolbar)

        button_intent_extras.setOnClickListener { goIntentExtras() }
        button_intent_flags.setOnClickListener { goIntentFlags() }
        button_intent_object.setOnClickListener { goIntentObject() }

    }

    private fun goIntentExtras() {
        val intent = Intent(this, IntentExtrasActivity::class.java)
        intent.putExtra("firstName", "Seve")
        intent.putExtra("lastName", "Valdez")
        intent.putExtra("age", 28)
        intent.putExtra("developer", true)

        startActivity(intent)

    }

    private fun goIntentFlags() {
        val intent = Intent(this, IntentExtrasActivity::class.java)
//        intent.flags = Intent.FLAG_ACTIVITY_NO_HISTORY // No guarda el activity en el stack
//        intent.flags = Intent.FLAG_ACTIVITY_NO_ANIMATION // Omite la animacion entre el cambio de activities
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK // Borra el stack completo
        startActivity(intent)
//        finish() // Destruye este activity evitando que entre al stack

    }

    private fun goIntentObject() {
        val intent = Intent(this, IntentExtrasActivity::class.java)
        val student = Student("Seve", "Valdez", 28, false)
        intent.putExtra("student", student)
        startActivity(intent)

    }
}
