package com.valpu.seve.applicationtest.activities

import android.os.Bundle
import android.support.v7.widget.Toolbar
import android.widget.Toast
import com.valpu.seve.applicationtest.R
import com.valpu.seve.mylibrary.ToolbarActivity
import kotlinx.android.synthetic.main.activity_kotlin_android_extensions.*

class KotlinAndroidExtensionsActivity : ToolbarActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlin_android_extensions)

        toolbarToLoad(toolbar as Toolbar)


        val btn = button_by_Id
        btn.setOnClickListener { Toast.makeText(this, "Clicked by Id!", Toast.LENGTH_SHORT).show() }

        button_by_KAT.setOnClickListener { Toast.makeText(this, "Clicked by KAT!", Toast.LENGTH_SHORT).show() }
    }
}
