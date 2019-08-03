package com.valpu.seve.applicationtest.activities

import android.os.Bundle
import android.support.v7.widget.Toolbar
import android.view.View
import android.widget.Toast
import com.valpu.seve.applicationtest.R
import com.valpu.seve.mylibrary.ToolbarActivity
import kotlinx.android.synthetic.main.activity_click_events.*

class ClickEventsActivity : ToolbarActivity(), View.OnLongClickListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_click_events)

        toolbarToLoad(toolbar as Toolbar)

        clickInLine()

        val btnM1 = button_click_multi_1
        val btnM2 = button_click_multi_2
        val btnM3 = button_click_multi_3

        btnM1.setOnLongClickListener(this)
        btnM2.setOnLongClickListener(this)
        btnM3.setOnLongClickListener(this)
    }

    fun xmlClick(view: View) {
        Toast.makeText(this, "Click by XML!", Toast.LENGTH_SHORT).show()
    }

    private fun clickInLine() {
        val btn = button_click_in_line
        btn.setOnClickListener { Toast.makeText(this, "Click in line!", Toast.LENGTH_SHORT).show() }
    }

    override fun onLongClick(v: View): Boolean {
        when (v.id) {
            R.id.button_click_multi_1 -> Toast.makeText(this, "Click Multi 1!", Toast.LENGTH_SHORT).show()
            R.id.button_click_multi_2 -> Toast.makeText(this, "Click Multi 2!", Toast.LENGTH_SHORT).show()
            R.id.button_click_multi_3 -> Toast.makeText(this, "Click Multi 3!", Toast.LENGTH_SHORT).show()
        }
        return true
    }
}
