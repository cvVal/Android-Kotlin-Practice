package com.valpu.seve.applicationtest.activities

import android.os.Bundle
import android.support.v7.widget.Toolbar
import com.valpu.seve.applicationtest.MainActivity
import com.valpu.seve.applicationtest.R
import com.valpu.seve.applicationtest.others.*
import com.valpu.seve.mylibrary.ToolbarActivity
import kotlinx.android.synthetic.main.activity_extension_functions.*

class ExtensionFunctionsActivity : ToolbarActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_extension_functions)

        toolbarToLoad(toolbar as Toolbar)

        button_toast.setOnClickListener { toast("Hello from extension functions") }
        button_snackbar.setOnClickListener { snackbar("Snackbar with extension functions", action = "Click") {toast("Clicked!")} }
        button_go_to_activity.setOnClickListener { goToActivity<MainActivity>() }
        button_load_by_url.setOnClickListener { image_view_load_by_url.loadByURL("https://udemy-images.udemy.com/course/200_H/1266742_b2f7_4.jpg")}

    }
}
