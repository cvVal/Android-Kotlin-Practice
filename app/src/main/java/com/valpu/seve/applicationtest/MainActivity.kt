package com.valpu.seve.applicationtest

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.support.constraint.ConstraintLayout
import android.support.design.widget.Snackbar
import android.support.v7.widget.Toolbar
import android.widget.Toast
import com.valpu.seve.applicationtest.activities.*
import com.valpu.seve.mylibrary.ToolbarActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : ToolbarActivity() {

    private var isExitEnabled = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toolbarToLoad(toolbar as Toolbar)

        val btnLifeCycle = button_to_cycle
        val btnClickEvents = button_to_click
        val btnAndroidExt = button_to_android_extensions
        val btnPicasso = button_to_picasso
        val btnListView = button_to_list_view
        val btnIntents = button_to_intents
        val btnPermission = button_to_permissions
        val btnSharedPrefs = button_to_shared_preferences
        val btnExtensionFunc = button_to_extension_functions

        btnLifeCycle.setOnClickListener { goToLifeCycleActivity() }
        btnClickEvents.setOnClickListener { goToClickEventsActivity() }
        btnAndroidExt.setOnClickListener { goToKotlinAndroidExtActivity() }
        btnPicasso.setOnClickListener { goToPicassoActivity() }
        btnListView.setOnClickListener { goToListViewActivity() }
        btnIntents.setOnClickListener { goToIntentsActivity() }
        btnPermission.setOnClickListener { goToPermissionActivity() }
        btnSharedPrefs.setOnClickListener { goToSharedPreferencesActivity() }
        btnExtensionFunc.setOnClickListener { goToExtensionFunActivity() }
    }

    override fun onBackPressed() {
        if (isExitEnabled)
            super.onBackPressed()

        isExitEnabled = true
        showToast()
        Handler().postDelayed({ isExitEnabled = false }, 2000)
    }

    fun showToast() {
        Toast.makeText(this, "Press back again if you really want to exit.", Toast.LENGTH_SHORT).show()
    }

    fun showSnackBar() {
        val myLayoutView = findViewById<ConstraintLayout>(R.id.main_constraint_layout)
        //Snackbar.make(myLayoutView, "", Snackbar.LENGTH_SHORT).show()
        Snackbar.make(myLayoutView, "Hello From Snack bar", Snackbar.LENGTH_INDEFINITE).setAction("OK") {
            Snackbar.make(myLayoutView, "Email has been restored", Snackbar.LENGTH_SHORT).show()
        }.show()
    }

    private fun goToLifeCycleActivity() = startActivity(Intent(this, LifeCycleActivity::class.java))
    private fun goToClickEventsActivity() = startActivity(Intent(this, ClickEventsActivity::class.java))
    private fun goToKotlinAndroidExtActivity() = startActivity(Intent(this, KotlinAndroidExtensionsActivity::class.java))
    private fun goToPicassoActivity() = startActivity(Intent(this, PicassoActivity::class.java))
    private fun goToListViewActivity() = startActivity(Intent(this, ListViewActivity::class.java))
    private fun goToIntentsActivity() = startActivity(Intent(this, IntentsActivity::class.java))
    private fun goToPermissionActivity() = startActivity(Intent(this, PermissionsActivity::class.java))
    private fun goToSharedPreferencesActivity() = startActivity(Intent(this, SharedPreferencesActivity::class.java))
    private fun goToExtensionFunActivity() = startActivity(Intent(this, ExtensionFunctionsActivity::class.java))
}
